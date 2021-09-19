import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
	
	private static int[][] puzzleToLoad;
	
	private Scanner fileScanner;
	
	private PuzzleVerificationSystem PVS = new PuzzleVerificationSystem();
	

	
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
				while (fileScanner.hasNextLine() && rowCounter < 8) {
					while (fileScanner.hasNextInt() && columnCounter < 8) {
						puzzleToLoad[rowCounter][columnCounter] = fileScanner.nextInt();
						columnCounter++;
					}
					columnCounter = 0;
					rowCounter++;
				}
			} 
		}catch (FileNotFoundException e) {
				e.printStackTrace();
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
		fileScanner.close();
		
		PVS.verifyPuzzle(puzzleToLoad);
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
		PVS.verifyPuzzle(puzzleToLoad);
	}
	
	public void savePuzzleToFile(int[][] puzzleToSave) throws IOException {
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
		File saveFile = new File ("Data/SavedSudoku.txt");
		FileWriter FW = new FileWriter(saveFile);
		int row = 0;
		int column = 0;
		while (row < 8) {
			while (column < 8) {
				FW.write(String.valueOf(puzzleToSave[row][column]));
				column++;
			}
			if (column == 8) {
				FW.write("\n");
			}
			FW.write(String.valueOf(puzzleToSave[row][column]));
			column = 0;
			row++;
		}
		FW.close();
		
	}
	
}
