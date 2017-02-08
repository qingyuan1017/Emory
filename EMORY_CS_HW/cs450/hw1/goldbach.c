/* I worked on this assignment alone, using only this semester's course materials.
	Qingyuan Zhang
*/
	
#include <stdlib.h>
#include <stdio.h>


typedef struct _seg {  /* definition of new type "seg" */
    int  bits[256];
    struct _seg  *next,*prev;        
      }seg  ;

#define BITSPERSEG  (8*256*sizeof(int))

/*
Declare all the methods
*/
void clearbits(seg *, int);
seg * whichseg(int N);
int whichint(int N);
int whichbit(int N);
void sieveOfE( int N );
seg *head;
void printPrimes(int N);
void goldbach(int N);

void main(int argc, char *argv[]) {

	seg *pt;
	int	i,N;
	int inp;
	int howmany;

//Allocate the segments
	if (argc == 2) sscanf(argv[1],"%d",&N);
		else scanf("%d",&N);
	howmany =  (N +BITSPERSEG*2 -1)/(BITSPERSEG*2);



	head= (  seg * ) malloc(sizeof(seg));
	pt=head;
	for (i=1;i<howmany;i++) { //Just Forward Links for Now
		pt->next = (  seg *) malloc(sizeof (seg)); 
		pt=pt->next;
		}

	printf("Calculating odd primes up to %d...\n", N );

	clearbits(head,howmany); //call the clearbits method
	 sieveOfE(N);	//call the sieve method
	printPrimes(N);	//print the result of sieve method
	
	 printf("Enter Even Numbers > 5 for Goldbach Tests ");

/*
Get input for goldbach method
*/
	 while (1)
   {

     if ( scanf("%d", &inp) == EOF )
     {
        break;
     }

     goldbach(inp);   //run goldbach method
   }


	
	
}	


/*
clearbits method clear all thie bit in the segment and set them in 0
*/
void	clearbits(seg *ptr , int num) { 
 
	int i,j;

	for (i=0; i< num; i++) {

		for (j=0; j<= 255; j++) {
			ptr->bits[j]=0;
			}
		ptr=ptr->next;
	}
}


/*
whichseg method returns the matching segement for the input integer
*/
seg * whichseg(int N){
	seg * ptr;
	ptr = head;
	int i;
	int segnumber = N/16384; 
/*
each segement has 8192 bits, since it only represent odd integer, 16384 = 8192*2
*/
	for(i=0; i<segnumber; i++){
	ptr = ptr->next;
		
}
return ptr;
}

/*
whichint method returns the matching integer in the segement for the input integer
*/
int whichint(int N){
	int i,segnumber;
	segnumber = N/16384;
/*
each integer in segment has 32 bits, devided by to 32 to get which integer in the segment
*/  
	i   = ((N-(16384*(segnumber))-1)/2)/32;
	return i;
}



/*
whichbit method returns the matching bit in the integer for the input integer
*/

int whichbit(int N){
	int pos,segnumber;
	segnumber = N/16384;
/*
each integer in segment has 32 bits, use the remainder to get the which bits
*/
	pos = ((N-(16383*(segnumber))-1)/2)%32; 
	return pos;
}


/*
setBit method set the non-prime odd integer to one in the seg
*/
void setBit(int N)
{
    
     seg * g;
    int i;   
    int pos;
    int segnumber;

    
    g = whichseg(N);
    i   = whichint(N);              
    pos = whichbit(N);             

   

    
    g->bits[i]= g -> bits[i] | (1 << pos) ;
}


/*
TestBitIs0 method test whether the input odd integer is a prime in the our bitmap
*/
int testBitIs0( int N){    	

    seg * g;
    int i; 
    int r;
    int pos;
    int segnumber;
    
    	
    g = whichseg(N);
    i   = whichint(N);              
    pos = whichbit(N);               
    
   

    r = g -> bits[i] & (1 << pos) ; 

   if ( r == 0 )
      return 1;     
   else
      return 0;
}


/*
sieveofE method is the sieve method for only odd integer

we start with first odd prime integer 3, and iterate the sieve method by find the next prime integer in the bitmap test with testBitIs0 method. 

Eliminate the multiply of the prime  integer, start with 3*I and each time add 2*I to it.
*/

void sieveOfE( int N )
{
   int i, j, k;
   k = 3;   
   while ( k*k <= N )
   {	
	for ( i = k; i <= N; i=i+2 )
//find the next prime using testBitIs0
          if ( testBitIs0(i) )
             break;            

     
      for ( j = 3*i; j <= N; j = j + 2*i ){
// start with 3*i as the first multipy of primes and eliminate every odd multiply of the original prime in the bit map
	  setBit(j);
}

      k = i+2;    
   }
}


/*
print how many prime we found
*/
void printPrimes(int N){
    int i,count;
	count = 0;
    
    for ( i = 2; i <= N; i++ )
	if( i % 2 == 1){
        if ( testBitIs0(i) )
            count++;
}
    printf("Found %d odd primes \n",count);
}


/*
goldbach method divide a even integer to 2 odd primes.

Suppose the even integer is N,

Decompose it first with 3 and N-3

Then check integer by adding or subtracting bit until N/2
*/

void goldbach(int N){
	
	
	seg * g,* h;	
	int i,j,pos1,pos2,r1,r2;
	int last;
	int count=0;
	int x =3;

//use whichseg, whichint and whichbit to find intger 3 and N-3	
	g = whichseg(3);
    	i   = whichint(3);              
    	pos1 = whichbit(3);

	h = whichseg(N-3);
    	j   = whichint(N-3);              
    	pos2 = whichbit(N-3);
	
	

	
	while(x <= N/2){
//test whether the N-i and i are both primes or not	
	r1 = g -> bits[i] & (1 << pos1);
	r2 = h -> bits[j] & (1 << pos2);
	
	
	if(r1 ==0 && r2 ==0){
	count++;
	last = x;
	
}


// flip one bit
	if(pos1 >= 31){	// increase one integer if it above 32 bits
	pos1 = 0;
	if(i == 255){	// goes to next segemet if it above 256 integers
	i = 0;
	g = g->next;}
	else i++;
}
	else{
	pos1 ++;}



	
	if(pos2 == 0){ // decrease one integer if it below 0 bits
	pos2 = 31;
	if(j == 0){	// goes to the previous segemet if it below 0 
	j = 255;
	h = h->prev;}
	else j--;
}
	else{
	pos2--;}

	x = x+2;
	
}
	
	printf("Largest %d = %d + %d out of %d solutions \n",N,last,N-last,count);
	

}




