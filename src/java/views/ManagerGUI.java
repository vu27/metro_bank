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
import javax.swing.border.EmptyBorder;

public class ManagerGUI extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    ManagerGUI frame = new ManagerGUI();
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
    public ManagerGUI() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1049, 573);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JComboBox comboBoxManager = new JComboBox();
	comboBoxManager.setModel(new DefaultComboBoxModel(
		new String[] { "Select", "Add Employee", "Add Manager", "Add Student", "Delete Employee", "Edit Employee", "Edit Students", "Edit Managers", "Bank Stats", "View All Students", "View All Employees" }));
	comboBoxManager.setBounds(21, 51, 227, 49);
	contentPane.add(comboBoxManager);

	JButton btnSelect = new JButton("Select");
	btnSelect.setBounds(21, 227, 227, 41);
	contentPane.add(btnSelect);
	btnSelect.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		try {

			String x = String.valueOf(comboBoxManager.getSelectedItem());

			switch (x) {
				case "Add Employee":
					AddEmployeeGUI addEmployeeGUI = new AddEmployeeGUI();
					addEmployeeGUI.setVisible(true);
					break;
				case "Add Manager":
					AddManagerGUI addManagerGUI = new AddManagerGUI();
					addManagerGUI.setVisible(true);
					break;
				case "Add Student":
					AddStudentGUI addStudentGUI = new AddStudentGUI();
					addStudentGUI.setVisible(true);
					break;
				case "Delete Employee":
					break;
				case "Edit Employee":
					ModifyEmployee modifyEmployee = new ModifyEmployee();
					modifyEmployee.setVisible(true);
					break;
				case "Edit Managers":
					ModifyManager modifyManager = new ModifyManager();
					modifyManager.setVisible(true);
					break;
				case "Edit Students":
					ModifyStudent modifyStudent = new ModifyStudent();
					modifyStudent.setVisible(true);
					break;
				case "View All Students":
					ManagerViewAllStudents viewStudents = new ManagerViewAllStudents();
					viewStudents.setVisible(true);
					break;
				case "View All Employees":
					ManagerViewAllEmployees viewEmployees = new ManagerViewAllEmployees();
					viewEmployees.setVisible(true);
					break;
				default:
					System.out.print("Swtich Error");
					break;
			}

		} catch (Exception ex) {

		}

	    }
	});

	textField = new JTextField();
	textField.setBounds(626, 51, 291, 49);
	contentPane.add(textField);
	textField.setColumns(10);

	JLabel lblEmpID = new JLabel("Employee ID");
	lblEmpID.setBounds(457, 51, 127, 49);
	contentPane.add(lblEmpID);

	JButton btnSearch = new JButton("Search");
	btnSearch.setBounds(690, 227, 227, 41);
	contentPane.add(btnSearch);

	JButton btnExit = new JButton("Exit");
	btnExit.setBounds(337, 227, 227, 41);
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
		    // WinBuilder mainMenu = new WinBuilder();
		    // mainMenu.setVisible(true);

		    //MainMenu mainMenu = new MainMenu();
		   // mainMenu.setVisible(true);

		    // ((JComponent) mainMenu).setVisible(true);

		    // customer custom = new customer();
		    // custom.setVisible(true);
		    // System.exit(0);

		} catch (Exception ex) {

		}

	    }
	});
    }
}
