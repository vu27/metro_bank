package views;//package WinBuilder;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import model.Manager;
import model.bank_accounts.CreditApplication;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import model.Manager;
import model.Student;
import model.bank_accounts.CreditApplication;

public class applyCreditSearch extends JFrame {

    private JPanel contentPane;
    private JTextField txtStuID;
    private JTextField txtEmail;
    public static Student student;
	private List<Student> students = new ArrayList<>(); //holds all students
	private List <CreditApplication> creditApplications = new ArrayList<>();
	//private List<CreditApplication> creditApplications = new ArrayList<>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    applyCreditSearch frame = new applyCreditSearch();
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
    public applyCreditSearch() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 526, 419);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblNewLabel = new JLabel("Student ID");
	lblNewLabel.setBounds(21, 95, 118, 26);
	contentPane.add(lblNewLabel);

	txtStuID = new JTextField();
	txtStuID.setBounds(170, 92, 186, 32);
	contentPane.add(txtStuID);
	txtStuID.setColumns(10);

	JLabel lblEmail = new JLabel("Email");
	lblEmail.setBounds(21, 154, 118, 26);
	contentPane.add(lblEmail);

	txtEmail = new JTextField();
	txtEmail.setColumns(10);
	txtEmail.setBounds(170, 151, 186, 32);
	contentPane.add(txtEmail);

	JButton btnSearch = new JButton("Search");
	btnSearch.setBounds(317, 253, 141, 35);
	contentPane.add(btnSearch);

	JButton btnExit = new JButton("Exit");
	btnExit.setBounds(104, 253, 141, 35);
	contentPane.add(btnExit);


		students = Manager.getStudents();
		creditApplications = Manager.getCreditApplication();

		btnExit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}


		});

		btnSearch.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {

					try {
						if(getStudents() != null ){

							if(!ifAppExists(student)) {
								applyCreditExisting applycreditexist = new applyCreditExisting(student);
								applycreditexist.setVisible(true);
								dispose();
							}

						}
					} catch (Exception e) {
						e.printStackTrace();
					}




			}

			;
		});


    }


	public static Student getter(){
		return student;
	}

	public static void setter(Student studentNew){
    	student = studentNew;
	}

	public Student getStudents(){
		int size = students.size(); //how many students in list
		int id = 0; //ID to search with


		if(!txtStuID.getText().isEmpty()){
			if(!allDigits(txtStuID.getText())){ //if Id isnt a number throw error
				JLabel useriderror = new JLabel("must enter a proper ID number");
				useriderror.setForeground(Color.RED);
				useriderror.setBounds(165, 414, 663, 26);
				JOptionPane.showMessageDialog(useriderror, "must enter a proper ID number");
				return null;
			}
			else
				id = Integer.parseInt(txtStuID.getText().toString());
		}

		//search for target in arrayList
		for(int i = 0; i < size; i++){

			// if found set textfields to targets data
			if(students.get(i).getEmail().equalsIgnoreCase(txtEmail.getText()) || students.get(i).getId() == id){
				student = students.get(i);


				try{
					if(txtEmail.getText().equalsIgnoreCase(creditApplications.get(i).getEmail()) || id == Integer.parseInt(creditApplications.get(i).getStudentId())){

						JLabel usernotfound = new JLabel("Application has been processed");
						usernotfound.setForeground(Color.RED);
						usernotfound.setBounds(165, 414, 663, 26);
						JOptionPane.showMessageDialog(usernotfound, "App has been processed already");
						return null;

					}
				}catch (Exception e){
					return student;
				}




				return student;
			}

		} //if target not found throw error
		JLabel usernotfound = new JLabel("Target not found");
		usernotfound.setForeground(Color.RED);
		usernotfound.setBounds(165, 414, 663, 26);
		JOptionPane.showMessageDialog(usernotfound, "Target not found");

		return null;


	}




	public static boolean allDigits(String s) {
		return s.replaceAll("\\d", "").equals("");
	}

	public boolean ifAppExists(Student student){

    	creditApplications = Manager.getCreditApplication();

		for(int i = 0; i < creditApplications.size(); i++){

			//System.out.println(student.getEmail());

			if(creditApplications.get(i).getEmail().equals(student.getEmail()) ||
					creditApplications.get(i).getStudentId().equals(String.valueOf(student.getId()))){
				JLabel lblAddSuccess = new JLabel("");
				lblAddSuccess.setForeground(Color.RED);
				lblAddSuccess.setBounds(165, 414, 663, 26);
				JOptionPane.showMessageDialog(lblAddSuccess, "Application Already Exists");
				return true;
			}
		}

		return false;
	}



}
