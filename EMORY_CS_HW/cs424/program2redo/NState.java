


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class NState  {

	protected String s_name;
	protected boolean finalState;
	protected HashMap<Character, Set<NState>> transition;
	protected HashMap<Character, NState> s_transition;
	protected  HashSet<String> content;
	
	public NState(String name){
		s_name = name;
		finalState = false;
		transition = new HashMap<Character,Set<NState>>();
		
	}
	
	public boolean isFinal() {
        return finalState;
    }
    
    public void setFinal(boolean finalState) {
        this.finalState = finalState;
    }
	


	
	
	
	
}
