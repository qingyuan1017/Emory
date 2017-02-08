select  distinct spj.jnum A
from spj,supplier,part,proj
where spj.snum = supplier.snum
and spj.jnum =proj.jnum
and spj.pnum = part.pnum
and proj.city = supplier.city 
and proj.city = part.city
order by A
