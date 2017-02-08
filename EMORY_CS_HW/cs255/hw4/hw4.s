* Collaboration Statement:
* I worked on this assignment alone, using only this semester's course 
* materials.
* 
* Qingyuan Zhang

	xdef Start, Stop, End
	xdef Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10
	xdef A, B, C
	xdef i, j, k
	xdef head
	xdef ans_b, ans_w, ans_l

Start:
*******************************************************************
* Put your assembler instructions here
* Write the answer to each question after the corresponding label.
* DO NOT REMOVE ANY LABEL IN THIS ASSIGNMENT
* *** Failure to do so will result in point dedections !!! ***
*******************************************************************

Q1:
	 movea.l #A, A0		* A0 = base address of A array
         move.b 5(A0), ans_b   

*         ans_b = A[5];





Q2:
	movea.l #B, A0 		* A0 = base address of B array
        move.w 8(A0), D0
	ext.l D0
	move.l	D0,   ans_l 
*         ans_l = B[4];





Q3:	
	 move.l #C, A0	    	* A0 = base address of C array
	 move.l k, D0		* D0 = k
	 add.l D0, D0           * D0 = 2*k
	 add.l D0, D0           * D0 = 4*k
	 adda.l D0, A0		* A0 = C + 4*k
         move.l (A0), ans_l          
*        ans_l = C[k];





Q4:	 
	 move.l #A, A0	    	* A0 = base address of C array
	 move.w j, D0		* D0 = j
	 ext.l	d0
 	 move.l k, D1		* D1 = k
	 add.l D1, D0           * D0 = j+k
	 adda.l D0, A0		
         move.b (A0), D0
	 ext.w D0
	 move.w D0, ans_w           
	
*         ans_w = A[j + k];      




Q5:	 move.l #C, A0	    	* A0 = base address of C array
	 move.b i, D0		* D0 = i
	 ext.w	d0
	 ext.l	d0
 	 move.l k, D1		* D1 = k
	 add.l D1, D0           * D0 = j+k
	 add.l D0, D0           * D0 = 2*(k+j)
	 add.l D0, D0           * D0 = 4*(k+j)
	 adda.l D0, A0		
         move.l (A0), D1
	 move.w D1, ans_w 

*         ans_w = C[i + k];      




Q6:
	move.l	#A,	A0	* A0 = base address of A array
	move.w	j,	d0	* D0 = j
	ext.l	d0
	adda.l	d0,	A0
	move.b	(A0),	d1	* D1 = A[j]
	move.l	#B,	A1	* A1 = base address of B array
	move.b	i,	d2	* D2 = i
	ext.w	d2
	ext.l	d2
	add.l	d2,	d2	* D2 = i*2
	adda.l	d2,	A1
	move.w	(A1),	d3	* D3 = B[j]
	ext.w	d1
	add.w	d1,	d3	* D3 = A[j] + B[i]
	ext.l	d3
	move.l	d3,	ans_l

*         ans_l = A[j] + B[i];  




Q7:	
	move.l	#A,	A0	* A0 = base address of A array
	move.w	j,	d2	* D2 = j
	ext.l d2
	adda.l	d2,	A0
	move.b	(A0),	d0	* D0 = A[j]
	sub.b	#50,	d0	* A[j]-50
	ext.w	d0
	ext.l	d0
	move.l	#A,	A0
	adda.l	d0,	A0
	move.b	(A0),	d1	* D1 = A[A[j]-50]
	ext.w	d1
	ext.l	d1
	move.l	d1,	ans_l

*         ans_l = A[A[j] - 50];      



	
Q8:
	move.l	#B,	A0	* A0 = base address of B array
	add.l	#26,	A0	* A0 = address of B[13] array
	move.w	(A0),	ans_w	* Q8 = B[13]

*         ans_w = B[ 13 ]





Q9:	
	move.l	head,	A0	* A0 points to list 1
	move.l	(A0),	d0	
	move.l	d0,	ans_l

*	ans_l = head.value1;



Q10:
	
	move.l	head,	A0	* A0 points to list 1
	move.l	6(A0),	A0	* A0 points to list 2
	move.l	6(A0),	A0	* A0 points to list 3
	add.l	#4,	A0	* A0 = A0+4
	move.w	(A0),	d0	* A0 points to list 3.value2
	move.w	d0,	ans_w
*	  ans_w = head.next.next.value2;



*************************************************
* Don't write any code below this line
*************************************************

Stop:	nop
	nop

*************************************************
* Don't touch these variables
* You do NOT need to define more variables !!!
*************************************************

************************************************************************
* Note the use of the even directive to locate the variables ans_w and j
* at an EVEN address due to the variables ans_b and i being bytes
* Short and int variables MUST start on an even address (or you 
* will get an "odd address" error)
************************************************************************

ans_b: ds.b 1
	even
ans_w: ds.w 1
ans_l: ds.l 1

i:     dc.b  3
	even
j:   dc.w  4
k:   dc.l  5

A:  dc.b   11, -22, 33, -44, 55, -66, 77, -88, 99, -123

B:  dc.w   111, -222, 333, -444, 555, -666, 777, -888, 999, -5432

C:  dc.l   1111, -2222, 3333, -4444, 5555, -6666, 7777, -8888, 9999, -9876


head:   dc.l  list1

list3:  dc.l 3456
        dc.w 67
	dc.l list4
list2:  dc.l 2345
        dc.w 78
	dc.l list3
list4:  dc.l 4567
        dc.w 56
	dc.l list5
list1:  dc.l 1234
        dc.w 89
	dc.l list2
list5:  dc.l 5678
        dc.w 45
	dc.l 0


End:
	end

