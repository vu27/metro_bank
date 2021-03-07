package WinBuilder;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class applyCreditNew extends JFrame {

    private JPanel contentPane;
    private JTextField txtFname;
    private JTextField txtLname;
    private JTextField txtPhone;
    private JTextField txtEmail;
    private JTextField txtAddress;
    private JTextField txtCity;
    private JComboBox comboBoxstate = new JComboBox();
    private JLabel lblState;
    private JTextField txtSSN;
    private JLabel lblSSN;
    private JTextField txtCreditScore;
    private JLabel lblCreditScore;
    private JTextField txtPassword;
    private JTextField txtPassword2;
    private JLabel lblCreatePassword;
    private JLabel lblCreatePassword2;
    private JButton btnFinish;
    private JButton btnExit;
    private JTextField txtIncome;
    private JLabel lblIncome;
    private JLabel lblNewLabel;
    private String email = "@metrostate.edu";
    private String emailBank = "@metrobank.edu";
    private Date date = new Date();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    private JTextField txtStuID;
    private JLabel lblStudentId;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    applyCreditNew frame = new applyCreditNew();
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
    public applyCreditNew() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 963, 729);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblFname = new JLabel("First Name");
	lblFname.setBounds(43, 81, 111, 49);
	contentPane.add(lblFname);

	txtFname = new JTextField();
	txtFname.setBounds(163, 81, 261, 49);
	contentPane.add(txtFname);
	txtFname.setColumns(10);

	JLabel lblLname = new JLabel("Last Name");
	lblLname.setBounds(445, 81, 111, 49);
	contentPane.add(lblLname);

	txtLname = new JTextField();
	txtLname.setColumns(10);
	txtLname.setBounds(566, 81, 285, 49);
	contentPane.add(txtLname);

	txtPhone = new JTextField();
	txtPhone.setColumns(10);
	txtPhone.setBounds(566, 291, 285, 49);
	contentPane.add(txtPhone);

	JLabel lblPhone = new JLabel("Phone");
	lblPhone.setBounds(455, 291, 79, 49);
	contentPane.add(lblPhone);

	JLabel lblEmail = new JLabel("Email");
	lblEmail.setBounds(43, 291, 65, 49);
	contentPane.add(lblEmail);

	txtEmail = new JTextField();
	txtEmail.setColumns(10);
	txtEmail.setBounds(164, 291, 258, 49);
	contentPane.add(txtEmail);

	txtAddress = new JTextField();
	txtAddress.setColumns(10);
	txtAddress.setBounds(163, 151, 688, 49);
	contentPane.add(txtAddress);

	JLabel lblAddress = new JLabel("Address");
	lblAddress.setBounds(43, 151, 111, 49);
	contentPane.add(lblAddress);

	JLabel lblCity = new JLabel("City");
	lblCity.setBounds(43, 221, 111, 49);
	contentPane.add(lblCity);

	txtCity = new JTextField();
	txtCity.setColumns(10);
	txtCity.setBounds(163, 221, 261, 49);
	contentPane.add(txtCity);

	comboBoxstate.setModel(new DefaultComboBoxModel(new String[] { "Select", "Alabama", "Alaska", "Arizona",
		"Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii",
		"Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
		"Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
		"New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
		"Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee",
		"Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" }));
	comboBoxstate.setMaximumRowCount(54);
	comboBoxstate.setBounds(556, 221, 295, 48);
	contentPane.add(comboBoxstate);

	lblState = new JLabel("State");
	lblState.setBounds(456, 221, 111, 49);
	contentPane.add(lblState);

	txtSSN = new JTextField();
	txtSSN.setColumns(10);
	txtSSN.setBounds(163, 372, 225, 49);
	contentPane.add(txtSSN);

	lblSSN = new JLabel("SSN");
	lblSSN.setBounds(43, 373, 111, 49);
	contentPane.add(lblSSN);

	txtCreditScore = new JTextField();
	txtCreditScore.setColumns(10);
	txtCreditScore.setBounds(566, 372, 285, 49);
	contentPane.add(txtCreditScore);

	lblCreditScore = new JLabel("Credit Score");
	lblCreditScore.setBounds(425, 373, 142, 49);
	contentPane.add(lblCreditScore);

	txtPassword = new JTextField();
	txtPassword.setColumns(10);
	txtPassword.setBounds(569, 442, 282, 49);
	contentPane.add(txtPassword);

	txtPassword2 = new JTextField();
	txtPassword2.setColumns(10);
	txtPassword2.setBounds(591, 509, 260, 49);
	contentPane.add(txtPassword2);

	lblCreatePassword = new JLabel("Create Password");
	lblCreatePassword.setBounds(398, 443, 453, 49);
	contentPane.add(lblCreatePassword);

	lblCreatePassword2 = new JLabel("Re-Type Password");
	lblCreatePassword2.setBounds(408, 509, 443, 49);
	contentPane.add(lblCreatePassword2);

	btnFinish = new JButton("Finish");
	btnFinish.setBounds(564, 579, 208, 42);
	contentPane.add(btnFinish);

	btnExit = new JButton("Exit");
	btnExit.setBounds(135, 583, 208, 42);
	contentPane.add(btnExit);

	txtIncome = new JTextField();
	txtIncome.setColumns(10);
	txtIncome.setBounds(163, 442, 225, 49);
	contentPane.add(txtIncome);

	lblIncome = new JLabel("Income");
	lblIncome.setBounds(43, 443, 111, 49);
	contentPane.add(lblIncome);

	lblNewLabel = new JLabel("Credit Card Application");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(343, 10, 241, 49);
	contentPane.add(lblNewLabel);

	txtStuID = new JTextField();
	txtStuID.setColumns(10);
	txtStuID.setBounds(163, 517, 225, 49);
	contentPane.add(txtStuID);

	lblStudentId = new JLabel("Student ID");
	lblStudentId.setBounds(43, 520, 111, 49);
	contentPane.add(lblStudentId);

	btnFinish.addMouseListener(new MouseAdapter() {
	    public void mouseClicked(MouseEvent arg0) {
		finishApplication();
	    }

	    ;
	});
	btnExit.addMouseListener(new MouseAdapter() {
	    public void mouseClicked(MouseEvent arg0) {
		dispose();
	    }

	    ;
	});
    }

    public void finishApplication() {

		if (isTextFieldsValid()) {

			// add to datebase somehow

			//JLabel lblAddSuccess = new JLabel("");
			//lblAddSuccess.setForeground(Color.RED);
			//lblAddSuccess.setBounds(165, 414, 663, 26);
			//JOptionPane.showMessageDialog(lblAddSuccess, "Application Created successfully");
		}
    }

    public boolean isTextFieldsValid() {
	// Verify all fields have values
	if (txtFname.getText().isEmpty() || txtLname.getText().isEmpty() || txtAddress.getText().isEmpty()
		|| txtCity.getText().isEmpty() || txtEmail.getText().isEmpty() || txtPhone.getText().isEmpty()
		|| txtSSN.getText().isEmpty() || txtIncome.getText().isEmpty()
		|| String.valueOf(comboBoxstate.getSelectedItem()).contentEquals("Select")
		|| txtPassword.getText().isEmpty() || txtCreditScore.getText().isEmpty()
		|| txtStuID.getText().isEmpty()) {

	    JLabel lblFieldIsEmpty = new JLabel("");
	    lblFieldIsEmpty.setForeground(Color.RED);
	    lblFieldIsEmpty.setBounds(165, 414, 663, 26);
	    JOptionPane.showMessageDialog(lblFieldIsEmpty, "Input fields cannot be empty.");
	    return false;
	}

	return true;
    }

    public boolean passwordMatch() {
	if (txtPassword.getText().equals(txtPassword2)) {
	    return true;
	}
	return false;
    }

    public boolean validEmail() {
	if (txtEmail.getText().contains(email) || txtEmail.getText().contains(emailBank)) {
	    return true;
	}
	return false;
    }

}
