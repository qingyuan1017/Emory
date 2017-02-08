

/********************************************************************
 * compile: javac NFA.java
 *
 * a simplified representation of an NFA with a single accept state
 ********************************************************************/

import java.util.*;

public class NFA {
    public int states; // number of states

    public int start;  // start state
    public int accept; // accept state 

    // transitions are represented in three parallel arraylists:
    // (inputStates(i), inputSymbol(i), outputStates(i))
    public ArrayList<Integer> inputStates;
    public ArrayList<Character> inputSymbol;
    public ArrayList<Integer> outputStates;

    public final String ALPHA = "a b c d e f h i j k l s v w";
    public final String DIGIT = "0 1";
    public final String SIGMA = ALPHA + " " + DIGIT + " " + "+ - * / = ; ~";

    public NFA() {
	inputStates = new ArrayList<Integer>();
	inputSymbol = new ArrayList<Character>();
	outputStates = new ArrayList<Integer>();
    }

    public void embed(NFA N) {
	// embed the NFA N to self, assuming the start and accept
	// states do not change
	states += N.states;

	// the empty transition from the start
	inputStates.add(start);
	inputSymbol.add('~');
	outputStates.add(N.start);
	// the empty transition to the accept
	inputStates.add(N.accept);
	inputSymbol.add('~');
	outputStates.add(accept);

	// copy the rest of the transitions in N
	inputStates.addAll(N.inputStates);
	inputSymbol.addAll(N.inputSymbol);
	outputStates.addAll(N.outputStates);
    }
	
    public String toString() {

        StringBuilder sb = new StringBuilder();

	for (int i = 0; i < states; i++) 
	    sb.append("Q" + (i + start) + " ");

	sb.append("\n");
	sb.append(SIGMA + "\n");
	sb.append("Q" + start + "\n");
	sb.append("Q" + accept + "\n");

	for (int i = 0; i < inputStates.size(); i++) 
	    sb.append("Q" + inputStates.get(i) + " " + inputSymbol.get(i) + " " + "Q" + outputStates.get(i)  + "\n");

	return sb.toString();
    }
}
