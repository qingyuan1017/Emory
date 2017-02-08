

void returnsquare(double *input){

*input = (*input) * (*input);

}
 
int main(int argc,char *argv[]){
double x=4;
returnsquare(&x);
printf("x=%lf\n",x);


}
