  -- Assignment 1
USE lib;
 -- qn 1

SELECT member_name FROM members  WHERE category IN(SELECT category FROM members WHERE member_name="keshav sharma");
-- qn 2
SELECT bi.issue_date,t.title_name,m.member_name,bi.due_date FROM book_issue bi,title t,members m ,books b 
WHERE bi.accession_no=b.accession_no 
AND b.title_id=t.title_id
AND bi.member_id=m.member_id
AND (bi.member_id,bi.accession_no) NOT IN(SELECT br.member_id,br.accession_no FROM book_return br);

-- qn 3
SELECT bi.issue_date, t.title_name, m.member_name ,bi.due_date FROM book_issue bi,title t,members m ,books b
WHERE bi.accession_no=b.accession_no 
AND b.title_id=t.title_id
AND bi.member_id=m.member_id
AND exists(SELECT  br.member_id,br.accession_no FROM book_return br WHERE datediff(bi.due_date,br.return_date)<0);

-- qn 4 
SELECT * FROM books WHERE price = (SELECT max(price) FROM books);

  -- qn 5
SELECT price FROM(SELECT price FROM books 
GROUP BY price
ORDER BY price DESC
LIMIT 2)  ORDER BY price asc LIMIT 1;



-- assignment 2
-- qn 1

CREATE VIEW memberRecord
AS
SELECT m.member_name,bi.* FROM book_issue bi,members m WHERE bi.member_id=m.member_id;

SELECT * FROM memberRecord;

-- qn 2

Create view memberDetail
AS
  
SELECT  member_id,member_name, CASE  category when 'f' then "faculty" when 's' then "student" else "others" end as "hello" FROM members; 

-- qn 3

create view returnDetails
as
SELECT s.subject_name,m.member_name,t.title_id,m.category,bi.issue_date,bi.due_date,br.return_date 
FROM book_issue bi left outer joIN book_return br on bi.accession_no=br.accession_no AND bi.member_id=br.member_id, 
subjects s,members m ,title t,books b WHERE m.member_id=bi.member_id AND t.subject_id=s.subject_id AND t.title_id=b.title_id
AND b.accession_no=bi.accession_no

