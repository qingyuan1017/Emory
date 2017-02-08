 /* THIS CODE IS MY OWN WORK. IT WAS WRITTEN WITHOUT CONSULTING CODE 
WRITTEN BY OTHER STUDENTS OR MATERIALS OTHER THAN THIS SEMESTER'S 
COURSE MATERIALS.  Zhang Qingyuan */
    import java.util.Scanner;
    import java.lang.String;
    
   public class ConvertDates
   {
      public static void main(String[] args)
      {
   	 String a;
        
    
   	 Scanner in = new Scanner(System.in);
    
   	 System.out.print("Please input a date ");
   	 a = in.next();
       int len = a.length();
if ( len == 5 ){
String name, e, g, f, result, result1;

   	name = "";
        e = "";
        f = "";
        g = "";
        

         
         char m = a.charAt(0);
         char c = a.charAt(1);
         char j = a.charAt(2);
       result = name + g+ e ;
         char n = a.charAt(3);
         char h = a.charAt(4);
         
         if (j == '/') { 
           g = " ";}
 
          else { result = "wrong format"; 
} 	
         switch (m) {
           case '0' : break; 
           case '1' : break;
           case '2' : break;
           case '3' : break;
           case '4' : break;
           case '5' : break;
           case '6': break;
           case '7': break;
           case '8': break;
           case '9': break;
           default :  result = "wrong format"; break;
      }
         switch (c) {
         case '0' : break; 
           case '1' : break;
           case '2' : break;
           case '3' : break;
           case '4' : break;
           case '5' : break;
           case '6': break;
           case '7': break;
           case '8': break;
           case '9': break;
           default :  result = "wrong format"; break;
}
        switch (n) {
         case '0' : break; 
           case '1' : break;
           case '2' : break;
           case '3' : break;
           case '4' : break;
           case '5' : break;
           case '6': break;
           case '7': break;
           case '8': break;
           case '9': break;
           default :  result = "wrong format"; break;
}
       switch (h) {
         case '0' : break; 
           case '1' : break;
           case '2' : break;
           case '3' : break;
           case '4' : break;
           case '5' : break;
           case '6': break;
           case '7': break;
           case '8': break;
           case '9': break;
           default :  result = "wrong format"; break;
}

        if (result == "wrong format") { System.out.println(result);}
        else {
         
         String b = a.substring(0, 2);
         String d = a.substring(3, 5);
         int i = Integer.parseInt(b);
         int l = Integer.parseInt(d);
             
         
           
   	 if ( i == 1) { name = "January"; 
           switch (l) {
           case 1 : e = "1st"; break;
           case 2 : e = "2nd"; break;
           case 3 : e = "3nd"; break;
           case 4 : e = "4th"; break;
           case 5 : e = "5th"; break;
           case 6 : e = "6th"; break;
           case 7 : e = "7th"; break;
           case 8 : e = "8th"; break;
           case 9 : e = "9th"; break;
           case 10: e = "10th";break;
           case 11: e = "11th"; break;
           case 12: e = "12th"; break;
           case 13: e = "13th"; break;
           case 14: e = "14th"; break;
           case 15: e = "15th"; break;
           case 16: e = "16th"; break;
           case 17: e = "17th"; break; 
           case 18: e = "18th"; break;
           case 19: e = "19th"; break;
           case 20: e = "20th"; break;
           case 21: e = "21st"; break;
           case 22: e = "22nd"; break;
           case 23: e = "23rd"; break;
           case 24: e = "24th"; break;
           case 25: e = "25th"; break;
           case 26: e = "26th"; break;
           case 27: e = "27th"; break;
           case 28: e = "28th"; break;
           case 29: e = "29th"; break;
           case 30: e = "30th"; break;
           case 31: e = "31st"; break;
           default: result = "wrong format"; break;
}
}
          else if ( i == 2) { name = "February"; 
           switch (l) {
           case 1 : e = "1st"; break;
           case 2 : e = "2nd"; break;
           case 3 : e = "3nd"; break;
           case 4 : e = "4th"; break;
           case 5 : e = "5th"; break;
           case 6 : e = "6th"; break;
           case 7 : e = "7th"; break;
           case 8 : e = "8th"; break;
           case 9 : e = "9th"; break;
           case 10: e = "10th";break;
           case 11: e = "11th"; break;
           case 12: e = "12th"; break;
           case 13: e = "13th"; break;
           case 14: e = "14th"; break;
           case 15: e = "15th"; break;
           case 16: e = "16th"; break;
           case 17: e = "17th"; break; 
           case 18: e = "18th"; break;
           case 19: e = "19th"; break;
           case 20: e = "20th"; break;
           case 21: e = "21st"; break;
           case 22: e = "22nd"; break;
           case 23: e = "23rd"; break;
           case 24: e = "24th"; break;
           case 25: e = "25th"; break;
           case 26: e = "26th"; break;
           case 27: e = "27th"; break;
           case 28: e = "28th"; break;
           case 29: e = "29th"; break;
           default: result = "wrong format"; break;
}
}
          
          else if ( i == 3) { name = "March"; 
           switch (l) {
           case 1 : e = "1st"; break;
           case 2 : e = "2nd"; break;
           case 3 : e = "3nd"; break;
           case 4 : e = "4th"; break;
           case 5 : e = "5th"; break;
           case 6 : e = "6th"; break;
           case 7 : e = "7th"; break;
           case 8 : e = "8th"; break;
           case 9 : e = "9th"; break;
           case 10: e = "10th";break;
           case 11: e = "11th"; break;
           case 12: e = "12th"; break;
           case 13: e = "13th"; break;
           case 14: e = "14th"; break;
           case 15: e = "15th"; break;
           case 16: e = "16th"; break;
           case 17: e = "17th"; break; 
           case 18: e = "18th"; break;
           case 19: e = "19th"; break;
           case 20: e = "20th"; break;
           case 21: e = "21st"; break;
           case 22: e = "22nd"; break;
           case 23: e = "23rd"; break;
           case 24: e = "24th"; break;
           case 25: e = "25th"; break;
           case 26: e = "26th"; break;
           case 27: e = "27th"; break;
           case 28: e = "28th"; break;
           case 29: e = "29th"; break;
           case 30: e = "30th"; break;
           case 31: e = "31st"; break;
           default: result = "wrong format"; break;
}
}



           else if ( i == 4) { name = "April"; 
           switch (l) {
           case 1 : e = "1st"; break;
           case 2 : e = "2nd"; break;
           case 3 : e = "3nd"; break;
           case 4 : e = "4th"; break;
           case 5 : e = "5th"; break;
           case 6 : e = "6th"; break;
           case 7 : e = "7th"; break;
           case 8 : e = "8th"; break;
           case 9 : e = "9th"; break;
           case 10: e = "10th";break;
           case 11: e = "11th"; break;
           case 12: e = "12th"; break;
           case 13: e = "13th"; break;
           case 14: e = "14th"; break;
           case 15: e = "15th"; break;
           case 16: e = "16th"; break;
           case 17: e = "17th"; break; 
           case 18: e = "18th"; break;
           case 19: e = "19th"; break;
           case 20: e = "20th"; break;
           case 21: e = "21st"; break;
           case 22: e = "22nd"; break;
           case 23: e = "23rd"; break;
           case 24: e = "24th"; break;
           case 25: e = "25th"; break;
           case 26: e = "26th"; break;
           case 27: e = "27th"; break;
           case 28: e = "28th"; break;
           case 29: e = "29th"; break;
           case 30: e = "30th"; break;
           default: result = "wrong format"; break;
}
}
            else if ( i == 5) { name = "May"; 
           switch (l) {
           case 1 : e = "1st"; break;
           case 2 : e = "2nd"; break;
           case 3 : e = "3nd"; break;
           case 4 : e = "4th"; break;
           case 5 : e = "5th"; break;
           case 6 : e = "6th"; break;
           case 7 : e = "7th"; break;
           case 8 : e = "8th"; break;
           case 9 : e = "9th"; break;
           case 10: e = "10th";break;
           case 11: e = "11th"; break;
           case 12: e = "12th"; break;
           case 13: e = "13th"; break;
           case 14: e = "14th"; break;
           case 15: e = "15th"; break;
           case 16: e = "16th"; break;
           case 17: e = "17th"; break; 
           case 18: e = "18th"; break;
           case 19: e = "19th"; break;
           case 20: e = "20th"; break;
           case 21: e = "21st"; break;
           case 22: e = "22nd"; break;
           case 23: e = "23rd"; break;
           case 24: e = "24th"; break;
           case 25: e = "25th"; break;
           case 26: e = "26th"; break;
           case 27: e = "27th"; break;
           case 28: e = "28th"; break;
           case 29: e = "29th"; break;
           case 30: e = "30th"; break;
           case 31: e = "31st"; break;
           default: result = "wrong format"; break;
}
}


           else if ( i == 6) { name = "June"; 
           switch (l) {
           case 1 : e = "1st"; break;
           case 2 : e = "2nd"; break;
           case 3 : e = "3nd"; break;
           case 4 : e = "4th"; break;
           case 5 : e = "5th"; break;
           case 6 : e = "6th"; break;
           case 7 : e = "7th"; break;
           case 8 : e = "8th"; break;
           case 9 : e = "9th"; break;
           case 10: e = "10th";break;
           case 11: e = "11th"; break;
           case 12: e = "12th"; break;
           case 13: e = "13th"; break;
           case 14: e = "14th"; break;
           case 15: e = "15th"; break;
           case 16: e = "16th"; break;
           case 17: e = "17th"; break; 
           case 18: e = "18th"; break;
           case 19: e = "19th"; break;
           case 20: e = "20th"; break;
           case 21: e = "21st"; break;
           case 22: e = "22nd"; break;
           case 23: e = "23rd"; break;
           case 24: e = "24th"; break;
           case 25: e = "25th"; break;
           case 26: e = "26th"; break;
           case 27: e = "27th"; break;
           case 28: e = "28th"; break;
           case 29: e = "29th"; break;
           case 30: e = "30th"; break;
           default: result = "wrong format"; break;
}
}
           else if ( i == 7) { name = "July"; 
           switch (l) {
           case 1 : e = "1st"; break;
           case 2 : e = "2nd"; break;
           case 3 : e = "3nd"; break;
           case 4 : e = "4th"; break;
           case 5 : e = "5th"; break;
           case 6 : e = "6th"; break;
           case 7 : e = "7th"; break;
           case 8 : e = "8th"; break;
           case 9 : e = "9th"; break;
           case 10: e = "10th";break;
           case 11: e = "11th"; break;
           case 12: e = "12th"; break;
           case 13: e = "13th"; break;
           case 14: e = "14th"; break;
           case 15: e = "15th"; break;
           case 16: e = "16th"; break;
           case 17: e = "17th"; break; 
           case 18: e = "18th"; break;
           case 19: e = "19th"; break;
           case 20: e = "20th"; break;
           case 21: e = "21st"; break;
           case 22: e = "22nd"; break;
           case 23: e = "23rd"; break;
           case 24: e = "24th"; break;
           case 25: e = "25th"; break;
           case 26: e = "26th"; break;
           case 27: e = "27th"; break;
           case 28: e = "28th"; break;
           case 29: e = "29th"; break;
           case 30: e = "30th"; break;
           case 31: e = "31st"; break;
           default: result = "wrong format"; break;
}
}
           else if ( i == 8) { name = "August"; 
           switch (l) {
           case 1 : e = "1st"; break;
           case 2 : e = "2nd"; break;
           case 3 : e = "3nd"; break;
           case 4 : e = "4th"; break;
           case 5 : e = "5th"; break;
           case 6 : e = "6th"; break;
           case 7 : e = "7th"; break;
           case 8 : e = "8th"; break;
           case 9 : e = "9th"; break;
           case 10: e = "10th";break;
           case 11: e = "11th"; break;
           case 12: e = "12th"; break;
           case 13: e = "13th"; break;
           case 14: e = "14th"; break;
           case 15: e = "15th"; break;
           case 16: e = "16th"; break;
           case 17: e = "17th"; break; 
           case 18: e = "18th"; break;
           case 19: e = "19th"; break;
           case 20: e = "20th"; break;
           case 21: e = "21st"; break;
           case 22: e = "22nd"; break;
           case 23: e = "23rd"; break;
           case 24: e = "24th"; break;
           case 25: e = "25th"; break;
           case 26: e = "26th"; break;
           case 27: e = "27th"; break;
           case 28: e = "28th"; break;
           case 29: e = "29th"; break;
           case 30: e = "30th"; break;
           case 31: e = "31st"; break;
           default: result = "wrong format"; break;
}
}
           else if ( i == 9) { name = "September"; 
           switch (l) {
           case 1 : e = "1st"; break;
           case 2 : e = "2nd"; break;
           case 3 : e = "3nd"; break;
           case 4 : e = "4th"; break;
           case 5 : e = "5th"; break;
           case 6 : e = "6th"; break;
           case 7 : e = "7th"; break;
           case 8 : e = "8th"; break;
           case 9 : e = "9th"; break;
           case 10: e = "10th";break;
           case 11: e = "11th"; break;
           case 12: e = "12th"; break;
           case 13: e = "13th"; break;
           case 14: e = "14th"; break;
           case 15: e = "15th"; break;
           case 16: e = "16th"; break;
           case 17: e = "17th"; break; 
           case 18: e = "18th"; break;
           case 19: e = "19th"; break;
           case 20: e = "20th"; break;
           case 21: e = "21st"; break;
           case 22: e = "22nd"; break;
           case 23: e = "23rd"; break;
           case 24: e = "24th"; break;
           case 25: e = "25th"; break;
           case 26: e = "26th"; break;
           case 27: e = "27th"; break;
           case 28: e = "28th"; break;
           case 29: e = "29th"; break;
           case 30: e = "30th"; break;
           default: result = "wrong format"; break;
}
}


          else if ( i == 10) { name = "October"; 
           switch (l) {
           case 1 : e = "1st"; break;
           case 2 : e = "2nd"; break;
           case 3 : e = "3nd"; break;
           case 4 : e = "4th"; break;
           case 5 : e = "5th"; break;
           case 6 : e = "6th"; break;
           case 7 : e = "7th"; break;
           case 8 : e = "8th"; break;
           case 9 : e = "9th"; break;
           case 10: e = "10th";break;
           case 11: e = "11th"; break;
           case 12: e = "12th"; break;
           case 13: e = "13th"; break;
           case 14: e = "14th"; break;
           case 15: e = "15th"; break;
           case 16: e = "16th"; break;
           case 17: e = "17th"; break; 
           case 18: e = "18th"; break;
           case 19: e = "19th"; break;
           case 20: e = "20th"; break;
           case 21: e = "21st"; break;
           case 22: e = "22nd"; break;
           case 23: e = "23rd"; break;
           case 24: e = "24th"; break;
           case 25: e = "25th"; break;
           case 26: e = "26th"; break;
           case 27: e = "27th"; break;
           case 28: e = "28th"; break;
           case 29: e = "29th"; break;
           case 30: e = "30th"; break;
           case 31: e = "31st"; break;
           default: result = "wrong format"; break;
}
}

            else if ( i == 11) { name = "November"; 
           switch (l) {
           case 1 : e = "1st"; break;
           case 2 : e = "2nd"; break;
           case 3 : e = "3nd"; break;
           case 4 : e = "4th"; break;
           case 5 : e = "5th"; break;
           case 6 : e = "6th"; break;
           case 7 : e = "7th"; break;
           case 8 : e = "8th"; break;
           case 9 : e = "9th"; break;
           case 10: e = "10th";break;
           case 11: e = "11th"; break;
           case 12: e = "12th"; break;
           case 13: e = "13th"; break;
           case 14: e = "14th"; break;
           case 15: e = "15th"; break;
           case 16: e = "16th"; break;
           case 17: e = "17th"; break; 
           case 18: e = "18th"; break;
           case 19: e = "19th"; break;
           case 20: e = "20th"; break;
           case 21: e = "21st"; break;
           case 22: e = "22nd"; break;
           case 23: e = "23rd"; break;
           case 24: e = "24th"; break;
           case 25: e = "25th"; break;
           case 26: e = "26th"; break;
           case 27: e = "27th"; break;
           case 28: e = "28th"; break;
           case 29: e = "29th"; break;
           case 30: e = "30th"; break;
           default: result = "wrong format"; break;
}
}


           else if ( i == 12) { name = "December"; 
           switch (l) {
           case 1 : e = "1st"; break;
           case 2 : e = "2nd"; break;
           case 3 : e = "3nd"; break;
           case 4 : e = "4th"; break;
           case 5 : e = "5th"; break;
           case 6 : e = "6th"; break;
           case 7 : e = "7th"; break;
           case 8 : e = "8th"; break;
           case 9 : e = "9th"; break;
           case 10: e = "10th";break;
           case 11: e = "11th"; break;
           case 12: e = "12th"; break;
           case 13: e = "13th"; break;
           case 14: e = "14th"; break;
           case 15: e = "15th"; break;
           case 16: e = "16th"; break;
           case 17: e = "17th"; break; 
           case 18: e = "18th"; break;
           case 19: e = "19th"; break;
           case 20: e = "20th"; break;
           case 21: e = "21st"; break;
           case 22: e = "22nd"; break;
           case 23: e = "23rd"; break;
           case 24: e = "24th"; break;
           case 25: e = "25th"; break;
           case 26: e = "26th"; break;
           case 27: e = "27th"; break;
           case 28: e = "28th"; break;
           case 29: e = "29th"; break;
           case 30: e = "30th"; break;
           case 31: e = "31st"; break;
           default: result = "wrong format"; break;
}
}

else {result = "wrong format";}
	

         
         if (result != "wrong format") {
 result1 = name + g + e;

System.out.println(result1);}
else {System.out.println("wrong format");}




       
           

 
    
    
   	

}
}


else { 
String result2;
result2 = "wrong format";
System.out.println(result2);
}
      }
   }
