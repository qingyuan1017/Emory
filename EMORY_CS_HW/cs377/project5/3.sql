select distinct spj.pnum A
from spj,proj
where spj.jnum = proj.jnum
and proj.city = 'Paris'
order by A
