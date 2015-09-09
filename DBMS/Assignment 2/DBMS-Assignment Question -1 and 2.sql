CREATE DATABASE library;

USE library;

CREATE TABLE Author(
author_id INT PRIMARY KEY AUTO_INCREMENT,
author_Name VARCHAR(50)
);

CREATE TABLE Publishers(
publisher_Id INT PRIMARY KEY,
publisher_Name VARCHAR(50)
);

CREATE TABLE Subjects(
subject_Id INT PRIMARY KEY AUTO_INCREMENT,
subject_Name varchar(50)
);

CREATE TABLE Members(
member_Id INT PRIMARY KEY AUTO_INCREMENT,
member_Name VARCHAR(50),
addressLine1 VARCHAR(50),
addressLine2 VARCHAR(50),
category CHAR(1)
);

CREATE TABLE Title(
title_Id INT PRIMARY KEY AUTO_INCREMENT,
title_Name VARCHAR(50),
subject_Id INT,
publisher_Id INT,
FOREIGN KEY (subject_Id) REFERENCES Subjects(subject_Id) ON DELETE CASCADE,
FOREIGN KEY (publisher_Id) REFERENCES Publishers(publisher_Id) ON DELETE CASCADE
);

CREATE TABLE Title_Author(
title_Id INT,
author_Id INT,
PRIMARY KEY(title_Id, author_Id),
FOREIGN KEY (title_Id) REFERENCES Title(title_Id) ON DELETE CASCADE,
FOREIGN KEY (author_Id) REFERENCES Author(author_Id) ON DELETE CASCADE
);

CREATE TABLE Books(
accessiON_No INT PRIMARY KEY AUTO_INCREMENT,
title_Id INT,
purchASe_Date DATE,
price REAL,
status INT 
CHECK (status = 0 OR status = 1)
);

CREATE TABLE Book_Issue(
issue_Date DATE,
accessiON_No INT,
member_Id INT,
due_Date DATE,
PRIMARY KEY(issue_Date, accessiON_No, member_Id),
FOREIGN KEY(accessiON_No) REFERENCES Books(accessiON_No) ON DELETE CASCADE,
FOREIGN KEY(member_Id) REFERENCES Members(member_Id) ON DELETE CASCADE
);

CREATE TABLE Book_Return(
return_Date DATE,
accessiON_No INT,
member_Id INT,
issue_Date DATE,
PRIMARY KEY(return_Date, accessiON_No, member_Id),
FOREIGN KEY(accessiON_No) REFERENCES Books(accessiON_No) ON DELETE CASCADE,
FOREIGN KEY(member_Id) REFERENCES Members(member_Id) ON DELETE CASCADE
);


SHOW TABLES;

ALTER TABLE Book_Issue MODIFY COLUMN issue_Date TIMESTAMP NOT NULL DEFAULT NOW();
DELIMITER ;;
CREATE TRIGGER book_due_date BEFORE INSERT ON Book_Issue FOR EACH ROW
BEGIN
    UPDATE Book_Issue SET due_Date = DATE_ADD(NOW(), INTERVAL 15 DAY) WHERE issue_Date = NOW();
END;;
DELIMITER ;

DESCRIBE Book_Issue;

DROP TRIGGER book_due_date;
DROP TABLE Book_Issue;
DROP TABLE Book_Return;
DROP TABLE Members;

CREATE TABLE Members(
member_Id INT PRIMARY KEY AUTO_INCREMENT,
member_Name VARCHAR(50),
addressLine1 VARCHAR(50),
addressLine2 VARCHAR(50),
category CHAR(1)
);

CREATE TABLE Book_Issue(
issue_Date DATE,
accessiON_No INT,
member_Id INT,
due_Date DATE,
PRIMARY KEY(issue_Date, accessiON_No, member_Id),
FOREIGN KEY(accessiON_No) REFERENCES Books(accessiON_No) ON DELETE CASCADE,
FOREIGN KEY(member_Id) REFERENCES Members(member_Id) ON DELETE CASCADE
);

CREATE TABLE Book_Return(
return_Date DATE,
accessiON_No INT,
member_Id INT,
issue_Date DATE,
PRIMARY KEY(return_Date, accessiON_No, member_Id),
FOREIGN KEY(accessiON_No) REFERENCES Books(accessiON_No) ON DELETE CASCADE,
FOREIGN KEY(member_Id) REFERENCES Members(member_Id) ON DELETE CASCADE
);

ALTER TABLE Book_Issue MODIFY COLUMN issue_Date TIMESTAMP NOT NULL DEFAULT NOW();
DELIMITER ;;
CREATE TRIGGER book_due_date BEFORE INSERT ON Book_Issue FOR EACH ROW
BEGIN
  SET NEW.due_date = DATE_ADD(NOW(), INTERVAL 15 DAY);  
