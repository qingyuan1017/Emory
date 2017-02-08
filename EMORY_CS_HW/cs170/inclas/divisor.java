import java.util.Scanner;

public class divisor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int i = 1;
		while(i <= n) {
			if(n % i == 0)
				System.out.println(i);
			i++;
		}
	}
}
