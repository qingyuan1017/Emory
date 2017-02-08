import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class State  {

protected String s_name;
protected int id;
protected HashMap<Character, Set<String>> t_transition;
protected HashMap<Character, State> s_transition;
protected  HashSet<String> content;
public State(String name){
s_name = name;
        for(int i=0; i<name.length();i++){
        id += Character.getNumericValue(name.charAt(i));
        }
t_transition = new HashMap<Character,Set<String>>();
s_transition = new HashMap<Character,State>();
content = new HashSet<String>();
}
public State(String name,ArrayList<String> in){
s_name = name;
        for(int i=0; i<name.length();i++){
        id += Character.getNumericValue(name.charAt(i));
        }
t_transition = new HashMap<Character,Set<String>>();
s_transition = new HashMap<Character,State>();
content = new HashSet<String>(in);
}


}
