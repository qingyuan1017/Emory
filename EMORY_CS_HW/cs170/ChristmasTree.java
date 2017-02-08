/* THIS CODE IS MY OWN WORK. IT WAS WRITTEN WITHOUT CONSULTING CODE 
WRITTEN BY OTHER STUDENTS OR MATERIALS OTHER THAN THIS SEMESTER'S 
COURSE MATERIALS.  Zhang Qingyuan*/


import java.util.Scanner;


public class ChristmasTree {
	public static void main(String[] args) {
               
                Scanner in = new Scanner (System.in);
               int n = in.nextInt();
		for (int i = 0; i < n; i++) {
                for(int a = 0; a < 5; a++) {
			for(int j = 0; j < 3 * (n-i) + 1 - a; j++) {
				System.out.print(' ');
			}
			
			for(int j = 0; j < 3 * i * 2 + 2 * a+ 1; j++) {
				System.out.print('A');
			}
			System.out.println();
		}
                
			}
                 
		
	}
}
