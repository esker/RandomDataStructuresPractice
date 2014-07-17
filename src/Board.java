import java.util.Scanner;

public class Board {
	private int[][] cells;
	private boolean[][] fixedCells;

	public Board(String[] row) {
		// need to create our 2 9*9 arrays
		cells = new int[9][9];
		fixedCells = new boolean[9][9];
		createBoard(row);
	}

	public int getCells(int x, int y) {
		return cells[x][y];
	}

	public boolean getFixedCells(int x, int y) {
		return fixedCells[x][y];
	}

	// method that creates the board given the rows via an array
	private void createBoard(String[] rowArray) {
		for (int x = 0; x < 9; x++) {
			Scanner s = new Scanner(rowArray[x]);
			for (int y = 0; y < 9; y++) {
				cells[x][y] = s.nextInt();
				// need to check if the current int has a positive, non zero
				// value if it does we need to flip the flag in the fixed array
				if (cells[x][y] == 0 || cells[x][y] > 9) {
					fixedCells[x][y] = false;
				} else {
					fixedCells[x][y] = true;
				}
			}
		}
	}

	public boolean isBad(Move move) {
		if (cells[move.getRow()][move.getColumn()] == 0) {

			// Check Row
			for (int i = 0; i < 9; i++) {
				if (cells[move.getRow()][i] == move.getValue())
					return true;
			}

			// Check Col
			for (int i = 0; i < 9; i++) {
				if (cells[i][move.getColumn()] == move.getValue())
					return true;
			}

			// Check square by checking the row
			//once found get the mod which will split rows into 3s allowing you to then loop through the 3 rows you need
			int rowStart, colStart;

			if (move.getRow() % 3 == 0)//if the row equal 3, 6, or 9
				rowStart = move.getRow();
			else if (move.getRow() % 3 == 1)//if the rows equal 4, or 7 
				rowStart = move.getRow() - 1;
			else
				rowStart = move.getRow() - 2;

			if (move.getColumn() % 3 == 0)// check the associated columns
				colStart = move.getColumn();
			else if (move.getColumn() % 3 == 1)
				colStart = move.getColumn() - 1;
			else
				colStart = move.getColumn() - 2;

			for (int i = rowStart; i < rowStart + 3; i++) {
				for (int j = colStart; j < colStart + 3; j++) {
					if (cells[i][j] == move.getValue())
						return true;
				}
			}

			return false;
		} else
			return true;
	}

	//print out data as you would expect to see in a sudoku puzzle
	public String toString() {
		String output = "";
		for (int i = 0; i < 9; i++) {//for all rows
			for (int j = 0; j < 9; j++) {// and all cols
				output += cells[i][j];// get the value
				if (j < 8) // if cols numbers are less than 8 
					output += " "; // put a space between the strings
			}
			if (i < 8)//if you're at the end of a column
				output += "\n";//move down a row.
		}

		return output;//return string
	}

	public void move(Move m) throws BadMoveException {
		// changes move object, should throw BadMoveException if trying to move
		// into a cell that's prefilled
		if (fixedCells[m.getRow()][m.getColumn()])
			cells[m.getRow()][m.getColumn()] = m.getValue();
		else
			throw new BadMoveException();
	}

}
