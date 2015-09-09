
select node.name as node_name , IFNULL(parent1.name,'Top Category') as parent_name , parent2.name as parent2_name , parent3.name as parent3_name 
from categories as node left outer join categories as parent1 on parent1.id = node.parentid  
left outer join categories as parent2 on parent2.id = parent1.parentid  
left outer join categories as parent3 on parent3.id = parent2.parentid;
    
SELECT name FROM categories where parentId is null ;
