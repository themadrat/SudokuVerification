
public class PuzzleVerificationSystem {
	
	private boolean puzzleIsValid = true;																			//Declaration of a private global scope boolean.
																											//This boolean will be used for the accessor method
																											//that will share the validity of the puzzle.

	private static int[][] puzzleToValidate = new int[9][9];												//This variable is a 2D array that will store the
																											//Sudoku puzzle to be validated. This variable is also
																											//instantiated here.

	private boolean rowsAreValid = false;
	private boolean columnsAreValid = false;
	private boolean blocksAreValid;
	
	private static int[][] validNumbers = getMaxValues();
	
	private static int[][] getMaxValues() {
		/* 
		 * Method:					getMaxValues()
		 * 
		 * Method Parameters:		None
		 * 
		 * Method Return:			int[][]
		 * 
		 * Synopsis:				This method will serve as the creator of the array
		 * 							in which the puzzles will be compared to
		 * 
		 * Modifications:			Date:		Name:			Modification:
		 * 							09/15/2021	Jared Shaddick	Method Created 
		 * 							09/15/2021	Jared Shaddick	Block Comments Created
		 * 							09/18/2021	Jared Shaddick	In-Line Comments Created
		 */
		int[][] numbersToFind = new int[9][9];
		numbersToFind[0][0] = 1;
		numbersToFind[1][0] = 2;
		numbersToFind[2][0] = 3;
		numbersToFind[3][0] = 4;
		numbersToFind[4][0] = 5;
		numbersToFind[5][0] = 6;
		numbersToFind[6][0] = 7;
		numbersToFind[7][0] = 8;
		numbersToFind[8][0] = 9;
		numbersToFind[0][1] = 2;
		numbersToFind[0][2] = 3;
		numbersToFind[0][3] = 4;
		numbersToFind[0][4] = 5;
		numbersToFind[0][5] = 6;
		numbersToFind[0][6] = 7;
		numbersToFind[0][7] = 8;
		numbersToFind[0][8] = 9;
		return numbersToFind;
	}
	
	public void verifyPuzzle(int[][] puzzleToValidate) {
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
		 * 							09/18/2021	Jared Shaddick	2 Of The 3 Parts Of The Validation
		 * 														Algorithm Have Been Completed
		 */																//Passes the 2D array from FileManager to this
																											//method so that it may be validated
		
		int findColumnIndex = 0;
		int findRowIndex = 0;
		int rows = 0;
		int columns = 0;
		
		boolean puzzleIsValid = true;
		
		while(rows < 8 && puzzleIsValid) {
			while (columns < 8 && puzzleIsValid) {
				if (puzzleToValidate[rows][columns] == validNumbers[findRowIndex][findColumnIndex] || findColumnIndex < 8) {
					columns++;
					findColumnIndex = 0;
				}
				if (puzzleToValidate[rows][columns] != validNumbers[findRowIndex][findColumnIndex] && findColumnIndex < 8) {
					findColumnIndex++;
				}
				if (puzzleToValidate[rows][columns] != validNumbers[findRowIndex][findColumnIndex] && findColumnIndex == 8) {
					setResult(false);
				}
				if (columns == 8) {
					columnsAreValid = true;
				}
			}
			if (puzzleToValidate[rows][columns] == validNumbers[findRowIndex][findColumnIndex] || findRowIndex < 8) {
				rows++;
				findRowIndex = 0;
			}
			if (puzzleToValidate[rows][columns] != validNumbers[findRowIndex][findColumnIndex] && findRowIndex < 8) {
				findRowIndex++;
			}
			if (puzzleToValidate[rows][columns] != validNumbers[findRowIndex][findColumnIndex] && findRowIndex == 8) {
				setResult(false);
			}
			if (rows == 8) {
				rowsAreValid = true;
			}
			
		}
		int rowGrid = 0;
		int columnGrid = 0;
		int columnMultiplier = 0;
		int rowMultiplier = 0;
		int validBlocks = 0;
		findRowIndex = 0;
		findColumnIndex = 0;
		while (rowGrid < 3*rowMultiplier - 1 && rowGrid < 8) {
			while (columnGrid < 3*columnMultiplier - 1 && columnGrid < 8) {
				if (puzzleToValidate[rowGrid][columnGrid] == validNumbers[findRowIndex][findColumnIndex] || findColumnIndex < 8)	{
					columnGrid++;
					findColumnIndex = 0;
				}
				if (puzzleToValidate[rowGrid][columnGrid] != validNumbers[findRowIndex][findColumnIndex] && findColumnIndex < 8)	{
					findColumnIndex++;
				}
				if (puzzleToValidate[rowGrid][columnGrid] != validNumbers[findRowIndex][findColumnIndex] && findColumnIndex == 8)	{
					setResult(false);
				}
			}
			columnMultiplier += 3;
			if (puzzleToValidate[rowGrid][columnGrid] == validNumbers[findRowIndex][findColumnIndex] || findRowIndex < 8)	{
				rowGrid++;
				findRowIndex = 0;
			}
			if (puzzleToValidate[rowGrid][columnGrid] != validNumbers[findRowIndex][findColumnIndex] && findRowIndex < 8)	{
				findRowIndex++;
			}
			if (puzzleToValidate[rowGrid][columnGrid] != validNumbers[findRowIndex][findColumnIndex] && findRowIndex == 8)	{
				setResult(false);
			}
			validBlocks++;
			rowMultiplier += 1;
			if (validBlocks == 9) {
				blocksAreValid = true;
			}
			
			
		}
	}
	
	public void setResult(boolean validPuzzle) {
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
		 * 							09/18/2021	Jared Shaddick	Implemented 2 Of The 3 Results
		 * 														From The Validation Method
		 */
		if (rowsAreValid && columnsAreValid && blocksAreValid) {
			puzzleIsValid = true;
		}
		if (!validPuzzle) {
			puzzleIsValid = false;
		}
		
	}

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
