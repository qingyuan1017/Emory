public class student {


        public String name;
        public String C;
        public course [] courses = new course [10];
        public int count;
        
        
        //public int[][] Day = new int [5][3];

	public student(String n) { 
        
        name = n;
        count = 0;

	}

	public void add(course c) {

        if (count == 0){
        
        courses [0] = c;
        count++;
    
        c.R[c.count] = name;
        c.count++;
        return;
    
}

        
         
         
	boolean b = false;
       if (count != 0){
       for (int j =0; j < count; j++){
       for(int i = 0; i < 5 ; i++){
       if (courses [j].Day[i][0] == c.Day[i][0]){
       if (c.Day[i][1]> courses[j].Day[i][1]&& c.Day[i][1]< courses[j].Day[i][2]|| c.Day[i][2]> courses[j].Day[i][1]&& c.Day[i][2]< courses[j].Day[i][2]||courses[j].Day[i][1]> c.Day[i][1]&& courses[j].Day[i][1]< c.Day[i][2]||courses[j].Day[i][2]> c.Day[i][1]&& courses[j].Day[i][2]< c.Day[i][2]){
        b = true;
        
         }
     
       }

}    
}
        
}if(!b){courses[count] = c;
        c.R[c.count] = name;
         count++;
         c.count++;}

C = "";
for (int a=0;a<count;a++){

C = C + "\n"+courses [a].name;}



         



      

        

	}
	
	public String toString() {
		return "Student  " + this.name +"\n"+ this.C;
	}
}
