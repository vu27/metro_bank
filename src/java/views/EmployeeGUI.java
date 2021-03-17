package views;

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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class EmployeeGUI extends JFrame {

    private JFrame frame;
    private JTextField txtFName;
    private JTextField txtStreetAddress;
    private JLabel Fname;
    private JLabel address;
    private JLabel Lname;
    private JTextField txtLName;
    private JTextField txtCity;
    private JLabel city;
    private JLabel State;
    private JComboBox comboState;
    private JTextField textField;
    private JLabel cardNumber;
    private JTextField textField_1;
    private JLabel accountNumber;
    private JButton btnSearch;
    private JPanel contentPane;
    private JTextField txtFname;
    private JTextField txtLname;
    private JLabel lblFname;
    private JLabel lblLastName;
    private JLabel lblstreet;
    private JTextField txtStreet;
    private JLabel lblcity;
    private JTextField txtcity;
    private JComboBox comboBoxstate;
    private JLabel lblstate;
    private JLabel lblcardNum;
    private JTextField txtCardNum;
    private JLabel lblAccountNumber;
    private JTextField txtAccNum;
    private JButton btnsearch;
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
	setBounds(100, 100, 1348, 649);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JComboBox comboBoxAccount = new JComboBox();
	comboBoxAccount.setModel(new DefaultComboBoxModel(
		new String[] { "Select", "Open Account", "Close Account", "Modify Student Account", "Apply Student Credit", "View All Accounts", "Pending Credit" }));
	comboBoxAccount.setBounds(53, 52, 282, 55);
	contentPane.add(comboBoxAccount);

	JButton btnSelect = new JButton("Select");
	btnSelect.setBounds(53, 265, 282, 55);
	contentPane.add(btnSelect);
	btnSelect.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		try {

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
		    	dispose();
			}
			if (x.equals("Pending Credit")){
				creditAppReview creditApp = new creditAppReview();
				creditApp.setVisible(true);
				dispose();
			}


		} catch (Exception ex) {

		}

	    }
	});

	txtFname = new JTextField();
	txtFname.setBounds(548, 52, 269, 55);
	contentPane.add(txtFname);
	txtFname.setColumns(10);

	txtLname = new JTextField();
	txtLname.setColumns(10);
	txtLname.setBounds(961, 52, 295, 55);
	contentPane.add(txtLname);

	lblFname = new JLabel("First Name");
	lblFname.setHorizontalAlignment(SwingConstants.CENTER);
	lblFname.setBounds(416, 59, 133, 41);
	contentPane.add(lblFname);

	lblLastName = new JLabel("Last Name");
	lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
	lblLastName.setBounds(822, 59, 133, 41);
	contentPane.add(lblLastName);

	lblstreet = new JLabel("Street Address");
	lblstreet.setHorizontalAlignment(SwingConstants.CENTER);
	lblstreet.setBounds(395, 132, 154, 41);
	contentPane.add(lblstreet);

	txtStreet = new JTextField();
	txtStreet.setColumns(10);
	txtStreet.setBounds(548, 125, 708, 55);
	contentPane.add(txtStreet);

	lblcity = new JLabel("City");
	lblcity.setHorizontalAlignment(SwingConstants.CENTER);
	lblcity.setBounds(395, 208, 154, 41);
	contentPane.add(lblcity);

	txtcity = new JTextField();
	txtcity.setColumns(10);
	txtcity.setBounds(548, 201, 269, 55);
	contentPane.add(txtcity);

	comboBoxstate = new JComboBox();
	comboBoxstate.setModel(new DefaultComboBoxModel(new String[] { "Select", "Alabama", "Alaska", "Arizona",
		"Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii",
		"Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
		"Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
		"New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
		"Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee",
		"Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" }));
	comboBoxstate.setMaximumRowCount(51);
	comboBoxstate.setBounds(961, 201, 295, 48);
	contentPane.add(comboBoxstate);

	lblstate = new JLabel("State");
	lblstate.setHorizontalAlignment(SwingConstants.CENTER);
	lblstate.setBounds(818, 204, 149, 48);
	contentPane.add(lblstate);

	lblcardNum = new JLabel("CardNumber");
	lblcardNum.setHorizontalAlignment(SwingConstants.CENTER);
	lblcardNum.setBounds(416, 289, 133, 41);
	contentPane.add(lblcardNum);

	txtCardNum = new JTextField();
	txtCardNum.setColumns(10);
	txtCardNum.setBounds(548, 282, 708, 55);
	contentPane.add(txtCardNum);

	lblAccountNumber = new JLabel("Account Number");
	lblAccountNumber.setHorizontalAlignment(SwingConstants.CENTER);
	lblAccountNumber.setBounds(382, 365, 166, 41);
	contentPane.add(lblAccountNumber);

	txtAccNum = new JTextField();
	txtAccNum.setColumns(10);
	txtAccNum.setBounds(548, 358, 708, 55);
	contentPane.add(txtAccNum);

	btnsearch = new JButton("Search");
	btnsearch.setBounds(980, 434, 282, 67);
	contentPane.add(btnsearch);

	btnExit = new JButton("Exit");
	btnExit.setBounds(53, 434, 282, 67);
	contentPane.add(btnExit);
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
