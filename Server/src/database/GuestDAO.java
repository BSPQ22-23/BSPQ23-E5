package database;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import domain.Guest;

/**
 * DAO for Guest class
 * @author a-rasines
 *
 */
public class GuestDAO extends DataAccessObjectBase implements IDataAccessObject<Guest>{
	private static final GuestDAO INSTANCE = new GuestDAO();
	public static GuestDAO getInstance() {
		return INSTANCE;
	}
	private GuestDAO() {}
	@Override
	public void save(Guest object) {
		saveObject(object);
		
	}

	@Override
	public void delete(Guest object) {
		deleteObject(object);
		
	}

	@Override
	public List<Guest> getAll() {				
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<Guest> articles = new ArrayList<>();
		
		try {
			tx.begin();
			
			Extent<Guest> extent = pm.getExtent(Guest.class, true);

			for (Guest category : extent) {
				articles.add(category);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Guests: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return articles;
	}

	@Override
	public Guest find(String dni) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		Guest result = null; 

		try {
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT FROM " + Guest.class.getName() + " WHERE dni == '" + dni.replace("'", "''")+"'");
			query.setUnique(true);
			result = (Guest) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Guest: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}
	public Guest find(String user, String password) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		Guest result = null; 

		try {
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT FROM " + Guest.class.getName() + " WHERE nick == '" + user.replace("'", "''")+"' && password == '" + password.replace("'", "''")+"'");
			query.setUnique(true);
			result = (Guest) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Guest: " + ex.getMessage());
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
		
		Guest result = null; 

		try {
			tx.begin();
						
			Query<?> query = pm.newQuery("SELECT FROM " + Guest.class.getName() + " WHERE nick == '" + user.replace("'", "''")+"'");
			query.setUnique(true);
			result = (Guest) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a Guest: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		System.out.println("result= " + result);
		return result != null;
	}
}
