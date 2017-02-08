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
	clearbits(head,howmany);
	 sieveOfE(N);
	printPrimes(N);
	
	 printf("Enter Even Numbers > 5 for Goldbach Tests ");
	 while (1)
   {

     if ( scanf("%d", &inp) == EOF )
     {
        break;
     }

     goldbach(inp);
   }


	
	
}	

void	clearbits(seg *ptr , int num) { 

	int i,j;

	for (i=0; i< num; i++) {

		for (j=0; j<= 255; j++) {
			ptr->bits[j]=0;
			}
		ptr=ptr->next;
	}
}


seg * whichseg(int N){
	seg * ptr;
	ptr = head;
	int i;
	int segnumber = N/16384;
	for(i=0; i<segnumber; i++){
	ptr = ptr->next;
		
}
return ptr;
}

int whichint(int N){
	int i,segnumber;
	segnumber = N/16384;
	i   = ((N-(16384*(segnumber))-1)/2)/32;
	return i;
}

int whichbit(int N){
	int pos,segnumber;
	segnumber = N/16384;
	pos = ((N-(16383*(segnumber))-1)/2)%32; 
	return pos;
}


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

void sieveOfE( int N )
{
   int i, j, k;
   k = 3;   
   while ( k*k <= N )
   {	
	for ( i = k; i <= N; i=i+2 )
          if ( testBitIs0(i) )
             break;            

     
      for ( j = 3*i; j <= N; j = j + 2*i ){
	
	  setBit(j);
}

      k = i+2;    
   }
}

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

void goldbach(int N){
	
	
	seg * g,* h;	
	int i,j,pos1,pos2,r1,r2;
	int last;
	int count=0;
	int x =3;
	
	g = whichseg(3);
    	i   = whichint(3);              
    	pos1 = whichbit(3);

	h = whichseg(N-3);
    	j   = whichint(N-3);              
    	pos2 = whichbit(N-3);
	
	

	
	while(x <= N/2){
	
	r1 = g -> bits[i] & (1 << pos1);
	r2 = h -> bits[j] & (1 << pos2);
	
	
	if(r1 ==0 && r2 ==0){
	count++;
	last = x;
	
}

	if(pos1 >= 31){
	pos1 = 0;
	if(i == 255){
	i = 0;
	g = g->next;}
	else i++;
}
	else{
	pos1 ++;}



	
	if(pos2 == 0){
	pos2 = 31;
	if(j == 0){
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




