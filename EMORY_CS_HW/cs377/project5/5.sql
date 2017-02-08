select distinct jnum A
from spj
where pnum in
(select pnum
from spj 
where spj.snum = 's4')
order by A
