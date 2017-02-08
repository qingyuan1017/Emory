


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Subset {

	public static Set<NState> NStates;
	public static Set<NState> initialNStates;
	public static Set<Character> Alphabet;
	public static Set<DState> dfa;

	private static HashMap<Set<NState>, DState> nfaToDfaConversions;
	private static HashMap<DState, Set<NState>> dfaToNfaConversions;
	private static Set<DState> fringeStates;
	private static DState startState;
	private static DState finalState;

	public static void main(String [] args) throws IOException{
		FileInputStream file = new FileInputStream(args[0]);
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(file));

		NStates = new HashSet<NState>();
		initialNStates = new HashSet<NState>();
		Alphabet = new HashSet<Character>();

		String states = keyboard.readLine();
		StringTokenizer st1 = new StringTokenizer(states," ");
		while(st1.hasMoreTokens()){
			String i = st1.nextToken();
			NStates.add(new NState(i));
		}


		String Alpha = keyboard.readLine();
		StringTokenizer st2 = new StringTokenizer(Alpha," ");
		while(st2.hasMoreTokens()){
			String i = st2.nextToken();
			Alphabet.add(i.charAt(0));
		}


		String initial = keyboard.readLine();
		StringTokenizer st3 = new StringTokenizer(initial," ");

		while(st3.hasMoreTokens()){
			String i = st3.nextToken();

			for(NState s: NStates){
				if(s.s_name.equals(i))
					initialNStates.add(s);

			}
		}



		String finalstate = keyboard.readLine();
		StringTokenizer st4 = new StringTokenizer(finalstate," ");
		while(st4.hasMoreTokens()){
			String i = st4.nextToken();
			for(NState s: NStates){
				if(s.s_name.equals(i))
					s.finalState = true;

			}
		}

		for(NState s: NStates){
			for(Character a : Alphabet){
				s.transition.put(a, new HashSet<NState>());
			}
			s.transition.put('~', new HashSet<NState>());
			
		}


		String line = null;

		while ((line = keyboard.readLine()) != null) {

			StringTokenizer st = new StringTokenizer(line," ");

			String source = st.nextToken();
			String alpha = st.nextToken();
			char al = alpha.charAt(0);
			String target = st.nextToken();

			NState begin = find(source);
			NState end = find(target);

			if(Alphabet.contains(al)){
				if(begin.transition.get(al) == null){
					Set<NState> temp = new HashSet<NState>();
					temp.add(end);
					begin.transition.put(al, temp);

				}
				else{
					Set<NState> temp = begin.transition.get(al);
					temp.add(end);
					begin.transition.put(al, temp);
				}
			}
			else{
				if(al == '~'){
					if(begin.transition.get(al) == null){
						Set<NState> temp = new HashSet<NState>();
						temp.add(end);
						begin.transition.put(al, temp);

					}
					else{
						Set<NState> temp = begin.transition.get(al);
						temp.add(end);
						begin.transition.put(al, temp);
					}


				}
				else{
					System.out.println("bad input");
				}

			}


		}

		for(NState s: NStates){
			if(!s.transition.get('~').isEmpty()){
				Set<NState> temp = s.transition.get('~');
				for(NState t: temp){
					for(Character a: Alphabet){
						Set<NState> copy = t.transition.get(a);
						s.transition.get(a).addAll(copy);

					}

				}
				if(initialNStates.contains(s)){

					initialNStates.addAll(temp);
				}

			}
			
		}



		
		
		dfa = generateDFA();
		
		for(DState s: dfa){
			if(s.isFinal())
				finalState = s;
		System.out.print(s.name+" ");
		}
		System.out.println();
		for(Character a: Alphabet){
			System.out.print(a+" ");
		}
		System.out.println();
		System.out.println(startState.name);
		System.out.println(finalState.name);
		
		for(DState s: dfa){
			for(Character a: Alphabet){
				String x =s.s_transition.get(a).name;
		System.out.println(s.name+" "+a+" "+x);
			}
		}
		
		

	}

	public static NState find(String name){

		for(NState s: NStates){
			if(s.s_name.equals(name)){
				return s;
			}

		}
		return null;
	}

	
	 private static Set<DState> generateDFA() {
	        nfaToDfaConversions = new HashMap<Set<NState>, DState>();
	        dfaToNfaConversions = new HashMap<DState, Set<NState>>();
	        fringeStates = new HashSet<DState>();

	        startState = new DState();
	        nfaToDfaConversions.put(initialNStates, startState);
	        dfaToNfaConversions.put(startState, initialNStates);
	        fringeStates.add(startState);

	        Set<DState> dfa = new HashSet<DState>();
	        dfa.add(startState);

	        dfa = completeConversion(dfa);

	        return dfa;
	    }

	 
	 
	 private static Set<DState> completeConversion(Set<DState> dfa) {
	        
	        
	        while (!fringeStates.isEmpty()) {
	            DState currState = fringeStates.toArray(new DState[0])[0];
	            for (Character letter : Alphabet) {
	                
	               
	                Set<NState> nfaStates = dfaToNfaConversions.get(currState);
	                Set<NState> transitionStates = new HashSet<NState>();
	                for(NState s : nfaStates){
	                	transitionStates.addAll(s.transition.get(letter));
	                }

	               
	                if (nfaToDfaConversions.containsKey(transitionStates)) {
	                    DState nextState = nfaToDfaConversions.get(transitionStates);
	                    currState.s_transition.put(letter,nextState);
	                    dfa.add(nextState);
	                } else {
	                    DState nextState = new DState();
	                    if (anyFinal(transitionStates)) nextState.setFinal(true);

	                    nfaToDfaConversions.put(transitionStates, nextState);
	                    dfaToNfaConversions.put(nextState, transitionStates);
	                    fringeStates.add(nextState);
	                    
	                    currState.s_transition.put(letter,nextState);
	                    dfa.add(nextState);
	                }
	            }
	            fringeStates.remove(currState);
	        }
			return dfa;
	    }

	    private static boolean anyFinal(Set<NState> transitionStates) {
	        for (NState State : transitionStates) {
	            if (State.isFinal()) return true;
	        }
	        return false;
	    }

}

