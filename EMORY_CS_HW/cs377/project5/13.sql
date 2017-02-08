select snum A,sname
from supplier s
where  exists
(select jnum
from proj
where jnum in (select proj.jnum
from proj
where proj.city ='Rome')
and jnum not in (
select jnum
from spj
where spj. snum = s.snum))
order by A
