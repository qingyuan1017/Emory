/* THIS CODE IS MY OWN WORK. IT WAS WRITTEN WITHOUT CONSULTING CODE
WRITTEN BY OTHER STUDENTS OR MATERIALS OTHER THAN THIS SEMESTER'S
COURSE MATERIALS. Zhang Qingyuan*/
public class hw4Helper {
	public static double shortestDistance = -1.0;
	public static double longestDistance = -1.0;
	
	public static double[] distanceArray = null;
	public static int pointCount = 0;
	
	public static void addNewPoint(double[] a) {
		double distance = getDistance(a);
                pointCount++;
                

if(distanceArray == null){
distanceArray = new double[1];
distanceArray[0] = distance;
}
if(distanceArray != null){
double[] b = new double[distanceArray.length*2];
for(int j=0; j< distanceArray.length;j++)
b[j] = distanceArray[j];
distanceArray = b;
distanceArray[pointCount] = distance;
}

shortestDistance = distanceArray[0];
longestDistance = distanceArray[0];


for(int i = 0; i<=pointCount; i++){
if (distanceArray[i] < shortestDistance)
{shortestDistance = distanceArray[i];}
if (distanceArray[i] > longestDistance)
{longestDistance = distanceArray[i];}



}// insert your code here		
	}
	
	public static double getDistance(double[] a) {
		double distance = Math.sqrt(a[0]*a[0]+a[1]*a[1]);// insert your code here
		return distance; // delete this line if necessary
	}
	
	public static void printAllDistance() {
		for (int i = 0; i<= pointCount; i++)
{System.out.println(distanceArray[ i]);
}// insert your code here
	}
}
