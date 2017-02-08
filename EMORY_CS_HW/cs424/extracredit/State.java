

import java.util.HashMap;
import java.util.Set;


public class State  {

	protected String s_name;
	protected HashMap<Character, State> s_transition;
	
	public State(String name){
		s_name = name;
		s_transition = new HashMap<Character,State>();
	}
	
	
	
	
}