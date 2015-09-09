CREATE DATABASE zipcodeInfo;
USE zipcodeInfo;

 CREATE TABLE zipcodeNumber
(
	zipcode int PRIMARY KEY AUTO_INCREMENT
);
CREATE TABLE cityInfo
(
	-- To store zip code and name
	zipcode int PRIMARY KEY AUTO_INCREMENT,
	cityName varchar(20),
	FOREIGN KEY (zipcode) REFERENCES zipcodeNumber(zipcode) 
);
CREATE TABLE stateInfo
(
	-- to store zipcode and stateName
	zipcode int PRIMARY KEY ,
	stateName varchar(20),
	FOREIGN KEY (zipcode) REFERENCES zipcodeNumber(zipcode) 
);
 
 INSERT INTO zipcodeNumber(zipcode) VALUES (800001);
 INSERT INTO zipcodeNumber(zipcode) VALUES (800002);
 INSERT INTO zipcodeNumber(zipcode) VALUES (800003);
 
 INSERT INTO cityInfo(zipcode,cityName) VALUES (800001,'patna');
 INSERT INTO cityInfo(cityName) VALUES ('jaipur');
 INSERT INTO cityInfo(cityName) VALUES ('delhi');
 
 INSERT INTO stateInfo(zipcode,stateName) VALUES (800001,'bihar');
 INSERT INTO stateInfo(stateName) VALUES ('rajasthan');
 INSERT INTO stateInfo(stateName) VALUES ('delhi');
 
 
 SELECT z.zipcode,cityName,stateName from zipcodeNumber z, cityInfo c, stateInfo s where ((z. zipcode=c.zipcode)&&(z.zipcode=s.zipcode)) ORDER BY stateName asc , cityName asc;

 
 
 
 