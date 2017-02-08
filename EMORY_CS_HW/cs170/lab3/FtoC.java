 /* THIS CODE IS MY OWN WORK. IT WAS WRITTEN WITHOUT 
     CONSULTING CODE WRITTEN BY OTHER STUDENTS OR MATERIALS 
     OTHER THAN THIS SEMESTER'S COURSE MATERIALS. 
             _Zhang Qingyuan_ */   


public class FtoC {
	public static double FtoC(double x) {
		//input: x => temp in degress F
		//returns: temp in degrees C

		double r;

		//Write these statements:


		//1.  Compute x - 32 and store the result in variable r
		r =x-32;

		//2.  Multiply r by 5 and store the result in r
		r=r*5;

		//3.  Divide r by 9 and store the result in r
		r=r/9;

		//4.  Return r
		return r;

	}

	public static double CtoF(double y) {
		//input: y => temp in degrees C
		//returns: temp in degress F

		double t;

		//Write these statements
	
		//1.  Multiply y by 9 and store the result in variable t
		t=y*9;

		//2.  Divide t by 5 and store the result in t
		t=t/5;

		//3.  Add 32 to t and store the result in t
		t=t+32;

		//4. Return t
		return t;

	}

	public static void main(String args[]) {
		System.out.println("32 degrees F is " + FtoC(32) + " degrees C");
		System.out.println("0 degrees C is " + CtoF(0) + " degress F");
		System.out.println("212 degrees F is " + FtoC(212) + " degress C");
		System.out.println("100 degress C is " + CtoF(100) + " degress F");
		System.out.println("89 degrees F is " + FtoC(89) + " degrees F");
        System.out.println("46 degrees C is " + CtoF(46) + " degrees C");
	}
}
