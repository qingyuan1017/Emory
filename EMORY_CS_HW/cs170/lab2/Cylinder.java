import java.util.Scanner;
    
  /* This program calculates the volume and surface area of a cylinder */
   
  public class Cylinder   {
     public static void main(String [] args) {
   
	double r, h, pi, volume, surface ;// declaration of the variables
      
	Scanner in = new Scanner(System.in );// create a Scanner
    System.out.print("R=");
	r = in.nextDouble();// Enter radius      
	// Read input from terminal and store it in the appropriate variable    
      System.out.print("H=");
	h = in.nextDouble();// Enter height
	// Read input from terminal and store it in the appropriate variable

	pi = 3.1415926;// define a variable for pi
     
	volume = pi * r * r * h; //compute the volume of the cylinder and store it in appropriate variable

	surface = 2 * pi * r * r + (2 * r * pi) * h;//computer the surface area and store it in appropriate variable.
      
	System.out.print("Volume=");// print out the result
System.out.println(volume);
System.out.print("Surface=");
System.out.println(surface);
      } 
}
