  /*

      THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING

      CODE WRITTEN BY OTHER STUDENTS. Qingyuan Zhang

      */

import java.util.ArrayList;
import javax.swing.JOptionPane;
public class GuessingGame {
 ArrayList<String> numbers= new ArrayList<String>();
 int index;
 int guess;
 int count=0;
 char[] digit= new char[4];
 
 public GuessingGame ( ) {
  
  for(int i=1000;i<=9999;i++){
   numbers.add(String.valueOf(i));
  }
 }
 public int myGuessIs() {
  if(numbers.size()==0){
   guess=-1;
  }
  else{
  index = (int)(Math.random()*(numbers.size()-1));
  guess = Integer.parseInt(numbers.get(index));
  count =count+1;}
  return guess;
  
 }
 
 public int totalNumGuesses() {
  return count;
 
 }
 
 public void updateMyGuess(int nmatches) {
 int same=0;
 int a=guess/1000;
 int b=(guess-1000*a)/100;
 int c=(guess-1000*a-b*100)/10;
 int d=(guess-1000*a-b*100-c*10);
 
 digit[0]=(char)(a+48);
 digit[1]=(char)(b+48);
 digit[2]=(char)(c+48);
 digit[3]=(char)(d+48);
 
 char[] x=new char [4];
 
 for (int i=0; i<=numbers.size()-1;i++){
  for (int j=0; j<4;j++){
   x[j]=numbers.get(i).charAt(j);
   if (digit[j]==x[j]){
    same++;
   }
  } 	
  if (same != nmatches)
   numbers.remove(i);
   same=0;
 }
 
 }
  
 
 // fill in code here (optional)
 // feel free to add more 3methods as needed
 
 // you shouldn't need to change the main function
 public static void main(String[] args) {
  GuessingGame gamer = new GuessingGame( );
 
  JOptionPane.showMessageDialog(null, "Think of a number between 1000 and 9999.\n Click OK when you are ready...", "Let's play a game", JOptionPane.INFORMATION_MESSAGE);
  int numMatches = 0;
  int myguess = 0;
  
  do {
   myguess = gamer.myGuessIs();
   if (myguess == -1) {
    JOptionPane.showMessageDialog(null, "I don't think your number exists.\n I could be wrong though...", "Mistake", JOptionPane.INFORMATION_MESSAGE);
    System.exit(0);
   }
   String userInput = JOptionPane.showInputDialog("I guess your number is " + myguess + ". How many digits did I guess correctly?");
   // quit if the user input nothing (such as pressed ESC)
   if (userInput == null)
    System.exit(0);
   // parse user input, pop up a warning message if the input is invalid
   try {
    numMatches = Integer.parseInt(userInput.trim());
   }
   catch(Exception exception) {
    JOptionPane.showMessageDialog(null, "Your input is invalid. Please enter a number between 0 and 4", "Warning", JOptionPane.WARNING_MESSAGE);
    numMatches = 0;
   }
   // the number of matches must be between 0 and 4
   if (numMatches < 0 || numMatches > 4) {
    JOptionPane.showMessageDialog(null, "Your input is invalid. Please enter a number between 0 and 4", "Warning", JOptionPane.WARNING_MESSAGE);
    numMatches = 0;
   }
   if (numMatches == 4)
    break;
   // update based on user input
   gamer.updateMyGuess(numMatches);
   
  } while (true);
  
  // the game ends when the user says all 4 digits are correct
  System.out.println("Aha, I got it, your number is " + myguess + ".");
  System.out.println("I did it in " + gamer.totalNumGuesses() + " turns.");
 }
}
