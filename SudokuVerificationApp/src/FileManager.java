import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileManager {
	
	private static int[][] puzzleToLoad;
	
	private Scanner fileScanner;
	

	
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
		//int columnReader = 0;
		//int rowReader = 0;
		
		try {
			File txtFile = new File(fileLocation);
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
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
		 * 						loaded file available to other classes
		 * 
		 * Moodifications:		Date:		Names:			Modification:
		 * 						09/17/2021	Jared Shaddick	Method Created
		 * 						09/17/2021	Jared Shaddick	Method Finished
		 * 						09/18/2021	Jared Shaddick	Block Comments Created
		 */
		return puzzleToLoad;
	}
	
	
	private void savePuzzleToFile() {
		/*
		 * Method:				savePuzzleToFile()
		 * 
		 * Method Parameters:	None
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
