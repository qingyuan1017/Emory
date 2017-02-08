

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class FSMtoProg {


	public static void main(String [] args) throws IOException{
		FileInputStream file = new FileInputStream("/home/qzhan37/cs424/hw1/sample.txt");

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(file));
		BufferedReader keyboard1 = new BufferedReader(new InputStreamReader(System.in));

		Set<State> States = new HashSet<State>();
		Set<Character> Alphabet = new HashSet<Character>();
		State state = null;
		Set<State> Accepts = new HashSet<State>();
		char ch;

		System.out.println("import java.io.*;");
		System.out.println("import java.util.*;");
		System.out.println("public class FSM {");
		System.out.print("public enum States {");

		String states = keyboard.readLine();
		StringTokenizer st1 = new StringTokenizer(states," ");
		while(st1.hasMoreTokens()){
			String i = st1.nextToken();
			States.add(new State(i));
			System.out.print(i+",");
		}
		System.out.println("}");
		System.out.println("public static void main(String [] args) throws IOException{");
		System.out.println("Reader keyboard = new InputStreamReader (System.in);");
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
		
		System.out.println("while((ch = (char) keyboard.read()) != '"+"\\" +"n'){");
		
		System.out.println("if(! Alphabet.contains(ch)){");
		System.out.println("System.out.println(\"invalid character\" + ch);");
		System.out.println("System.exit(0);");
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
		System.out.println("System.out.println(\"Yes\");");
		System.out.println("else");
		System.out.println("System.out.println(\"No\");");
		System.out.println("}");
		System.out.println("}");

System.out.println("\\"+"\\The program is above, but you can just start test your language now!");
System.out.println("\\"+"\\Input your language");


		String i =keyboard1.readLine();




		
		

		
		for(int j = 0; j< i.length(); j++){
			ch = i.charAt(j);
			if(! Alphabet.contains(ch)){
				System.out.println("invalid character" + ch);
				System.exit(0);
			}
			
			state = check(state,ch,States);
				
		}
		
		if(Accepts.contains(state))
			System.out.println("Yes");
		else
			System.out.println("No");





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
