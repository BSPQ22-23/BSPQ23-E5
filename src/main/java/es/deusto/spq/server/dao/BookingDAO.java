package es.deusto.spq.server.dao;
import java.util.Date;



import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.spq.jdo.Room;
import es.deusto.spq.server.*;
import es.deusto.spq.jdo.Booking;

/**
 * DAO for Booking class
 * @author maitanegarcia
 *
 */

public class BookingDAO extends DataAccessObjectBase implements IDataAccessObject<Booking> {

	private static BookingDAO instance;	
	//private static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	public BookingDAO() { }
	
	public static BookingDAO getInstance() {
		if (instance == null) {
			instance = new BookingDAO();
		}		
		
		return instance;
	}	
	/**
	 * This method saves a reservation
	 */
	@Override
	public void save(Booking object) {
		// TODO Auto-generated method stub
		super.saveObject(object);
		
	}
/**
 * Thus method deletes a reservation
 */
	@Override
	public void delete(Booking object) {
		// TODO Auto-generated method stub
		super.deleteObject(object);
		
	}
	
/**
 * This method gets a list of all the reservations 
 */
	@Override
	public List<Booking> getAll() {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Query<Booking> q = pm.newQuery(Booking.class);
		List<Booking> ListBooking = (List<Booking>) q.executeList();
		return ListBooking;
	}
	

	@Override
	public Booking find(String param) {
	    PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();

	    Booking result = null;

	    try {
	        tx.begin();

	        Query<Booking> q = pm.newQuery(Booking.class);
	        q.setFilter("user == userParam");
	        q.declareParameters("String userParam");
	        q.setUnique(true);
	        result = (Booking) q.execute(param);

	        tx.commit();
	    } catch (Exception ex) {
	        System.out.println("Error: " + ex.getMessage());
	    } finally {
	        if (tx != null && tx.isActive()) {
	            tx.rollback();
	        }

	        pm.close();
	    }

	    return result;
	}

	/**
	 */
	public void createBooking(Booking booking) {
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        try {
            tx.begin();
            pm.makePersistent(booking);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            pm.close();
        }
    }
	
}
