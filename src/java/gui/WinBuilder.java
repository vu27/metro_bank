package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class WinBuilder extends JFrame {

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

	JButton btnForgot = new JButton("Forgot User/Password");
	btnForgot.setBounds(376, 307, 261, 66);
	btnForgot.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		// Function f = new Function();
		// ResultSet rs = null;

		System.exit(0);

	    }
	});

	JLabel lblUserNotFound = new JLabel("UserName/Password is not correct");
	lblUserNotFound.setForeground(Color.RED);
	lblUserNotFound.setBounds(165, 414, 663, 26);

	frmLogin.getContentPane().setLayout(null);
	frmLogin.getContentPane().add(btnForgot);

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
	btnLogin.addMouseListener(new MouseAdapter() {
	    public void mouseClicked(MouseEvent arg0) {

		// Function f = new Function();
		// ResultSet rs = null;
		try {
		    if (userName.getText().equals("Teller")) {
			teller4 tellerInfo = new teller4();
			tellerInfo.setVisible(true);
			dispose();

		    } else if (userName.getText().equals("Manager")) {

			Manager manager = new Manager();
			manager.setVisible(true);
			dispose();

		    } else {

			// String name = JOptionPane.showInputDialog("user not found");
			// userName.setText(name);
			JOptionPane.showMessageDialog(lblUserNotFound, "User not found");

		    }

		} catch (Exception ex) {
		    ex.printStackTrace();
		    JLabel lblUserNotFound = new JLabel("UserName/Password is not correct");
		    lblUserNotFound.setForeground(Color.RED);
		    lblUserNotFound.setBounds(165, 414, 663, 26);
		    frmLogin.getContentPane().add(lblUserNotFound);
		}

	    }
	});

	JLabel lblNewLabel = new JLabel("UserName");
	lblNewLabel.setBounds(63, 107, 115, 49);
	frmLogin.getContentPane().add(lblNewLabel);

	JLabel lblPassword = new JLabel("Password");
	lblPassword.setBounds(63, 215, 115, 49);
	frmLogin.getContentPane().add(lblPassword);

	JLabel lblNewLabel_1 = new JLabel("User Login");
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

	JRadioButton rdbtnNewRadioButton = new JRadioButton("Manager");
	rdbtnNewRadioButton.setBounds(980, 49, 201, 35);
	frmLogin.getContentPane().add(rdbtnNewRadioButton);

	JRadioButton rdbtnTeller = new JRadioButton("Teller");
	rdbtnTeller.setBounds(980, 114, 201, 35);
	frmLogin.getContentPane().add(rdbtnTeller);

	JRadioButton rdbtnCustomer = new JRadioButton("Customer");
	rdbtnCustomer.setBounds(980, 183, 201, 35);
	frmLogin.getContentPane().add(rdbtnCustomer);

    }
}
