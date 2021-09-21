public class PuzzleVerificationSystem {
	
	private boolean puzzleIsValid;																					//Declaration of a private global scope boolean.
																													//This boolean will be used for the accessor method
																													//that will share the validity of the puzzles
	
	public boolean isPuzzleIsValid() {
		return puzzleIsValid;
	}

	public void setPuzzleIsValid(boolean puzzleIsValid) {
		this.puzzleIsValid = puzzleIsValid;
	}

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
		int[][] numbersToFind = new int[9][9];																		//2D array for comparing the numbers in the puzzle
		numbersToFind[0][0] = 1;																					//Lines 30 - 46
		numbersToFind[1][0] = 2;																					//Adds numbers to the array
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
		return numbersToFind;																						//Returns the method scope 2D array to the method
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
		 * 							09/18/2021	Jared Shaddick	The Validation Algorithm 
		 * 														Has Been Completed
		 * 							09/20/2021	Jared Shaddick	Fixed Parts Of The Validation Method
		 * 							09/21/2021	Jared Shaddick	Fixed More Parts Of The Validation Method
		 * 							09/21/2021	Jared Shaddick	No Further Changes Necessary
		 */
		int numberDuplicateDetection;
		int findColumnIndex = 0;
		int findRowIndex = 0;
		int rows = 0;
		int columnIndex = 0;
		
		int oneAppears = 0;
		int twoAppears = 0;
		int threeAppears = 0;
		int fourAppears = 0;
		int fiveAppears = 0;
		int sixAppears = 0;
		int sevenAppears = 0;
		int eightAppears = 0;
		int nineAppears = 0;
		
		int rowCounter = 0;
		
		boolean rowsValid = true;
		
		while(rows < 8 && rows != 9 && rowsValid) {
			if(oneAppears == 1 && twoAppears == 1 && threeAppears == 1 && fourAppears == 1 && fiveAppears == 1 && sixAppears == 1 && sevenAppears == 1 && eightAppears == 1 && nineAppears == 1) {
				oneAppears = 0;
				twoAppears = 0;
				threeAppears = 0;
				fourAppears = 0;
				fiveAppears = 0;
				sixAppears = 0;
				sevenAppears = 0;
				eightAppears = 0;
				nineAppears = 0;
				findColumnIndex = 0;
				columnIndex = 0;
				rowCounter++;
			}
			if (puzzleToValidate[rows][columnIndex] == validNumbers[findRowIndex][findColumnIndex] || findColumnIndex < 8) {
				numberDuplicateDetection = puzzleToValidate[rows][columnIndex];
				if (numberDuplicateDetection == 1) {
					oneAppears++;
				}
				if (numberDuplicateDetection == 2) {
					twoAppears++;
				}
				if (numberDuplicateDetection == 3) {
					threeAppears++;
				}
				if (numberDuplicateDetection == 4) {
					fourAppears++;
				}
				if (numberDuplicateDetection == 5) {
					fiveAppears++;
				}
				if (numberDuplicateDetection == 6) {
					sixAppears++;
				}
				if (numberDuplicateDetection == 7) {
					sevenAppears++;
				}
				if (numberDuplicateDetection == 8) {
					eightAppears++;
				}
				if (numberDuplicateDetection == 9) {
					nineAppears++;
				}
				findColumnIndex = 0;
			}
			if (oneAppears > 1 || twoAppears > 1 || threeAppears > 1 || fourAppears > 1 || fiveAppears > 1 || sixAppears > 1 || sevenAppears > 1 || eightAppears > 1 || nineAppears > 1) {
				rowsValid = false;
			}
			if (puzzleToValidate[rows][columnIndex] != validNumbers[findRowIndex][findColumnIndex] && findColumnIndex < 8) {
				findColumnIndex++;
			}
			if (puzzleToValidate[rows][columnIndex] != validNumbers[findRowIndex][findColumnIndex] && findColumnIndex == 8) {
				rowsValid = false;
			}
			if (rowCounter == 8) {
				rowsValid = true;
			}
			columnIndex++;
			if (columnIndex == 9) {
				rows++;
				columnIndex = 0;
			}
		}
		if(rowsValid) {
			checkRows(rowsValid, puzzleToValidate);
		}
		
	}
	
	private void checkRows(boolean rowsValid, int[][] puzzleToValidate) {
		
		int numberDuplicateDetection;
		int findColumnIndex = 0;
		int findRowIndex = 0;
		int rows = 0;
		int columnIndex = 0;
		
		int oneAppears = 0;
		int twoAppears = 0;
		int threeAppears = 0;
		int fourAppears = 0;
		int fiveAppears = 0;
		int sixAppears = 0;
		int sevenAppears = 0;
		int eightAppears = 0;
		int nineAppears = 0;
		
		int columnCounter = 0;
		
		boolean columnsValid = true;
		
		if (rowsValid) {
			while(columnIndex < 8 && columnIndex != 9 && columnsValid) {
				if(oneAppears == 1 && twoAppears == 1 && threeAppears == 1 && fourAppears == 1 && fiveAppears == 1 && sixAppears == 1 && sevenAppears == 1 && eightAppears == 1 && nineAppears == 1) {
					oneAppears = 0;
					twoAppears = 0;
					threeAppears = 0;
					fourAppears = 0;
					fiveAppears = 0;
					sixAppears = 0;
					sevenAppears = 0;
					eightAppears = 0;
					nineAppears = 0;
					findRowIndex = 0;
					rows = 0;
					columnCounter++;
				}
				if (puzzleToValidate[rows][columnIndex] == validNumbers[findRowIndex][findColumnIndex] || findRowIndex < 8) {
					numberDuplicateDetection = puzzleToValidate[rows][columnIndex];
					if (numberDuplicateDetection == 1) {
						oneAppears++;
					}
					if (numberDuplicateDetection == 2) {
						twoAppears++;
					}
					if (numberDuplicateDetection == 3) {
						threeAppears++;
					}
					if (numberDuplicateDetection == 4) {
						fourAppears++;
					}
					if (numberDuplicateDetection == 5) {
						fiveAppears++;
					}
					if (numberDuplicateDetection == 6) {
						sixAppears++;
					}
					if (numberDuplicateDetection == 7) {
						sevenAppears++;
					}
					if (numberDuplicateDetection == 8) {
						eightAppears++;
					}
					if (numberDuplicateDetection == 9) {
						nineAppears++;
					}
					findRowIndex = 0;
				}
				if (oneAppears > 1 || twoAppears > 1 || threeAppears > 1 || fourAppears > 1 || fiveAppears > 1 || sixAppears > 1 || sevenAppears > 1 || eightAppears > 1 || nineAppears > 1) {
					columnsValid = false;
				}
				if (columnCounter == 8) {
					rowsValid = true;
				}
				if (puzzleToValidate[rows][columnIndex] != validNumbers[findRowIndex][findColumnIndex] && findRowIndex < 8) {
					findRowIndex++;
				}
				if (puzzleToValidate[rows][columnIndex] != validNumbers[findRowIndex][findColumnIndex] && findRowIndex == 8) {
					columnsValid = false;
				}
				rows++;
				if (rows == 9) {
					columnIndex++;
					rows = 0;
				}
			}
			setPuzzleIsValid(columnsValid);
		}
	}
}
