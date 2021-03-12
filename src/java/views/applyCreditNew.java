package views;//package WinBuilder;

import model.Manager;
import model.Student;
import model.bank_accounts.CreditApplication;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


/**
 * This creates a GUI so someone who doesn't have an exisiting account can apply for credit
 *
 */
public class applyCreditNew extends JFrame {

    private JPanel contentPane;
    private JTextField txtFname;
    private JTextField txtLname;
    private JTextField txtPhone;
    private JTextField txtEmail;
    private JTextField txtAddress;
    private JTextField txtCity;
	private JTextField txtCreditScore;
	private JTextField txtSSN;
	private JTextField txtIncome;
    private JComboBox comboBoxstate = new JComboBox();
    private JLabel lblState;
    private JLabel lblSSN;
    private JLabel lblCreditScore;
    private JTextField txtPassword;
    private JTextField txtPassword2;
    private JLabel lblCreatePassword;
    private JLabel lblCreatePassword2;
    private JLabel lblIncome;
    private JLabel lblNewLabel;
    private String email = "@metrostate.edu";
    private String emailBank = "@metrobank.edu";
    private Date date = new Date();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    private JTextField txtStuID;
    private JLabel lblStudentId;
	private List<Student> students = new ArrayList<>(); //holds all students
	JPasswordField password = new JPasswordField();
	JPasswordField password2 = new JPasswordField();
	private List<CreditApplication> creditApplications = new ArrayList<>();
	private JButton btnFinish;
	private JButton btnExit;




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


	password.setColumns(10);
	password.setBounds(569, 442, 282, 49);
	password.setFont(new Font("font", Font.PLAIN, 30));
	password.setEchoChar('*');
	contentPane.add(password);


	password2.setColumns(10);
	password2.setBounds(591, 509, 260, 49);
	password2.setFont(new Font("font", Font.PLAIN, 30));
	password2.setEchoChar('*');
	contentPane.add(password2);



	//txtPassword = new JTextField();
	//txtPassword.setColumns(10);
	//txtPassword.setBounds(569, 442, 282, 49);
	//txtPassword.setEchoChar('*');
	//contentPane.add(txtPassword);

	//txtPassword2 = new JTextField();
	//txtPassword2.setColumns(10);
	//txtPassword2.setBounds(591, 509, 260, 49);
	//contentPane.add(txtPassword2);

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
	//contentPane.add(txtStuID);

	lblStudentId = new JLabel("Student ID");
	lblStudentId.setBounds(43, 520, 111, 49);
	//contentPane.add(lblStudentId);

