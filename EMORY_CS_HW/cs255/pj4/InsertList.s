
* *******************************************************************************
* I worked on this assignment alone, using only this semester's course materials.
* Qingyuan Zhang
* ********************************************************************************

	xdef InsertList

InsertList:

* ********************************************************************
* Put your InsertList function here 
* Remember, you must have a RECURSIVE implementation
* Iterative solutions will receive little/no credit
* ********************************************************************

	move.l A6, -(A7)
	move.l A7, A6
	suba.l #4, A7		* local variable help

	move.l 12(A6), D0	
	cmp.l #0, D0		* head == null
	beq thenPart

	move.l 12(A6), A0 	*A0 = head.value
	move.l (A0), D2	        *D2 = head.value
	move.l 8(A6), A0
	move.l (A0), D3		*D2 = elem.value
	cmp.l D3, D2
	bge elsepart

thenPart:
	move.l 8(A6), A0	* A0 = elem
	move.l  12(A6), 4(A0)   * elem.next = head

	move.l 8(A6), D0	* return elem

	move.l A6, A7		* postlude
	move.l (A7)+, A6

	rts
elsepart:
	move.l 12(A6), A0	* A0 = head
	move.l 4(A0), -(A7)	* stack add head.next
	move.l 8(A6), -(A7)	* stack add elem
	bsr InsertList
	adda.l #8, A7		
	
	move.l D0, -4(A6)	* help =return value

	move.l 12(A6), A0	* a0 = head
	move.l -4(A6), 4(A0)	* head.next = help
	
	move.l 12(A6), D0	* d0 = head return value
	
	move.l A6, A7		*postlude
	move.l (A7)+, A6

	rts








        end
