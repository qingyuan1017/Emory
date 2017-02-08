select distinct sname A
from supplier 
where snum not in
(select distinct snum 
from spj,part
where spj.pnum = part.pnum
and part.weight > 18)
order by A
