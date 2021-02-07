package views;

import model.User;
import util.MySQLConnect;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

import javax.swing.*;

public class WinBuilder extends JFrame {

    MySQLConnect mysql = new MySQLConnect();
    User user;
    private JFrame frmLogin;
    private JTextField txtPassword;
    private JTextField userName;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WinBuilder window = new WinBuilder();
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
    public WinBuilder() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmLogin = new JFrame();
        frmLogin.setTitle("Login");
        frmLogin.setBounds(100, 100, 1365, 638);
        frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        password.setBounds(165, 214, 720, 72);
        password.setEchoChar('*');
        frmLogin.getContentPane().add(password);

        // contentPane.add(password);

        userName = new JTextField();
        userName.setFont(new Font("Tahoma", Font.PLAIN, 30));
        userName.setColumns(10);
        userName.setBounds(165, 107, 720, 72);
        frmLogin.getContentPane().add(userName);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(658, 307, 227, 66);
        frmLogin.getContentPane().add(btnLogin);

        JLabel lblNewLabel = new JLabel("UserName");
        lblNewLabel.setBounds(63, 107, 115, 49);
        frmLogin.getContentPane().add(lblNewLabel);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(63, 215, 115, 49);
        frmLogin.getContentPane().add(lblPassword);

        JLabel lblNewLabel_1 = new JLabel("User Login");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 33));
        lblNewLabel_1.setBounds(199, 21, 686, 49);
        frmLogin.getContentPane().add(lblNewLabel_1);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(165, 307, 190, 66);
        frmLogin.getContentPane().add(btnExit);
        btnExit.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent arg0) {

                // Function f = new Function();
                // ResultSet rs = null;
                try {
                    System.exit(0);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        JSeparator separator = new JSeparator();
        separator.setBounds(21, 290, 1253, 12);
        frmLogin.getContentPane().add(separator);


        JRadioButton rdbtnManager = new JRadioButton("Manager");
        rdbtnManager.setBounds(980, 49, 201, 35);
        frmLogin.getContentPane().add(rdbtnManager);

        JRadioButton rdbtnTeller = new JRadioButton("Teller");
        rdbtnTeller.setBounds(980, 114, 201, 35);
        frmLogin.getContentPane().add(rdbtnTeller);

        JRadioButton rdbtnCustomer = new JRadioButton("Student");
        rdbtnCustomer.setBounds(980, 183, 201, 35);
        frmLogin.getContentPane().add(rdbtnCustomer);


        ButtonGroup buttonGroupRole = new ButtonGroup();
        buttonGroupRole.add(rdbtnManager);
        buttonGroupRole.add(rdbtnTeller);
        buttonGroupRole.add(rdbtnCustomer);

        // LOG IN USER
        btnLogin.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {

                // Check if user selected a role
                if (!rdbtnManager.isSelected() && !rdbtnTeller.isSelected() && !rdbtnCustomer.isSelected()) {
                    JOptionPane.showMessageDialog(lblRoleNotSelected, "User role not selected");
                } else {

                    try {
                        // Get the user from mySql db where username == inputted_email
                        String queryString = "SELECT * FROM user WHERE user_email = \"" + userName.getText().toLowerCase() + "\";";
                        List<Map<String, Object>> resultList = mysql.getData(queryString);

                        // Create user model if user exists
                        if (resultList.isEmpty()) {
                            JOptionPane.showMessageDialog(lblUserNotFound, "User not found");
                        } else {
                            user = new User(Integer.parseInt(resultList.get(0).get("user_id").toString()),
                                    resultList.get(0).get("user_fname").toString(),
                                    resultList.get(0).get("user_lname").toString(),
                                    resultList.get(0).get("user_phone").toString(),
                                    resultList.get(0).get("user_role").toString(),
                                    resultList.get(0).get("user_email").toString(),
                                    resultList.get(0).get("user_password").toString());

                            // Print current user to console
                            System.out.println(user.getFname());
                            System.out.println(user.getLname());
                            System.out.println(user.getPhone());
                            System.out.println(user.getRole());
                            System.out.println(user.getEmail());
                        }

                        // Verify role then verify password
                        if ((rdbtnManager.isSelected() && !user.getRole().equals("Manager")) ||
                                (rdbtnTeller.isSelected() && !user.getRole().equals("Teller")) ||
                                (rdbtnCustomer.isSelected() && !user.getRole().equals("Student"))) {
                            JOptionPane.showMessageDialog(lblUserNotFound, "Userfd not found");
                        } else {
                            // Verify password
                            if (user.getPassword() != String.valueOf(password.getPassword())) {
                                JOptionPane.showMessageDialog(lblIncorrectCredentials, "Username or password is incorrect");
                            } else {
                                // Success - send to GUI based on role

                                // to be implemented
                            }
                        }


//					if (userName.getText().equals("Teller")) {
//						teller4 tellerInfo = new teller4();
//						tellerInfo.setVisible(true);
//						dispose();
//
//					} else if (userName.getText().equals("Manager")) {
//
//						Manager manager = new Manager();
//						manager.setVisible(true);
//						dispose();
//
//					} else {
//
//						// String name = JOptionPane.showInputDialog("user not found");
//						// userName.setText(name);
//						JOptionPane.showMessageDialog(lblUserNotFound, "User not found");
//
//		    }

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
}
