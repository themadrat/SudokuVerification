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
	private JLabel lblVerificationDisplay1;
	private JButton btnSave;
	private JTextArea textAreaSudoku1;
	
	private FileManager FM = new FileManager();
	private PuzzleVerificationSystem PVS = new PuzzleVerificationSystem();
	private JTextField textFieldDirectory;
	
	private ImageIcon checkMark = new ImageIcon("Assets/CheckMark.png");
	private ImageIcon XMark = new ImageIcon("Assets/X-Mark.png");
	
	private Scanner textScanner;

	private JTextField textFieldSaveDirectory;
	
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
				textAreaSudoku1.setEnabled(true);
				textAreaSudoku1.setEditable(true);
				
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
				lblVerificationDisplay1.setEnabled(true);
				int[][] puzzle1;
				int rowCounter = 0;
				int columnCounter = 0;
					
					try {
						FM.loadPuzzleFile(textFieldDirectory.getText());
						textAreaSudoku1.setEnabled(true);
						puzzle1 = FM.setPuzzle();
						while (rowCounter < 9) {
							while (columnCounter < 9) {
								textAreaSudoku1.append(String.valueOf(puzzle1[rowCounter][columnCounter]));
								columnCounter++;
							}
							textAreaSudoku1.append("\n");
							rowCounter++;
							columnCounter = 0;
						}
					}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Error: File Cound Not Be Found" + "\n" + "Please Enter a Valid Directory With A Valid File");
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
		
		lblVerificationDisplay1 = new JLabel("");
		lblVerificationDisplay1.setEnabled(false);
		lblVerificationDisplay1.setBounds(339, 72, 200, 200);
		contentPane.add(lblVerificationDisplay1);
		
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
		
		textAreaSudoku1 = new JTextArea();
		textAreaSudoku1.setToolTipText("");
		textAreaSudoku1.setWrapStyleWord(true);
		textAreaSudoku1.setLineWrap(true);
		textAreaSudoku1.setEditable(false);
		textAreaSudoku1.setEnabled(false);
		textAreaSudoku1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textAreaSudoku1.setBounds(120, 11, 209, 261);
		contentPane.add(textAreaSudoku1);
		
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
		btnNewButton.setBounds(352, 11, 132, 50);
		contentPane.add(btnNewButton);
	}
	private boolean sufficientPuzzle() {
		textScanner = new Scanner(textAreaSudoku1.getText());
		int detectedRows = 0;
		int detectedColumns = 0;
		
		boolean enoughColumns = true;
		boolean enoughRows = true;
		
		while (detectedRows < 8 && enoughRows) {
			while (detectedColumns < 8 && enoughColumns) {
				if (textScanner.hasNext()) {
					textScanner.next();
					detectedColumns++;
				}
				else if (detectedColumns < 8) {
					enoughColumns = false;
				}
			}
			if (textScanner.hasNextLine()) {
				textScanner.nextLine();
				detectedColumns = 0;
				detectedRows++;
			}
			else if (detectedColumns < 8) {
				enoughRows = false;
			}
		}
		textScanner.close();
		if (!enoughRows || !enoughColumns) {
			PVS.setResult(false);
			if (PVS.isPuzzleValid() == false) {
				lblVerificationDisplay1.setIcon(XMark);
			}
			return false;
		}
		else {
			assignPuzzleFromText();
			return true;
		}
	}
	
	private void assignPuzzleFromText() {
		int rowCounter = 0;
		int columnCounter = 0;
		if(sufficientPuzzle()) {
			textScanner = new Scanner(textAreaSudoku1.getText());
			puzzleFromText = new int[9][9];
			puzzleFromText[rowCounter][columnCounter] = textScanner.nextInt();
			columnCounter++;
			while (textScanner.hasNextLine() && rowCounter < 9) {
				while (textScanner.hasNextInt() && columnCounter < 9) {
					puzzleFromText[rowCounter][columnCounter] = textScanner.nextInt();
					columnCounter++;
				}
				textScanner.nextLine();
				rowCounter++;
				columnCounter = 0;
			}
			PVS.verifyPuzzle(puzzleFromText);
		}
	}
	
	private void getTheResult() {
		if (PVS.isPuzzleValid() == false) {
			lblVerificationDisplay1.setIcon(XMark);
		}
		if (PVS.isPuzzleValid() == true) {
			lblVerificationDisplay1.setIcon(checkMark);
		}
	}
}
