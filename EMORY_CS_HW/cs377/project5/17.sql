select snum A,sname
from supplier 
where snum in(select snum
from supplier s
where  not exists
(select pnum
from part
where pnum in (select part.pnum
from part
where part.color ='Blue')
and pnum not in (
select pnum
from spj
where spj. snum = s.snum)))
and snum in(select snum 
from supplier s
where  not exists
(select pnum
from part
where pnum in(
select pnum
from spj
where spj. snum = s.snum)
and pnum not in(select part.pnum
from part
where part.color !='green')))
order by A
