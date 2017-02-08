public class hw4 {
	
	public static double[] generateNewPoint(int dimension, double range) {
		double[] x = new double[dimension];
		for(int i = 0; i < dimension; i++) {
			x[i] = Math.random() * range;
		}		
		return x;
	}
	
	public static void main(String[] args) {
		int numOfPoints = Integer.parseInt(args[0]);

		for(int i = 0; i < numOfPoints; i++) {
			double[] x = generateNewPoint(2, 10.0);
			hw4Helper.addNewPoint(x);
		}
		
		System.out.println("Number of points: " + hw4Helper.pointCount);
		System.out.println("Shortest distance from origin: " + hw4Helper.shortestDistance);
		System.out.println("Longest distance from origin: " + hw4Helper.longestDistance);
		System.out.println("All distance:");
		hw4Helper.printAllDistance();
	}
}
