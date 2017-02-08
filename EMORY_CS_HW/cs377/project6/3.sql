select supplier.snum,sname

from supplier,spj,proj,part

where supplier.snum = spj.snum

and proj.jnum = spj.jnum

and part.pnum = spj.pnum

group by spj.snum,spj.jnum

having count(distinct spj.pnum) >3
