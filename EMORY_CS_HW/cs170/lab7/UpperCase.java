 

/* ----------------------------------------------------------------
   Complete the method "toUpperCase()"
   ---------------------------------------------------------------- */
public class UpperCase
{
    public static String toUpperCase( String s )
    {
       String output;
       output = "";
       int n = s.length();
       int i;
       
       for (i=0; i<n;i++){
       char c = s.charAt(i);
       if ('a'<= c && c<= 'z'){
        output = output + (char) (c-'a'+'A');}
        else 
        { output = output + c;
}// For each character in input string s, do:
       // {
       //     if character is a lowercase:
       //         append the uppercase character to output
       //     otherise
       //         append the character to output
       // }
       

       // Don't forget the return the output !!!
    }return output;}



   /* ------------------------------------------------------
      Method main is our main entry point.
      ------------------------------------------------------ */
   public static void main(String args[])
   {
      String in, out;

      in = "Hello4";
      out = toUpperCase(in);
      System.out.println("Input: " + in + "\tUppercased Output: " + out);

      in = "7*h$npo";
      out = toUpperCase(in);
      System.out.println("Input: " + in + "\tUppercased Output: " + out);
   }
}
