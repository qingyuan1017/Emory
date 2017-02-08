select jnum A,jname
from proj p
where not exists 
(select pnum
from part
where pnum in (select pnum
from spj
where spj.jnum ='j3' )
and pnum not in (select pnum
from spj
where spj.jnum = p.jnum))
Order by A

