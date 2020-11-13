/**
 * The class board has member methods that simulate a tic-tac-toe game board.
 * It has methods responsible for placing the marks, checking for a winner and displaying itself.
 * @author ENSF 409
 * @version 1.1
 * @since February 20, 2020
 *
 */
public class Board implements Constants {
	private char theBoard[][];
	private int markCount;
	/**
	 * Constructs a new object of type board with a 3x3 char array filled with SPACE_CHAR from constants Interface.
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}
	/**
	 * Gets the mark on the board at a given row and column.
	 * @param row The row of the wanted mark.
	 * @param col The column of the wanted mark.
	 * @return The mark at the specified row and column
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}
	/**
	 * Checks if the board is full with marks.
	 * @return True if board is full.
	 */
	public boolean isFull() {
		return markCount == 9;
	}
	/**
	 * Checks if the X marks have formed a winning a configuration.
	 * It calls the checkWinner method to identify winning configurations.
	 * @return True If the X marks form a winning configuration
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}
	/**
	 * Checks if the Y marks have formed a winning a configuration.
	 * It calls the checkWinner method to identify winning configurations.
	 * @return True If the Y marks form a winning configuration
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}
	/**
	 * Draws the board to the console using the help of several methods.
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}
	/**
	 * Places the specified mark to the given row and column.
	 * @param row Row of the mark location.
	 * @param col Column of the mark location.
	 * @param mark Mark to be placed at the given row and column.
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}
	/**
	 * Resets the board with the Default SPACE_CHAR.
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}
	/**
	 * Checks if the given mark has formed a winning configuration on the board.
	 * @param mark The mark checked for wining conditions.
	 * @return 1 if the mark has formed a winning configuration, and 0 otherwise.
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}
	/**
	 * Prints the column header for the board.
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}
	/**
	 * Prints hyphens to draw the horizontal lines of the board.
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}
	/**
	 * Prints vertical lines to draw the vertical lines of the board.
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
	/**
	 * Checks if the location specified has a mark already in it
	 * @param x An integer representing the row
	 * @param y An integer representing the column
	 * @return true if a mark already exists in the specified location
	 */
	boolean checkForMark(int x, int y) {
		boolean check = false;
		if(this.getMark(x, y) != SPACE_CHAR)
			check = true;
		return check;
	}
	/**
	 * Removes a mark from the specified location and replaces it with a space character
	 * @param row An integer representing the row
	 * @param col An integer representing the column
	 */
	public void removeMark(int row, int col) {
		theBoard[row][col] = SPACE_CHAR;
		markCount--;
		
	}
}
