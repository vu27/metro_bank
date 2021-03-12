package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
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

import model.Employee;
import model.Manager;
import model.Student;
import model.bank_accounts.CreditApplication;

public class applyCreditExisting extends JFrame {

    private JPanel contentPane;
    private JTextField txtFname;
    private JTextField txtLname;
    private JTextField txtAddress;
    private JTextField txtCity;
    private JTextField txtPhone;
    private JTextField txtEmail;
    private JTextField txtSSN;
    private JTextField txtCreditScore;
    private JTextField txtIncome;
    private Date date = new Date();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    private JComboBox comboBoxstate = new JComboBox();
    private JTextField txtStuID;
    private Student student;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    applyCreditExisting frame = new applyCreditExisting();
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
    public applyCreditExisting() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 915, 671);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblFname = new JLabel("First Name");
	lblFname.setBounds(43, 102, 111, 49);
	contentPane.add(lblFname);

	txtFname = new JTextField();
	txtFname.setEditable(false);
	txtFname.setColumns(10);
	txtFname.setBounds(163, 102, 261, 49);
	contentPane.add(txtFname);

	txtLname = new JTextField();
	txtLname.setEditable(false);
	txtLname.setColumns(10);
	txtLname.setBounds(566, 102, 285, 49);
	contentPane.add(txtLname);

	JLabel lblLname = new JLabel("Last Name");
	lblLname.setBounds(445, 102, 111, 49);
	contentPane.add(lblLname);

	txtAddress = new JTextField();
	txtAddress.setEditable(false);
	txtAddress.setColumns(10);
	txtAddress.setBounds(163, 172, 688, 49);
	contentPane.add(txtAddress);

	JLabel lblAddress = new JLabel("Address");
	lblAddress.setBounds(43, 172, 111, 49);
	contentPane.add(lblAddress);

	JLabel lblCity = new JLabel("City");
	lblCity.setBounds(43, 242, 111, 49);
	contentPane.add(lblCity);

	txtCity = new JTextField();
	txtCity.setEditable(false);
	txtCity.setColumns(10);
	txtCity.setBounds(163, 242, 261, 49);
	contentPane.add(txtCity);

	JLabel lblState = new JLabel("State");
	lblState.setBounds(456, 242, 111, 49);
	contentPane.add(lblState);

	// JComboBox comboBoxstate = new JComboBox();
	// comboBoxstate.setMaximumRowCount(54);
	// comboBoxstate.setBounds(556, 242, 295, 48);
	// contentPane.add(comboBoxstate);

	txtPhone = new JTextField();
	txtPhone.setEditable(false);
	txtPhone.setColumns(10);
	txtPhone.setBounds(566, 312, 285, 49);
	contentPane.add(txtPhone);

	JLabel lblPhone = new JLabel("Phone");
	lblPhone.setBounds(455, 312, 79, 49);
	contentPane.add(lblPhone);

	txtEmail = new JTextField();
	txtEmail.setEditable(false);
	txtEmail.setColumns(10);
	txtEmail.setBounds(164, 312, 258, 49);
	contentPane.add(txtEmail);

	JLabel lblEmail = new JLabel("Email");
	lblEmail.setBounds(43, 312, 65, 49);
	contentPane.add(lblEmail);

	JLabel lblSSN = new JLabel("SSN");
	lblSSN.setBounds(43, 394, 111, 49);
	contentPane.add(lblSSN);

	txtSSN = new JTextField();
	txtSSN.setEditable(false);
	txtSSN.setColumns(10);
	txtSSN.setBounds(163, 393, 225, 49);
	contentPane.add(txtSSN);

	JLabel lblCreditScore = new JLabel("Credit Score");
	lblCreditScore.setBounds(423, 463, 142, 49);
	contentPane.add(lblCreditScore);

	txtCreditScore = new JTextField();
	txtCreditScore.setColumns(10);
	txtCreditScore.setBounds(566, 463, 285, 49);
	contentPane.add(txtCreditScore);

	txtIncome = new JTextField();
	txtIncome.setColumns(10);
	txtIncome.setBounds(163, 463, 225, 49);
	contentPane.add(txtIncome);

	JLabel lblIncome = new JLabel("Income");
	lblIncome.setBounds(43, 464, 111, 49);
	contentPane.add(lblIncome);

	JLabel lblNewLabel = new JLabel("Credit Card Application");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(315, 21, 241, 49);
	contentPane.add(lblNewLabel);

	JButton btnFinish = new JButton("Finish");
	btnFinish.setBounds(592, 533, 208, 42);
	contentPane.add(btnFinish);

	JButton btnExit = new JButton("Exit");
	btnExit.setBounds(163, 537, 208, 42);
	contentPane.add(btnExit);

	comboBoxstate.setModel(new DefaultComboBoxModel(new String[] { "Select", "Alabama", "Alaska", "Arizona",
		"Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii",
		"Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
		"Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
		"New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
		"Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee",
		"Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" }));
	comboBoxstate.setMaximumRowCount(54);
	comboBoxstate.setBounds(556, 241, 295, 48);
	comboBoxstate.setEditable(false);
	contentPane.add(comboBoxstate);

	txtStuID = new JTextField();
	txtStuID.setEditable(false);
	txtStuID.setColumns(10);
	txtStuID.setBounds(566, 382, 285, 49);
	contentPane.add(txtStuID);

	JLabel lblStudentId = new JLabel("Student ID");
	lblStudentId.setBounds(423, 382, 142, 49);
	contentPane.add(lblStudentId);



	setData();

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

		if (isTextFieldsValid() && validCreditScore()) {

			String income = txtIncome.getText().replaceAll("[$,]", "");
			String date = Instant.now().toString();

			CreditApplication creditApplication = new CreditApplication(0,txtFname.getText(), txtLname.getText(),
					txtAddress.getText(),txtCity.getText(),
					txtEmail.getText(), txtPhone.getText(),comboBoxstate.getSelectedItem().toString(),
					Integer.parseInt(txtSSN.getText()), Integer.parseInt(txtCreditScore.getText()),Double.parseDouble(income),
					student.getPassword(), String.valueOf(student.getId()),
					"In review", date);



			Manager.processApp(creditApplication);


	    // add to datebase somehow

		resetTextInputs();
	    JLabel lblAddSuccess = new JLabel("");
	    lblAddSuccess.setForeground(Color.RED);
	    lblAddSuccess.setBounds(165, 414, 663, 26);
	    JOptionPane.showMessageDialog(lblAddSuccess, "Application Created successfully");

		}

		JLabel lblAddSuccess = new JLabel("");
		lblAddSuccess.setForeground(Color.RED);
		lblAddSuccess.setBounds(165, 414, 663, 26);
		JOptionPane.showMessageDialog(lblAddSuccess, "Application Process Failed");




    }

    public boolean isTextFieldsValid() {
	// Verify all fields have values
		if (txtFname.getText().isEmpty() || txtLname.getText().isEmpty() || txtAddress.getText().isEmpty()
		|| txtCity.getText().isEmpty() || txtEmail.getText().isEmpty() || txtPhone.getText().isEmpty()
		|| txtSSN.getText().isEmpty() || txtIncome.getText().isEmpty()
		|| String.valueOf(comboBoxstate.getSelectedItem()).contentEquals("Select")
		|| txtCreditScore.getText().isEmpty()) {

	    JLabel lblFieldIsEmpty = new JLabel("");
	    lblFieldIsEmpty.setForeground(Color.RED);
	    lblFieldIsEmpty.setBounds(165, 414, 663, 26);
	    JOptionPane.showMessageDialog(lblFieldIsEmpty, "Input fields cannot be empty.");
	    return false;
		}

	return true;
    }

    public boolean validCreditScore(){
    	if(Integer.parseInt(txtCreditScore.getText()) > 300 && Integer.parseInt(txtCreditScore.getText()) < 850)
    		return true;

		JLabel lblFieldIsEmpty = new JLabel("");
		lblFieldIsEmpty.setForeground(Color.RED);
		lblFieldIsEmpty.setBounds(165, 414, 663, 26);
		JOptionPane.showMessageDialog(lblFieldIsEmpty, "Credit Score Invalid.");
    	return false;
	}

	public boolean validNumber(){
		String regex = "[0-9, /,]+";

		if(txtIncome.getText().contains(regex) && txtCreditScore.getText().contains(regex)){
			return true;
		}
		JLabel lblFieldIsEmpty = new JLabel("");
		lblFieldIsEmpty.setForeground(Color.RED);
		lblFieldIsEmpty.setBounds(165, 414, 663, 26);
		JOptionPane.showMessageDialog(lblFieldIsEmpty, "Income and/or Credit Score not valid");
		return false;

	}





    public void setData(){
    	student = applyCreditSearch.getter();
    	txtFname.setText(student.getFname());
    	txtLname.setText(student.getLname());
    	txtAddress.setText(student.getAddress());
    	txtEmail.setText(student.getEmail());
    	txtCity.setText(student.getCity());
    	txtPhone.setText(student.getPhone());
    	txtSSN.setText(String.valueOf(student.getSsn()));
		txtStuID.setText(String.valueOf(student.getId()));
		comboBoxstate.setEditable(true);
		comboBoxstate.getModel().setSelectedItem(student.getState());
		comboBoxstate.setEditable(false);
		comboBoxstate.setEnabled(false);
	}


	/**
	 * reset the text fields to null
	 */
	public void resetTextInputs() {
		txtEmail.setText("");
		//txtManID.setText("");
		txtFname.setText("");
		txtLname.setText("");
		txtEmail.setText("");
		//txtPassword.setText("");
		txtPhone.setText("");
		//txtID.setText("");
		txtIncome.setText("");
		txtAddress.setText("");
		txtCity.setText("");
		txtSSN.setText("");
		txtCreditScore.setText("");
		txtIncome.setText("");
		comboBoxstate.setSelectedIndex(0);

	}



}
