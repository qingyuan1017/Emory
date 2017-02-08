import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileIO {
	public static void main(String[] args) throws IOException {
		File f = new File("./TextFile");
		Scanner in = new Scanner(f);

		while(in.hasNext()) {
			System.out.println(in.next());
		}
	}
}
