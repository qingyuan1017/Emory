import java.util.Scanner;

public class PrimeNum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i = 2; i <= n; i++) {
			boolean flag = true;
			for(int j = 2; j * j <= i; j++) {
				if(i % j == 0) {
					flag = false;
					break;
				}
			}
			if(flag)
				System.out.println(i);
		}
	}
}
