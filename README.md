HOTEL MANAGER 
----------------------


First, the whole code can be compile using:
<<<<<<< HEAD
=======
	
	mvn install -DskipTests
>>>>>>> 1bbcaec (update)

    mvn compile
Run this command to compile all the junit test:
	
	mvn test
	mvn verify
	mvn site

Make sure that the database was correctly configured. Use the contents of the file create-productsdb.sql to create the database and grant privileges:


	mysql –uroot -p < sql/HotelManagementDB.sql
Run this  command to enhance the database classes:

	mvn datanucleus:enhance
Run the following command to create database schema for this sample.

	mvn datanucleus:schema-create
	
Then, in three separate shell windows, run the following commands:

1. Run the server:

    mvn jetty:run 
 or   
  
    mvn exec:java -Pmanager
 2.Run the client:
 
    mvn exec:java -Pclient
Run the following command to generate the Javadoc documentation inside the target/site/apidocs directory

	mvn javadoc:javadoc