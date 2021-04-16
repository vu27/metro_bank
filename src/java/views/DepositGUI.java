package views;

import model.Employee;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DepositGUI extends JFrame {

    private JPanel contentPane;
    private JTextField txtFieldAmount;
    private JTextField txtFieldAccountNumber;
    private JTextField textFieldStudentId;
    private JTextField textCheckingAccountNumber;
    private JTextField textCheckingRoutingNumber;
    private JTextField textDebitCardNumber;
    private JTextField textSavingsAcountNumber;
    private JTextField textSavingsRoutingNumber;
    private JTextField textFieldStatus;
    private long accountNumber;
    private int studentId;
    private double depositAmount;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DepositGUI frame = new DepositGUI();
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
    public DepositGUI() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1263, 553);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtFieldAmount = new JTextField();
        txtFieldAmount.setBounds(553, 217, 210, 48);
        contentPane.add(txtFieldAmount);
        txtFieldAmount.setColumns(10);

        txtFieldAccountNumber = new JTextField();
        txtFieldAccountNumber.setColumns(10);
        txtFieldAccountNumber.setBounds(553, 97, 210, 48);
        contentPane.add(txtFieldAccountNumber);

        JLabel lblAccountNumber = new JLabel("Account Number");
        lblAccountNumber.setBounds(411, 89, 142, 64);
        contentPane.add(lblAccountNumber);

        textFieldStudentId = new JTextField();
        textFieldStudentId.setColumns(10);
        textFieldStudentId.setBounds(553, 157, 210, 48);
        contentPane.add(textFieldStudentId);

        JLabel lblAmount = new JLabel("Amount to Deposit");
        lblAmount.setBounds(411, 209, 142, 64);
        contentPane.add(lblAmount);

        JLabel lblHeader = new JLabel("Deposit");
        lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader.setBounds(476, 0, 368, 56);
        contentPane.add(lblHeader);

        JLabel lblStudentId = new JLabel("Student Account Id");
        lblStudentId.setBounds(411, 149, 142, 64);
        contentPane.add(lblStudentId);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(553, 277, 117, 29);
        contentPane.add(btnSubmit);

        JLabel lblStatus = new JLabel("Status");
        lblStatus.setBounds(411, 367, 142, 64);
        contentPane.add(lblStatus);

        textFieldStatus = new JTextField();
        textFieldStatus.setColumns(10);
        textFieldStatus.setBounds(553, 375, 410, 48);
        contentPane.add(textFieldStatus);

        JRadioButton rdbtnSaving = new JRadioButton("Savings");
        rdbtnSaving.setBounds(675, 51, 141, 23);
        contentPane.add(rdbtnSaving);

        JRadioButton rdbtnChecking = new JRadioButton("Checking");
        rdbtnChecking.setBounds(543, 51, 141, 23);
        contentPane.add(rdbtnChecking);

        ButtonGroup buttonGroupAccountChoice = new ButtonGroup();
        buttonGroupAccountChoice.add(rdbtnSaving);
        buttonGroupAccountChoice.add(rdbtnChecking);

        btnSubmit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                if (txtFieldAccountNumber.getText().isBlank()
                        || textFieldStudentId.getText().isBlank()
                        || txtFieldAmount.getText().isBlank()) {
                    textFieldStatus.setText("ERROR: Fields cannot be empty.");
                } else {
                    if (!rdbtnChecking.isSelected() && !rdbtnSaving.isSelected()) {
                        textFieldStatus.setText("ERROR: Must choose checking or savings.");
                    } else {
                        textFieldStatus.setText("");
                        accountNumber = Long.parseLong(txtFieldAccountNumber.getText());
                        studentId = Integer.parseInt(textFieldStudentId.getText());
                        depositAmount = Double.parseDouble(txtFieldAmount.getText());

                        if (rdbtnChecking.isSelected()) {
                            if(!Employee.makeDepositChecking(accountNumber, studentId, depositAmount)) {
                                textFieldStatus.setText("ERROR: Something went wrong.");
                            } else {
                                textFieldStatus.setText("Deposit was successful.");
                            }
                        } else {
                            if(!Employee.makeDepositSavings(accountNumber, studentId, depositAmount)) {
                                textFieldStatus.setText("ERROR: Something went wrong.");
                            } else {
                                textFieldStatus.setText("Deposit was successful.");
                            }
                        }
                    }
                }
            }
        });
    }
}
