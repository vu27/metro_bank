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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Student extends JFrame {

    private JPanel contentPane;
    private JTextField txtTotal;
    private JTextField txtDepositW;
    private JTextField txtSaving;
    private JTextField textField_1;
    private JTextField txtTransfers;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Student frame = new Student();
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
    public Student() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1263, 553);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblTotal = new JLabel("Total $");
	lblTotal.setBounds(21, 212, 142, 64);
	contentPane.add(lblTotal);

	txtTotal = new JTextField();
	txtTotal.setBounds(111, 220, 210, 48);
	contentPane.add(txtTotal);
	txtTotal.setColumns(10);

	txtDepositW = new JTextField();
	txtDepositW.setColumns(10);
	txtDepositW.setBounds(457, 138, 279, 48);
	contentPane.add(txtDepositW);

	JButton btnNewButton = new JButton("Deposit");
	btnNewButton.setBounds(457, 241, 116, 35);
	contentPane.add(btnNewButton);

	JButton btnWithdraw = new JButton("Withdraw");
	btnWithdraw.setBounds(594, 241, 142, 35);
	contentPane.add(btnWithdraw);

	JLabel lblTotal_1 = new JLabel("$");
	lblTotal_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblTotal_1.setBounds(367, 130, 142, 64);
	contentPane.add(lblTotal_1);

	txtSaving = new JTextField();
	txtSaving.setColumns(10);
	txtSaving.setBounds(111, 143, 210, 48);
	contentPane.add(txtSaving);

	JLabel lblChecking = new JLabel("Checking $");
	lblChecking.setBounds(0, 135, 142, 64);
	contentPane.add(lblChecking);

	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(111, 74, 210, 48);
	contentPane.add(textField_1);

	JLabel lblSavings = new JLabel("Savings $");
	lblSavings.setBounds(0, 66, 142, 64);
	contentPane.add(lblSavings);

	txtTransfers = new JTextField();
	txtTransfers.setColumns(10);
	txtTransfers.setBounds(906, 143, 279, 48);
	contentPane.add(txtTransfers);

	JComboBox comboBoxtransfer = new JComboBox();
	comboBoxtransfer.setModel(new DefaultComboBoxModel(new String[] { "Select", "Checking", "Savings" }));
	comboBoxtransfer.setBounds(906, 82, 103, 32);
	contentPane.add(comboBoxtransfer);

	JComboBox comboBoxtransfer2 = new JComboBox();
	comboBoxtransfer2.setModel(new DefaultComboBoxModel(new String[] { "Select", "Checking", "Savings" }));
	comboBoxtransfer2.setBounds(1067, 82, 103, 32);
	contentPane.add(comboBoxtransfer2);

	JLabel lblNewLabel = new JLabel("To");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(992, 85, 92, 26);
	contentPane.add(lblNewLabel);

	JLabel lblFrom = new JLabel("From");
	lblFrom.setHorizontalAlignment(SwingConstants.CENTER);
	lblFrom.setBounds(817, 85, 92, 26);
	contentPane.add(lblFrom);

	JLabel lblTotal_1_1 = new JLabel("$");
	lblTotal_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblTotal_1_1.setBounds(817, 135, 142, 64);
	contentPane.add(lblTotal_1_1);

	JButton btnTransfer = new JButton("Transfer");
	btnTransfer.setBounds(956, 241, 142, 35);
	contentPane.add(btnTransfer);

	JButton btnExit = new JButton("Exit");
	btnExit.setBounds(957, 378, 141, 35);
	contentPane.add(btnExit);

	JLabel lblNewLabel_1 = new JLabel("Customer");
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setBounds(476, 0, 368, 56);
	contentPane.add(lblNewLabel_1);

	JLabel lblNewLabel_1_1 = new JLabel("Transfers");
	lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_1.setBounds(817, 33, 368, 56);
	contentPane.add(lblNewLabel_1_1);

	JLabel lblNewLabel_1_1_1 = new JLabel("Deposit/Withdrawals");
	lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_1_1.setBounds(411, 82, 368, 56);
	contentPane.add(lblNewLabel_1_1_1);

	JLabel lblNewLabel_1_1_1_1 = new JLabel("Cash");
	lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_1_1_1.setBounds(31, 15, 368, 56);
	contentPane.add(lblNewLabel_1_1_1_1);

	JButton btnPayCreditcard = new JButton("Pay Credit Card");
	btnPayCreditcard.setBounds(488, 378, 216, 35);
	contentPane.add(btnPayCreditcard);
	btnPayCreditcard.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		try {

		    dispose();
		    CreditCardStudent creditCard = new CreditCardStudent();
		    creditCard.setVisible(true);
		    // this.setVisible(false);

		} catch (Exception ex) {

		}

	    }
	});

    }

}
