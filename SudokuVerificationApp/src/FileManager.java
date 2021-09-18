import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileManager {
	
	int[][] puzzle1;
	
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
		 */
		puzzle1 = new int[9][9];
		int rowCounter = 0;
		int columnCounter = 0;
		
		
		int columnReader = 0;
		int rowReader = 0;
		
		try {
			File txtFile = new File(fileLocation);
			fileScanner = new Scanner(txtFile);
			
			puzzle1[rowCounter][columnCounter] = fileScanner.nextInt();
			columnCounter++;
			while (fileScanner.hasNextLine() && rowCounter < 9) {
				while (fileScanner.hasNextInt() && columnCounter < 9) {
					puzzle1[rowCounter][columnCounter] = fileScanner.nextInt();
					columnCounter++;
				}
				rowCounter++;
				columnCounter = 0;
			}
			
			while (rowReader < 9) {
				while (columnReader < 9) {
					System.out.print(puzzle1[rowReader][columnReader]);
					columnReader++;
				}
				rowReader++;
				columnReader = 0;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "File Could Not Be Loaded");
		}
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
