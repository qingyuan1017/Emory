import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SumFile {
	public static void main(String[] args) throws IOException {
		File f = new File("number");
		Scanner in = new Scanner(f);

		int sum = 0;
		while(in.hasNextInt()) {
			sum += in.nextInt();
		}
		System.out.println(sum);
	}
}
