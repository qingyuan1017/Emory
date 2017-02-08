

/********************************************************************
 * compile: javac RegToNFA.java
 * usage:   java RegToNFA < input.txt 
 *          where input.txt is an input list of regular expressions
 *          limited to the restrictions described below
 ********************************************************************/

import java.util.*;

public class RegToNFA {

    public static int numberOfStates;

    public static ArrayList<String> groupExpressions(String regEx) {
	// simplified regEx: assume [, ], * not part of the alphabet set
	// concatenation:  abc
	// union:          [abc...] = a U b U c ...
	// Kleene closure: [abc...]* = (a U b U c ...)*

	ArrayList<String> groups = new ArrayList<String>();
	String group = "";

	int count = 0;
	int state = 0; // 0:concat, 1:union
	int i = 0;
	while (i < regEx.length()) {
	    switch (state) {
	    case 0:
		if (regEx.charAt(i) == '[') {
		    state = 1;
		    group = "";
		}
		else {
		    groups.add(String.valueOf(regEx.charAt(i)));
		    numberOfStates++;
		}
		i++;
		break;
	    case 1:
		if (regEx.charAt(i) == ']') {
		    state = 0;
		    if (i+1 < regEx.length() && regEx.charAt(i+1) == '*') {
			// a Kleene closure
			groups.add("*" + group);
			i += 2;
			if (i < regEx.length()) 
			    numberOfStates++;
		    }
		    else { // a union
			groups.add(group);
			numberOfStates++;
			i++;
		    }
		}
		else {
		    group += regEx.charAt(i);
		    i++;
		}
		break;
	    default: 
		System.out.println("FSM error");
		System.exit(0);
	    }
	}
	return groups;
    }
		

    public static String main(String[] args) {
	
	Scanner scanner = new Scanner(System.in);

	NFA resultNFA = new NFA();
	resultNFA.states = 2;
	resultNFA.start = 0;
	resultNFA.accept = 1;

	String regEx;

	NFA nfa;

	int globalStateIndex = 2;

	while (scanner.hasNextLine()) {
	    numberOfStates = 1;
	    regEx = scanner.nextLine(); // one line per regular expression
	    nfa = new NFA();

	    ArrayList<String> groups = groupExpressions(regEx); // also calculate number of states
	    nfa.states = numberOfStates;  
	    
	    nfa.start = globalStateIndex;
	    globalStateIndex += nfa.states;
	    nfa.accept = globalStateIndex - 1;

	    // fill in the transitions

	    for (int i = 0; i < groups.size(); i++) {
		String group = groups.get(i);
		if (group.length() == 1) { // a single character
		    nfa.inputStates.add(nfa.start + i);
		    nfa.inputSymbol.add(group.charAt(0));
		    nfa.outputStates.add(nfa.start + i + 1);
		}
		else {         // union or Kleene
		    int start; //   0   or   1
		    int stop;  // i + 1 or   i
		    if (group.charAt(0) == '*') {
			start = 1;
			stop = nfa.start + i;

			for (int j = start; j < group.length(); j++) {
			    nfa.inputStates.add(nfa.start + i);
			    nfa.inputSymbol.add(group.charAt(j));
			    nfa.outputStates.add(stop);
			}

			if (i < groups.size() - 1) { // if not the last group then make an empty transition to the next state

			stop++;

			for (int j = start; j < group.length(); j++) {
			    nfa.inputStates.add(nfa.start + i);
			    nfa.inputSymbol.add('~');
			    nfa.outputStates.add(stop);
			}
			}
		    }
		    else {
			start = 0;
			stop = nfa.start + i + 1;

			for (int j = start; j < group.length(); j++) {
			    nfa.inputStates.add(nfa.start + i);
			    nfa.inputSymbol.add(group.charAt(j));
			    nfa.outputStates.add(stop);
			}

		    }

		}
	    }
	    resultNFA.embed(nfa);
	}

	return resultNFA.toString();
    }
}
