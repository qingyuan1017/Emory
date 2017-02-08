select distinct A.snum,A.sname

from part,spj,supplier A

where 

spj.pnum=part.pnum

and spj.snum=A.snum

and weight in  

(select min(weight)

from spj,part

where spj.snum=A.snum

and spj.pnum=part.pnum

) 

and color="Blue"

order by A.snum,A.sname
