CREATE DATABASE lib;

USE lib;

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
accession_No INT PRIMARY KEY AUTO_INCREMENT,
title_Id INT,
purchase_Date DATE,
price REAL,
status INT 
CHECK (status = 0 OR status = 1),
FOREIGN KEY (title_id) REFERENCES title(title_id) ON DELETE CASCADE 
);

CREATE TABLE Book_Issue(
issue_Date DATE,
accession_No INT,
member_Id INT,
due_Date DATE,
PRIMARY KEY(issue_Date, accession_No, member_Id),
FOREIGN KEY(accession_No) REFERENCES Books(accession_No) ON DELETE CASCADE,
FOREIGN KEY(member_Id) REFERENCES Members(member_Id) ON DELETE CASCADE
);

CREATE TABLE Book_Return(
return_Date DATE,
accession_No INT,
member_Id INT,
issue_Date DATE,
PRIMARY KEY(return_Date, accession_No, member_Id),
FOREIGN KEY(accession_No) REFERENCES Books(accession_No) ON DELETE CASCADE,
FOREIGN KEY(member_Id) REFERENCES Members(member_Id) ON DELETE CASCADE
);

INSERT INTO author VALUES(101,'yashwant kanitkar');
INSERT INTO author VALUES(102,'james');
INSERT INTO author VALUES(103,'joff');
INSERT INTO author VALUES(104,'abc');
INSERT INTO author VALUES(105,'ram');

INSERT INTO publishers VALUES(1,'a');
INSERT INTO publishers VALUES(2,'b');
INSERT INTO publishers VALUES(3,'c');
INSERT INTO publishers VALUES(4,'d');
INSERT INTO publishers VALUES(5,'e');

INSERT INTO members VALUES (1000,"udit","abc","xyz","f");
INSERT INTO members(member_name,addressline1,addressline2,category) VALUES('nagar','cab','xyz','s');
INSERT INTO members(member_name,addressline1,addressline2,category) VALUES('udit','abc','xyz','s');
INSERT INTO members(member_name,addressline1,addressline2,category) VALUES('udit','abc','xyz','f');
INSERT INTO members(member_name,addressline1,addressline2,category) VALUES('udit','abc','xyz','o');


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

INSERT INTO books(accession_no,title_id,purchase_date,price,status) VALUES(505,1200,"2015-05-21",100.00,1);
INSERT INTO books(accession_no,title_id,purchase_date,price,status) VALUES(506,1201,"2015-05-21",100.00,1);
INSERT INTO books(accession_no,title_id,purchase_date,price,status) VALUES(507,1201,"2015-05-21",120.00,1);
INSERT INTO books(accession_no,title_id,purchase_date,price,status) VALUES(508,1202,"2015-05-21",130.00,1);
INSERT INTO books(accession_no,title_id,purchase_date,price,status) VALUES(509,1200,"2015-05-21",140.00,1);

INSERT INTO title_author VALUES(1200,102);
INSERT INTO title_author VALUES(1201,102);
INSERT INTO title_author VALUES(1202,101);
INSERT INTO title_author VALUES(1202,104);
INSERT INTO title_author VALUES(1204,104);

INSERT INTO book_issue VALUES("2015-01-04",505,1000,"2015-02-02");
INSERT INTO book_issue VALUES("2015-01-03",505,1000,"2015-02-02");
INSERT INTO book_issue VALUES("2015-01-02",506,1001,"2015-04-02");
INSERT INTO book_issue VALUES("2015-01-01",506,1001,"2015-04-02");
INSERT INTO book_issue VALUES("2015-01-04",506,1001,"2015-01-15");

INSERT INTO book_return VALUES("2015-01-04",505,1000,"2015-01-02");
INSERT INTO book_return VALUES("2015-03-03",505,1000,"2014-01-02");
INSERT INTO book_return VALUES("2015-02-02",506,1001,"2014-01-02");
INSERT INTO book_return VALUES("2015-05-01",507,1001,"2011-01-02");
INSERT INTO book_return VALUES("2015-10-04",507,1002,"2014-01-02");

-- ASSIGNMENT 1
-- QN 1
SELECT m.member_name,m.member_Id,t.title_Name,t.title_Id,b.accession_No,b.issue_Date,b.due_Date , DATEDIFF(due_Date,issue_Date ) AS DiffDate  from Members m,Book_Issue b,Title t, Books bk
WHERE (m.member_id = b.member_id && t.title_id = bk.title_id && bk.accession_No = b.accession_No) &&( DATEDIFF(b.due_Date,b.issue_Date )) > 60 order By member_name ,title_Name;

-- QN 2

Select member_name,length(member_name) as lengthOfName from members where length(member_name) in (Select max(length(member_name)) from members);

-- QN 3
select count(distinct accession_no) from book_issue ;

--  Assignment 2
-- Qn 1

select s.subject_id,subject_name,count(subject_name)from title t,subjects s,books b where s.subject_id=t.subject_id and t.title_id=b.title_id group by subject_name; 

-- Qn 2

select * from book_issue where datediff(due_date,issue_date)>60; 


-- Qn 3

Select * from books where price>(select min(price) from books);

-- Assignment 3

-- Qn 1

select (Select count(category) from members where category="f") as female,(Select count(category) from members where category="s") as Students,(Select count(category) from members where category="o") as Others ;
 
-- Qn 2

select t.* from title t,book_issue bi,books b where b.accession_no=bi.accession_no and b.title_id=t.title_id group by t.title_id having count(bi.accession_no)>2;
-- Qn 3

select bi.* from  book_issue bi,members m where m.member_id=bi.member_id and m.category NOT IN("f");

-- Qn 4
select a.* from author a,title_author at,books b where a.author_id=at.author_id and at.title_id=b.title_id group by a.author_name ;

