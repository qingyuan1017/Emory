select snum A,sname
from supplier s
where  not exists
(select pnum
from part
where pnum in (select part.pnum
from part
where part.pname ='Bolt')
and pnum not in (
select pnum
from spj
where spj. snum = s.snum))
order by A
