package database;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import database.DataAccessObjectBase;
import domain.User;

/**
 * DAO for User class
 * @author a-rasines
 *
 */
public class UserDAO extends DataAccessObjectBase implements IDataAccessObject<User>{
	private static final UserDAO INSTANCE = new UserDAO();
	 private static  PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
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

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {				
		PersistenceManager pm = pmf.getPersistenceManager();
		Query<User> q = pm.newQuery(User.class);
		return (List<User>)q.execute(20);
	}

	@Override
	public User find(String dni) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Query<User> q = pm.newQuery(User.class, "dni == '" + dni.replace("'", "''")+"'");
		q.setUnique(true);
		return (User)q.execute(20);
	}
	public User find(String user, String password) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Query<User> q = pm.newQuery(User.class, "nick == '" + user.replace("'", "''")+"' && password == '" + password.replace("'", "''")+"'");
		q.setUnique(true);
		return (User)q.execute(20);
	}
	@SuppressWarnings("unchecked")
	public boolean exists(String user) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Query<User> q = pm.newQuery(User.class, "nick == '" + user.replace("'", "''")+"'");
		return ((List<User>)q.execute()).size() != 0;
	}
	 public void setPersistenceManagerFactory(PersistenceManagerFactory factory) {
	        pmf = factory;
	    }

}
