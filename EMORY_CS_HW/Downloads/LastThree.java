
/* THIS CODE IS MY OWN WORK. IT WAS WRITTEN WITHOUT CONSULTING CODE 
WRITTEN BY OTHER STUDENTS OR MATERIALS OTHER THAN THIS SEMESTER'S 
COURSE MATERIALS.  Zhang Qingyuan */
import java.util.Scanner;
    public class LastThree
   {
      public static void main(String[] args)
      {
Scanner in = new Scanner(System.in); 

   	 int a, x, y, z, X, Y;
         String e, f, g;
System.out.println("Please type an Integer");
    
         a = in.nextInt() ;

   	 if (a >= 4) {
   	    x = a % 2;    
            X = a / 2 ;
            y = X % 2;
            Y = X / 2;
            z = Y % 2;
  e = Integer.toString(x);
f = Integer.toString(y);
g = Integer.toString(z);


 System.out.println(g+f+e);

      }
else if (a >= 2)
{x = a % 2;
X = a / 2;
y = X % 2;
z = 0;

  e = Integer.toString(x);
f = Integer.toString(y);
g = Integer.toString(z);

 System.out.println(g+f+e);
}
 
else {
x = a % 2;
y = 0 ;
z =0;

  e = Integer.toString(x);
f = Integer.toString(y);
g = Integer.toString(z);

   	 System.out.println(g+f+e);

}
        
      }
   }
