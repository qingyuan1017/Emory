import java.util.Stack;

public class NQueens {

        public static int number;
        static Stack<Integer> s = new Stack<Integer>();
        public static boolean test (int c){
                boolean a = true;
                  for(int i=0;i<s.size();i++){
                          int col = s.get(i);
                          if (col == c){
                                  a = false;
                          return a;}
                          if (c-col == s.size()-i){
                                  a = false;
                          return a;}
                          if (col-c == s.size()-i){
                                  a = false;
                          return a;}
                          else
                                  a =true;

                  }
                        return a;
        }




  //***** fill in your code here *****
  //feel free to add additional methods as necessary

  //finds and prints out all solutions to the n-queens problem
  public static int solve(int n) {



          int c = 0;
          s.push(0);

          while(c>=0){

                  if (test(c)&& s.size()<n){
                          s.push(c);
                          c=0;


                  }
                  if(!(test(c))&& c<n){
                          c++;
                          if(c==n){
                                  int last;
                                  last= s.pop();

                          if(s.isEmpty()&&last==n-1)
                                  break;
                          else if(!s.isEmpty()&&last==n-1)
                                  last= s.pop();
                                  c=++last;
                          }
                          }
                if (s.size()==n){
                        number++;
                        printSolution(s);
                        int last;
                          last= s.pop();

                  if(s.isEmpty()&&last==n-1)
                          break;
                  else if(!s.isEmpty()&&last==n-1)
                          last= s.pop();
                          c=++last;
                }

                  }


          return number;
          }

     //***** fill in your code here *****

    //update the following statement to return the number of solutions found


  //solve()

  //this method prints out a solution from the current stack
  //(you should not need to modify this method)
  private static void printSolution(Stack<Integer> s) {
    for (int i = 0; i < s.size(); i ++) {
      for (int j = 0; j < s.size(); j ++) {
        if (j == s.get(i))
          System.out.print("Q ");
        else
          System.out.print("* ");
      }//for
      System.out.println();
    }//for
    System.out.println();
  }//printSolution()

  // ----- the main method -----
  // (you shouldn't need to change this method)
  public static void main(String[] args) {

  int n = 8;

  // pass in parameter n from command line
  if (args.length == 1) {
    n = Integer.parseInt(args[0].trim());
    if (n < 1) {
      System.out.println("Incorrect parameter");
      System.exit(-1);
    }//if
  }//if

  int number = solve(n);
  System.out.println("There are " + number + " solutions to the " + n
+ "-queens problem.");
 }//main()
}
