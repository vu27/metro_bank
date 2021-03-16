package views;

import model.Employee;
import model.Manager;
import model.Student;
import util.MySQLConnect;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.swing.*;

public class Login extends JFrame {

    MySQLConnect mysql = new MySQLConnect();
    public Manager manager;
    public Employee employee;
    public Student student;

    private JFrame frmLogin;
    private JTextField txtPassword;
    private JTextField userName;

    protected String manager_str = "Manager";
    protected String employee_string = "Employee";
    protected String student_string = "Student";


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.frmLogin.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Login() throws FontFormatException, IOException {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() throws FontFormatException, IOException {
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        frmLogin = new JFrame();
        frmLogin.setTitle("Login");
        frmLogin.setBounds(100, 100, 1052, 582);
        frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLogin.getContentPane().setBackground(new Color(11, 40, 83));

        // LABELS
        JLabel lblUserNotFound = new JLabel("UserName/Password is not correct");
        lblUserNotFound.setForeground(Color.RED);
        lblUserNotFound.setBounds(165, 414, 663, 26);

        JLabel lblRoleNotSelected = new JLabel("User role was not selected");
        lblRoleNotSelected.setForeground(Color.RED);
        lblRoleNotSelected.setBounds(165, 414, 663, 26);

        JLabel lblIncorrectCredentials = new JLabel("Username or password is incorrect");
        lblIncorrectCredentials.setForeground(Color.RED);
        lblIncorrectCredentials.setBounds(165, 414, 663, 26);

        frmLogin.getContentPane().setLayout(null);

        // txtPassword = new JTextField();
        // txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
        // txtPassword.setBounds(165, 200, 720, 72);
        // frmLogin.getContentPane().add(txtPassword);
        // txtPassword.setColumns(10);

        // JLabel lblPassword = new JLabel("Password");
        // lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        // lblPassword.setBounds(276, 411, 154, 41);
        // contentPane.add(lblPassword);
        JPasswordField password = new JPasswordField();
        // txtPassword = new JTextField();
        // txtPassword.setColumns(10);
        // txtPassword.setBounds(430, 404, 718, 55);
        password.setColumns(10);
        password.setBounds(165, 214, 595, 72);
        password.setFont(new Font("font", Font.PLAIN, 30));
        password.setEchoChar('*');
        frmLogin.getContentPane().add(password);

        // contentPane.add(password);

        userName = new JTextField();
        userName.setFont(new Font("font", Font.PLAIN, 30));
        userName.setColumns(10);
        userName.setBounds(165, 107, 595, 72);
        frmLogin.getContentPane().add(userName);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBackground(Color.WHITE);
        btnLogin.setBounds(533, 307, 227, 66);
        frmLogin.getContentPane().add(btnLogin);

        JLabel lblNewLabel = new JLabel("UserName");
        lblNewLabel.setFont(new Font("font", Font.PLAIN, 21));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(63, 122, 115, 49);
        frmLogin.getContentPane().add(lblNewLabel);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("font", Font.PLAIN, 21));
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setBounds(63, 226, 115, 49);
        frmLogin.getContentPane().add(lblPassword);

        JLabel lblNewLabel_1 = new JLabel("Metro State Bank");
        // lblNewLabel_1.setFont(font);
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 40));
        lblNewLabel_1.setBounds(102, 21, 686, 49);

        frmLogin.getContentPane().add(lblNewLabel_1);

        JButton btnExit = new JButton("Exit");
        btnExit.setBackground(Color.WHITE);
        btnExit.setBounds(165, 307, 190, 66);
        frmLogin.getContentPane().add(btnExit);
        btnExit.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent arg0) {
                try {
                    System.exit(0);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        //radial buttons
        JRadioButton rdbtnManager = new JRadioButton("Manager");
        rdbtnManager.setFont(new Font("Dialog", Font.PLAIN, 21));
        rdbtnManager.setForeground(Color.WHITE);
        rdbtnManager.setBounds(784, 104, 244, 66);
        rdbtnManager.setBackground(new Color(11, 40, 83));
        frmLogin.getContentPane().add(rdbtnManager);

        JRadioButton rdbtnEmployee = new JRadioButton("Employee");
        rdbtnEmployee.setFont(new Font("Dialog", Font.PLAIN, 21));
        rdbtnEmployee.setForeground(Color.WHITE);
        rdbtnEmployee.setBounds(784, 183, 234, 46);
        frmLogin.getContentPane().add(rdbtnEmployee);
        rdbtnEmployee.setBackground(new Color(11, 40, 83));

        JRadioButton rdbtnStudent = new JRadioButton("Student");
        rdbtnStudent.setFont(new Font("Dialog", Font.PLAIN, 21));
        rdbtnStudent.setForeground(Color.WHITE);
        rdbtnStudent.setBounds(784, 247, 244, 62);
        rdbtnStudent.setBackground(new Color(11, 40, 83));
        frmLogin.getContentPane().add(rdbtnStudent);

        ButtonGroup buttonGroupRole = new ButtonGroup();
        buttonGroupRole.add(rdbtnManager);
        buttonGroupRole.add(rdbtnEmployee);
        buttonGroupRole.add(rdbtnStudent);

        //images
        JLabel lblSchool = new JLabel("");
        Image school = new ImageIcon(this.getClass().getResource("/static/Untitled.jpg")).getImage();
        lblSchool.setIcon(new ImageIcon(school));
        lblSchool.setBounds(543, 385, 464, 150);
        // ImageIcon image = new ImageIcon("/Untitled.jpg");
        frmLogin.getContentPane().add(lblSchool);

        JLabel lblFdic = new JLabel("");
        lblFdic.setBounds(0, 465, 126, 83);
        Image fdic = new ImageIcon(this.getClass().getResource("/static/fdic1.jpg")).getImage();
        lblFdic.setIcon(new ImageIcon(fdic));
        frmLogin.getContentPane().add(lblFdic);

        JLabel lblVisa = new JLabel("");
        lblVisa.setBounds(126, 500, 97, 49);
        Image visa = new ImageIcon(this.getClass().getResource("/static/visa.jpg")).getImage();
        lblVisa.setIcon(new ImageIcon(visa));
        frmLogin.getContentPane().add(lblVisa);


        // LOG IN USER
        btnLogin.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                EmployeeGUI employeeGUI = new EmployeeGUI();

                ManagerGUI managerGUI = new ManagerGUI();

                String selectRole = "";
                if (rdbtnManager.isSelected()) {
                    selectRole = manager_str;
                } else if (rdbtnStudent.isSelected()) {
                    selectRole = student_string;
                } else if (rdbtnEmployee.isSelected()) {
                    selectRole = employee_string;
                }


                // Check if user selected a role
                if (!rdbtnManager.isSelected() && !rdbtnEmployee.isSelected() && !rdbtnStudent.isSelected()) {
                    JOptionPane.showMessageDialog(lblRoleNotSelected, "User role not selected");
                } else {

                    try {
                        // Get the user from mySql db where username == inputted_email
                        String queryString = "SELECT * FROM " + selectRole.toLowerCase()
                                + " WHERE + " + selectRole.toLowerCase() + "_email = \""
                                + userName.getText().toLowerCase() + "\";";
                        List<Map<String, Object>> resultList = mysql.getData(queryString);

                        // Create user model if user exists
                        if (!resultList.isEmpty()) {
                            switch (selectRole) {
                                case "Manager":
                                    manager = new Manager(Integer.parseInt(resultList.get(0).get("manager_id").toString()),
                                            resultList.get(0).get("manager_fname").toString(),
                                            resultList.get(0).get("manager_lname").toString(),
                                            resultList.get(0).get("manager_phone").toString(),
                                            resultList.get(0).get("manager_email").toString(),
                                            resultList.get(0).get("manager_password").toString(),
                                            Double.parseDouble(resultList.get(0).get("manager_salary").toString()),
                                            Integer.parseInt(resultList.get(0).get("manager_ssn").toString()),
                                            resultList.get(0).get("manager_address").toString(),
                                            resultList.get(0).get("manager_city").toString(),
                                            resultList.get(0).get("manager_state").toString());
                                    break;
                                case "Employee":
                                    employee = new Employee(Integer.parseInt(resultList.get(0).get("employee_id").toString()),
                                            resultList.get(0).get("employee_fname").toString(),
                                            resultList.get(0).get("employee_lname").toString(),
                                            resultList.get(0).get("employee_phone").toString(),
                                            resultList.get(0).get("employee_email").toString(),
                                            resultList.get(0).get("employee_password").toString(),
                                            Double.parseDouble(resultList.get(0).get("employee_salary").toString()),
                                            Integer.parseInt(resultList.get(0).get("employee_ssn").toString()),
                                            resultList.get(0).get("employee_address").toString(),
                                            resultList.get(0).get("employee_city").toString(),
                                            resultList.get(0).get("employee_state").toString());
                                    break;
                                case "Student":
                                    student = new Student(Integer.parseInt(resultList.get(0).get("student_id").toString()),
                                            resultList.get(0).get("student_fname").toString(),
                                            resultList.get(0).get("student_lname").toString(),
                                            resultList.get(0).get("student_phone").toString(),
                                            resultList.get(0).get("student_email").toString(),
                                            resultList.get(0).get("student_password").toString(),
                                            resultList.get(0).get("date_created").toString(),
                                            Integer.parseInt(resultList.get(0).get("student_ssn").toString()),
                                            resultList.get(0).get("student_address").toString(),
                                            resultList.get(0).get("student_city").toString(),
                                            resultList.get(0).get("student_state").toString());
                                    break;
                                default:
                                    System.out.println("Error with role selection.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(lblUserNotFound, "User not found");
                        }

                        // Verify password
                        switch (selectRole) {
                            case "Manager":
                                if (manager != null && manager.getPassword().equals(password.getText())) {
                                    managerGUI.setVisible(true);
                                    resetLoginTextInputs(userName, password);
                                } else {
                                    JOptionPane.showMessageDialog(lblIncorrectCredentials, "Username or password is incorrect");
                                }
                                break;
                            case "Employee":
                                if (employee != null && employee.getPassword().equals(password.getText())) {
                                    employeeGUI.setVisible(true);
                                    resetLoginTextInputs(userName, password);
                                } else {
                                    JOptionPane.showMessageDialog(lblIncorrectCredentials, "Username or password is incorrect");
                                }
                                break;
                            case "Student":
                                if (student != null && student.getPassword().equals(password.getText())) {
                                    StudentGUI studentGUI = new StudentGUI(student);
                                    studentGUI.setVisible(true);
                                    resetLoginTextInputs(userName, password);
                                } else {
                                    JOptionPane.showMessageDialog(lblIncorrectCredentials, "Username or password is incorrect");
                                }
                                break;
                            default:
                                System.out.println("Error at password confirmation");
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JLabel lblUserNotFound = new JLabel("UserName/Password is not correct");
                        lblUserNotFound.setForeground(Color.RED);
                        lblUserNotFound.setBounds(165, 414, 663, 26);
                        frmLogin.getContentPane().add(lblUserNotFound);
                    }
                }
            }
        });
    }

    public void resetLoginTextInputs(JTextField userName, JPasswordField password) {
        userName.setText("");
        password.setText("");
    }
}
