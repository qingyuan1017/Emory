import java.util.Scanner;


public class ConnectFour {

	
	public static void main(String [] args){
		
		System.out.println("Welcome to connect four!");
		System.out.println("Drop a piece in the game grid by inputting which column to place the piece.");
		System.out.println("If you get four in a row, you win!");
		System.out.println("When you're ready to start, hit enter.");
		
		Scanner input = new Scanner(System.in);  
		String readString = input.next();
		
		if (input.hasNextLine()){
            readString = input.nextLine();
		System.out.println("aa");}
        else
            readString = null;
	}
	
	
}

