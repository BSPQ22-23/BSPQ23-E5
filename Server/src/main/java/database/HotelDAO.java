package database;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;

import javax.jdo.Query;
import javax.jdo.Transaction;

import domain.Guest;

/**
 * DAO for Hotel class
 * @author maitanegarcia
 *
 */

import domain.Hotel;

public class HotelDAO  extends DataAccessObjectBase implements IDataAccessObject<Hotel> {
	private static final HotelDAO INSTANCE = new HotelDAO();
	
	public static HotelDAO getInstance() {
		return INSTANCE;
	}

	@Override
	public void save(Hotel object) {
		// TODO Auto-generated method stub
		HotelDAO.getInstance().save(object);
		save(object);
	}
	/**
	 * Delete a hotel
	 */
	@Override
	public void delete(Hotel object) {
		// TODO Auto-generated method stub
		deleteObject(object);
	}
	/**
	 * Method that get a list of all the hotels
	 */
	@Override
	public List<Hotel> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Query<Hotel> q = pm.newQuery(Hotel.class);
		List<Hotel> ListHotel = (List<Hotel>) q.executeList();
		return ListHotel;
		
	}
	/**
	 * Method that get a list Hotel by the name
	 * @param name
	 * @return a list of Hotel Names
	 */
	public List<Hotel> getbyName (String name) {
	    PersistenceManager pm = pmf.getPersistenceManager();
	    Query<Hotel> q = pm.newQuery(Hotel.class,"name == '" + name.replace("'", "''") + "'");
	    List<Hotel> resultList =  (List<Hotel>) q.execute();
	    return resultList;
	}
	
	/**
	 * Add a hotel
	 * @param hotel
	 */
    public void addHotel(Hotel hotel) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        try {
            tx.begin();
            pm.makePersistent(hotel);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            pm.close();
        }
    }
 
    
    public List<Hotel> findHotelsByOwner(Guest owner) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Query<Hotel> q = pm.newQuery(Hotel.class, "owner == :ownerParam");
        q.setParameters(owner);
        List<Hotel> resultList = (List<Hotel>) q.execute();
        return resultList;
    }
	/**
	 * Look for  if the name of the owner exits
	 * @param ownerName
	 * @return boolean , true o false
	 */
   
	public boolean ownerExists(String ownerName) {
	    PersistenceManager pm = pmf.getPersistenceManager();
	    Query<Guest> q = pm.newQuery(Guest.class, "name == '" + ownerName.replace("'", "''") + "'");
	    List<Guest> resultList =  (List<Guest>) q.execute();
	    return !resultList.isEmpty();
	}

	

	@Override
	public Hotel find(String param) {
	    PersistenceManager pm = pmf.getPersistenceManager();  
	    Query<Hotel> q = pm.newQuery(Hotel.class, "name.toLowerCase().contains(:param)");  // Se crea una consulta JDO para la clase Hotel, filtrando el nombre 
	    q.setParameters(param.toLowerCase());  
	    List<Hotel> resultList = (List<Hotel>) q.execute();  
	    
	    if (!resultList.isEmpty()) {
	        return resultList.get(0);  // Devuelve el primer hotel encontrado
	    } else {
	        return null;  // No se encontró ningún hotel
	    }
	}
	
}
