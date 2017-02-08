select distinct A.snum, A.sname
from supplier A
where
not exists (
select *
from proj
where
city=A.city
and jnum not in
(select distinct jnum
from spj
where spj.snum=A.snum
group by jnum
having count(pnum)>=3))
order by A.snum, A.sname
