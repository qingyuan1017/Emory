import java.util.Scanner;

public class greaternum {
	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("Please type two numbers:");
		a = in.nextInt();
		b = in.nextInt();
		
		if (a > b)
			System.out.println(a + " is greater.");
		else if (b > a)
			System.out.println(b + " is greater.");
		else
			System.out.println("They are the same.");
	}
}
