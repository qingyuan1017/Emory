#include <stdio.h>
#include "header.h"

/* ---------------------------------------------------------
   setBit( n ): set the bit corresponding to the number n
   --------------------------------------------------------- */

void clearAll(){
    seg * X;
    X = head;
    while (X -> next != NULL) {/////////////////////////////////
        int i;
        for(i=0; i<256; i++){
            X->bits[i]=0;////////////////////////////////////////
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
    g->bits[i]= g -> bits[i] | (1 << pos) ;////////////////////////////////////////////
}

/* -------------------------------------------------
   testBit( n ): return 1 if bit n is RESET
   ------------------------------------------------- */
int testBitIs0( int n){    //the input n is the bit position in the segmented bit
                            //array.
                            //The bit position n represents the number (2*n+1)
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
    
    r = g -> bits[i] & (1 << pos) ; // Get bit at pos in prime[i]////////////////////////

   if ( r == 0 )
      return 1;        // return 1 to indicate that n is still prime
   else
      return 0;
}



int countPrimes( int N ){
    int count;
    int i;
    count = 0;
    
    for ( i = 2; i <= N; i++ )
        if ( testBitIs0(i) )
            count++;
    return count;
}

void printPrimes(int N){
    int i;
    
    for ( i = 2; i <= N; i++ )
        if ( testBitIs0(i) )
            printf("%d ", i );
    printf("\n\n");
}

void sieveOfE( int N )
{
   int i, j, k;

   /* ------------------------
      Initialize prime[]
      ------------------------ */

// PrintBits(N);

   /* ------------------------
      Perform the sieve of E
      ------------------------ */
   k = 2;   // Start with 2 to find all primes

   while ( k <= N )
   {
//    PrintBits(N);
      /* ----------------------------------------
         Starting from k, find next 
         prime number number i

         A prime number is detected by:  

                      isPrime[i] == true
         ---------------------------------------- */
      for ( i = k; i <= N; i++ )
          if ( testBitIs0(i) )
             break;             // Found !

      /* --------------------------------------
         Set:  isPrime[2*i] = false,
               isPrime[3*i] = false,
               ....
               (upto isPrime[N])
         -------------------------------------- */
      for ( j = 2*i; j <= N; j = j + i )
	  setBit(j);

      k = i+1;    // Set up k for next iteration !!!   
   }
}



void factor(int num) {
    int div = 2;

    while (num != 1) {
        if (num % div == 0) {
            //cout << num << " ";
	    printf("%d", div);
	    printf("\n");
            num /= div;
        } else {
            div += 1;
        }
    }
}

