import java.util.*;

public class SudokuSolver {

	//the idea is to use backtracking to solve board states in a particular cell
	//if the 
	public String solve(Board board) {

		Stack<Move> stackOfMoves = new Stack<Move>();

		try {
			int row = 0;
			int col = 0;
			int guess = 1;
			boolean badMove = true;

			while (badMove == true && row < 9) {
				if (board.getFixedCells(row, col) == false) {
					// Check if the move is bad
					Move m = new Move(row, col, guess);
					badMove = board.isBad(m);
					// if move not bad move to that position and push that move onto the move stack
					if (badMove == false) {
						board.move(m);
						stackOfMoves.push(m);

						// Increment to the next cell
						if (col != 8)
							col++;
						else {
							row++;
							col = 0;
						}

						guess = 1;
						badMove = true;
					} else {
						//if not done guessing increment guess count
						if (guess != 9)
							guess++;
						else {
							// backtrack in the move stack and try the previous move
							Move lastMove = stackOfMoves.pop();

							row = lastMove.getRow();
							col = lastMove.getColumn();

							Move tmp = new Move(row, col, 0);
							board.move(tmp);

							// If the top Move guess is '9', skip it
							while (lastMove.getValue() == 9) {
								lastMove = stackOfMoves.pop();
								row = lastMove.getRow();
								col = lastMove.getColumn();

								Move tmp2 = new Move(row, col, 0);
								board.move(tmp2);
							}

							// increment guess
							guess = lastMove.getValue() + 1;

						}
					}
				} else {
					// Move to next cell
					if (col != 8)
						col++;
					else {
						row++;
						col = 0;
					}
				}
			}

		} catch (EmptyStackException e) {return "This puzzle has no solution.";};

		return board.toString();
	}

}
