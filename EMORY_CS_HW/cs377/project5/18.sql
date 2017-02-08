select snum A, sname
from  supplier
where ( select count(distinct color)
from spj, part
where spj.pnum = part.pnum
and supplier.snum = spj.snum )    
=
(select count(distinct color) 
 from part  )
order by A
