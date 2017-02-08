 void f4(){
extern int a;
a =1;
}

/*void f5(){
extern int b;
b=1;
}
*/
extern int a;
int main(int argc, char *argv[]){
a=1;
f1();
f2(1);
f3(1);
//f4() 
//f5()
}
