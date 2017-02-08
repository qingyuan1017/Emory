select distinct jnum A , jname
from proj
where jnum not in
(select jnum 
from spj,part
where spj.pnum = part.pnum
and part.color = 'red')
order by A
