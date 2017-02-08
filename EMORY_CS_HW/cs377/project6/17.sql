Select snum A,sname

From supplier s

Where not exists 

(Select * 

From part

Where pnum in(Select spj.pnum

From part,spj,proj

where part.pnum =spj.pnum

and spj.jnum = proj.jnum

and proj.city = 'Atlanta')

and pnum not in

(Select pnum

From spj

Where s.snum = spj.snum))

order by A
