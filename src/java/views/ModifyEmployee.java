package views;

import model.Employee;
import model.Manager;
import model.Student;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import util.MySQLConnect;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ModifyEmployee extends JFrame {

    private JPanel contentPane;
    private JTextField txtFname;
    private JTextField txtLname;
    private JTextField txtEmail;
    private JTextField txtCity;
    private JTextField txtEmpID;
    private JTextField txtFname2;
    private JTextField txtLName2;
    private JTextField txtEmail2;
    private JTextField txtCity2;
    private JTextField txtEmpID2;
    private JTextField txtPhone;
    private JTextField textField;
	MySQLConnect mysql = new MySQLConnect();
	private Employee employee;
	private Employee oldEmployee;
	private String oldEmail;
	private String newEmail;
	//private JButton btnUpdate;
	//private String oldEmail;
	//private String newEmail;
	private JTextField txtID;
	private JTextField txtSalary;
	private JTextField txtPassword;
	private JTextField textPhone;

	private List<Employee> employees = new ArrayList<>(); //holds all students
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

		txtEmpID = new JTextField();
		txtEmpID.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtEmpID.setColumns(10);
		txtEmpID.setBounds(173, 87, 269, 55);
		contentPane.add(txtEmpID);

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

		JLabel lblSearchEmployee = new JLabel("Search Employee");
		lblSearchEmployee.setBounds(174, 21, 178, 45);
		contentPane.add(lblSearchEmployee);

		JLabel lblUpdateEmployee = new JLabel("Update Employee");
		lblUpdateEmployee.setBounds(773, 21, 178, 45);
		contentPane.add(lblUpdateEmployee);

		JLabel lblEditEmployee = new JLabel("Edit Employee");
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

		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalary.setBounds(1243, 319, 154, 41);
		contentPane.add(lblSalary);

		txtSalary = new JTextField();
		txtSalary.setColumns(10);
		txtSalary.setBounds(1382, 312, 295, 55);
		contentPane.add(txtSalary);



		employees = Manager.getEmployees();

		btnSearch.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				getEmployee();


			}
		});

		btnUpdate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {




				updateEmployee();

			}
		});




    }

	public void updateEmployee(){
		int size = employees.size(); //how many students in list


		//oldEmail =

				//employee = employees.get(i);
				//txtFname2.setText(employee.getFname());
				//txtLName2.setText(employee.getLname());
				//txtEmail2.setText(employee.getEmail());


		//System.out.println(txtEmail2.getText());
		//System.out.println(txtEmail.getText());
		employee.setEmail(txtEmail.getText());

		//System.out.println(employee.getEmail());
		//System.out.println(oldEmployee.getEmail());
		//String queryString = "SELECT * FROM employee"
		//		+ " WHERE employee_email" + " = \""
		//		+ employee.getEmail().toLowerCase() + "\";";

		if(txtSalary.getText().matches("\\d*\\.?\\d+") && allDigits(txtID.getText())) {
			String queryString = "UPDATE employee SET employee_email = \"" + txtEmail2.getText() +
					"\"" + " , employee_id = \"" + Integer.parseInt(txtID.getText()) + "\"" + " , employee_fname =  \"" + txtFname2.getText()  + "\""  +
					" ,  employee_lname = \"" + txtLName2.getText() + "\""  + " , employee_phone = \"" + textPhone.getText() + "\""  + "  , employee_password = \"" + txtPassword.getText()  + "\""  +
					" , employee_salary = \"" +  Double.parseDouble(txtSalary.getText())+ "\""  +  "WHERE employee_email = \"" + employee.getEmail() + "\";";

			mysql.executeStatement(queryString);

		}

		else if(!txtSalary.getText().matches("\\d*\\.?\\d+") || !allDigits(txtID.getText())){
			JLabel useriderror = new JLabel("must enter a proper ID number and/or salary");
			useriderror.setForeground(Color.RED);
			useriderror.setBounds(165, 414, 663, 26);
			JOptionPane.showMessageDialog(useriderror, "must enter a proper ID number and/or salary");
		}



	}

	public void getEmployee(){
		int size = employees.size(); //how many students in list
		int id = 0;


		if(!txtEmpID.getText().isEmpty()){
			if(!allDigits(txtEmpID.getText())){
				//System.out.println("error");
				JLabel useriderror = new JLabel("must enter a proper ID number");
				useriderror.setForeground(Color.RED);
				useriderror.setBounds(165, 414, 663, 26);
				JOptionPane.showMessageDialog(useriderror, "must enter a proper ID number");


				return;
			}
			else
				 id = Integer.parseInt(txtEmpID.getText().toString());
		}


		//String num = txtID.getText();


		for(int i = 0; i < size; i++){

			if(employees.get(i).getEmail().equalsIgnoreCase(txtEmail.getText()) || employees.get(i).getId() == id){
				//oldEmployee = employees.get(i);
				employee = employees.get(i);
				txtFname2.setText(employee.getFname());
				txtLName2.setText(employee.getLname());
				txtEmail2.setText(employee.getEmail());
				txtPassword.setText(employee.getPassword());
				textPhone.setText(employee.getPhone());
				txtID.setText(String.valueOf(employee.getId()));
				txtSalary.setText(String.valueOf((employee.getSalary())));
				//System.out.println(oldEmployee.getEmail());
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







}
