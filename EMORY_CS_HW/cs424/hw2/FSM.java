import java.io.*;
import java.util.*;
public class FSM {
public enum States {DQ1Q3Q4,DQ3Q4,DQ2,DQ3Q4Q2,DQ1Q3,DQ1Q2,DQ1Q3Q2,DQ1,DQ3,DQ1Q4,DQ1Q4Q2,D,DQ4,DQ1Q3Q2Q4,DQ2Q4,DQ3Q2,}
public static void main(String [] args) throws IOException{
Reader keyboard = new InputStreamReader (System.in);
Set<Character> Alphabet = new HashSet<Character>();
Set<States> Accepts = new HashSet<States>();
Alphabet.add('0');
Alphabet.add('1');
States state = States.DQ1;
Accepts.add(States.DQ1Q3Q4);
Accepts.add(States.DQ3Q4);
Accepts.add(States.DQ3Q4Q2);
Accepts.add(States.DQ1Q4);
Accepts.add(States.DQ1Q4Q2);
Accepts.add(States.DQ4);
Accepts.add(States.DQ1Q3Q2Q4);
Accepts.add(States.DQ2Q4);
char ch;
while((ch = (char) keyboard.read()) != '\n'){
if(! Alphabet.contains(ch)){
System.out.println("invalid character" + ch);
System.exit(0);
}
switch (state){
case DQ1Q3Q4:
if(ch == '1'){ state = States.DQ1Q3Q2Q4;}
if(ch == '0'){ state = States.DQ1Q4;}
break;
case DQ3Q4:
if(ch == '1'){ state = States.DQ4;}
if(ch == '0'){ state = States.DQ4;}
break;
case DQ2:
if(ch == '1'){state = States.D;}
if(ch == '0'){ state = States.DQ3;}
break;
case DQ3Q4Q2:
if(ch == '1'){ state = States.DQ4;}
if(ch == '0'){ state = States.DQ3Q4;}
break;
case DQ1Q3:
if(ch == '1'){ state = States.DQ1Q3Q2Q4;}
if(ch == '0'){ state = States.DQ1;}
break;
case DQ1Q2:
if(ch == '1'){ state = States.DQ1Q3Q2;}
if(ch == '0'){ state = States.DQ1Q3;}
break;
case DQ1Q3Q2:
if(ch == '1'){ state = States.DQ1Q3Q2Q4;}
if(ch == '0'){ state = States.DQ1Q3;}
break;
case DQ1:
if(ch == '1'){ state = States.DQ1Q3Q2;}
if(ch == '0'){ state = States.DQ1;}
break;
case DQ3:
if(ch == '1'){ state = States.DQ4;}
if(ch == '0'){state = States.D;}
break;
case DQ1Q4:
if(ch == '1'){ state = States.DQ1Q3Q2Q4;}
if(ch == '0'){ state = States.DQ1Q4;}
break;
case DQ1Q4Q2:
if(ch == '1'){ state = States.DQ1Q3Q2Q4;}
if(ch == '0'){ state = States.DQ1Q3Q4;}
break;
case D:
if(ch == '1'){state = States.D;}
if(ch == '0'){state = States.D;}
break;
case DQ4:
if(ch == '1'){ state = States.DQ4;}
if(ch == '0'){ state = States.DQ4;}
break;
case DQ1Q3Q2Q4:
if(ch == '1'){ state = States.DQ1Q3Q2Q4;}
if(ch == '0'){ state = States.DQ1Q3Q4;}
break;
case DQ2Q4:
if(ch == '1'){ state = States.DQ4;}
if(ch == '0'){ state = States.DQ3Q4;}
break;
case DQ3Q2:
if(ch == '1'){ state = States.DQ4;}
if(ch == '0'){ state = States.DQ3;}
break;
}
}
if(Accepts.contains(state))
System.out.println("Yes");
else
System.out.println("No");
}
}

