import java.util.Scanner;
import java.io.*;

public class Hw4{
	

//Define Max method
public static double Max(double a, double b)
	{double large =0;
		if(a<b) {large=b;}
		else if (a>b) {large=a;}
		return large;
	}	
	
	
public static void main(String[] args) throws IOException{
	File myfile=new File("grade.txt");
	Scanner in=new Scanner(myfile);
	double sum=0.0;
	int count =0;
	double ave=0.0;
	
	//Calculate the Average
	while(in.hasNext()) {
		String name=in.next();
		double score=in.nextInt();
		sum +=score;
		count++;
		ave=sum/count;}
	if(count>0) {System.out.print("the average score is" + ave);}
	
	Scanner in2=new Scanner(myfile);
	double large=0;
	//calculate the Maximum 
	while(in2.hasNext()) {
		String name=in2.next();
		double grade=in2.nextDouble();
		large=Max(large,grade);}
	System.out.println("highest grade is"+large);
	
	Scanner in3=new Scanner(myfile);
	double squaresum=0;
	Double Std;
	
	//calculate the Standard Deviation
	while(in3.hasNext()) {
		String name=in3.next();
		double grade=in3.nextDouble();
		double square= (grade-ave)*(grade-ave);
		squaresum +=square;
		count++;}
		Std= Math.sqrt(squaresum/count);
		System.out.println("Standard Deviation of the class"+ Std);	
			
	}
		
}


