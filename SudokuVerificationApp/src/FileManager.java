import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {
	
	private static int[][] puzzleToLoad;
	
	private Scanner fileScanner;
	
	PuzzleVerificationSystem PVZ = new PuzzleVerificationSystem();
	

	
	public void loadPuzzleFile(String fileLocation) {
		/*
		 * Method:				loadPuzzleFile()
		 * 
		 * Method Parameters:	None
		 * 
		 * Method Return:		Void
		 * 
		 * Synopsis:			This method is responsible for the loading of
		 * 						.txt files containing the values for the
		 * 						use of verifying puzzles.
		 * 
		 * Modifications:		Date:		Name:			Modification:
		 * 						09/17/2021	Jared Shaddick	Method Created
		 * 						09/17/2021	Jared Shaddick	Block Comments Created
		 * 						09/18/2021	Jared Shaddick	Added the ability to add
		 * 													the contents of a file to
		 * 													a single 2D array
		 */
		int rowCounter = 0;
		int columnCounter = 0;
		
		try {
			File txtFile = new File(fileLocation);
			fileScanner = new Scanner(txtFile);
			
			int detectedRows = 0;
			int detectedColumns = 0;
			
			boolean enoughColumns = true;
			boolean enoughRows = true;
			
			while (detectedRows < 8 && enoughRows) {
				while (detectedColumns < 8 && enoughColumns) {
					if (fileScanner.hasNext()) {
						fileScanner.next();
						detectedColumns++;
					}
					else if (detectedColumns < 8) {
						enoughColumns = false;
					}
				}
				if (fileScanner.hasNextLine()) {
					fileScanner.nextLine();
					detectedColumns = 0;
					detectedRows++;
				}
				else if (detectedRows < 8) {
					enoughRows = false;
				}
			}
			fileScanner.close();
			if (enoughColumns && enoughRows) {
				fileScanner = new Scanner(txtFile);
				puzzleToLoad = new int[9][9];
				puzzleToLoad[rowCounter][columnCounter] = fileScanner.nextInt();
				columnCounter++;
				while (fileScanner.hasNextLine() && rowCounter < 9) {
					while (fileScanner.hasNextInt() && columnCounter < 9) {
						puzzleToLoad[rowCounter][columnCounter] = fileScanner.nextInt();
						columnCounter++;
					}
					rowCounter++;
					columnCounter = 0;
				}
			} 
		}catch (FileNotFoundException e) {
				e.printStackTrace();
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
		fileScanner.close();
	}
	
	public int[][] setPuzzle() {
		/*
		 * Method:				setPuzzle()
		 * 
		 * Method Parameters:	None
		 * 
		 * Method Return:		int[][]
		 * 
		 * Synopsis:			This method serves to make the data from the
		 * 						loaded file available to UserInterfaace
		 * 
		 * Modifications:		Date:		Names:			Modification:
		 * 						09/17/2021	Jared Shaddick	Method Created
		 * 						09/17/2021	Jared Shaddick	Method Finished
		 * 						09/18/2021	Jared Shaddick	Block Comments Created
		 */
		return puzzleToLoad;
	}
	
	public void puzzleToBeVerified() {
		PVZ.verifyPuzzle(puzzleToLoad);
	}
	
	public void savePuzzleToFile(String saveFileLocation, int[][] puzzleToSave) {
		/*
		 * Method:				savePuzzleToFile()
		 * 
		 * Method Parameters:	String saveFileLocation, int[][] puzzleToSave
		 * 
		 * Method Return:		Void
		 * 
		 * Synopsis:			This method is responsible for the saving of content
		 * 						to .txt files.
		 * 
		 * Modifications:		Date:		Name:			Modification:
		 * 						09/17/2021	Jared Shaddick	Method Created
		 * 						09/17/2021	Jared Shaddick	Block Comments Created
		 */
		
	}
	
}
