select snum A, sname B
from supplier 
where snum in 
(select snum
from spj,part
where spj.pnum = part.pnum
and part.pname = 'nut')
order by A

