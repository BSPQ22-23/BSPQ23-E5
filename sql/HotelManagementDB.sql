DROP SCHEMA IF EXISTS HotelManagement;
DROP USER IF EXISTS 'spq'@'localhost';

CREATE SCHEMA HotelManagement;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';

GRANT ALL ON HotelManagement.* TO 'spq'@'localhost';