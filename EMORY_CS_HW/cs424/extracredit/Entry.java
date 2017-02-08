import java.util.ArrayList;
import java.util.StringTokenizer;


public class Entry {
	
	public static String e_change;
	
	
	public static Boolean e_action;
	
	
	public Entry(String replacement, boolean action){
		
		/*StringTokenizer st = new StringTokenizer(replacement," ");
		
		st.nextToken();
		
		StringBuilder right = new StringBuilder();
		
		
		
		while(st.hasMoreTokens()){
			right.append(st.nextToken()+" ");
		}
		*/
		
		e_change = replacement;
		
		e_action = action;
		
	}

}

