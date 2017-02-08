Select supplier.snum,sname,part.pnum,pname

From supplier,part,spj

where supplier.snum = spj.snum

and part.pnum = spj.pnum

group by snum,pnum

having count(distinct jnum) >3

order by supplier.snum ,sname ,part.pnum,pname
