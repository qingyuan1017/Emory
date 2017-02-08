* I worked on this assignment alone, using only this semester's course materials.
* Qingyuan Zhang


* ********************************************************************
* Do not touch the following 2 xdef lists:
* ********************************************************************
        xdef Start, Stop, End
        xdef a, b, len_a, len_b, min, max, sum, common

* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
* You can add more xdef here to export labels to EGTAPI
* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
*      Put your assembler program here - between the start and stop label
*      DO NOT define any variables here - see the variable section below
* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Start:
         move.l #0, d2        * D2 = sum
         move.l #0, d1        * D1 = Loop count (i)
         move.l #a, a0        * A0 points to next array element
	 move.l (a0), d0      * d0 = A[0]
	 move.l 0(a0), min    * min = A[0]
	 move.l 0(a0), max    * max = A[0]


WhileStartA:
         cmp.l #5, d1
         bge  WhileEndA
	 move.l (a0), d0		
         add.l  (a0), d2      * sum = sum + A[i]
	 cmp.l min, d0	      *Test A[i] against min
	 bge  skipMinPartA     *Skip over the min part if A[i] >= min
	 move.l d0, min       *ThenPart: min = A[i] 
skipMinPartA:
	 cmp.l max, d0	      *Test A[i] with max
	 ble  skipMaxPartA    *Skip over the max part if A[i] <= max
	 move.l d0, max       *ThenPart: max = A[i] 
skipMaxPartA:	
         adda.l #4, a0        * A0 points to next array element
         add.l  #1, d1        * i = i + 1
         bra WhileStartA
WhileEndA:
         move.l d2, sum       * Put accumulated sum d0 to variable sum


         move.l #0, d4        * D4 = sum
         move.l #0, d1        * D1 = Loop count (i)
         move.l #b, a0        * A0 points to next array element
	 move.l (a0), d3      * d3 = B[0]


WhileStartB:
         cmp.l #6, d1
         bge  WhileEndB
	 move.l (a0), d3
         add.l  (a0), d4      * sum = sum + A[i]
 	 cmp.l min, d3	      *TestB[i] against min
	 bge  skipMinPartB     *Skip over the then part if A[i] >= min
	 move.l d3, min       *ThenPart: min = B[i] 
skipMinPartB:
	 cmp.l max, d3	      *Test B[i] agains max
	 ble  skipMaxPartB    *Skip over the then part if A[i] >= min
	 move.l d3, max      *ThenPart: min = B[i] 
skipMaxPartB:	
         adda.l #4, a0       
         add.l  #1, d1        
         bra WhileStartB
WhileEndB:

         add.l d4, sum       * Put accumulated sum d0 to variable sum





	move.l #0, d1        * D1 = Loop count (i)
	move.l #0, d2        * D2 = Loop count (j)
	move.l #0, d5        * common = 0
	move.l #a, a0        * A0 points to next array A element
	move.l (a0), d0      * d0 = A[0]
	

LoopStartA:	
	cmp.l #5, d1
        bge  LoopEndA
	move.l (a0), d0
	move.l #b, a1        * A1 points to next array B element
	move.l #0, d2        * D1 = Loop count (j)
LoopStartB:
	cmp.l #6, d2
        bge  LoopEndB
	move.l (a1), d3
	cmp.l d3, d0	      
	bne  skipcommon       *Skip over the then part if A[i] !=B[j]
	add.l #1, d5
skipcommon:	
	 adda.l #4, a1        * A1 points to next array element
         add.l  #1, d2        * j = j + 1
         bra LoopStartB
LoopEndB
	 adda.l #4, a0        * A0 points to next array element
         add.l  #1, d1        * i = i + 1
         bra LoopStartA

LoopEndA
	move.l d5, common
	






 
 




* ********************************************************************
* Don't touch the stop label - you need it to stop the program
* ********************************************************************
Stop:   nop


End:    nop

* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
*    Variable Section -   Put your variables here
*
*    Do not define any of the variables specified in the program
*    They are already defined below
*    This section is for any temporary variables you might need
* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++



* ********************************************************************
* XXXX Don't touch anything below this line !!!
* ********************************************************************
a:      dc.l  1, 2, 3, 4, 5
b:      dc.l  6, 7, 8, 9, 10, 11 
len_a: 	equ 5
len_b:	equ 6
min:	ds.l 1
max:	ds.l 1
sum:	ds.l 1
common:	ds.l 1

        end 
