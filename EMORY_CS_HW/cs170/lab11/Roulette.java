
public class Roulette {

   public String[] value;
   public String[] color;

   public int outcome;

   /* ================================================
      TODO: Task 1: write the constructor
      ================================================ */
   public Roulette( ) {
          value = new String[38];
          color = new String[38];
          
          value[0]= "0"; color[0]="G";
          value[37]= "00"; color[37]="G";
          
          for (int i = 1; i < 37; i++){
          value[i] = Integer.toString(i);
          if ((i<=10)||(i>=19 && i <29)){
               if (i%2==0)
                color[i]="B";
                else 
                color[i]="R";
}
          else{
               if(i%2==0)
               color[i]="R";
               else
               color[i]="B";
}
} 

   }


   /* ================================================
      TODO: Task 2: write the spin() method
      ================================================ */
   public void spin() {
          double r = Math.random()*38;
          outcome = (int)(r);
         

          //outcome = (int) (Math.round(Math.random()*37));
   }


   /* ************************************************
      TODO: Task 2b: change the instance variable to  

                   private

      and recompile Test1.java and Test2.java

      You should get errors
      ************************************************ */

   /* ================================================
      TODO Task 3: write the value() method
      ================================================ */
   public String value() {
      return value[outcome]; //this return statement is wrong, write a correct one.
   }

   /* ================================================
      TODO Task 4: write the color() method
      ================================================ */
   public String color() {
      return color[outcome]; //this return statement is wrong, write a correct one.
   }

   /* ================================================
      TODO Task 5: write the toString() method
      ================================================ */
   public String toString() {	
	return value()+" "+color()r; //this return statement is wrong, write a correct one.
   }

}



