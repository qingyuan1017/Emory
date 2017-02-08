import java.util.*;

public class flipWord {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();
		
		String fliped = "";
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != ' ') {
				fliped = s.charAt(i) + fliped;
			}
			else {
				if(fliped.length() > 0)
					System.out.print(fliped);
				fliped = "";
				System.out.print(' ');
			}
		}
		if(fliped.length() > 0)
			System.out.println(fliped);
	}
}
