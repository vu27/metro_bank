package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ForgotUserPassword extends JFrame {

    private JPanel contentPane;
    private JTextField txtSocial1;
    private JTextField txtSocial2;
    private JTextField txtSocial3;
    private JTextField textField;
    private JLabel lblNewLabel_2;
    private JTextField textField_1;
    private JLabel lblPassword;
    private JButton btnExit;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    ForgotUserPassword frame = new ForgotUserPassword();
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
    public ForgotUserPassword() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1076, 403);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	txtSocial1 = new JTextField();
	txtSocial1.setColumns(10);
	txtSocial1.setBounds(175, 60, 90, 55);
	contentPane.add(txtSocial1);

	JLabel lbl = new JLabel("Social Security");
	lbl.setHorizontalAlignment(SwingConstants.CENTER);
	lbl.setBounds(21, 74, 154, 41);
	contentPane.add(lbl);

	txtSocial2 = new JTextField();
	txtSocial2.setColumns(10);
	txtSocial2.setBounds(316, 60, 64, 55);
	contentPane.add(txtSocial2);

	txtSocial3 = new JTextField();
	txtSocial3.setColumns(10);
	txtSocial3.setBounds(433, 60, 90, 55);
	contentPane.add(txtSocial3);

	JLabel lblNewLabel = new JLabel("-");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
	lblNewLabel.setBounds(262, 67, 58, 41);
	contentPane.add(lblNewLabel);

	JLabel lblNewLabel_1 = new JLabel("-");
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
	lblNewLabel_1.setBounds(379, 67, 58, 41);
	contentPane.add(lblNewLabel_1);

	JButton btnNewButton = new JButton("Search");
	btnNewButton.setBounds(262, 228, 141, 35);
	contentPane.add(btnNewButton);

	textField = new JTextField();
	textField.setEditable(false);
	textField.setBounds(711, 67, 294, 41);
	contentPane.add(textField);
	textField.setColumns(10);

	lblNewLabel_2 = new JLabel("User Name");
	lblNewLabel_2.setBounds(584, 74, 106, 26);
	contentPane.add(lblNewLabel_2);

	textField_1 = new JTextField();
	textField_1.setEditable(false);
	textField_1.setColumns(10);
	textField_1.setBounds(711, 125, 294, 41);
	contentPane.add(textField_1);

	lblPassword = new JLabel("Password");
	lblPassword.setBounds(594, 132, 106, 26);
	contentPane.add(lblPassword);

	btnExit = new JButton("Exit");
	btnExit.setBounds(765, 228, 141, 35);
	contentPane.add(btnExit);
	btnExit.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		try {

		    dispose();
		    MainMenu mainMenu = new MainMenu();
		    mainMenu.setVisible(true);

		} catch (Exception ex) {

		}

	    }
	});

    }

}
