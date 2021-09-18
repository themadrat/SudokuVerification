import javax.swing.DefaultListModel;

public class PuzzleVerificationSystem {
	
	private boolean puzzleIsValid;
	
	private int[] thePuzzles;

	private int[][] getPuzzleToCheck() {
		/* 
		 * Method:					puzzleToCheck()
		 * 
		 * Method Parameters:		None
		 * 
		 * Method Return:			int[][]
		 * 
		 * Synopsis:				This method will serve as the way in which puzzles are retrieved so
		 * 							that they maay be verified as valid or invalid.
		 * 
		 * Modifications:			Date:		Name:			Modification:
		 * 							09/15/2021	Jared Shaddick	Method Created 
		 * 							09/15/2021	Jared Shaddick	Block Comments Created
		 * 
		 */
		
		return null;
	}
	
	private boolean verifyPuzzle() {
		/* 
		 * Method:					verifyRows()
		 * 
		 * Method Parameters:		None
		 * 
		 * Method Return:			boolean
		 * 
		 * Synopsis:				This method serves as the means in which each row of the
		 * 							Sudoku puzzle is checked and verified.
		 * 
		 * Modifications:			Date:		Name:			Modification:
		 * 							09/15/2021	Jared Shaddick	Method Created
		 * 							09/15/2021	Jared Shaddick	Blockk Comments Created
		 */
		
		
		return false;
	}
	
	public void setResult(boolean isPuzzleValid) {
		/*
		 * Method:					getResult()
		 * 
		 * Method Parameters:		boolean isPuzzleValid
		 * 
		 * Method Return:			Void
		 * 
		 * Synopsis:				This method serves as the accessor method
		 * 							for other classes to read this information.
		 * 
		 * Modifications:			Date:		Name:			Modification:
		 * 							09/17/2021	Jared Shaddick	Method Created
		 * 							09/17/2021	Jared Shaddick	Block Comments Created
		 * 							09/17/2021	Jared Shaddick	Setup Complete
		 */
		this.puzzleIsValid = isPuzzleValid;																	//sets the private global boolean, puzzleIsValid, to
	}																										//to the accessor method, setResult(), using the boolean
																											//parameter, isPuzzleValid.
	
}
