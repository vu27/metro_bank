package views;

import model.Employee;
import model.Manager;
import model.Student;
import util.MySQLConnect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
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
	//private JPanel contentPane;
	//private JTextField txtFname;
	//private JTextField txtLname;
	private JTextField txtEmail;
	//private JTextField txtCity;
	private JTextField txtStuID;
	//private JTextField txtFname2;
	private JTextField txtLName2;
	private JTextField txtEmail2;
	private JTextField txtCity2;
	private JTextField txtStuID2;
	private JTextField txtPhone;
	//private JTextField textField;
	MySQLConnect mysql = new MySQLConnect();
	private Employee employee;
	private Employee oldEmployee;
	private String oldEmail;
	private String newEmail;
	//private JButton btnUpdate;
	//private String oldEmail;
	//private String newEmail;
	private JTextField txtID;
	private JTextField txtDate;
	private JTextField txtPassword;
	private JTextField textPhone;
	private List<Student> students = new ArrayList<>(); //holds all students
	private Student student;

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
		setBounds(100, 100, 1723, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblstreet = new JLabel("Email");
		lblstreet.setHorizontalAlignment(SwingConstants.CENTER);
		lblstreet.setBounds(21, 167, 154, 41);
		contentPane.add(lblstreet);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtEmail.setColumns(10);
		txtEmail.setBounds(174, 160, 513, 55);
		contentPane.add(txtEmail);

		// JLabel lblstate = new JLabel("State");
		// lblstate.setHorizontalAlignment(SwingConstants.CENTER);
		// lblstate.setBounds(444, 239, 149, 48);
		// contentPane.add(lblstate);

		txtStuID = new JTextField();
		txtStuID.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtStuID.setColumns(10);
		txtStuID.setBounds(173, 87, 269, 55);
		contentPane.add(txtStuID);

		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeId.setBounds(21, 94, 154, 41);
		contentPane.add(lblEmployeeId);

		txtFname2 = new JTextField();
		txtFname2.setColumns(10);
		txtFname2.setBounds(969, 87, 269, 55);
		contentPane.add(txtFname2);

		txtLName2 = new JTextField();
		txtLName2.setColumns(10);
		txtLName2.setBounds(1382, 87, 295, 55);
		contentPane.add(txtLName2);

		JLabel lblFname_1 = new JLabel("First Name");
		lblFname_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFname_1.setBounds(837, 94, 133, 41);
		contentPane.add(lblFname_1);

		JLabel lblLastName_1 = new JLabel("Last Name");
		lblLastName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName_1.setBounds(1243, 94, 133, 41);
		contentPane.add(lblLastName_1);

		JLabel lblstreet_1 = new JLabel("Email");
		lblstreet_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblstreet_1.setBounds(816, 167, 154, 41);
		contentPane.add(lblstreet_1);

		txtEmail2 = new JTextField();
		txtEmail2.setColumns(10);
		txtEmail2.setBounds(969, 160, 708, 55);
		contentPane.add(txtEmail2);

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

		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(969, 236, 269, 55);
		contentPane.add(txtPassword);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(816, 243, 154, 41);
		contentPane.add(lblPassword);

		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(1382, 236, 295, 55);
		contentPane.add(textPhone);

		JLabel lblPhone_1 = new JLabel("Phone");
		lblPhone_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone_1.setBounds(1243, 243, 154, 41);
		contentPane.add(lblPhone_1);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(638, 399, 199, 55);
		contentPane.add(btnExit);

		JLabel lblSearchEmployee = new JLabel("Search Student");
		lblSearchEmployee.setBounds(174, 21, 178, 45);
		contentPane.add(lblSearchEmployee);

		JLabel lblUpdateEmployee = new JLabel("Update Student");
		lblUpdateEmployee.setBounds(773, 21, 178, 45);
		contentPane.add(lblUpdateEmployee);

		JLabel lblEditEmployee = new JLabel("Edit Student");
		lblEditEmployee.setBounds(1357, 21, 178, 45);
		contentPane.add(lblEditEmployee);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(174, 399, 199, 55);
		contentPane.add(btnSearch);

		// employees = Manager.getEmployees();

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(1128, 399, 199, 55);
		contentPane.add(btnUpdate);

		JLabel lblEmployeeId_1_1 = new JLabel("Employee ID");
		lblEmployeeId_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeId_1_1.setBounds(816, 319, 154, 41);
		contentPane.add(lblEmployeeId_1_1);

		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(969, 312, 269, 55);
		contentPane.add(txtID);

		JLabel lblSalary = new JLabel("Date Created");
		lblSalary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalary.setBounds(1243, 319, 154, 41);
		contentPane.add(lblSalary);

		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(1382, 312, 295, 55);
		contentPane.add(txtDate);



		students = Manager.getStudents();
		//employees = Manager.getEmployees();

		btnSearch.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				getStudents();

			}
		});

		btnUpdate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {

				updateEmployee();

			}
		});



	}

	public void updateEmployee(){


		if(allDigits(txtID.getText())) {
			//System.out.print("hit");
			String queryString = "UPDATE student SET student_email = \"" + txtEmail2.getText() +
					"\"" + " , student_id = \"" + Integer.parseInt(txtID.getText()) + "\"" + " , student_fname =  \"" + txtFname2.getText()  + "\""  +
					" ,  student_lname = \"" + txtLName2.getText() + "\""  + " , student_phone = \"" + textPhone.getText() + "\""  + "  , student_password = \"" + txtPassword.getText()  + "\""  +
					" , date_created = \"" +  txtDate.getText()+ "\""  +  "WHERE student_email = \"" + student.getEmail() + "\";";

			mysql.executeStatement(queryString);
			resetTextInputs();
			student = null;

		}

		else if(!allDigits(txtID.getText())){
			JLabel useriderror = new JLabel("must enter a proper ID number and/or salary");
			useriderror.setForeground(Color.RED);
			useriderror.setBounds(165, 414, 663, 26);
			JOptionPane.showMessageDialog(useriderror, "must enter a proper ID number and/or salary");
		}



	}

	public void getStudents(){
		int size = students.size(); //how many students in list
		int id = 0;


		if(!txtStuID.getText().isEmpty()){
			if(!allDigits(txtStuID.getText())){
				//System.out.println("error");
				JLabel useriderror = new JLabel("must enter a proper ID number");
				useriderror.setForeground(Color.RED);
				useriderror.setBounds(165, 414, 663, 26);
				JOptionPane.showMessageDialog(useriderror, "must enter a proper ID number");


				return;
			}
			else
				id = Integer.parseInt(txtStuID.getText().toString());
		}



		//String num = txtID.getText();


		for(int i = 0; i < size; i++){

			if(students.get(i).getEmail().equalsIgnoreCase(txtEmail.getText()) || students.get(i).getId() == id){
				//oldEmployee = students.get(i);
				student = students.get(i);
				txtFname2.setText(student.getFname());
				txtLName2.setText(student.getLname());
				txtEmail2.setText(student.getEmail());
				txtPassword.setText(student.getPassword());
				textPhone.setText(student.getPhone());
				txtID.setText(String.valueOf(student.getId()));
				txtDate.setText(student.getDateCreated().replaceAll("[Z,T]", " "));
				return;
				//break;
			}



		}
		JLabel usernotfound = new JLabel("User was not found");
		usernotfound.setForeground(Color.RED);
		usernotfound.setBounds(165, 414, 663, 26);
		JOptionPane.showMessageDialog(usernotfound, "User not found");
	}

	public static boolean allDigits(String s) {
		return s.replaceAll("\\d", "").equals("");
	}

	public void resetTextInputs() {

    	txtEmail.setText("");
	txtStuID.setText("");
	txtFname2.setText("");
	txtLName2.setText("");
	txtEmail2.setText("");
	txtPassword.setText("");
	textPhone.setText("");
	txtID.setText("");
	txtDate.setText("");
	}



}
