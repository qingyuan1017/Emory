#include <stdio.h>


void QuikSort(int X[ ], int n1, int n2)
{
int pivot,urr, right_array_spot;
if (n1 < n2)
{
pivot = X[n2];
right_array_spot = n2;

while (urr != right_array_spot)
{ if (X[urr] <= pivot)
{ 
}
else
{
X[right_array_spot] = X[urr];
X[urr] = X[right_array_spot-1];
right_array_spot--;
}
}
X[urr] = pivot;
QuikSort(X, n1, urr-1);
QuikSort(X, urr+1, n2);
}
}


int main(int argc, char * argv[]){
int i;
int array [] = {3,2,9,1,12,10,30,99,6,18,23};
	

QuikSort(array,0,10);

for(i=0;i<11;i++){
printf("%d\n",array[i]);
}
}  
