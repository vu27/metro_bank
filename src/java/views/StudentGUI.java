package views;

import model.Student;
import model.bank_accounts.Checkings;
import model.bank_accounts.Savings;
import util.MySQLConnect;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class StudentGUI extends JFrame {

    private JPanel contentPane;
    private JTextField txtTotal;
    private JTextField txtDepositW;
    private JTextField txtCheckings;
    private JTextField textSavings;
    private JTextField txtTransfers;
    JButton btnCreateCredit = new JButton("apply for Credit Card");
    Checkings checkingsAccount;
    Savings savingsAccount;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentGUI frame = new StudentGUI(new Student());
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
    public StudentGUI(Student student) {
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

        txtCheckings = new JTextField();
        txtCheckings.setColumns(10);
        txtCheckings.setBounds(111, 143, 210, 48);
        contentPane.add(txtCheckings);

        JLabel lblChecking = new JLabel("Checking $");
        lblChecking.setBounds(0, 135, 142, 64);
        contentPane.add(lblChecking);

        textSavings = new JTextField();
        textSavings.setColumns(10);
        textSavings.setBounds(111, 74, 210, 48);
        contentPane.add(textSavings);

        JLabel lblSavings = new JLabel("Savings $");
        lblSavings.setBounds(0, 66, 142, 64);
        contentPane.add(lblSavings);

        txtTransfers = new JTextField();
        txtTransfers.setColumns(10);
        txtTransfers.setBounds(906, 143, 279, 48);
        contentPane.add(txtTransfers);

        JComboBox comboBoxtransfer = new JComboBox();
        comboBoxtransfer.setModel(new DefaultComboBoxModel(new String[]{"Select", "Checking", "Savings"}));
        comboBoxtransfer.setBounds(906, 82, 103, 32);
        contentPane.add(comboBoxtransfer);

        JComboBox comboBoxtransfer2 = new JComboBox();
        comboBoxtransfer2.setModel(new DefaultComboBoxModel(new String[]{"Select", "Checking", "Savings"}));
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


        btnCreateCredit.setBounds(150, 378, 216, 35);
        contentPane.add(btnCreateCredit);

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

        btnCreateCredit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {

                    applyCreditStudent applyCredit = new applyCreditStudent();
                    applyCredit.setVisible(true);

                } catch (Exception ex) {

                }

            }
        });

        // Example of using student object
        System.out.println(student.getFname() + "IS NOW LOGGED IN");

        // Fill in checkings account information
        checkingsAccount = retrieveCheckingsAccount(student);
        txtCheckings.setText(String.valueOf(checkingsAccount.getTotal()));

        // Fill in savings account information
        savingsAccount = retrieveSavingsAccount(student);
        textSavings.setText(String.valueOf(savingsAccount.getTotal()));

        // Fill in total
        txtTotal.setText(String.valueOf(calculateTotal(checkingsAccount, savingsAccount)));
    }

    public Checkings retrieveCheckingsAccount(Student student) {
        MySQLConnect mySQLConnect = new MySQLConnect();
        String queryString = "SELECT * FROM checkings WHERE student_id = " + student.getId() + ";";
        List<Map<String, Object>> resultList = mySQLConnect.getData(queryString);

        boolean isActive = resultList.get(0).get("is_active").toString() == "1" ? true : false;
        boolean isOverdrafted = resultList.get(0).get("is_overdrafted").toString() == "1" ? true : false;

        Checkings checkingAccount = new Checkings(Integer.parseInt(resultList.get(0).get("id").toString()),
                resultList.get(0).get("date_opened").toString(),
                isActive,
                Integer.parseInt(resultList.get(0).get("student_id").toString()),
                Double.parseDouble(resultList.get(0).get("total").toString()),
                isOverdrafted);

        return checkingAccount;
    }

    public Savings retrieveSavingsAccount(Student student) {
        MySQLConnect mySQLConnect = new MySQLConnect();
        String queryString = "SELECT * FROM savings WHERE student_id = " + student.getId() + ";";
        List<Map<String, Object>> resultList = mySQLConnect.getData(queryString);

        boolean isActive = resultList.get(0).get("is_active").toString() == "1" ? true : false;

        Savings savingsAccount = new Savings(Integer.parseInt(resultList.get(0).get("id").toString()),
                resultList.get(0).get("date_opened").toString(),
                isActive,
                Integer.parseInt(resultList.get(0).get("student_id").toString()),
                Double.parseDouble(resultList.get(0).get("total").toString()),
                Double.parseDouble(resultList.get(0).get("interest").toString()));

        return savingsAccount;
    }

    public double calculateTotal(Checkings checkings, Savings savings) {
        return checkings.getTotal() + savings.getTotal();
    }
}
