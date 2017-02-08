

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Extra{
    public static void main (String[] args) throws IOException {
        String s = RegToNFA.main(args);
        BufferedWriter NFA = new BufferedWriter(new FileWriter("NFA.txt"));
        NFA.write(s);
        NFA.close();
	
	String dfa = Subset.main();
	BufferedWriter DFA = new BufferedWriter(new FileWriter("DFA.txt"));
        DFA.write(dfa);
        DFA.close();

	FSMtoProg.main();
    }
}
