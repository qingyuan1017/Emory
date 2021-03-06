

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class FSMtoProg {


	public static void main() throws IOException{
		FileInputStream file = new FileInputStream("DFA.txt");

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(file));
		BufferedReader keyboard1 = new BufferedReader(new InputStreamReader(System.in));

		Set<State> States = new HashSet<State>();
		Set<Character> Alphabet = new HashSet<Character>();
		State state = null;
		Set<State> Accepts = new HashSet<State>();
		char ch;

		System.out.println("import java.io.*;");
		System.out.println("import java.util.*;");
		System.out.println("public class Tokenizer {");
		System.out.print("public enum States {");
		

		String states = keyboard.readLine();
		StringTokenizer st1 = new StringTokenizer(states," ");
		while(st1.hasMoreTokens()){
			String i = st1.nextToken();
			States.add(new State(i));
			System.out.print(i+",");
		}
		System.out.println("}");
		System.out.println("public static StringBuilder sb = new StringBuilder();");
		System.out.println("public static void main(String [] args) throws IOException{");
		System.out.println("FileInputStream file = new FileInputStream(args[0]);");
		System.out.println("BufferedReader keyboard = new BufferedReader(new InputStreamReader(file));");
		System.out.println("BufferedWriter output = new BufferedWriter(new FileWriter(\"token.txt\"));");
		System.out.println("String line = null;");
		System.out.println("while ((line = keyboard.readLine()) != null) {");
		System.out.println("StringTokenizer st = new StringTokenizer(line,\" \");");
		System.out.println("while(st.hasMoreTokens()){");
		System.out.println("String v = st.nextToken();");
		System.out.println("tokenize(v);");
		System.out.println("}}");
		System.out.println("sb.append(\"~\");");
		System.out.println("sb.append(\"\\n\");");
		System.out.println("sb.append(\"<eof>\");");
		
		System.out.println("System.out.println(sb.toString());");
		System.out.println("output.write(sb.toString());");
		System.out.println("output.close();");
		System.out.println("}");
		System.out.println("public static void tokenize(String s) throws IOException{");
		System.out.println("for(int i =1; i<=s.length(); i++){");
		System.out.println("String v = s.substring(0,i);");
		System.out.println("boolean b = test(v+\"~\");");
		System.out.println("if(i== s.length() && b == false){");
		System.out.println(" System.err.println(\"bad input,check your program input!\");");
		System.out.println(" sb = new StringBuilder();");
		System.out.println(" break;}");
		System.out.println("if(b== true){");
		System.out.println("sb.append(v);");
		System.out.println("sb.append(\"\\n\");");
		System.out.println("String r = s.substring(i, s.length());");
		System.out.println("tokenize(r);");
		System.out.println("break;}");
		System.out.println("}");
		System.out.println("}");
		System.out.println("");

		System.out.println("public static boolean test(String args) throws IOException{");
		System.out.println("Set<Character> Alphabet = new HashSet<Character>();");
		

		String Alpha = keyboard.readLine();
		StringTokenizer st2 = new StringTokenizer(Alpha," ");
		while(st2.hasMoreTokens()){
			String i = st2.nextToken();
			
			Alphabet.add(i.charAt(0));
			System.out.println("Alphabet.add('"+i.charAt(0)+"');");
		}

		String initial = keyboard.readLine();
		StringTokenizer st3 = new StringTokenizer(initial," ");
		while(st3.hasMoreTokens()){
			String i = st3.nextToken();
			
			for(State j:States){
				if(j.s_name.equals(i)){
					state = j;
				System.out.println("States state = States."+j.s_name+";");}
			}
		}
		
		
		System.out.println("Set<States> Accepts = new HashSet<States>();");
		
		
		

		String finalstate = keyboard.readLine();
		StringTokenizer st4 = new StringTokenizer(finalstate," ");
		while(st4.hasMoreTokens()){
			String i = st4.nextToken();
			
			
			for(State j:States){
				if(j.s_name.equals(i)){
					Accepts.add(j); 
				System.out.println("Accepts.add(States."+j.s_name+");");}
			}
		}
		
		System.out.println("char ch;");
		System.out.println("for(int j=0; j< args.length(); j++){");
		System.out.println("ch = args.charAt(j);");
		
		System.out.println("if(! Alphabet.contains(ch)){");
		System.out.println("return false;");
		
			System.out.println("}");


		String line = null;

		while ((line = keyboard.readLine()) != null) {
			
			StringTokenizer st = new StringTokenizer(line," ");
             
			String source = st.nextToken();
			String alpha = st.nextToken();
			String target = st.nextToken();
			
			
			//System.out.println(source);
			//System.out.println(alpha.charAt(0));
			//System.out.println(target);

			AddTransition(source,alpha.charAt(0),target,States);
			
		}
		
	
		System.out.println("switch (state){");
		for(State i : States){
			System.out.println("case "+ i.s_name+":");
			for(Character j: Alphabet)
			System.out.println("if(ch == '"+j+"') state = States." +check(i,j,States).s_name+";");
			System.out.println("break;");
		}
		
		System.out.println("}");
		System.out.println("}");
		
		System.out.println("if(Accepts.contains(state))");
		System.out.println("return true;");
		System.out.println("else");
		System.out.println("return false;");
		System.out.println("}");
		System.out.println("}");

		




	} 
	
	
	
	public static void AddTransition(String fst, char i, String snd, Set<State> All){
		
		State source = find(fst,All);
		
		State target = find(snd,All);
		
		source.s_transition.put(i,target);
		
	}
	
	public static State find(String name,Set<State> States){
		
		
		for(State j:States){
			if(j.s_name.equals(name))
				return j;
		}
		return null;
		
	}
    public static State check(State source, char i,Set<State> All){
    	
    	
    	State to = source.s_transition.get(i);
		
		return to;
	}
}
