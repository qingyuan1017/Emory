import java.util.Scanner;

public class grade {
	public static void main(String[] args) {
		int a = 0;
		Scanner in = new Scanner(System.in);

		System.out.print("Please enter the grade: ");
		a = in.nextInt();

		if (a >= 90) {
			System.out.println("A");
		}
		else {
			if (a >= 80) {
				System.out.println("B");
			}
			else {
				if (a >= 70) {
					System.out.println("C");
				}
				else {
					if (a >= 60) {
						System.out.println("D");
					}
					else {
						System.out.println("F");
					}	
				}
			}
		}

	}
}
