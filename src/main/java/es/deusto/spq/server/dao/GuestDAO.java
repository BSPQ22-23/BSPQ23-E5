package es.deusto.spq.server.dao;

import java.util.List;


import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import es.deusto.spq.server.*;


/**
 * Data Access Object for managing Guest objects in the hotel management system.
 * Extends DataAccessObjectBase and implements IDataAccessObject<Guest>.
 */
public class GuestDAO extends DataAccessObjectBase implements IDataAccessObject<Guest> {

    private static final GuestDAO INSTANCE = new GuestDAO();
    private static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

    /**
     * Returns the singleton instance of GuestDAO.
     *
     * @return The singleton instance of GuestDAO.
     */
    public static GuestDAO getInstance() {
        return INSTANCE;
    }

    private GuestDAO() {
    }

    /**
     * Saves a Guest object to the database.
     *
     * @param object The Guest object to save.
     */
    @Override
    public void save(Guest object) {
        saveObject(object);
    }

    /**
     * Deletes a Guest object from the database.
     *
     * @param object The Guest object to delete.
     */
    @Override
    public void delete(Guest object) {
        deleteObject(object);
    }

    /**
     * Retrieves all Guest objects from the database.
     *
     * @return A list of all Guest objects.
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Guest> getAll() {
        PersistenceManager pm = pmf.getPersistenceManager();
        Query<Guest> q = pm.newQuery(Guest.class);
        return (List<Guest>) q.execute(20);
    }

    /**
     * Finds a Guest object in the database based on the specified DNI (National Identity Document).
     *
     * @param dni The DNI of the Guest to find.
     * @return The found Guest object, or null if not found.
     */
    @Override
    public Guest find(String dni) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Query<Guest> q = pm.newQuery(Guest.class, "dni == '" + dni.replace("'", "''") + "'");
        q.setUnique(true);
        return (Guest) q.execute(20);
    }

    /**
     * Checks if a Guest object with the specified DNI (National Identity Document) exists in the database.
     *
     * @param dni The DNI of the Guest to check.
     * @return {@code true} if the Guest exists, {@code false} otherwise.
     */
    @SuppressWarnings("unchecked")
    public boolean exists(String dni) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Query<Guest> q = pm.newQuery(Guest.class, "dni == '" + dni.replace("'", "''") + "'");
        return ((List<Guest>) q.execute(20)).size() != 0;
    }

    /**
     * Sets the PersistenceManagerFactory for the GuestDAO.
     *
     * @param factory The PersistenceManagerFactory to set.
     */
    public void setPersistenceManagerFactory(PersistenceManagerFactory factory) {
        pmf = factory;
    }
}
