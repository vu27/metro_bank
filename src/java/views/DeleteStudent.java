package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DeleteStudent extends JFrame {

    private JPanel contentPane;
    private JTextField txtFname;
    private JTextField txtLname;
    private JTextField txtStreetAddress;
    private JTextField txtCity;
    private JTextField txtAccountNum;
    private JTextField textField_5;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    DeleteStudent frame = new DeleteStudent();
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
    public DeleteStudent() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1050, 691);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	txtFname = new JTextField();
	txtFname.setColumns(10);
	txtFname.setBounds(174, 111, 269, 55);
	contentPane.add(txtFname);

	txtLname = new JTextField();
	txtLname.setColumns(10);
	txtLname.setBounds(587, 111, 295, 55);
	contentPane.add(txtLname);

	JLabel lblFname = new JLabel("First Name");
	lblFname.setHorizontalAlignment(SwingConstants.CENTER);
	lblFname.setBounds(42, 118, 133, 41);
	contentPane.add(lblFname);

	JLabel lblLastName = new JLabel("Last Name");
	lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
	lblLastName.setBounds(448, 118, 133, 41);
	contentPane.add(lblLastName);

	JLabel lblstreet = new JLabel("Street Address");
	lblstreet.setHorizontalAlignment(SwingConstants.CENTER);
	lblstreet.setBounds(21, 191, 154, 41);
	contentPane.add(lblstreet);

	txtStreetAddress = new JTextField();
	txtStreetAddress.setColumns(10);
	txtStreetAddress.setBounds(174, 184, 708, 55);
	contentPane.add(txtStreetAddress);

	JLabel lblcity = new JLabel("City");
	lblcity.setHorizontalAlignment(SwingConstants.CENTER);
	lblcity.setBounds(21, 267, 154, 41);
	contentPane.add(lblcity);

	txtCity = new JTextField();
	txtCity.setColumns(10);
	txtCity.setBounds(174, 260, 269, 55);
	contentPane.add(txtCity);

	JComboBox comboBoxstate = new JComboBox();
	comboBoxstate.setBounds(587, 260, 295, 48);
	contentPane.add(comboBoxstate);

	JLabel lblstate = new JLabel("State");
	lblstate.setHorizontalAlignment(SwingConstants.CENTER);
	lblstate.setBounds(444, 263, 149, 48);
	contentPane.add(lblstate);

	txtAccountNum = new JTextField();
	txtAccountNum.setColumns(10);
	txtAccountNum.setBounds(174, 329, 269, 55);
	contentPane.add(txtAccountNum);

	JLabel lblAccountNum = new JLabel("Account Number");
	lblAccountNum.setHorizontalAlignment(SwingConstants.CENTER);
	lblAccountNum.setBounds(0, 336, 175, 41);
	contentPane.add(lblAccountNum);

	textField_5 = new JTextField();
	textField_5.setColumns(10);
	textField_5.setBounds(587, 329, 295, 55);
	contentPane.add(textField_5);

	JLabel lblPhone = new JLabel("Phone");
	lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
	lblPhone.setBounds(448, 336, 154, 41);
	contentPane.add(lblPhone);

	JButton btnExit = new JButton("Exit");
	btnExit.setBounds(21, 471, 282, 55);
	contentPane.add(btnExit);
	btnExit.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		try {
		    dispose();
		    teller4 teller = new teller4();
		    teller.setVisible(true);

		} catch (Exception ex) {

		}

	    }
	});

	JButton btnDelete = new JButton("Delete");
	btnDelete.setBounds(721, 471, 282, 55);
	contentPane.add(btnDelete);

	JButton btnSearch = new JButton("Search");
	btnSearch.setBounds(371, 471, 282, 55);
	contentPane.add(btnSearch);
	btnSearch.addMouseListener(new MouseAdapter() {
	    public void mouseClicked(MouseEvent arg0) {

		// Function f = new Function();
		// ResultSet rs = null;
		try {
		    if (txtFname.getText().equals("Anthony")) {
			// System.out.print("yes");
			// ex.printStackTrace();
			// String name = JOptionPane.showDialog("You must enter a name");
			// userName.setText(name);

			// frmLogin.getContentPane().add(lblUserNotFound);
			// teller4 tellerInfo = new teller4();
			// tellerInfo.setVisible(true);

		    } else {

			// String name = JOptionPane.showInputDialog("user not found");
			// userName.setText(name);
			JOptionPane.showMessageDialog(btnSearch, "Customer not found");

		    }

		} catch (Exception ex) {
		    ex.printStackTrace();

		}

	    }
	});

	JLabel lblNewLabel = new JLabel("Delete Customer");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(286, 41, 477, 48);
	contentPane.add(lblNewLabel);

	JLabel lblCardNum = new JLabel("Card Number");
	lblCardNum.setHorizontalAlignment(SwingConstants.CENTER);
	lblCardNum.setBounds(0, 411, 175, 41);
	contentPane.add(lblCardNum);

	textField = new JTextField();
	textField.setColumns(10);
	textField.setBounds(174, 405, 708, 55);
	contentPane.add(textField);
    }

}
