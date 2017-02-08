import java.util.Random;
import java.util.Arrays;

public class ArrayPractice {
	public static void printReverse(int[] a) {
		*TODO: write code to print number in array in reverse */
	system.out.print("[");
        for (int i=a.length-1; i>= 0; i--){
           System.out.print(a[i]);
        
            if(i > 0){System.out.print(", ");
} 
}
System.out.println("]");
}

	public static int minGap(int[] a) {
		/*TODO: complete this method to find the minimum gap between
		two elements as defined in the lab handout*/
              int min = 101;
            for (int i=0; i<a.length-1; i++){
              int b = Math.abs(a[i+1]-a[i]);
              
              if(b <  min){
              min = b;}
}
               return min;

	}

	public static int[] collapse(int[] a) {
       int[] c=new int[a.length/2];
		for(int i=0; i<a.length-1;i+=2){
                 c[i/2]= a[i]+a[i+1];

}
/*TODO: write code to "collapse" the array (as defined in the lab handout*/
return c;
	}


	public static void main(String[] args) {
		Random generator = new Random();

		//declare our initial array
		int[] a; 
		
		//check to make sure user enters a command line argument
		if (args.length != 1) {
			System.out.println("You must enter an integer as a command line argument to run this program.");
			System.exit(1);
		}

	
		/*TODO: modify program so that it takes a command line argument specifying
		the number of integers to put into an array*/
                 int arraysize= Integer.parseInt(args[0]);
                 a =new int[arraysize];


		//populate array with random numbers between 0 and 99
		for (int i = 0; i < a.length; i++) {
			a[i] = generator.nextInt(100);
		}

		System.out.println(Arrays.toString(a));

		/*TODO: uncomment the function calls below as you complete the related  
		functions. You should test each function to make sure it works before 
		moving on to the next one. */

		printReverse(a);

		int min = minGap(a);
		System.out.println("The minimum gap is: " + min);
		
		int[] c = collapse(a);
		System.out.println(Arrays.toString(c));


	}
}
