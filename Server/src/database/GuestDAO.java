package database;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Guest> getAll() {				
		PersistenceManager pm = pmf.getPersistenceManager();
		Query<Guest> q = pm.newQuery(Guest.class);
		return (List<Guest>)q.execute(20);
	}

	@Override
	public Guest find(String dni) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Query<Guest> q = pm.newQuery(Guest.class, "dni == '" + dni.replace("'", "''")+"'");
		q.setUnique(true);
		return (Guest)q.execute(20);
	}
	@SuppressWarnings("unchecked")
	public boolean exists(String dni) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Query<Guest> q = pm.newQuery(Guest.class, "dni == '" + dni.replace("'", "''")+"'");
		return ((List<Guest>)q.execute(20)).size() != 0;
	}
}
