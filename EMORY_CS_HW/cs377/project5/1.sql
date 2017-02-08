select distinct pnum A
from spj,supplier,proj
where spj.snum=supplier.snum
and spj.jnum=proj.jnum
and proj.city = 'London'
and supplier.city = 'London'
ORDER by A
