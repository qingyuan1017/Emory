/* I worked on this assignment alone, using only this semester's course materials.
	Qingyuan Zhang
*/

#include <stdio.h>
#include <stdlib.h>
#include "header.h"



void clearAll(){
    int x;
    for(x=0; x<MAX; x++){
        prime[x]=0; //every number is candidate and all element equal to 0
    }
}

void setBit(unsigned int prime[], int N){
    int i = N/32;   //array index
    int pos = N%32; //bit position
    (prime[(N/32)] |= (1 << (N % 32))); //bit setting
}


int testBitIs0(unsigned int prime[], int N){
     int i = N/32;   //array index
    int pos = N%32; //bit position
    return ( (prime[i] & (1 << pos )) == 0 );//bit testing
}

void sieveOfE(int N){
    int i, j, k;
    
    clearAll();
    setBit(prime, 0);
    setBit(prime, 1);
    
    for ( i = 2; i <= N; i++ )
    k = 2;   // prime start with 2
    
    while ( k <= N )
    {
        for ( i = k; i <= N; i++ )
            if ( testBitIs0(prime, i))
                break;            
        for ( j = i+i; j <= N; j = j + i )
	    setBit(prime, j);
	
        k = i+1;
    }
    
}

int countPrimes(int N){
    int count = 0;
    int i;
    for(i=2; i<=N; i++)
        if(testBitIs0(prime, i))
            count++;
    return count;
}

void printPrimes(int N){
    int i;
    for(i=2; i<=N; i++)
        if(testBitIs0(prime, i))
            printf("%u\n",i );
}
