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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DeleteEmployee extends JFrame {

    private JPanel contentPane;
    private JTextField txtFname;
    private JTextField txtLname;
    private JTextField txtAddress;
    private JTextField txtCity;
    private JTextField txtEmpID;
    private JTextField txtPhone;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    DeleteEmployee frame = new DeleteEmployee();
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
    public DeleteEmployee() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1049, 678);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	txtFname = new JTextField();
	txtFname.setColumns(10);
	txtFname.setBounds(174, 91, 269, 55);
	contentPane.add(txtFname);

	txtLname = new JTextField();
	txtLname.setColumns(10);
	txtLname.setBounds(587, 91, 295, 55);
	contentPane.add(txtLname);

	JLabel lblFname = new JLabel("First Name");
	lblFname.setHorizontalAlignment(SwingConstants.CENTER);
	lblFname.setBounds(42, 98, 133, 41);
	contentPane.add(lblFname);

	JLabel lblLastName = new JLabel("Last Name");
	lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
	lblLastName.setBounds(448, 98, 133, 41);
	contentPane.add(lblLastName);

	JLabel lblstreet = new JLabel("Street Address");
	lblstreet.setHorizontalAlignment(SwingConstants.CENTER);
	lblstreet.setBounds(21, 171, 154, 41);
	contentPane.add(lblstreet);

	txtAddress = new JTextField();
	txtAddress.setColumns(10);
	txtAddress.setBounds(174, 164, 708, 55);
	contentPane.add(txtAddress);

	JLabel lblcity = new JLabel("City");
	lblcity.setHorizontalAlignment(SwingConstants.CENTER);
	lblcity.setBounds(21, 247, 154, 41);
	contentPane.add(lblcity);

	txtCity = new JTextField();
	txtCity.setColumns(10);
	txtCity.setBounds(174, 240, 269, 55);
	contentPane.add(txtCity);

	JComboBox comboBoxstate = new JComboBox();
	comboBoxstate.setModel(new DefaultComboBoxModel(new String[] { "Select", "Alabama", "Alaska", "Arizona",
		"Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii",
		"Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
		"Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
		"New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
		"Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee",
		"Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" }));
	comboBoxstate.setBounds(587, 240, 295, 48);
	contentPane.add(comboBoxstate);

	JLabel lblstate = new JLabel("State");
	lblstate.setHorizontalAlignment(SwingConstants.CENTER);
	lblstate.setBounds(444, 243, 149, 48);
	contentPane.add(lblstate);

	txtEmpID = new JTextField();
	txtEmpID.setColumns(10);
	txtEmpID.setBounds(174, 309, 269, 55);
	contentPane.add(txtEmpID);

	JLabel lblEmployeeId = new JLabel("Employee ID");
	lblEmployeeId.setHorizontalAlignment(SwingConstants.CENTER);
	lblEmployeeId.setBounds(21, 316, 154, 41);
	contentPane.add(lblEmployeeId);

	txtPhone = new JTextField();
	txtPhone.setColumns(10);
	txtPhone.setBounds(587, 309, 295, 55);
	contentPane.add(txtPhone);

	JLabel lblPhone = new JLabel("Phone");
	lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
	lblPhone.setBounds(448, 316, 154, 41);
	contentPane.add(lblPhone);

	JButton btnExit = new JButton("Exit");
	btnExit.setBounds(21, 425, 282, 55);
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
		    Manager manager = new Manager();
		    manager.setVisible(true);
		    // System.exit(0);

		} catch (Exception ex) {

		}

	    }
	});

	JButton btnDelete = new JButton("Delete");
	btnDelete.setBounds(720, 425, 282, 55);
	contentPane.add(btnDelete);

	JButton btnSearch = new JButton("Search");
	btnSearch.setBounds(371, 425, 282, 55);
	contentPane.add(btnSearch);

	JLabel lblNewLabel = new JLabel("Delete Employee");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(286, 21, 477, 48);
	contentPane.add(lblNewLabel);
    }

}
