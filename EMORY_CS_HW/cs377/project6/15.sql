select distinct A.snum, A.sname

from supplier A

where

not exists (

select *

from proj

where 

city not in 

(select distinct city

from spj,proj

where spj.snum=A.snum

and spj.jnum=proj.jnum

group by city

having count(pnum)>=3)

)

order by A.snum,A.sname
