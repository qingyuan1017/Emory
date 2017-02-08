select distinct snum A,sname
from supplier 
where snum in(
select distinct supplier.snum
from proj,spj,supplier
where proj.jnum = spj.jnum
and supplier.snum = spj.snum
and proj.city = 'Rome')
and snum not in(select snum
from supplier s
where  not exists
(select jnum
from proj
where jnum in (select proj.jnum
from proj
where proj.city ='Rome')
and jnum not in (
select jnum
from spj
where spj. snum = s.snum))
)
order by A
