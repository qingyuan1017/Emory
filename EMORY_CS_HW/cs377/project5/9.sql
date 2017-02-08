select distinct jnum A
from spj
where jnum not in
(select distinct spj.jnum 
from spj,proj,part
where spj.jnum = proj.jnum
and spj.pnum =part.pnum
and proj.city = part.city)
order by A
