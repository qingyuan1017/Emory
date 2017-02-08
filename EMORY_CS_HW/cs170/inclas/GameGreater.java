import java.util.Scanner;

public class GameGreater {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int money = 30;

		while(true) {
			if(money <= 0) {
				System.out.println("No money left. Good luck in the future.");
				return;
			}
			System.out.println("-------------------\nYou have $" + money + " left.\n-------------------");
			System.out.println("New game starts.");
			int computer = (int)(Math.random() * 1000) % 13 + 1;
			int user = (int)(Math.random() * 1000) % 13 + 1;

			String symbol = "";
			switch(user) {
				case 1: symbol = "A"; break;
				case 11: symbol = "J"; break;
				case 12: symbol = "Q"; break;
				case 13: symbol = "K"; break;
				default: symbol = Integer.toString(user); break;
			}
			System.out.println("You got " + symbol);

			System.out.println("Please enter your commend: (e) end the game; (d) drop; (g) go.");
			String input = in.next();
			if(input.charAt(0) == 'e')
				break;

			if(input.charAt(0) == 'd') {
				money -= 5;
				continue;
			}

			if(input.charAt(0) == 'g') {
				switch(computer) {
					case 1: symbol = "A"; break;
					case 11: symbol = "J"; break;
					case 12: symbol = "Q"; break;
					case 13: symbol = "K"; break;
					default: symbol = Integer.toString(computer); break;
				}
				System.out.println("Computer got " + symbol);
				if(computer > user) {
					System.out.println("Computer win.");
					money -= 10;
				}
				else if(user > computer) {
					System.out.println("You win.");
					money += 10;
				}
				else
					System.out.println("Draw.");
			}
		}
		System.out.println("You leave the game with $" + money + " in your pocket.");
	}
}
