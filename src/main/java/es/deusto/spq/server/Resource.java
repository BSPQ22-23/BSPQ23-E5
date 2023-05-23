package es.deusto.spq.server;

import javax.jdo.PersistenceManager;

import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;

import es.deusto.spq.jdo.User;


import es.deusto.spq.pojo.UserData;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
            logger.info("Checking whether the user already exits or not: '{}'", userData.getLogin());
			User user = null;
			try {
				user = pm.getObjectById(User.class, userData.getLogin());
			} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
				logger.info("Exception launched: {}", jonfe.getMessage());
			}
			logger.info("User: {}", user);
			if (user != null) {
				logger.info("Setting password user: {}", user);
				user.setPassword(userData.getPassword());
				logger.info("Password set user: {}", user);
			} else {
				logger.info("Creating user: {}", user);
				user = new User(userData.getNickname(), userData.getPassword(), userData.getDni(), userData.getAge(),userData.getCity(), false);
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
                if(!user.getPassword().equals(userData.getPassword())) {
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
