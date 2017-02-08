import java.util.*;

public class reduceSpace {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();
		boolean flag = false;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != ' ') {
				flag = false;
				System.out.print(s.charAt(i));
			}
			else {
				if(flag) {
					continue;
				}
				else {
					flag = true;
					System.out.print(' ');
				}
			}
		}
		System.out.println();
	}
}

