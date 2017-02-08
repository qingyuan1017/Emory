select distinct proj.jnum A, jname

from proj,spj

where spj.jnum =proj.jnum

and spj.pnum in

(select pnum

from part

where weight = (select max(weight)

from part

where pnum not in  

(select pnum   

from part   

where weight = (select max(weight)

from part))))

order by A
