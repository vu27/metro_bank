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

public class ModifyAccount extends JFrame {

    private JPanel contentPane;
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
    // private JPanel contentPane;
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
    private JTextField txtFname2;
    private JTextField txtlName2;
    private JLabel lblFname_1;
    private JLabel lblLastName_1;
    private JLabel lblstreet_1;
    private JTextField txtStreetAddress2;
    private JLabel lblcity_1;
    private JComboBox comboBoxstate_1;
    private JLabel lblstate_1;
    private JLabel lblcardNum_1;
    private JTextField txtCardNumber2;
    private JLabel lblAccountNumber_1;
    private JTextField txtAccNum2;
    private JButton btnSearch2;
    private JButton btnExit;
    private JButton btnUpdate;
    private JLabel lblNewLabel;
    private JLabel lblUpdateCustomerInformation;
    private JLabel lblEditCustomer;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    ModifyAccount frame = new ModifyAccount();
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
    public ModifyAccount() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1901, 587);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	txtFname = new JTextField();
	txtFname.setBounds(1096, 50, 269, 55);
	contentPane.add(txtFname);
	txtFname.setColumns(10);

	txtLname = new JTextField();
	txtLname.setBounds(1509, 50, 295, 55);
	txtLname.setColumns(10);
	contentPane.add(txtLname);

	lblFname = new JLabel("First Name");
	lblFname.setBounds(964, 57, 133, 41);
	lblFname.setHorizontalAlignment(SwingConstants.CENTER);
	contentPane.add(lblFname);

	lblLastName = new JLabel("Last Name");
	lblLastName.setBounds(1370, 57, 133, 41);
	lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
	contentPane.add(lblLastName);

	lblstreet = new JLabel("Street Address");
	lblstreet.setBounds(943, 130, 154, 41);
	lblstreet.setHorizontalAlignment(SwingConstants.CENTER);
	contentPane.add(lblstreet);

	txtStreet = new JTextField();
	txtStreet.setBounds(1096, 123, 708, 55);
	txtStreet.setColumns(10);
	contentPane.add(txtStreet);

	lblcity = new JLabel("City");
	lblcity.setBounds(943, 206, 154, 41);
	lblcity.setHorizontalAlignment(SwingConstants.CENTER);
	contentPane.add(lblcity);

	txtcity = new JTextField();
	txtcity.setBounds(1096, 199, 269, 55);
	txtcity.setColumns(10);
	contentPane.add(txtcity);

	comboBoxstate = new JComboBox();
	comboBoxstate.setBounds(1509, 199, 295, 48);
	comboBoxstate.setModel(new DefaultComboBoxModel(new String[] { "Select", "Alabama", "Alaska", "Arizona",
		"Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii",
		"Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
		"Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
		"New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
		"Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee",
		"Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" }));
	comboBoxstate.setMaximumRowCount(51);
	contentPane.add(comboBoxstate);

	lblstate = new JLabel("State");
	lblstate.setBounds(1366, 202, 149, 48);
	lblstate.setHorizontalAlignment(SwingConstants.CENTER);
	contentPane.add(lblstate);

	lblcardNum = new JLabel("Card Number");
	lblcardNum.setBounds(964, 287, 133, 41);
	lblcardNum.setHorizontalAlignment(SwingConstants.CENTER);
	contentPane.add(lblcardNum);

	txtCardNum = new JTextField();
	txtCardNum.setBounds(1096, 280, 708, 55);
	txtCardNum.setColumns(10);
	contentPane.add(txtCardNum);

	lblAccountNumber = new JLabel("Account Number");
	lblAccountNumber.setBounds(930, 363, 166, 41);
	lblAccountNumber.setHorizontalAlignment(SwingConstants.CENTER);
	contentPane.add(lblAccountNumber);

	txtAccNum = new JTextField();
	txtAccNum.setBounds(1096, 356, 708, 55);
	txtAccNum.setColumns(10);
	contentPane.add(txtAccNum);

	txtFname2 = new JTextField();
	txtFname2.setColumns(10);
	txtFname2.setBounds(187, 50, 269, 55);
	contentPane.add(txtFname2);

	txtlName2 = new JTextField();
	txtlName2.setColumns(10);
	txtlName2.setBounds(600, 50, 295, 55);
	contentPane.add(txtlName2);

	lblFname_1 = new JLabel("First Name");
	lblFname_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblFname_1.setBounds(55, 57, 133, 41);
	contentPane.add(lblFname_1);

	lblLastName_1 = new JLabel("Last Name");
	lblLastName_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblLastName_1.setBounds(461, 57, 133, 41);
	contentPane.add(lblLastName_1);

	lblstreet_1 = new JLabel("Street Address");
	lblstreet_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblstreet_1.setBounds(34, 130, 154, 41);
	contentPane.add(lblstreet_1);

	txtStreetAddress2 = new JTextField();
	txtStreetAddress2.setColumns(10);
	txtStreetAddress2.setBounds(187, 123, 708, 55);
	contentPane.add(txtStreetAddress2);

	lblcity_1 = new JLabel("City");
	lblcity_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblcity_1.setBounds(34, 206, 154, 41);
	contentPane.add(lblcity_1);

	JTextField txtCity2 = new JTextField();
	txtCity2.setColumns(10);
	txtCity2.setBounds(187, 199, 269, 55);
	contentPane.add(txtCity2);

	comboBoxstate_1 = new JComboBox();
	comboBoxstate_1.setMaximumRowCount(51);
	comboBoxstate_1.setBounds(600, 199, 295, 48);
	contentPane.add(comboBoxstate_1);

	lblstate_1 = new JLabel("State");
	lblstate_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblstate_1.setBounds(457, 202, 149, 48);
	contentPane.add(lblstate_1);

	lblcardNum_1 = new JLabel("Card Number");
	lblcardNum_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblcardNum_1.setBounds(55, 287, 133, 41);
	contentPane.add(lblcardNum_1);

	txtCardNumber2 = new JTextField();
	txtCardNumber2.setColumns(10);
	txtCardNumber2.setBounds(187, 280, 708, 55);
	contentPane.add(txtCardNumber2);

	lblAccountNumber_1 = new JLabel("Account Number");
	lblAccountNumber_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblAccountNumber_1.setBounds(21, 363, 166, 41);
	contentPane.add(lblAccountNumber_1);

	txtAccNum2 = new JTextField();
	txtAccNum2.setColumns(10);
	txtAccNum2.setBounds(187, 356, 708, 55);
	contentPane.add(txtAccNum2);

	btnSearch2 = new JButton("Search");
	btnSearch2.setBounds(187, 445, 210, 49);
	contentPane.add(btnSearch2);
	btnSearch2.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

	    }
	});

	btnExit = new JButton("Exit");
	btnExit.setBounds(685, 445, 210, 49);
	contentPane.add(btnExit);

	btnUpdate = new JButton("Update");
	btnUpdate.setBounds(1420, 445, 210, 49);
	contentPane.add(btnUpdate);

	lblNewLabel = new JLabel("Search Customer");
	lblNewLabel.setBounds(187, 3, 221, 26);
	contentPane.add(lblNewLabel);

	lblUpdateCustomerInformation = new JLabel("Update Customer Information");
	lblUpdateCustomerInformation.setBounds(755, 3, 308, 26);
	contentPane.add(lblUpdateCustomerInformation);

	lblEditCustomer = new JLabel("Edit Customer");
	lblEditCustomer.setBounds(1319, 3, 221, 26);
	contentPane.add(lblEditCustomer);

    }

}
