import java.util.Scanner;

public class leap {
	public static void main(String[] args) {
		int a = 0;
		Scanner in = new Scanner(System.in);
		System.out.print("Please type a year: ");
		
		a = in.nextInt();
		if(((a % 4) == 0 && !(a % 100 == 0)) || a % 400 == 0)
			System.out.println(a + " is a leap year.");
		else
			System.out.println(a + " is not a leap year.");
	}
}
