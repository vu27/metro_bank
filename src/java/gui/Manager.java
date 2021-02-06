package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Manager extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Manager frame = new Manager();
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
    public Manager() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1049, 573);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JComboBox comboBoxManager = new JComboBox();
	comboBoxManager.setModel(new DefaultComboBoxModel(
		new String[] { "Select", "Add Employee", "Delete Employee", "Edit Employee", "Bank Stats" }));
	comboBoxManager.setBounds(21, 51, 227, 49);
	contentPane.add(comboBoxManager);

	JButton btnSelect = new JButton("Select");
	btnSelect.setBounds(21, 227, 227, 41);
	contentPane.add(btnSelect);
	btnSelect.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		try {

		    String x = String.valueOf(comboBoxManager.getSelectedItem());

		    if (x.equals("Add Employee")) {
			// OpenAccount openAccount = new OpenAccount();
			// openAccount.setVisible(true);
			AddEmployee addEmployee = new AddEmployee();
			addEmployee.setVisible(true);
		    }
		    if (x.equals("Delete Employee")) {

		    }
		    if (x.equals("Edit Employee")) {
			// ModifyAccount modifyAccount = new ModifyAccount();
			// modifyAccount.setVisible(true);
			ModifyEmployee modifyEmployee = new ModifyEmployee();
			modifyEmployee.setVisible(true);
		    }

		} catch (Exception ex) {

		}

	    }
	});

	textField = new JTextField();
	textField.setBounds(626, 51, 291, 49);
	contentPane.add(textField);
	textField.setColumns(10);

	JLabel lblEmpID = new JLabel("Employee ID");
	lblEmpID.setBounds(457, 51, 127, 49);
	contentPane.add(lblEmpID);

	JButton btnSearch = new JButton("Search");
	btnSearch.setBounds(690, 227, 227, 41);
	contentPane.add(btnSearch);

	JButton btnExit = new JButton("Exit");
	btnExit.setBounds(337, 227, 227, 41);
	contentPane.add(btnExit);
	btnExit.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		try {

		    // creditCardCustomer creditCard = new creditCardCustomer();
		    // System.exit(0);
		    // creditCard.setVisible(false);
		    // this.
		    // JFrame.DISPOSE_ON_CLOSE;
		    // frame.setVisible(false);
		    dispose();
		    // WinBuilder mainMenu = new WinBuilder();
		    // mainMenu.setVisible(true);

		    MainMenu mainMenu = new MainMenu();
		    mainMenu.setVisible(true);

		    // ((JComponent) mainMenu).setVisible(true);

		    // customer custom = new customer();
		    // custom.setVisible(true);
		    // System.exit(0);

		} catch (Exception ex) {

		}

	    }
	});
    }
}
