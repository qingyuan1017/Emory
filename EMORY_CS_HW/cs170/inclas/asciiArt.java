public class asciiArt {
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10 - i - 1; j++) {
				System.out.print(' ');
			}
			
			for(int j = 0; j < i * 2 + 1; j++) {
				System.out.print('A');
			}
			System.out.println();
		}
	}
}
