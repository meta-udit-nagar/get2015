create database if not exists vehical_dekho;

use vehical_dekho;

create table if not exists tbl_admin(
admin_id integer(5) auto_increment,
username varchar(100) not null,
password varchar(100) not null,
created_by varchar(100) not null,
created_time Date not null,
primary key(admin_id)
);

CREATE TABLE if not exists tbl_vehicle
(
    vehicle_id INT auto_increment,
    make VARCHAR(100) NOT NULL,
	model VARCHAR(100)NOT NULL,
	engin_in_cc INT NOT NULL,
	fuel_capacity INT NOT NULL,
	milage INT NOT NULL,
	price DOUBLE NOT NULL,
	roadTax DOUBLE NOT NULL,
    created_by VARCHAR(100) NOT NULL,
    created_time Date NOT NULL,
	PRIMARY KEY(vehicle_id)
);

CREATE TABLE if not exists tbl_car
(   car_id int auto_increment,   
   vehicle_id INT NOT NULL,
    ac ENUM('true','false') NOT NULL,
	power_steering ENUM('true','false') NOT NULL,
	accessory_kit ENUM('true','false') NOT NULL,
    created_by varchar(100) not null,
    created_time varchar(100) not null,
	PRIMARY KEY(car_id),
	FOREIGN  KEY(vehicle_id) REFERENCES tbl_vehicle(vehicle_id) ON DELETE CASCADE
);




