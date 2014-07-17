public class Move {
	private int row, column, value;

	public Move(int row, int column, int value){
		this.column = column;
		this.row = row;
		this.value = value;
	}
		
	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public int getValue() {
		return value;
	}

	
}
