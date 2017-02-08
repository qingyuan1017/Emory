/*
I worked on this assignment alone, using only this semester's course materials.
Qingyuan Zhang
*/

#include <stdio.h>
#include "header.h"



void clearAll(){
    seg * X;
    X = head;
    while (X -> next != NULL) {
        int i;
        for(i=0; i<256; i++){
            X->bits[i]=0;
        }
        X = X->next;
    }
}

void setBit( int n)//bit position
{
  
    seg * g;
    int i; //index of bits[]
    int j;
    int pos;
    int segnumber;

    
    segnumber = n/8192;
    i   = (n-(8192*(segnumber)))/32;               //index
    pos = (n-(8192*(segnumber)))%32;              // position within bit[i]

    g = head;
    for ( j = 0; j < segnumber; j++)
        g = g->next;
    g->bits[i]= g -> bits[i] | (1 << pos) ;
}


int testBitIs0( int n){    

	
    seg * g;
    int i; //index of bits[]
    int j; 
    int r;
    int pos;
    int segnumber;
    
    
    segnumber = n/8192;
    i   = (n-(8192*(segnumber)))/32;               //index
    pos = (n-(8192*(segnumber)))%32;              // position within bit[i]
    
    g = head;
    for ( j = 0; j < segnumber; j++){
        g = g->next;
    }
    
    r = g -> bits[i] & (1 << pos) ; 

   if ( r == 0 )
      return 1;        // return 1 to indicate that n is still prime
   else
      return 0;
}



int countPrimes( int N ){
    int count;
    int i;
    count = 1;
    
    for ( i = 3; i <= N; i+=2 )
        if ( testBitIs0((i-1)/2) )
            count++;
    return count;
}

void printPrimes(int N){
    int i;
    printf("2 ");
    for ( i = 3; i <= N; i+=2 )
        if ( testBitIs0((i-1)/2) )
            printf("%d ", i );
    printf("\n");
}

void sieveOfE( int N )
{
   int i, j, k, n;

   k = 2;   // Start with 2 


 


   while ( k <= N )
   {
      for ( i = k; i <= N; i++ ){
	if( i % 2 == 0)
	break;
	else {
	//printf("test number = %d\n",i);
          if ( testBitIs0((i-1)/2) )
             break;  }           
}
     
      for ( j = 2*i; j <= N; j = j + i ){
	if(j%2 ==0)
	continue;
	else
	  setBit((j-1)/2);
}

      k = i+1;     
   }
}



void factor(int num) {
    int div = 2;

    while (num != 1) {
        if (num % div == 0) {
            
	    printf("%d", div);
	    printf("\n");
            num /= div;
        } else {
            div += 1;
        }
    }
}

