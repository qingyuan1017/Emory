import java.util.Scanner;

public class TipCalc {
	//TODO: Write the method bill
         public static double bill(int w, int h){
      return 3.35*w+1.45*h;
}

	//TODO: Write the method tip
         public static double tip(double b){
      return 0.15*b;
}


	//TODO: Write the method info
         public static void info(int w, int h, double b, double t){
System.out.println("You bought" + w +"waffles and"+ h +"hashbrowns");
System.out.println("Calculated bill before tip: $" + b);
System.out.println("Calculated 15% tip $" + t);
System.out.println("Total bill is $" + (b+t) + ", rounded up to $" + Math.ceil(b+t));
}
     

	
	public static void main(String[] args) {
		//DO NOT change any code in the main method

		Scanner in = new Scanner(System.in);
		
		//get the number of waffles
		System.out.print("How many waffles? ");
		int w = in.nextInt();

		//get the number of hashbrowns from the user
		System.out.print("How many hashbrowns? " );
		int h = in.nextInt();

		//Calculate the total bill for 5 waffles and 2 hashbrowns
		double b = bill(w, h);
		double t = tip(b);
		info(w, h, b, t);	

	}

}
