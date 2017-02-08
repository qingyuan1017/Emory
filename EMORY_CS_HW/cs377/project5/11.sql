select distinct jnum A,jname
from proj p
where not exists 
(select *
from part
where pnum in ( select pnum
from spj 
where spj.jnum = p.jnum)
and pnum not in (
select pnum
from part
where part.color = 'red'))
Order by A
