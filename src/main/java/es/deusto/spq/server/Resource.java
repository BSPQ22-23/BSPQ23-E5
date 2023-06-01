package es.deusto.spq.server;

import javax.jdo.PersistenceManager;

<<<<<<< HEAD
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;

=======


import javax.jdo.PersistenceManagerFactory;

import javax.jdo.JDOHelper;
import javax.jdo.Transaction;


>>>>>>> 1bbcaec (update)
import es.deusto.spq.jdo.User;


import es.deusto.spq.pojo.UserData;

<<<<<<< HEAD
import javax.ws.rs.GET;
=======
>>>>>>> 1bbcaec (update)
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
<<<<<<< HEAD
import javax.ws.rs.core.Response.Status;
=======

>>>>>>> 1bbcaec (update)

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Path("/resource")
@Produces(MediaType.APPLICATION_JSON)
public class Resource {
	protected static final Logger logger = LogManager.getLogger();

	
	private PersistenceManager pm=null;
	private Transaction tx=null;

	public Resource() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		this.pm = pmf.getPersistenceManager();
		this.tx = pm.currentTransaction();
	}
	/* JDO --> public User(String nick, String password, String dni, int age, String cityOfProvenance, boolean isHotelOwner) {*/
	@POST
	@Path("/register")
	public Response register(UserData userData) {
		try
        {	
            tx.begin();
<<<<<<< HEAD
            logger.info("Checking whether the user already exits or not: '{}'", userData.getLogin());
			User user = null;
			try {
				user = pm.getObjectById(User.class, userData.getLogin());
=======
            logger.info("Checking whether the user already exits or not: '{}'", userData.getNickname());
			User user = null;
			try {
				user = pm.getObjectById(User.class, userData.getNickname());
>>>>>>> 1bbcaec (update)
			} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
				logger.info("Exception launched: {}", jonfe.getMessage());
			}
			logger.info("User: {}", user);
			if (user != null) {
<<<<<<< HEAD
				logger.info("Setting password user: {}", user);
				user.setPassword(userData.getPassword());
				logger.info("Password set user: {}", user);
			} else {
				logger.info("Creating user: {}", user);
				user = new User(userData.getNickname(), userData.getPassword(), userData.getDni(), userData.getAge(),userData.getCity(), false);
=======
				return Response.serverError().build();
			} else {
				logger.info("Creating user: {}", user);
				user = new User(userData.getNickname(), userData.getPassword());
>>>>>>> 1bbcaec (update)
				//user = new User(userData.getNickname(), userData.getPassword(),null,true);
				pm.makePersistent(user);					 
				logger.info("User created: {}", user);
			}
			tx.commit();
			return Response.ok().build();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
      
		}
	}
	/**
	 * 
	 * @param userData
	 * @return
	 */
	@POST
    @Path("/login")
    public Response loginUser(UserData userData) {
        try
        {
<<<<<<< HEAD
=======
        	System.out.println("He entrado al login en el reosurce");
>>>>>>> 1bbcaec (update)
            tx.begin();
            logger.info("Checking whether the user already exits or not: '{}'", userData.getNickname());
            User user = null;
            try {
                user = pm.getObjectById(User.class, userData.getNickname());
            } catch (javax.jdo.JDOObjectNotFoundException jonfe) {
                logger.info("Exception launched: {}", jonfe.getMessage());
            }
            logger.info("User: {}", user);
            if (user != null) {
<<<<<<< HEAD
                if(!user.getPassword().equals(userData.getPassword())) {
=======
                if(!user.getPassword()
                		.equals(userData.getPassword())) {
>>>>>>> 1bbcaec (update)
                    return Response.serverError().build();
                }
            } else {
                return Response.serverError().build();
            }
            tx.commit();
            return Response.ok().build();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }

        }
    }
	

}
