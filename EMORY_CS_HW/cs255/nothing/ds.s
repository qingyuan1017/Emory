* Demonstrate the effect of DS directive
* Assemble with: as255 ds
* Look at the output file a.lst
	ORG $1000
	move.b d0, d1
	move.b d0, d1
A:	ds.b 10
	move.b d0, d1
	move.b d0, d1
B:	ds.w 10
	move.b d0, d1
	move.b d0, d1
C:	ds.l 10
	move.b d0, d1
	move.b d0, d1
	end

