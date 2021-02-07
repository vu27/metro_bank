package views;

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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainMenu extends JFrame {

    private JPanel contentPane;
    private JPasswordField txtPassword;
    private JTextField txtUserName;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    MainMenu frame = new MainMenu();
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
    public MainMenu() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1028, 514);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JButton btnForgot = new JButton("Forgot User/Password");
	btnForgot.setBounds(376, 321, 261, 66);
	contentPane.add(btnForgot);

	txtPassword = new JPasswordField();
	txtPassword.setEchoChar('*');
	txtPassword.setColumns(10);
	txtPassword.setBounds(165, 228, 720, 72);
	contentPane.add(txtPassword);

	txtUserName = new JTextField();
	txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 30));
	txtUserName.setColumns(10);
	txtUserName.setBounds(165, 121, 720, 72);
	contentPane.add(txtUserName);

	JButton btnLogin = new JButton("Login");
	btnLogin.setBounds(658, 321, 227, 66);
	contentPane.add(btnLogin);
	btnLogin.addMouseListener(new MouseAdapter() {
	    public void mouseClicked(MouseEvent arg0) {

		// Function f = new Function();
		// ResultSet rs = null;
		try {
		    if (txtUserName.getText().equals("Teller")) {
			teller4 tellerInfo = new teller4();
			tellerInfo.setVisible(true);

		    } else if (txtUserName.getText().equals("Manager")) {
			Manager manager = new Manager();
			manager.setVisible(true);
		    } else {
			JOptionPane.showMessageDialog(btnLogin, "User not found");

		    }

		} catch (Exception ex) {
		    ex.printStackTrace();

		}

	    }
	});

	JLabel lblUserName = new JLabel("UserName");
	lblUserName.setBounds(63, 121, 115, 49);
	contentPane.add(lblUserName);

	JLabel lblPassword = new JLabel("Password");
	lblPassword.setBounds(63, 229, 115, 49);
	contentPane.add(lblPassword);

	JLabel lblNewLabel_1 = new JLabel("User Login");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 33));
	lblNewLabel_1.setBounds(199, 35, 686, 49);
	contentPane.add(lblNewLabel_1);

	JButton btnExit = new JButton("Exit");
	btnExit.setBounds(165, 321, 190, 66);
	contentPane.add(btnExit);
	btnExit.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		try {
		    System.exit(0);

		} catch (Exception ex) {

		}

	    }
	});

	JSeparator separator = new JSeparator();
	separator.setBounds(21, 304, 1253, 12);
	contentPane.add(separator);
    }
}
