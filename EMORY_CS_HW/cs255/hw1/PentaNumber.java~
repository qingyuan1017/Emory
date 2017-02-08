

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class PentaNumber {

	public static void main(String [] args){
		
		System.out.println(parsePenta("10"));
		System.out.println(toString(256));


	}

	public static int parsePenta(String s) {
		int exp = 0;
		char ch;
		int number = 0;
		int result = 0;
		Set<Character> Alphabet = new HashSet<Character>();
		Alphabet.add('1');
		Alphabet.add('2');
		Alphabet.add('3');
		Alphabet.add('4');
		Alphabet.add('6');
		Alphabet.add('7');
		Alphabet.add('8');
		Alphabet.add('9');
		Alphabet.add('A');
		Alphabet.add('Z');
		Alphabet.add('Q');
		Alphabet.add('J');
		Alphabet.add('Z');


		if(s.charAt(0) == '-'){

			for(int i = s.length()-1; i >=1; i--){
				ch = s.charAt(i);
				switch (ch) {
				case '0': number += Math.pow(15, exp)*0;
				exp++;
				break;
				case '1': number += Math.pow(15, exp)*1;
				exp++;
				break;
				case '2':  number += Math.pow(15, exp)*2;
				exp++;
				break;
				case '3':  number += Math.pow(15, exp)*3;
				exp++;
				break;
				case '4':  number += Math.pow(15, exp)*4;
				exp++;
				break;
				case '5':  number += Math.pow(15, exp)*5;
				exp++;
				break;
				case '6':  number += Math.pow(15, exp)*6;
				exp++;
				break;
				case '7':  number += Math.pow(15, exp)*7;
				exp++;
				break;
				case '8':  number += Math.pow(15, exp)*8;
				exp++;
				break;
				case '9':  number += Math.pow(15, exp)*9;
				exp++;
				break;
				case 'A': number += Math.pow(15, exp)*10;
				exp++;
				break;
				case 'Z': number += Math.pow(15, exp)*11;
				exp++;
				break;
				case 'Q': number += Math.pow(15, exp)*12;
				exp++;
				break;
				case 'J': number += Math.pow(15, exp)*13;
				exp++;
				break;
				case 'G': number += Math.pow(15, exp)*14;
				exp++;
				break;
				default: System.out.println("Wrong input");
				break;

				}

			}

			number = number * (-1);

		}


		else if (Alphabet.contains(s.charAt(0))){

			for(int i = s.length()-1; i >=0; i--){
				ch = s.charAt(i);
				switch (ch) {
				case '0': number += Math.pow(15, exp)*0;
				exp++;
				break;
				case '1': number += Math.pow(15, exp)*1;
				exp++;
				break;
				case '2':  number += Math.pow(15, exp)*2;
				exp++;
				break;
				case '3':  number += Math.pow(15, exp)*3;
				exp++;
				break;
				case '4':  number += Math.pow(15, exp)*4;
				exp++;
				break;
				case '5':  number += Math.pow(15, exp)*5;
				exp++;
				break;
				case '6':  number += Math.pow(15, exp)*6;
				exp++;
				break;
				case '7':  number += Math.pow(15, exp)*7;
				exp++;
				break;
				case '8':  number += Math.pow(15, exp)*8;
				exp++;
				break;
				case '9':  number += Math.pow(15, exp)*9;
				exp++;
				break;
				case 'A': number += Math.pow(15, exp)*10;
				exp++;
				break;
				case 'Z': number += Math.pow(15, exp)*11;
				exp++;
				break;
				case 'Q': number += Math.pow(15, exp)*12;
				exp++;
				break;
				case 'J': number += Math.pow(15, exp)*13;
				exp++;
				break;
				case 'G': number += Math.pow(15, exp)*14;
				exp++;
				break;
				default: System.out.println("Wrong input");
				break;

				}
			}

		}

		else{
			System.out.println("Wrong input");

		}



		return number;

	}


	public static String toString(int a) {
		
		Stack<Integer> q = new Stack<Integer>();
		int quotient = a;
		int remainder = 0;
		StringBuilder builder = new StringBuilder();
		if(a>=0){
		while(quotient/15!=0){
			
			remainder = quotient%15;
			q.push(remainder);
			
			quotient = quotient/15;
		}
		q.push(quotient);
		
		
		while(!q.isEmpty()){
			int pen =  q.pop();
			switch (pen) {
			case 0: builder.append('0');
			break;
			case 1: builder.append('1');
			break;
			case 2: builder.append('2');
			break;
			case 3: builder.append('3');
			break;
			case 4: builder.append('4');
			break;
			case 5: builder.append('5');
			break;
			case 6: builder.append('6');
			break;
			case 7: builder.append('7');
			break;
			case 8: builder.append('8');
			break;
			case 9: builder.append('9');
			break;
			case 10: builder.append('A');
			break;
			case 11: builder.append('Z');
			break;
			case 12: builder.append('Q');
			break;
			case 13: builder.append('J');
			break;
			case 14: builder.append('G');
			break;
			}
			
		}
		}
		
		else{
			builder.append('-');
			quotient = quotient*(-1);
			while(quotient/15!=0){
				
				remainder = quotient%15;
				q.push(remainder);
			
				quotient = quotient/15;
			}
			q.push(quotient);
			
			
			while(!q.isEmpty()){
				int pen =  q.pop();
				switch (pen) {
				case 0: builder.append('0');
				break;
				case 1: builder.append('1');
				break;
				case 2: builder.append('2');
				break;
				case 3: builder.append('3');
				break;
				case 4: builder.append('4');
				break;
				case 5: builder.append('5');
				break;
				case 6: builder.append('6');
				break;
				case 7: builder.append('7');
				break;
				case 8: builder.append('8');
				break;
				case 9: builder.append('9');
				break;
				case 10: builder.append('A');
				break;
				case 11: builder.append('Z');
				break;
				case 12: builder.append('Q');
				break;
				case 13: builder.append('J');
				break;
				case 14: builder.append('G');
				break;
				}
				
			}
		}
		
		String result = builder.toString();
		return result;

	}


}
