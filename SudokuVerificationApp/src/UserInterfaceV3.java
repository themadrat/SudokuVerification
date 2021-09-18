import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;

public class UserInterfaceV3 extends JFrame {

	private JPanel contentPane;
	
	private JButton btnCreateUserPuzzle;
	private JButton btnUseAFile;
	private JButton btnSubmitDirectory;
	private JButton btnSubmitPuzzle;
	private JLabel lblVerficationDisplay1;
	private JLabel lblVerficationDisplay2;
	private JLabel lblVerficationDisplay3;
	private JButton btnSave;
	private JLabel lblSaveLoaction;
	
	private FileManager FM = new FileManager();
	private PuzzleVerificationSystem PVZ = new PuzzleVerificationSystem();
	private JTextField textFieldDirectory;
	
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
		setBounds(100, 100, 650, 500);
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
			}
		});
		btnUseAFile.setBounds(10, 72, 100, 50);
		contentPane.add(btnUseAFile);
		
		btnSubmitDirectory = new JButton("Open File");
		btnSubmitDirectory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FM.loadPuzzleFile(textFieldDirectory.getText());
			}
		});
		btnSubmitDirectory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSubmitDirectory.setEnabled(false);
		btnSubmitDirectory.setBounds(251, 374, 100, 75);
		contentPane.add(btnSubmitDirectory);
		
		btnSubmitPuzzle = new JButton("Submit Puzzles");
		btnSubmitPuzzle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSubmitPuzzle.setEnabled(false);
		btnSubmitPuzzle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSubmitPuzzle.setBounds(419, 136, 196, 35);
		contentPane.add(btnSubmitPuzzle);
		
		lblVerficationDisplay1 = new JLabel("");
		lblVerficationDisplay1.setEnabled(false);
		lblVerficationDisplay1.setBounds(120, 182, 50, 50);
		contentPane.add(lblVerficationDisplay1);
		
		lblVerficationDisplay2 = new JLabel("");
		lblVerficationDisplay2.setEnabled(false);
		lblVerficationDisplay2.setBounds(219, 182, 50, 50);
		contentPane.add(lblVerficationDisplay2);
		
		lblVerficationDisplay3 = new JLabel("");
		lblVerficationDisplay3.setEnabled(false);
		lblVerficationDisplay3.setBounds(319, 182, 50, 50);
		contentPane.add(lblVerficationDisplay3);
		
		btnSave = new JButton("Save Puzzles");
		btnSave.setEnabled(false);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSave.setBounds(237, 292, 132, 35);
		contentPane.add(btnSave);
		
		lblSaveLoaction = new JLabel("Saves as SaveSudoku.txt in project Data folder");
		lblSaveLoaction.setEnabled(false);
		lblSaveLoaction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSaveLoaction.setBounds(147, 256, 346, 25);
		contentPane.add(lblSaveLoaction);
		
		textFieldDirectory = new JTextField();
		textFieldDirectory.setBounds(10, 338, 605, 20);
		contentPane.add(textFieldDirectory);
		textFieldDirectory.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(120, 11, 208, 158);
		contentPane.add(textPane);
	}
}
