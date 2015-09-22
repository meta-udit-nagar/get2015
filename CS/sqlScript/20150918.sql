CREATE DATABASE vehicleDB;
USE vehicleDB;
CREATE TABLE tbl_vehicle
(
    id INT NOT NULL,
    make VARCHAR(100) NOT NULL,
	model VARCHAR(100)NOT NULL,
	engin_in_cc INT NOT NULL,
	fuel_capacity INT NOT NULL,
	milage INT NOT NULL,
	price DOUBLE NOT NULL,
	roadTax DOUBLE NOT NULL,
    created_by VARCHAR(100) NOT NULL,
    created_time VARCHAR(100) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE tbl_car
(   vehical_id INT NOT NULL,
    ac ENUM('true','false') NOT NULL,
	power_steering ENUM('true','false') NOT NULL,
	accessory_kit ENUM('true','false') NOT NULL,
	PRIMARY KEY(vehical_id),
	FOREIGN  KEY(vehical_id) REFERENCES tbl_vehicle(id) ON DELETE CASCADE
);

CREATE TABLE tbl_bike
(

    vehical_id INT NOT NULL,
	self_start ENUM('true','false') NOT NULL,
	helmet_prize DOUBLE NOT NULL ,
	PRIMARY KEY(vehical_id),
	FOREIGN  KEY(vehical_id) REFERENCES tbl_vehicle(id) ON DELETE CASCADE

);
