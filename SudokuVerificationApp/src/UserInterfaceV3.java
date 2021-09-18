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
	private JLabel lblVerificationDisplay2;
	private JLabel lblVerificationDisplay3;
	private JButton btnSave;
	private JLabel lblSaveLoaction;
	private JTextArea textAreaSudoku1;
	
	private FileManager FM = new FileManager();
	private PuzzleVerificationSystem PVZ = new PuzzleVerificationSystem();
	private JTextField textFieldDirectory;
	
	private ImageIcon checkMark = new ImageIcon("Assets/CheckMark.png");
	private ImageIcon XMark = new ImageIcon("Assets/X-Mark.png");
	
	
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
				PVZ.verifyPuzzle();
				if (PVZ.isPuzzleValid() == true) {
					lblVerificationDisplay1.setIcon(checkMark);
				}
				if (PVZ.isPuzzleValid() == false) {
					lblVerificationDisplay1.setIcon(XMark);
				}
			}
		});
		btnSubmitDirectory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmitDirectory.setEnabled(false);
		btnSubmitDirectory.setBounds(331, 474, 100, 75);
		contentPane.add(btnSubmitDirectory);
		
		btnSubmitPuzzle = new JButton("Submit Puzzles");
		btnSubmitPuzzle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSubmitPuzzle.setEnabled(false);
		btnSubmitPuzzle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSubmitPuzzle.setBounds(290, 315, 196, 35);
		contentPane.add(btnSubmitPuzzle);
		
		lblVerificationDisplay1 = new JLabel("");
		lblVerificationDisplay1.setEnabled(false);
		lblVerificationDisplay1.setBounds(255, 211, 50, 50);
		contentPane.add(lblVerificationDisplay1);
		
		lblVerificationDisplay2 = new JLabel("");
		lblVerificationDisplay2.setEnabled(false);
		lblVerificationDisplay2.setBounds(529, 182, 50, 50);
		contentPane.add(lblVerificationDisplay2);
		
		lblVerificationDisplay3 = new JLabel("");
		lblVerificationDisplay3.setEnabled(false);
		lblVerificationDisplay3.setBounds(120, 294, 50, 50);
		contentPane.add(lblVerificationDisplay3);
		
		btnSave = new JButton("Save Puzzles");
		btnSave.setEnabled(false);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSave.setBounds(319, 397, 132, 35);
		contentPane.add(btnSave);
		
		lblSaveLoaction = new JLabel("Saves as SaveSudoku.txt in project Data folder");
		lblSaveLoaction.setEnabled(false);
		lblSaveLoaction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSaveLoaction.setBounds(219, 361, 346, 25);
		contentPane.add(lblSaveLoaction);
		
		textFieldDirectory = new JTextField();
		textFieldDirectory.setEditable(false);
		textFieldDirectory.setEnabled(false);
		textFieldDirectory.setBounds(82, 443, 605, 20);
		contentPane.add(textFieldDirectory);
		textFieldDirectory.setColumns(10);
		
		textAreaSudoku1 = new JTextArea();
		textAreaSudoku1.setEditable(false);
		textAreaSudoku1.setEnabled(false);
		textAreaSudoku1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textAreaSudoku1.setBounds(120, 11, 125, 250);
		contentPane.add(textAreaSudoku1);
	}
}