	btnFinish.addMouseListener(new MouseAdapter() {
	    public void mouseClicked(MouseEvent arg0) {
	    	finishApplication();
	    }
	});
	btnExit.addMouseListener(new MouseAdapter() {
	    public void mouseClicked(MouseEvent arg0) {
		dispose();
	    }

	    ;
	});
    }

    public void finishApplication (){

		if (isTextFieldsValid() && validEmail() && validCreditScore() && userExists() && passwordMatch()) {

			String income = txtIncome.getText().replaceAll("[$,]", "");
			String date = Instant.now().toString();
			Student student = new Student(0,txtFname.getText(), txtLname.getText(),txtPhone.getText(),
					txtEmail.getText(), String.valueOf(password.getPassword()), date, Integer.parseInt(txtSSN.getText()),
					txtAddress.getText(), txtCity.getText(), comboBoxstate.getSelectedItem().toString());


			Manager.addStudent(student); //create new student and add to database
			//student = null;
			students = Manager.getStudents(); //get database
			//int size = students.size();

			Student newStudent = findStudent(); // search for student in new databse and get the Object


			if(newStudent == null){
				JLabel lblAddSuccess = new JLabel("");
				lblAddSuccess.setForeground(Color.RED);
				lblAddSuccess.setBounds(165, 414, 663, 26);
				JOptionPane.showMessageDialog(lblAddSuccess, "Student created not found in database");
				resetTextInputs();
				resetTextInputs();
				dispose();
			}


			CreditApplication creditApplication = new CreditApplication(0,txtFname.getText(), txtLname.getText(),
					txtAddress.getText(),txtCity.getText(),
					txtEmail.getText(), txtPhone.getText(),comboBoxstate.getSelectedItem().toString(),
					Integer.parseInt(txtSSN.getText()), Integer.parseInt(txtCreditScore.getText()),Double.parseDouble(income),
					String.valueOf(password.getPassword()), String.valueOf(newStudent.getId()),
					"In review", date);

			Manager.processApp(creditApplication);
			resetTextInputs();

			JLabel lblAddSuccess = new JLabel("");
			lblAddSuccess.setForeground(Color.RED);
			lblAddSuccess.setBounds(165, 414, 663, 26);
			JOptionPane.showMessageDialog(lblAddSuccess, "Application Created successfully");
		}
		else {
			JLabel lblAddSuccess = new JLabel("");
			lblAddSuccess.setForeground(Color.RED);
			lblAddSuccess.setBounds(165, 414, 663, 26);
			JOptionPane.showMessageDialog(lblAddSuccess, "Application Failed");
			resetTextInputs();
		}

    }

	/**
	 * checks if credit score field is in range
	 * @return true if in range
	 */
	public boolean validCreditScore(){
		if(Integer.parseInt(txtCreditScore.getText()) > 300 && Integer.parseInt(txtCreditScore.getText()) < 850)
			return true;

		JLabel lblFieldIsEmpty = new JLabel("");
		lblFieldIsEmpty.setForeground(Color.RED);
		lblFieldIsEmpty.setBounds(165, 414, 663, 26);
		JOptionPane.showMessageDialog(lblFieldIsEmpty, "Credit Score out of range");
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
		JOptionPane.showMessageDialog(lblFieldIsEmpty, "Income or Credit score is not Valid");
		return false;

	}


	/**
	 * check if fields are empty
	 * @return false if one field is empty
	 */
    public boolean isTextFieldsValid() {
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


	/**
	 * check if passwords match
	 * @return true if passwords match
	 */
    public boolean passwordMatch() {
	if (Arrays.equals(password.getPassword(), password2.getPassword())) {
	    return true;
	}

	JLabel lblAddSuccess = new JLabel("");
	lblAddSuccess.setForeground(Color.RED);
	lblAddSuccess.setBounds(165, 414, 663, 26);
	JOptionPane.showMessageDialog(lblAddSuccess, "Passwords Don't match");

	return false;
    }

	/**
	 * check txtEmail field to see if it is a proper school email
	 * @return true if contains valid email
	 */
	public boolean validEmail() {
	if (txtEmail.getText().contains(email) || txtEmail.getText().contains(emailBank)) {
	    return true;
	}
		JLabel lblAddSuccess = new JLabel("");
		lblAddSuccess.setForeground(Color.RED);
		lblAddSuccess.setBounds(165, 414, 663, 26);
		JOptionPane.showMessageDialog(lblAddSuccess, "Need to use a @metrobank or @metrostate email");
	return false;
    }

	/**
	 * check if user is already in databse
	 * @return false if found in databse under student
	 */
	public boolean userExists(){
			int size = students.size();
		for(int i = size - 1  ; i > 0; i--){

			// if found set textfields to targets data
			if(students.get(i).getEmail().equalsIgnoreCase(txtEmail.getText())){
				JLabel lblFieldIsEmpty = new JLabel("");
				lblFieldIsEmpty.setForeground(Color.RED);
				lblFieldIsEmpty.setBounds(165, 414, 663, 26);
				JOptionPane.showMessageDialog(lblFieldIsEmpty, "User exists Already, use the exisiting user form");
				resetTextInputs();
				return false;

			}

		}
		return true;
	}




	/**
	 * reset the text fields to null
	 */
	public void resetTextInputs() {
		txtEmail.setText("");
		txtFname.setText("");
		txtLname.setText("");
		txtEmail.setText("");
		txtPhone.setText("");
		txtIncome.setText("");
		txtAddress.setText("");
		txtCity.setText("");
		txtSSN.setText("");
		txtCreditScore.setText("");
		txtIncome.setText("");
		comboBoxstate.setSelectedIndex(0);
		password.setText("");
		password2.setText("");

	}

	public boolean ifAppExists(){

		creditApplications = Manager.getCreditApplication();

		for(int i = 0; i < creditApplications.size(); i++){
			if(creditApplications.get(i).getEmail().equals(txtEmail.getText())){
				JLabel lblAddSuccess = new JLabel("");
				lblAddSuccess.setForeground(Color.RED);
				lblAddSuccess.setBounds(165, 414, 663, 26);
				JOptionPane.showMessageDialog(lblAddSuccess, "Application Already Exists");
				return true;
			}
		}

		return false;
	}


		public Student findStudent() {
			Student student = null;
			students = Manager.getStudents();

			for (int i = 0; i < students.size(); i++) {

				if (students.get(i).getEmail().equals(txtEmail.getText())) {
					student = students.get(i);
					return student;
				}

			}
			return null;
		}



}
