package gui;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ModifyEmployee extends JFrame {

    private JPanel contentPane;
    private JTextField txtFname;
    private JTextField txtLname;
    private JTextField txtStreetAddress;
    private JTextField txtCity;
    private JTextField txtEmpID;
    private JTextField txtFname2;
    private JTextField txtLName2;
    private JTextField txtStreetAddress2;
    private JTextField txtCity2;
    private JTextField txtEmpID2;
    private JTextField txtPhone;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    ModifyEmployee frame = new ModifyEmployee();
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
    public ModifyEmployee() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1903, 567);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	txtFname = new JTextField();
	txtFname.setColumns(10);
	txtFname.setBounds(174, 87, 269, 55);
	contentPane.add(txtFname);

	txtLname = new JTextField();
	txtLname.setColumns(10);
	txtLname.setBounds(587, 87, 295, 55);
	contentPane.add(txtLname);

	JLabel lblFname = new JLabel("First Name");
	lblFname.setHorizontalAlignment(SwingConstants.CENTER);
	lblFname.setBounds(42, 94, 133, 41);
	contentPane.add(lblFname);

	JLabel lblLastName = new JLabel("Last Name");
	lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
	lblLastName.setBounds(448, 94, 133, 41);
	contentPane.add(lblLastName);

	JLabel lblstreet = new JLabel("Street Address");
	lblstreet.setHorizontalAlignment(SwingConstants.CENTER);
	lblstreet.setBounds(21, 167, 154, 41);
	contentPane.add(lblstreet);

	txtStreetAddress = new JTextField();
	txtStreetAddress.setColumns(10);
	txtStreetAddress.setBounds(174, 160, 708, 55);
	contentPane.add(txtStreetAddress);

	JLabel lblcity = new JLabel("City");
	lblcity.setHorizontalAlignment(SwingConstants.CENTER);
	lblcity.setBounds(21, 243, 154, 41);
	contentPane.add(lblcity);

	txtCity = new JTextField();
	txtCity.setColumns(10);
	txtCity.setBounds(174, 236, 269, 55);
	contentPane.add(txtCity);

	JComboBox comboBoxstate = new JComboBox();
	comboBoxstate.setMaximumRowCount(51);
	comboBoxstate.setBounds(587, 236, 295, 48);
	contentPane.add(comboBoxstate);

	JLabel lblstate = new JLabel("State");
	lblstate.setHorizontalAlignment(SwingConstants.CENTER);
	lblstate.setBounds(444, 239, 149, 48);
	contentPane.add(lblstate);

	txtEmpID = new JTextField();
	txtEmpID.setColumns(10);
	txtEmpID.setBounds(174, 305, 269, 55);
	contentPane.add(txtEmpID);

	JLabel lblEmployeeId = new JLabel("Employee ID");
	lblEmployeeId.setHorizontalAlignment(SwingConstants.CENTER);
	lblEmployeeId.setBounds(21, 312, 154, 41);
	contentPane.add(lblEmployeeId);

	JButton btnNewButton = new JButton("Search");
	btnNewButton.setBounds(174, 399, 199, 55);
	contentPane.add(btnNewButton);

	txtFname2 = new JTextField();
	txtFname2.setColumns(10);
	txtFname2.setBounds(1128, 87, 269, 55);
	contentPane.add(txtFname2);

	txtLName2 = new JTextField();
	txtLName2.setColumns(10);
	txtLName2.setBounds(1541, 87, 295, 55);
	contentPane.add(txtLName2);

	JLabel lblFname_1 = new JLabel("First Name");
	lblFname_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblFname_1.setBounds(996, 94, 133, 41);
	contentPane.add(lblFname_1);

	JLabel lblLastName_1 = new JLabel("Last Name");
	lblLastName_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblLastName_1.setBounds(1402, 94, 133, 41);
	contentPane.add(lblLastName_1);

	JLabel lblstreet_1 = new JLabel("Street Address");
	lblstreet_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblstreet_1.setBounds(975, 167, 154, 41);
	contentPane.add(lblstreet_1);

	txtStreetAddress2 = new JTextField();
	txtStreetAddress2.setColumns(10);
	txtStreetAddress2.setBounds(1128, 160, 708, 55);
	contentPane.add(txtStreetAddress2);

	JLabel lblcity_1 = new JLabel("City");
	lblcity_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblcity_1.setBounds(975, 243, 154, 41);
	contentPane.add(lblcity_1);

	txtCity2 = new JTextField();
	txtCity2.setColumns(10);
	txtCity2.setBounds(1128, 236, 269, 55);
	contentPane.add(txtCity2);

	JComboBox comboBoxstate2 = new JComboBox();
	comboBoxstate2.setModel(new DefaultComboBoxModel(new String[] { "Select", "Alabama", "Alaska", "Arizona",
		"Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii",
		"Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
		"Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
		"New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
		"Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee",
		"Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" }));
	comboBoxstate2.setMaximumRowCount(51);
	comboBoxstate2.setBounds(1541, 236, 295, 48);
	contentPane.add(comboBoxstate2);

	JLabel lblstate_1 = new JLabel("State");
	lblstate_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblstate_1.setBounds(1398, 239, 149, 48);
	contentPane.add(lblstate_1);

	txtEmpID2 = new JTextField();
	txtEmpID2.setColumns(10);
	txtEmpID2.setBounds(1128, 305, 269, 55);
	contentPane.add(txtEmpID2);

	JLabel lblEmployeeId_1 = new JLabel("Employee ID");
	lblEmployeeId_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblEmployeeId_1.setBounds(975, 312, 154, 41);
	contentPane.add(lblEmployeeId_1);

	JButton btnUpdate = new JButton("Update");
	btnUpdate.setBounds(1128, 399, 199, 55);
	contentPane.add(btnUpdate);

	txtPhone = new JTextField();
	txtPhone.setColumns(10);
	txtPhone.setBounds(587, 305, 295, 55);
	contentPane.add(txtPhone);

	JLabel lblPhone = new JLabel("Phone");
	lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
	lblPhone.setBounds(448, 312, 154, 41);
	contentPane.add(lblPhone);

	textField = new JTextField();
	textField.setColumns(10);
	textField.setBounds(1541, 305, 295, 55);
	contentPane.add(textField);

	JLabel lblPhone_1 = new JLabel("Phone");
	lblPhone_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblPhone_1.setBounds(1393, 312, 154, 41);
	contentPane.add(lblPhone_1);

	JButton btnExit = new JButton("Exit");
	btnExit.setBounds(683, 399, 199, 55);
	contentPane.add(btnExit);

	JLabel lblSearchEmployee = new JLabel("Search Employee");
	lblSearchEmployee.setBounds(174, 21, 178, 45);
	contentPane.add(lblSearchEmployee);

	JLabel lblUpdateEmployee = new JLabel("Update Employee");
	lblUpdateEmployee.setBounds(863, 21, 178, 45);
	contentPane.add(lblUpdateEmployee);

	JLabel lblEditEmployee = new JLabel("Edit Employee");
	lblEditEmployee.setBounds(1357, 21, 178, 45);
	contentPane.add(lblEditEmployee);
    }

}
