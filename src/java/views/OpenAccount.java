package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class OpenAccount extends JFrame {

    private JPanel contentPane;
    private JTextField txtFname;
    private JTextField txtLName;
    private JTextField txtAddress;
    private JTextField txtCity;
    private JTextField txtSocialS;
    private JTextField txtSocialS2;
    private JTextField txtSocialS3;
    private JTextField txtUserName;
    private JTextField txtPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    OpenAccount frame = new OpenAccount();
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
    public OpenAccount() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1300, 637);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JRadioButton rdbtnChecking = new JRadioButton("Checking");
	rdbtnChecking.setBounds(17, 38, 201, 35);
	contentPane.add(rdbtnChecking);

	JRadioButton rdbtnSavings = new JRadioButton("Savings");
	rdbtnSavings.setBounds(17, 89, 201, 35);
	contentPane.add(rdbtnSavings);

	JRadioButton rdbtnCreditCard = new JRadioButton("Credit Card");
	rdbtnCreditCard.setBounds(17, 137, 201, 35);
	contentPane.add(rdbtnCreditCard);

	JLabel lblFname = new JLabel("First Name");
	lblFname.setHorizontalAlignment(SwingConstants.CENTER);
	lblFname.setBounds(276, 35, 133, 41);
	contentPane.add(lblFname);

	txtFname = new JTextField();
	txtFname.setColumns(10);
	txtFname.setBounds(430, 28, 269, 55);
	contentPane.add(txtFname);

	JLabel lblLastName = new JLabel("Last Name");
	lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
	lblLastName.setBounds(699, 35, 133, 41);
	contentPane.add(lblLastName);

	txtLName = new JTextField();
	txtLName.setColumns(10);
	txtLName.setBounds(853, 28, 295, 55);
	contentPane.add(txtLName);

	JLabel lblstreet = new JLabel("Street Address");
	lblstreet.setHorizontalAlignment(SwingConstants.CENTER);
	lblstreet.setBounds(276, 113, 154, 41);
	contentPane.add(lblstreet);

	txtAddress = new JTextField();
	txtAddress.setColumns(10);
	txtAddress.setBounds(430, 104, 718, 55);
	contentPane.add(txtAddress);

	JLabel lblcity = new JLabel("City");
	lblcity.setHorizontalAlignment(SwingConstants.CENTER);
	lblcity.setBounds(276, 195, 154, 41);
	contentPane.add(lblcity);

	txtCity = new JTextField();
	txtCity.setColumns(10);
	txtCity.setBounds(430, 181, 269, 55);
	contentPane.add(txtCity);

	JLabel lblstate = new JLabel("State");
	lblstate.setHorizontalAlignment(SwingConstants.CENTER);
	lblstate.setBounds(699, 180, 149, 48);
	contentPane.add(lblstate);

	JComboBox comboBoxstate = new JComboBox();
	comboBoxstate.setMaximumRowCount(51);
	comboBoxstate.setBounds(853, 180, 295, 48);
	contentPane.add(comboBoxstate);

	txtSocialS = new JTextField();
	txtSocialS.setColumns(10);
	txtSocialS.setBounds(430, 257, 90, 55);
	contentPane.add(txtSocialS);

	JLabel lbl = new JLabel("Social Security");
	lbl.setHorizontalAlignment(SwingConstants.CENTER);
	lbl.setBounds(276, 271, 154, 41);
	contentPane.add(lbl);

	txtSocialS2 = new JTextField();
	txtSocialS2.setColumns(10);
	txtSocialS2.setBounds(571, 257, 64, 55);
	contentPane.add(txtSocialS2);

	txtSocialS3 = new JTextField();
	txtSocialS3.setColumns(10);
	txtSocialS3.setBounds(688, 257, 90, 55);
	contentPane.add(txtSocialS3);

	JLabel lblNewLabel = new JLabel("-");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(517, 264, 58, 41);
	contentPane.add(lblNewLabel);

	JLabel lblNewLabel_1 = new JLabel("-");
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
	lblNewLabel_1.setBounds(634, 264, 58, 41);
	contentPane.add(lblNewLabel_1);

	JButton btnExit = new JButton("Exit");
	btnExit.setBounds(430, 480, 258, 41);
	contentPane.add(btnExit);
	btnExit.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		try {

		    dispose();
		    EmployeeGUI teller = new EmployeeGUI();
		    teller.setVisible(true);

		} catch (Exception ex) {

		}

	    }
	});

	JLabel lblUsername = new JLabel("UserName");
	lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
	lblUsername.setBounds(276, 340, 154, 41);
	contentPane.add(lblUsername);

	txtUserName = new JTextField();
	txtUserName.setColumns(10);
	txtUserName.setBounds(430, 333, 718, 55);
	contentPane.add(txtUserName);

	JLabel lblPassword = new JLabel("Password");
	lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
	lblPassword.setBounds(276, 411, 154, 41);
	contentPane.add(lblPassword);
	JPasswordField password = new JPasswordField();
	// txtPassword = new JTextField();
	// txtPassword.setColumns(10);
	// txtPassword.setBounds(430, 404, 718, 55);
	password.setColumns(10);
	password.setBounds(430, 404, 718, 55);
	password.setEchoChar('*');
	contentPane.add(password);

	JButton btnCreateAccount = new JButton("Create Account");
	btnCreateAccount.setBounds(890, 483, 258, 41);
	contentPane.add(btnCreateAccount);
	btnCreateAccount.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		try {
		    dispose();
		    EmployeeGUI teller = new EmployeeGUI();
		    teller.setVisible(true);

		} catch (Exception ex) {

		}

	    }
	});

    }
}
