public class course {
	
        public String name;
        public int[][] Day;
        public String[] R;
        public int count = 0;
        public String S;
	public course(String n) {
        
        name = n;
        R = new String[10];
        S = " ";
       

	}
	
	public void setDay(int[] d) {
        
        Day = new int[5][3];
        
        for (int i = 0; i< d.length; i++){
        if(d[i]==0)
        Day[0][0]=1;
        if(d[i]==1)
        Day[1][0]=1;
        if(d[i]==2)
        Day[2][0]=1;
        if(d[i]==3)
        Day[3][0]=1;
        if(d[i]==4)
        Day[4][0]=1;
}

	}
	
	public void setTime(int s, int e) {
        
        
        if (Day[0][0] == 1){
        Day[0][1] = s;
        Day[0][2] = e;
}       
         if (Day[1][0] == 1){
        Day[1][1] = s;
        Day[1][2] = e;
}
         if (Day[2][0] == 1){
        Day[2][1] = s;
        Day[2][2] = e;
}
         if (Day[3][0] == 1){
        Day[3][1] = s;
        Day[3][2] = e;
}
        if (Day[4][0] == 1){
        Day[4][1] = s;
        Day[4][2] = e;
} 




         

	}
	
	public String toString() {
                for (int i = 0; i< count; i++){
        S = S+ "\n"+ R[i];}
                
                return "Course" +"  "+ name+ "   " + this.S;
               
	}
}
