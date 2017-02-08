//specify the import statements needed to use
//a Scanner object and File objects
import java.util.Scanner;
import java.io.*;

public class Words {
	// add a throws exception to the main method
	public static void main(String[] args)  throws IOException{
		int wordCount = 0;
		int lineCount = 0;
                

		File myfile = new File ("poe.txt");
              //declare and initialize a file built from poe.txt
	       Scanner in = new Scanner (myfile);
		//declare and initialize a Scanner which reads the File object
		while (in.hasNext())
                {
                     String word = in.next();
                   wordCount++;
                 }
              
		//write a while-loop to count all *words* in the file
                        in = new Scanner(myfile);
		//reset your Scanner
		while (in.hasNextLine()){
    String line = in.nextLine();
lineCount++;}
		//write a while-loop to count all *lines* in the file
		
		System.out.println("Total words = " + wordCount);
		System.out.println("Total lines = " + lineCount);
	}
}
