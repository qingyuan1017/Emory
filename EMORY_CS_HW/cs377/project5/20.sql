select snum A,sname
from supplier s
where not exists 
(select *
from proj
where jnum in(select jnum 
from spj
where spj.snum = s.snum)	
and jnum not in
 (select  distinct jnum 
from proj
where proj.city = 'Rome'
))
order by A
