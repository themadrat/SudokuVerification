import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class PuzzleVerificationSystem {
	
	private boolean puzzleIsValid;																			//Declaration of a private global scope boolean.
																											//This boolean will be used for the accessor method
																											//that will share the validity of the puzzle.

	private static int[][] puzzleToValidate = new int[9][9];												//This variable is a 2D array that will store the
																											//Sudoku puzzle to be validated. This variable is also
																											//instantiated here.

	private boolean rowsAreValid;
	private boolean columnsAreValid;
	private boolean blocksAreValid;
	
	FileManager FM = new FileManager();																		//Creates an instance of FileManager in
																											//PuzzleVerificationSystem
	
	//private int[][] getPuzzleToCheck() {
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
		 * 							09/18/2021	Jared Shaddick	In-Line Comments Created
		 */
		//return null;
	//}
	
	public void verifyPuzzle() {
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
		 * 							09/15/2021	Jared Shaddick	Block Comments Created
		 * 							09/18/2021	Jared Shaddick	Merged getPuzzleToCheck as
		 * 														it did nothing but apply the
		 * 														puzzle to validate to the static
		 * 														array puzzleToValidate.
		 */
		puzzleToValidate = FM.setPuzzle();																	//Passes the 2D array from FileManager to this
																											//method so that it may be validated
		int[] numbersToFind = new int[9];
		numbersToFind[0] = 1;
		numbersToFind[1] = 2;
		numbersToFind[2] = 3;
		numbersToFind[3] = 4;
		numbersToFind[4] = 5;
		numbersToFind[5] = 6;
		numbersToFind[6] = 7;
		numbersToFind[7] = 8;
		numbersToFind[8] = 9;
		
		int valueToFind = 1;
		int rows = 0;
		int columns = 0;
		//while(rows < 9) {
		//	while (columns < 9) {
		//	}
		//}
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
		 * 							09/17/2021	Jared Shaddick	In-Line Comments Created
		 * 							09/17/2021	Jared Shaddick	Setup Complete
		 */
		this.puzzleIsValid = isPuzzleValid;																	//sets the private global boolean, puzzleIsValid, to
	}																										//to the accessor method, setResult(), using the boolean
																											//parameter, isPuzzleValid.

	public boolean isPuzzleValid() {
		/*
		 * Method:					isPuzzleValid()
		 * 
		 * Method Parameters:		None
		 * 
		 * Method Return:			boolean
		 * 
		 * Synopsis:				This Method serves to allow other classes to access
		 * 							the information on if a puzzle is valid
		 * 
		 * Modifications:			Date:		Name:			Modification:
		 * 							09/17/2021	Jared Shaddick	Method Created
		 * 							09/17/2021	Jared Shaddick	Method Finished
		 * 							09/18/2021	Jared Shaddick	Block Comments Created
		 * 							09/18/2021	Jared Shaddick	In-Line Comments Created					
		 */
		return puzzleIsValid;																//Returns the variable to the accessor method
	}
	
}
