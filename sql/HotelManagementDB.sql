
/* DELETE 'HotelManagementDB' database*/
DROP SCHEMA IF EXISTS HotelManagerDB;
/* DELETE USER 'strava_user' AT LOCAL SERVER*/
DROP USER IF EXISTS 'spq'@'localhost';

/* CREATE 'stravadb' DATABASE */
CREATE SCHEMA IF NOT EXISTS HotelManagerDB;
/* CREATE THE USER 'strava_user' AT LOCAL SERVER WITH PASSWORD 'strava_user' */
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
/* GRANT FULL ACCESS TO THE DATABASE 'HotelManagementDB' FOR THE USER 'strava_user' AT LOCAL SERVER*/
GRANT ALL ON  HotelManagerDB.* TO 'spq'@'localhost';