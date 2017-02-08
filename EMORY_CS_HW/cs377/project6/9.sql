Select proj.jnum,jname,sum(qty*weight)

From proj,spj,part,supplier

Where proj.jnum = spj.jnum

And part.pnum = spj.pnum

and supplier.snum = spj.snum

And supplier.sname = 'Smith'

group by jnum
