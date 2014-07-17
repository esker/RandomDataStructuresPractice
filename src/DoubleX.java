public class DoubleX {

	String[] board;

	public DoubleX(String[] game) {
		board = game;
	}

	public String[] solver() {
		// want to count the number of strings and if there are two adjectent
		// spaces place an X in that space and the one next to it

		String[] newBoardState = board;
		try {
			for (int i = 0; i < board.length; i++) {
				if (board[i] == "" && board[i + 1] == ""
						&& board[i + 1] != null) {
					newBoardState[i] = "x";
					newBoardState[i + 1] = "x";
					return newBoardState;
				}
			}
		} catch (ArrayIndexOutOfBoundsException a) {
			System.err.println("Index out of bounds: " + a.getMessage());
		}

		return newBoardState;
	}

	public String toString() {
		String s = new String();
		for (int j = 0; j < board.length; j++) {
			s += board[j];
			if (board[j] == "")
				s += " ";
		}

		return s;
	}
	
	public boolean contains(String s){
		int count = 0;
		while (count != board.length){
			if (s == board[count])
				return true;
		}
			
		return false;
	}

}
