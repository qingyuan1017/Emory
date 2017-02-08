public class GameGrid{
  private static final int ROWS = 6;
	private static final int COLS = 7;

	public static final char P1_PIECE = '+';
	public static final char P2_PIECE = '@';
	private static final char BLANK = ' ';

	private char grid[][] = new char[ROWS][COLS];
	
	public GameGrid(){
		
		
	}
	
	public boolean canPlacePiece(int column){
		if(column < 0 || column >6){
			return false;
		}
		
		if(grid[5][column] != BLANK){
			return false;
		}
		return true;
	}
	
	public void placePiece(int column, char symbol){
		System.out.println("aasdf");
		if(symbol == P1_PIECE){
			for(int  row = 0; row< ROWS; row++){
				if(grid[row][column] == BLANK)
					grid[row][column] = P1_PIECE;
			}
		}
		
		else if(symbol == P2_PIECE){
			System.out.println("aasdf");
			for(int  row = 0; row< ROWS; row++){
				if(grid[row][column] == BLANK){
					
					System.out.println("aasdf");
					grid[row][column] = P2_PIECE;
					System.out.println(grid[row][column]);
				}
			}
		}
		
		else {
			System.out.println("BAD INPUT");
		}
	}

	public void printGrid(){
		//Print out the column numbers so players can see it
		System.out.println("\n 0 1 2 3 4 5 6 ");

		//Print the body of the grid
		System.out.println("---------------");
		for(int row = 0; row < ROWS; row++){
			System.out.print("|");
			for(int col = 0; col < COLS; col++){
				System.out.print(grid[row][col] + "|");
			}
			System.out.println("\n---------------");
		}
	}
	
	
	
	public static void main(String [] args){
		GameGrid a = new GameGrid();
		a.placePiece(0,'@');
		a.printGrid();
	}
}
