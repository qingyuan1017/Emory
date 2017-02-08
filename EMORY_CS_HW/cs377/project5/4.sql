select distinct spj.pnum A
from spj
where pnum not in
(select distinct spj.pnum 
from spj,proj
where spj.jnum = proj.jnum
and proj.city = 'Paris')
order by A
