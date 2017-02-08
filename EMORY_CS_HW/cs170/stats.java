/* THIS CODE IS MY OWN WORK. IT WAS WRITTEN WITHOUT CONSULTING CODE
WRITTEN BY OTHER STUDENTS OR MATERIALS OTHER THAN THIS SEMESTER'S
COURSE MATERIALS. Zhang Qingyuan */


import java.util.Scanner;
import java.io.*;

public class stats {
	public static void main(String[] args)  throws IOException{
		int num; double sum; double avg; double max; double standard;
                 sum = 0;
                 num = 0;
                 max = 0;
                 avg = 0;
               standard = 0;
               double standarda = 0;

		File myfile = new File ("grade.txt");
              
	       Scanner in = new Scanner (myfile);
		
		while (in.hasNext())
                {    String b = in.next();
                     double a = in.nextDouble();
                     
                     num++;
                     sum = sum + a;
                     while (a > max) {
                        max = a;
                 }
                     avg = sum / num;
                    
                 }

              
                        in = new Scanner(myfile);
		
		while (in.hasNext()){
                    
                     String c = in.next();
                     double b = in.nextDouble();
                     standard = (b-avg) * (b-avg);
                     standarda = standarda + standard;
}
                     double standarddeviation = Math.sqrt(standarda / num);
                     
                      
              
                System.out.println("num = " + num);       
		System.out.println("Averge score = " + avg);
		System.out.println("highest score = " + max);
                System.out.println("standard deviation = " + standarddeviation);
	}
}
