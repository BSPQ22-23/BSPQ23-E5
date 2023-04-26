package database;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import domain.User;

/**
 * DAO for User class
 * @author a-rasines
 *
 */
public class UserDAO extends DataAccessObjectBase implements IDataAccessObject<User>{
	private static final UserDAO INSTANCE = new UserDAO();
	public static UserDAO getInstance() {
		return INSTANCE;
	}
	private UserDAO() {}
	@Override
	public void save(User object) {
		GuestDAO.getInstance().save(object.getLegalInfo());
		saveObject(object);
		
	}

	@Override
	public void delete(User object) {
		deleteObject(object);
		
	}

	@Override
	public List<User> getAll() {				
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<User> articles = new ArrayList<>();
		
		try {
			tx.begin();
			
			Extent<User> extent = pm.getExtent(User.class, true);

			for (User category : extent) {
				articles.add(category);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Users: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return articles;
	}

	@Override
	public User find(String dni) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		User result = null; 

		try {
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE dni == '" + dni.replace("'", "''")+"'");
			query.setUnique(true);
			result = (User) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a User: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}
	public User find(String user, String password) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		User result = null; 

		try {
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE nick == '" + user.replace("'", "''")+"' && password == '" + password.replace("'", "''")+"'");
			query.setUnique(true);
			result = (User) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a User: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}
	public boolean exists(String user) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		long result = 0; 

		try {
			tx.begin();	
			System.out.println("SELECT COUNT(this) FROM " + User.class.getName() + " WHERE nick == '" + user.replace("'", "''")+"'");
			Query<?> query = pm.newQuery("SELECT COUNT(this) FROM " + User.class.getName() + " WHERE nick == '" + user.replace("'", "''")+"'");
			query.setUnique(true);
			result = (long)query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a User: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		System.out.println("result= " + result);
		return result != 0;
	}
}
