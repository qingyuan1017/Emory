/* ----------------------------------------------------------------
   Correct the syntax error in this program
   ---------------------------------------------------------------- */
public class Mystery
{
   /* ------------------------------------------------------
      Method main is our main entry point.
      ------------------------------------------------------ */
   public static void main(String args[])
   {
      int i, c, j, n;

      if ( args.length != 1 )
      {
         System.err.println("Usage: java Mystery NUMBER");
         System.err.println("- you need to provide a number to the program");
         System.exit(1);
      }

      n = Integer.parseInt( args[0] );

      c = 0;

      for ( i = 1; i <= n ; i++ )
      {
         System.out.print(i);
         j = i;

	     while ( j > 0 )
         {
            if ( j % 10 == 4 )
            {
               c++;
               System.out.print("*");
            }

            j = j / 10;   // Computes j = j / 10;
         }

         System.out.print(" ");
      }

      System.out.println();
      System.out.println("Mystery output = " + c);
   }
}
