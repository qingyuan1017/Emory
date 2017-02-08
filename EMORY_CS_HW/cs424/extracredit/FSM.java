
			
				import java.io.*;
				import java.util.*;
				public class FSM {
				public enum States {q4,q3,q0,q2,q1,q5,}
				public static StringBuilder sb = new StringBuilder();
				public static void main(String [] args) throws IOException{
				FileInputStream file = new FileInputStream("program.txt");
				BufferedReader keyboard = new BufferedReader(new InputStreamReader(file));
				BufferedWriter output = new BufferedWriter(new FileWriter("token.txt"));
				String line = null;
				while ((line = keyboard.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line," ");
				while(st.hasMoreTokens()){
				String v = st.nextToken();
				tokenize(v);
				}}
				sb.append("~");
				sb.append("\n");
				sb.append("<eof>");
				System.out.println(sb.toString());
				output.write(sb.toString());
				output.close();
				}
				public static void tokenize(String s) throws IOException{
				for(int i =1; i<=s.length(); i++){
				String v = s.substring(0,i);
				boolean b = test(v+"~");
				if(i== s.length() && b == false){
				 System.err.println("bad input,check your program input!");
				 sb = new StringBuilder();
				 break;}
				if(b== true){
				sb.append(v);
				sb.append("\n");
				String r = s.substring(i, s.length());
				tokenize(r);
				break;}
				}
				}

				public static boolean test(String args) throws IOException{
				Set<Character> Alphabet = new HashSet<Character>();
				Alphabet.add('f');
				Alphabet.add('d');
				Alphabet.add('e');
				Alphabet.add('b');
				Alphabet.add('c');
				Alphabet.add('a');
				Alphabet.add('*');
				Alphabet.add('+');
				Alphabet.add('l');
				Alphabet.add('j');
				Alphabet.add('/');
				Alphabet.add('k');
				Alphabet.add('h');
				Alphabet.add('-');
				Alphabet.add('i');
				Alphabet.add('w');
				Alphabet.add('v');
				Alphabet.add('1');
				Alphabet.add('0');
				Alphabet.add('s');
				Alphabet.add(';');
				Alphabet.add('~');
				Alphabet.add('=');
				States state = States.q0;
				Set<States> Accepts = new HashSet<States>();
				Accepts.add(States.q5);
				char ch;
				for(int j=0; j< args.length(); j++){
				ch = args.charAt(j);
				if(! Alphabet.contains(ch)){
				return false;
				}
				switch (state){
				case q3:
				if(ch == 'f') state = States.q1;
				if(ch == 'd') state = States.q1;
				if(ch == 'e') state = States.q1;
				if(ch == 'b') state = States.q1;
				if(ch == 'c') state = States.q1;
				if(ch == 'a') state = States.q1;
				if(ch == '*') state = States.q1;
				if(ch == '+') state = States.q1;
				if(ch == 'l') state = States.q1;
				if(ch == 'j') state = States.q1;
				if(ch == '/') state = States.q1;
				if(ch == 'k') state = States.q1;
				if(ch == 'h') state = States.q1;
				if(ch == 'i') state = States.q2;
				if(ch == '-') state = States.q1;
				if(ch == 'w') state = States.q1;
				if(ch == 'v') state = States.q1;
				if(ch == '1') state = States.q1;
				if(ch == '0') state = States.q1;
				if(ch == 's') state = States.q1;
				if(ch == ';') state = States.q1;
				if(ch == '~') state = States.q1;
				if(ch == '=') state = States.q1;
				break;
				case q1:
				if(ch == 'f') state = States.q1;
				if(ch == 'd') state = States.q1;
				if(ch == 'e') state = States.q1;
				if(ch == 'b') state = States.q1;
				if(ch == 'c') state = States.q1;
				if(ch == 'a') state = States.q1;
				if(ch == '*') state = States.q1;
				if(ch == '+') state = States.q1;
				if(ch == 'l') state = States.q1;
				if(ch == 'j') state = States.q1;
				if(ch == '/') state = States.q1;
				if(ch == 'k') state = States.q1;
				if(ch == 'h') state = States.q1;
				if(ch == 'i') state = States.q1;
				if(ch == '-') state = States.q1;
				if(ch == 'w') state = States.q1;
				if(ch == 'v') state = States.q1;
				if(ch == '1') state = States.q1;
				if(ch == '0') state = States.q1;
				if(ch == 's') state = States.q1;
				if(ch == ';') state = States.q1;
				if(ch == '~') state = States.q1;
				if(ch == '=') state = States.q1;
				break;
				case q2:
				if(ch == 'f') state = States.q4;
				if(ch == 'd') state = States.q1;
				if(ch == 'e') state = States.q1;
				if(ch == 'b') state = States.q1;
				if(ch == 'c') state = States.q1;
				if(ch == 'a') state = States.q1;
				if(ch == '*') state = States.q1;
				if(ch == '+') state = States.q1;
				if(ch == 'l') state = States.q1;
				if(ch == 'j') state = States.q1;
				if(ch == '/') state = States.q1;
				if(ch == 'k') state = States.q1;
				if(ch == 'h') state = States.q1;
				if(ch == 'i') state = States.q1;
				if(ch == '-') state = States.q1;
				if(ch == 'w') state = States.q1;
				if(ch == 'v') state = States.q1;
				if(ch == '1') state = States.q1;
				if(ch == '0') state = States.q1;
				if(ch == 's') state = States.q1;
				if(ch == ';') state = States.q1;
				if(ch == '~') state = States.q1;
				if(ch == '=') state = States.q1;
				break;
				case q0:
				if(ch == 'f') state = States.q1;
				if(ch == 'd') state = States.q1;
				if(ch == 'e') state = States.q1;
				if(ch == 'b') state = States.q1;
				if(ch == 'c') state = States.q1;
				if(ch == 'a') state = States.q1;
				if(ch == '*') state = States.q1;
				if(ch == '+') state = States.q1;
				if(ch == 'l') state = States.q1;
				if(ch == 'j') state = States.q1;
				if(ch == '/') state = States.q1;
				if(ch == 'k') state = States.q1;
				if(ch == 'h') state = States.q1;
				if(ch == 'i') state = States.q2;
				if(ch == '-') state = States.q1;
				if(ch == 'w') state = States.q1;
				if(ch == 'v') state = States.q1;
				if(ch == '1') state = States.q1;
				if(ch == '0') state = States.q1;
				if(ch == 's') state = States.q1;
				if(ch == ';') state = States.q1;
				if(ch == '~') state = States.q3;
				if(ch == '=') state = States.q1;
				break;
				case q4:
				if(ch == 'f') state = States.q1;
				if(ch == 'd') state = States.q1;
				if(ch == 'e') state = States.q1;
				if(ch == 'b') state = States.q1;
				if(ch == 'c') state = States.q1;
				if(ch == 'a') state = States.q1;
				if(ch == '*') state = States.q1;
				if(ch == '+') state = States.q1;
				if(ch == 'l') state = States.q1;
				if(ch == 'j') state = States.q1;
				if(ch == '/') state = States.q1;
				if(ch == 'k') state = States.q1;
				if(ch == 'h') state = States.q1;
				if(ch == 'i') state = States.q1;
				if(ch == '-') state = States.q1;
				if(ch == 'w') state = States.q1;
				if(ch == 'v') state = States.q1;
				if(ch == '1') state = States.q1;
				if(ch == '0') state = States.q1;
				if(ch == 's') state = States.q1;
				if(ch == ';') state = States.q1;
				if(ch == '~') state = States.q5;
				if(ch == '=') state = States.q1;
				break;
				case q5:
				if(ch == 'f') state = States.q1;
				if(ch == 'd') state = States.q1;
				if(ch == 'e') state = States.q1;
				if(ch == 'b') state = States.q1;
				if(ch == 'c') state = States.q1;
				if(ch == 'a') state = States.q1;
				if(ch == '*') state = States.q1;
				if(ch == '+') state = States.q1;
				if(ch == 'l') state = States.q1;
				if(ch == 'j') state = States.q1;
				if(ch == '/') state = States.q1;
				if(ch == 'k') state = States.q1;
				if(ch == 'h') state = States.q1;
				if(ch == 'i') state = States.q1;
				if(ch == '-') state = States.q1;
				if(ch == 'w') state = States.q1;
				if(ch == 'v') state = States.q1;
				if(ch == '1') state = States.q1;
				if(ch == '0') state = States.q1;
				if(ch == 's') state = States.q1;
				if(ch == ';') state = States.q1;
				if(ch == '~') state = States.q1;
				if(ch == '=') state = States.q1;
				break;
				}
				}
				if(Accepts.contains(state))
				return true;
				else
				return false;
				}
				}

