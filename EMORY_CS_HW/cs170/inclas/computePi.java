public class computePi {
	public static void main(String[] args) {
		int count = 0;
		int total = 0;
		for(int i = 0; i < 100000; i++) {
			double a = Math.random();
			double b = Math.random();
			total++;

			if(a * a + b * b < 1.0) {
				count++;
			}
		}
		
		System.out.println((double)count/(double)total * 4.0);
	}
}
