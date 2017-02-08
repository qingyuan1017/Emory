



import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class DState {
    protected boolean finalState;
    protected String name;
    private int id;
    protected HashMap<Character, DState> s_transition;
    
    private static int count = 0;
    
    public DState() {
        this.name = "q" + count;
        
        this.finalState = false;
        this.s_transition = new HashMap<Character,DState>();
        
        count++;
    }
   
    public boolean isFinal() {
        return finalState;
    }
    
    public void setFinal(boolean finalState) {
        this.finalState = finalState;
    }
    
   
}
