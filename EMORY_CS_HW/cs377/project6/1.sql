select supplier.snum A,sname

from supplier

where snum in

(select supplier.snum

from supplier,spj,proj

where supplier.snum = spj.snum

and proj.jnum = spj.jnum

and proj.city ='Rome'

group by spj.snum

having count(distinct spj.jnum) >2)

and snum in

(select supplier.snum

from supplier

where snum in

(select distinct supplier.snum

from supplier,spj,proj

where supplier.snum = spj.snum

and proj.jnum = spj.jnum

and proj.city ='Paris'

group by spj.snum

having count(distinct spj.jnum) <4)

or snum in 

(select distinct supplier.snum

from supplier,spj,proj

where supplier.snum = spj.snum

and proj.jnum = spj.jnum

and proj.city !='Paris'

group by spj.snum))

order by A
