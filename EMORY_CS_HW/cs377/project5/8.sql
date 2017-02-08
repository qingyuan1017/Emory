select snum A, sname
from supplier
where snum not in 
(select snum 
from spj,part
where spj.pnum = part.pnum
and part.pname='nut')
order by A
