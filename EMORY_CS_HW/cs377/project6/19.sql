Select jnum A, jname

From proj p

Where not exists 

(Select * 

From part

Where pnum in(Select pnum

From part

where weight >15)

and pnum not in

(Select pnum

From spj

Where p.jnum = spj.jnum))

order by A
