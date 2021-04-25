package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * This is the GUI for the Emloyee account
 * @author Everyone
 * @since 2021/25/04
 * @version 1.021.12
 */

public class EmployeeGUI extends JFrame {

    private JPanel contentPane;
    private JButton btnExit;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    EmployeeGUI frame = new EmployeeGUI();
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
    public EmployeeGUI() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1006, 409);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	getContentPane().setBackground(new Color(11, 40, 83));
	contentPane.setLayout(null);

	JLabel lblSchool = new JLabel("");
	Image school = new ImageIcon(this.getClass().getResource("/static/Untitled.jpg")).getImage();
	lblSchool.setIcon(new ImageIcon(school));
	lblSchool.setBounds(485, 94, 464, 150);
	getContentPane().add(lblSchool);

	JComboBox comboBoxAccount = new JComboBox();
	comboBoxAccount.setModel(new DefaultComboBoxModel(
		new String[] { "Select", "Add Student", "Close Account", "Modify Student Account", "Apply Student Credit",
				"View All Accounts", "View Credit Status", "Deposit", "Withdraw" }));
	comboBoxAccount.setBounds(53, 121, 282, 55);
	contentPane.add(comboBoxAccount);

	JLabel lblMetroState = new JLabel("Metro State Bank Employee");
	lblMetroState.setForeground(Color.WHITE);
	lblMetroState.setHorizontalAlignment(SwingConstants.CENTER);
	lblMetroState.setFont(new Font("Dialog", Font.PLAIN, 40));
	lblMetroState.setBounds(85, 0, 686, 49);
	getContentPane().add(lblMetroState);

	btnExit = new JButton("Exit");
	btnExit.setBounds(667, 285, 282, 55);
	contentPane.add(btnExit);

	JButton btnSelect = new JButton("Select");
	btnSelect.setBounds(53, 285, 282, 55);
	contentPane.add(btnSelect);

	//select button if clicked
	btnSelect.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		try {
			//get string from jcombobox
		    String x = String.valueOf(comboBoxAccount.getSelectedItem());

		    if (x.equals("Open Account")) {
			OpenAccount openAccount = new OpenAccount();
			openAccount.setVisible(true);
			dispose();
		    }
		    if (x.equals("Modify Student Account")) {
			ModifyStudent modifyAccount = new ModifyStudent();
			modifyAccount.setVisible(true);
			dispose();
		    }
		    if (x.equals("Close Account")) {
			DeleteStudent deleteStudent = new DeleteStudent();
			deleteStudent.setVisible(true);
			dispose();
		    }
		    if (x.equals("Apply Student Credit")){
		    	applyCredit credit = new applyCredit();
		    	credit.setVisible(true);
			}
			if (x.equals("View Credit Status")){
				creditAppSearch creditSearch = new creditAppSearch();
				creditSearch.setVisible(true);
			}
			if (x.equals("Deposit")){
				DepositGUI depositGUI = new DepositGUI();
				depositGUI.setVisible(true);
			}
			if (x.equals("Withdraw")){
				WithdrawalGUI withdrawalGUI = new WithdrawalGUI();
				withdrawalGUI.setVisible(true);
			}
			if (x.equals("Add Student")){
				AddStudentGUI addStudentGUI = new AddStudentGUI();
				addStudentGUI.setVisible(true);
			}

		} catch (Exception ex) {

		}

	    }
	});



	//exit button if clicked
	btnExit.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		try {

		    dispose();

		} catch (Exception ex) {

		}

	    }
	});

    }

}
