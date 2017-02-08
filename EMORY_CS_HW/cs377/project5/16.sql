select jnum A,jname
from proj p
where not exists 
(select *
from part
where pnum in(select pnum 
from spj
where spj.jnum = p.jnum)	
and pnum not in
 (select  distinct pnum 
from part
where p.city = part.city
))
order by A