END;;
DELIMITER ;

INSERT INTO author VALUES(101,'yAShwant kanitkar');
INSERT INTO author VALUES(102,'james');
INSERT INTO author VALUES(103,'joff');
INSERT INTO author VALUES(104,'abc');
INSERT INTO author VALUES(105,'ram');

INSERT INTO publishers VALUES(1,'a');
INSERT INTO publishers VALUES(2,'b');
INSERT INTO publishers VALUES(3,'c');
INSERT INTO publishers VALUES(4,'d');
INSERT INTO publishers VALUES(5,'e');

INSERT INTO members VALUES (1000,"udit","abc","xyz","m");
INSERT INTO members(member_name,addressline1,addressline2,category) VALUES('nagar','cab','xyz','f');
INSERT INTO members(member_name,addressline1,addressline2,category) VALUES('udit','abc','xyz','f');
INSERT INTO members(member_name,addressline1,addressline2,category) VALUES('udit','abc','xyz','f');
INSERT INTO members(member_name,addressline1,addressline2,category) VALUES('udit','abc','xyz','f');


INSERT INTO books(accessiON_no,title_id,purchASe_date,price,status) VALUES(500,400,"2015-05-21",100.00,1);
INSERT INTO books(accessiON_no,title_id,purchASe_date,price,status) VALUES(501,400,"2015-05-21",100.00,1);
INSERT INTO books(accessiON_no,title_id,purchASe_date,price,status) VALUES(502,401,"2015-05-21",100.00,1);
INSERT INTO books(accessiON_no,title_id,purchASe_date,price,status) VALUES(503,401,"2015-05-21",100.00,1);
INSERT INTO books(accessiON_no,title_id,purchASe_date,price,status) VALUES(504,402,"2015-05-21",100.00,1);


INSERT INTO subjects VALUES(700,"dbms");
INSERT INTO subjects VALUES(701,"adbms");
INSERT INTO subjects VALUES(702,"dsa");
INSERT INTO subjects VALUES(703,"pf");
INSERT INTO subjects VALUES(704,"java");

INSERT INTO title VALUES(1200,"abc",700,1);
INSERT INTO title VALUES(1201,"ab",700,1);
INSERT INTO title VALUES(1202,"a",701,2);
INSERT INTO title VALUES(1203,"b",701,2);
INSERT INTO title VALUES(1204,"c",704,3);


INSERT INTO title_author VALUES(1200,102);
INSERT INTO title_author VALUES(1201,102);
INSERT INTO title_author VALUES(1202,101);
INSERT INTO title_author VALUES(1202,104);
INSERT INTO title_author VALUES(1204,104);

INSERT INTO book_issue(accessiON_no,member_id) VALUES(500,1000);
INSERT INTO book_issue(accessiON_no,member_id) VALUES(503,1000);
INSERT INTO book_issue(accessiON_no,member_id) VALUES(501,1001);
INSERT INTO book_issue(accessiON_no,member_id) VALUES(502,1001);
INSERT INTO book_issue(accessiON_no,member_id) VALUES(502,1002);

INSERT INTO book_return VALUES("2015-01-04",500,1000,"2015-01-02");
INSERT INTO book_return VALUES("2015-01-03",500,1000,"2014-01-02");
INSERT INTO book_return VALUES("2015-01-02",501,1001,"2014-01-02");
INSERT INTO book_return VALUES("2015-01-01",502,1001,"2011-01-02");
INSERT INTO book_return VALUES("2015-01-04",502,1002,"2014-01-02");

SELECT * FROM members;

SELECT member_name,member_id,category FROM members;

SELECT member_name,member_id,category FROM members WHERE category = "f";

SELECT DISTINCT category FROM members;

SELECT member_name,category FROM members order by member_name desc;

SELECT  title_name,subject_name,publisher_name FROM title t,publishers p,subjects s WHERE p.publisher_id=t.publisher_id AND s.subject_id=t.subject_id;

SELECT category,COUNT(*)  FROM members GROUP BY category;

SELECT member_name FROM members  WHERE category in(SELECT category FROM members WHERE member_name="keshav sharma"); 

SELECT bi.issue_date,bi.accessiON_no,bi.member_id,ifnull(br.return_date,"") AS Return_date FROM book_issue bi LEFT OUTER JOIN book_return br ON bi.accessiON_no=br.accessiON_no AND bi.member_id=br.member_id; 

-- qn no 2

SELECT bi.issue_date,bi.accessiON_no,bi.member_id,ifnull(br.return_date,"") AS Return_date 
FROM book_issue bi LEFT OUTER JOIN book_return br ON bi.accessiON_no=br.accessiON_no AND bi.member_id=br.member_id ,members m 
WHERE m.member_id=bi.member_id 
ORDER BY bi.issue_date ASC; 