package es.deusto.spq.server.dao;

import java.util.List;


import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import es.deusto.spq.*;
import es.deusto.spq.server.*;

/**
 * Data Access Object for managing User objects in the hotel management system.
 * Extends DataAccessObjectBase and implements IDataAccessObject<User>.
 */
public class UserDAO extends DataAccessObjectBase implements IDataAccessObject<User> {

    private static final UserDAO INSTANCE = new UserDAO();
    private static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

    /**
     * Returns the singleton instance of UserDAO.
     *
     * @return The singleton instance of UserDAO.
     */
    public static UserDAO getInstance() {
        return INSTANCE;
    }

    private UserDAO() {
    }

    /**
     * Saves a User object to the database.
     * Also saves the associated Guest object.
     *
     * @param object The User object to save.
     */
    @Override
    public void save(User object) {
        GuestDAO.getInstance().save(object.getLegalInfo());
        saveObject(object);
    }

    /**
     * Deletes a User object from the database.
     *
     * @param object The User object to delete.
     */
    @Override
    public void delete(User object) {
        deleteObject(object);
    }

    /**
     * Retrieves all User objects from the database.
     *
     * @return A list of all User objects.
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAll() {
        PersistenceManager pm = pmf.getPersistenceManager();
        Query<User> q = pm.newQuery(User.class);
        return (List<User>) q.execute(20);
    }

    /**
     * Finds a User object in the database based on the specified DNI (National Identity Document).
     *
     * @param dni The DNI of the User to find.
     * @return The found User object, or null if not found.
     */
    @Override
    public User find(String dni) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Query<User> q = pm.newQuery(User.class, "dni == '" + dni.replace("'", "''") + "'");
        q.setUnique(true);
        return (User) q.execute(20);
    }

    /**
     * Finds a User object in the database based on the specified username and password.
     *
     * @param user     The username of the User to find.
     * @param password The password of the User to find.
     * @return The found User object, or null if not found.
     */
    public User find(String user, String password) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Query<User> q = pm.newQuery(User.class, "nick == '" + user.replace("'", "''") + "' && password == '" + password.replace("'", "''") + "'");
        q.setUnique(true);
        return (User) q.execute(20);
    }

    /**
     * Checks if a User object with the specified username exists in the database.
     *
     * @param user The username of the User to check.
     * @return {@code true} if the User exists, {@code false} otherwise.
     */
    @SuppressWarnings("unchecked")
    public boolean exists(String user) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Query<User> q = pm.newQuery(User.class, "nick == '" + user.replace("'", "''") + "'");
        return ((List<User>) q.execute()).size() != 0;
    }

    /**
     * Sets the PersistenceManagerFactory for the UserDAO.
     *
     * @param factory The PersistenceManagerFactory to set.
     */
    public void setPersistenceManagerFactory(PersistenceManagerFactory factory) {
        pmf = factory;
    }
}

