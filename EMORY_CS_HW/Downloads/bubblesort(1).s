        xdef BubbleSort


BubbleSort:
******************************************************
* Write your bubble sort assembler subroutine here
******************************************************
	muls	#4,	d1
	add.l	#-4,	d1
A:	move.l	d0,	a0
	move.l	#0,	c
	move.l	#1,	k
B:	move.l	(a0),	d2
	move.l	a0,	a1
	add.l	#4,	a1
	move.l	(a1),	d3
	cmp.l	d2,	d3
	bgt	L
	move.l	d3,	(a0)
	move.l	d2,	(a1)
	move.l	#0,	k
L:	add.l	#4,	a0
	add.l	#4,	c
	cmp.l	c,	d1
	bgt	C
	move.l	#1,	d4
	cmp.l	k,	d4
	beq	END
	bra	A
C:	bra	B
END:

	rts

* *****************************************************************************
* If you need local variables, you can add variable definitions below this line
* *****************************************************************************
c:	dc.l	0
k:	dc.l	1

        end
