/* ----------------------------------------------------------------
   Java program to test prime
   ---------------------------------------------------------------- */
public class IsPrime
{
    public static boolean isPrime(int x)
    {
       // input: x = number
       // output: true if x is prime, false otherwise
    
       boolean prime = true;

       /* ------------------------------------------------
          Check if x is divisible by any of the numbers
          between 2 and x-1
          ------------------------------------------------ */
       for ( int i = 2; i < x; i++ )
       {
          if ( x%i == 0 )
          {
             prime = false; 
             break;   // x is divisible by i, x is not prime 
          }
          else
          {
             prime = true;     // x is not divisible by i, x is prime
          }
       }

       return (prime);
    }


   public static void testIsPrime(int x)
   {
      System.out.println(x + " is prime: " + isPrime(x) );
   }


   /* ------------------------------------------------------
      Method main is our main entry point.
      ------------------------------------------------------ */
   public static void main(String args[])
   {
      testIsPrime(3);
      testIsPrime(4);
      testIsPrime(5);
      testIsPrime(6);
      testIsPrime(8);
      testIsPrime(9);
      testIsPrime(10);
      testIsPrime(11);
   }
}
