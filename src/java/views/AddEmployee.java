package views;

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

public class AddEmployee extends JFrame {

    private JPanel contentPane;
    private JTextField txtFname;
    private JTextField txtLname;
    private JTextField txtStreetAddress;
    private JTextField txtCity;
    private JTextField txtEmpId;
    private JTextField txtPhone;
    private JTextField txtSocialSecurity;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    AddEmployee frame = new AddEmployee();
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
    public AddEmployee() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1049, 599);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	txtFname = new JTextField();
	txtFname.setColumns(10);
	txtFname.setBounds(174, 43, 269, 55);
	contentPane.add(txtFname);

	txtLname = new JTextField();
	txtLname.setColumns(10);
	txtLname.setBounds(587, 43, 295, 55);
	contentPane.add(txtLname);

	JLabel lblFname = new JLabel("First Name");
	lblFname.setHorizontalAlignment(SwingConstants.CENTER);
	lblFname.setBounds(42, 50, 133, 41);
	contentPane.add(lblFname);

	JLabel lblLastName = new JLabel("Last Name");
	lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
	lblLastName.setBounds(448, 50, 133, 41);
	contentPane.add(lblLastName);

	JLabel lblstreet = new JLabel("Street Address");
	lblstreet.setHorizontalAlignment(SwingConstants.CENTER);
	lblstreet.setBounds(21, 123, 154, 41);
	contentPane.add(lblstreet);

	txtStreetAddress = new JTextField();
	txtStreetAddress.setColumns(10);
	txtStreetAddress.setBounds(174, 116, 708, 55);
	contentPane.add(txtStreetAddress);

	JLabel lblcity = new JLabel("City");
	lblcity.setHorizontalAlignment(SwingConstants.CENTER);
	lblcity.setBounds(21, 199, 154, 41);
	contentPane.add(lblcity);

	txtCity = new JTextField();
	txtCity.setColumns(10);
	txtCity.setBounds(174, 192, 269, 55);
	contentPane.add(txtCity);

	JComboBox comboBoxstate = new JComboBox();
	comboBoxstate.setModel(new DefaultComboBoxModel(new String[] { "Select", "Alabama", "Alaska", "Arizona",
		"Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii",
		"Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
		"Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
		"New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
		"Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee",
		"Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" }));
	comboBoxstate.setMaximumRowCount(51);
	comboBoxstate.setBounds(587, 192, 295, 48);
	contentPane.add(comboBoxstate);

	JLabel lblstate = new JLabel("State");
	lblstate.setHorizontalAlignment(SwingConstants.CENTER);
	lblstate.setBounds(444, 195, 149, 48);
	contentPane.add(lblstate);

	txtEmpId = new JTextField();
	txtEmpId.setColumns(10);
	txtEmpId.setBounds(174, 261, 269, 55);
	contentPane.add(txtEmpId);

	JLabel lblEmployeeId = new JLabel("Employee ID");
	lblEmployeeId.setHorizontalAlignment(SwingConstants.CENTER);
	lblEmployeeId.setBounds(21, 268, 154, 41);
	contentPane.add(lblEmployeeId);

	txtPhone = new JTextField();
	txtPhone.setColumns(10);
	txtPhone.setBounds(587, 261, 295, 55);
	contentPane.add(txtPhone);

	JLabel lblPhone = new JLabel("Phone");
	lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
	lblPhone.setBounds(448, 268, 154, 41);
	contentPane.add(lblPhone);

	JButton btnExit = new JButton("Exit");
	btnExit.setBounds(161, 438, 282, 55);
	contentPane.add(btnExit);

	JButton btnUpdate = new JButton("Update");
	btnUpdate.setBounds(589, 438, 282, 55);
	contentPane.add(btnUpdate);

	txtSocialSecurity = new JTextField();
	txtSocialSecurity.setColumns(10);
	txtSocialSecurity.setBounds(174, 337, 269, 55);
	contentPane.add(txtSocialSecurity);

	JLabel lblSocialSecurity = new JLabel("Social Security");
	lblSocialSecurity.setHorizontalAlignment(SwingConstants.CENTER);
	lblSocialSecurity.setBounds(21, 351, 154, 41);
	contentPane.add(lblSocialSecurity);
    }

}
