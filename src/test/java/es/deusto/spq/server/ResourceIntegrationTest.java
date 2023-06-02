package es.deusto.spq.server;



import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotEquals;

import java.util.UUID;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import org.junit.AfterClass;
import org.junit.Before;


import org.junit.Test;
import org.junit.experimental.categories.Category;

import categories.IntegrationTest;
import es.deusto.spq.pojo.UserData;

import es.deusto.spq.jdo.User;

@Category(IntegrationTest.class)
public class ResourceIntegrationTest {

private static final PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    
    private static Resource source;
    private WebTarget target;

    

    @Before
    public void setUp() {
    	// create the client
    	 Client c = ClientBuilder.newClient();
        target = c.target("http://localhost:8080/rest").path("resource");
    }
    @AfterClass
    public static void tearDownServer() throws Exception {
        

        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try {
            tx.begin();
            pm.newQuery(User.class).deletePersistentAll();
            
            tx.commit();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }
    }

    

    @Test
    public void testLoginWithError() {
    	UserData user = new UserData();
    	
        user.setNickname("A");
        user.setPassword("A");


    }
    

    @Test
    public void testRegisterWithError() {
        UserData user = new UserData();
       
        user.setNickname("A");
        user.setLastname("A");
        user.setPassword("A");
    }
}