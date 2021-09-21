import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UserInterfaceV3 extends JFrame {

	private JPanel contentPane;
	
	
	private JButton btnCreateUserPuzzle;
	private JButton btnUseAFile;
	private JButton btnSubmitDirectory;
	private JButton btnSubmitPuzzle;
	private JLabel lblVerificationDisplay;
	private JButton btnSave;
	private JTextArea textAreaSudoku;
	
	private FileManager FM = new FileManager();
	private PuzzleVerificationSystem PVS = new PuzzleVerificationSystem();
	private JTextField textFieldDirectory;
	
	private ImageIcon checkMark = new ImageIcon("Assets/CheckMark.png");
	private ImageIcon XMark = new ImageIcon("Assets/X-Mark.png");
	
	private Scanner textScanner;

	private JTextField textFieldSaveDirectory;
	
	private boolean puzzleIsSufficient;
	
	private static int[][] puzzleFromText;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterfaceV3 frame = new UserInterfaceV3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserInterfaceV3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCreateUserPuzzle = new JButton("Enter Puzzle");
		btnCreateUserPuzzle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateUserPuzzle.setEnabled(false);
				btnUseAFile.setEnabled(false);
				btnSubmitPuzzle.setEnabled(true);
				textAreaSudoku.setEnabled(true);
				textAreaSudoku.setEditable(true);
				
			}
		});
		btnCreateUserPuzzle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCreateUserPuzzle.setBounds(10, 11, 100, 50);
		contentPane.add(btnCreateUserPuzzle);
		
		btnUseAFile = new JButton("Use A File");
		btnUseAFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateUserPuzzle.setEnabled(false);
				btnUseAFile.setEnabled(false);
				textFieldDirectory.setEnabled(true);
				btnSubmitDirectory.setEnabled(true);
				textFieldDirectory.setEditable(true);
			}
		});
		btnUseAFile.setBounds(10, 72, 100, 50);
		contentPane.add(btnUseAFile);
		
		btnSubmitDirectory = new JButton("Open File");
		btnSubmitDirectory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblVerificationDisplay.setEnabled(true);
				int[][] puzzle1;
				int rowCounter = 0;
				int columnCounter = 0;
				FM.loadPuzzleFile(textFieldDirectory.getText());
				textAreaSudoku.setEnabled(true);
				puzzle1 = FM.setPuzzle();
				while (rowCounter < 9) {
					while (columnCounter < 9) {
						textAreaSudoku.append(String.valueOf(puzzle1[rowCounter][columnCounter]) + " ");
						columnCounter++;
					}
					rowCounter++;
					columnCounter = 0;
				}
				PVS.isPuzzleValid();
			}
		});
		btnSubmitDirectory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmitDirectory.setEnabled(false);
		btnSubmitDirectory.setBounds(329, 499, 112, 50);
		contentPane.add(btnSubmitDirectory);
		
		btnSubmitPuzzle = new JButton("Submit Puzzles");
		btnSubmitPuzzle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sufficientPuzzle();
			}
		});
		btnSubmitPuzzle.setEnabled(false);
		btnSubmitPuzzle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSubmitPuzzle.setBounds(290, 315, 196, 35);
		contentPane.add(btnSubmitPuzzle);
		
		lblVerificationDisplay = new JLabel("");
		lblVerificationDisplay.setEnabled(false);
		lblVerificationDisplay.setBounds(341, 61, 200, 200);
		contentPane.add(lblVerificationDisplay);
		
		btnSave = new JButton("Save Puzzles");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					FM.savePuzzleToFile(puzzleFromText);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSave.setEnabled(false);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSave.setBounds(317, 384, 132, 35);
		contentPane.add(btnSave);
		
		textFieldDirectory = new JTextField();
		textFieldDirectory.setEditable(false);
		textFieldDirectory.setEnabled(false);
		textFieldDirectory.setBounds(82, 468, 605, 20);
		contentPane.add(textFieldDirectory);
		textFieldDirectory.setColumns(10);
		
		textAreaSudoku = new JTextArea();
		textAreaSudoku.setToolTipText("");
		textAreaSudoku.setWrapStyleWord(true);
		textAreaSudoku.setLineWrap(true);
		textAreaSudoku.setEditable(false);
		textAreaSudoku.setEnabled(false);
		textAreaSudoku.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textAreaSudoku.setBounds(120, 11, 211, 250);
		contentPane.add(textAreaSudoku);
		
		JLabel lblNewLabel = new JLabel("Do Not Use Any C Directories Outside Of The Project Folder. All Other Diretories Like D:\\, E:\\, etc will work.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(59, 430, 655, 25);
		contentPane.add(lblNewLabel);
		
		textFieldSaveDirectory = new JTextField();
		textFieldSaveDirectory.setEnabled(false);
		textFieldSaveDirectory.setEditable(false);
		textFieldSaveDirectory.setColumns(10);
		textFieldSaveDirectory.setBounds(82, 361, 605, 20);
		contentPane.add(textFieldSaveDirectory);
		
		JButton btnNewButton = new JButton("Get Result");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getTheResult();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(341, 9, 132, 50);
		contentPane.add(btnNewButton);
	}
	private boolean sufficientPuzzle() throws NumberFormatException {
		/*
		 * Method:				sufficientPuzzle()
		 * 
		 * Method Parameters:	None
		 * 
		 * Method Return:		boolean
		 * 
		 * Synopsis:			This method serves to determine if the text entered
		 * 						in textAreaSudoku1 is large enough to be passed to
		 * 						the PuzzleVerificationSystem
		 * 
		 * Modifications:		Date:		Name:			Modification:
		 * 						09/19/2021	Jared Shaddick	Method Created
		 * 						09/19/2021	Jared Shaddick	Method Finished
		 * 						09/20/2021	Jared Shaddick	Began Debugging
		 * 						09/21/2021	Jared Shaddick	Debugging Completed
		 */
		
		
		textScanner = new Scanner(textAreaSudoku.getText());
		int detectedRows = 0;
		int detectedColumns = 0;
	
		
		boolean enoughColumns = true;
		boolean enoughRows = true;
		
		while (detectedRows < 9 && enoughRows) {
			while (detectedColumns < 9 && enoughColumns) {
				if (textScanner.hasNext()) {
					textScanner.next();
					detectedColumns++;
				}
			}
			if (textScanner.hasNextLine()) {
				textScanner.nextLine();
				detectedRows++;
				detectedColumns = 0;
			}
			detectedRows++;
		}
		if (!enoughColumns || !enoughColumns) {
			PVS.setResult(false);
			if (PVS.isPuzzleValid() == false) {
				lblVerificationDisplay.setIcon(XMark);
			}
			return false;
		}
		else {
			puzzleIsSufficient = true;
			assignPuzzleFromText();
			return true;
		}
		
	}
	
	private void assignPuzzleFromText() {
		/*
		 * Method:				assignPuzzleFromText()
		 * 
		 * Method Parameters:	None
		 * 
		 * Method Return:		void
		 * 
		 * Synopsis:			This method assigns the content from textAreaSudoku1
		 * 						to a 2D array to be used in the PuzzleVerificationSystem
		 * 
		 * Modifications:		Date:		Name:			Modifications:
		 * 						09/19/2021	Jared Shaddick	Method Created
		 * 						09/19/2021	Jared Shaddick	Method Setup Finished
		 * 						09/20/2021	Jared Shaddick	Debugging Started
		 * 						09/21/2021	Jared Shaddick	Debugging Complete
		 */
		int rowCounter = 0;
		int columnCounter = 0;
		if(puzzleIsSufficient) {
			textScanner = new Scanner(textAreaSudoku.getText());
			puzzleFromText = new int[9][9];
			puzzleFromText[rowCounter][columnCounter] = textScanner.nextInt();
			columnCounter++;
			while (textScanner.hasNextLine() && rowCounter < 9) {
				while (textScanner.hasNextInt() && columnCounter < 9) {
					puzzleFromText[rowCounter][columnCounter] = textScanner.nextInt();
					columnCounter++;
				}
				if(textScanner.hasNextLine())
				textScanner.nextLine();
				rowCounter++;
				columnCounter = 0;
			}
			PVS.verifyRowsAndColumns(puzzleFromText);
		}
	}
	
	private void getTheResult() {
		/*
		 * Method:				getTheResult()
		 * 
		 * Method Parameters:	None
		 * 
		 * Method Return:		void
		 * 
		 * Synopsis:			This method is designed to take the values
		 * 						from the isPuzzleValid method and use that
		 * 						information to display the results to the
		 * 						user using lblVerificationDisplay1
		 */
		if (PVS.isPuzzleValid() == false) {
			lblVerificationDisplay.setIcon(XMark);
		}
		if (PVS.isPuzzleValid() == true) {
			lblVerificationDisplay.setIcon(checkMark);
		}
	}
}
