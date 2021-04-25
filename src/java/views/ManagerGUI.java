package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * This is the GUI for the Manager account
 * @author Everyone
 * @since 2021/25/04
 * @version 1.021.12
 */

public class ManagerGUI extends JFrame {

    private JPanel contentPane;

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
		setBounds(100, 100, 911, 379);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	getContentPane().setBackground(new Color(11, 40, 83));
	contentPane.setLayout(null);

	JComboBox comboBoxManager = new JComboBox();
	comboBoxManager.setModel(new DefaultComboBoxModel(
		new String[] { "Select", "Add Employee", "Add Manager", "Add Student", "Delete Employee","Delete Manager",
				"Delete Student", "Apply Student Credit", "Edit Employee", "Edit Students", "Edit Managers",
				"View All Students", "View All Employees", "Pending Credit", "View All Credit App",
				"View Credit Status" }));
	comboBoxManager.setBounds(21, 81, 227, 49);
	contentPane.add(comboBoxManager);

	JLabel lblSchool = new JLabel("");
	Image school = new ImageIcon(this.getClass().getResource("/static/Untitled.jpg")).getImage();
	lblSchool.setIcon(new ImageIcon(school));
	lblSchool.setBounds(332, 51, 464, 150);
	getContentPane().add(lblSchool);

	JLabel lblMetroState = new JLabel("Metro State Bank Manager");
	lblMetroState.setForeground(Color.WHITE);
	lblMetroState.setHorizontalAlignment(SwingConstants.CENTER);
	lblMetroState.setFont(new Font("Dialog", Font.PLAIN, 40));
	lblMetroState.setBounds(85, 0, 686, 49);
	getContentPane().add(lblMetroState);

	JButton btnSelect = new JButton("Select");
	btnSelect.setBounds(21, 277, 227, 41);
	contentPane.add(btnSelect);

	//select button
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
				case "Apply Student Credit":
					applyCredit credit = new applyCredit();
					credit.setVisible(true);
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
				case "Pending Credit":
					creditAppReviewSearch creditApp = new creditAppReviewSearch();
					creditApp.setVisible(true);
					break;
				case "View All Credit App":
					viewAllCreditApp viewAllCredit = new viewAllCreditApp();
					viewAllCredit.setVisible(true);
					break;
				case "View Credit Status":
					creditAppSearch creditSearch = new creditAppSearch();
					creditSearch.setVisible(true);
					break;
				case "Delete Employee":
					DeleteEmployee deleteEmployee = new DeleteEmployee();
					deleteEmployee.setVisible(true);
					break;
				case "Delete Manager":
					DeleteManager deleteManager = new DeleteManager();
					deleteManager.setVisible(true);
					break;
				case "Delete Student":
					DeleteStudent deleteStudent = new DeleteStudent();
					deleteStudent.setVisible(true);
					break;
				default:
					System.out.print("Swtich Error");
					break;
			}

		} catch (Exception ex) {

		}

	    }
	});



	JButton btnExit = new JButton("Exit");
	btnExit.setBounds(590, 277, 227, 41);
	contentPane.add(btnExit);
	btnExit.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		try {

		    dispose();

		} catch (Exception ex) {

		}

	    }
	});
    }
}
