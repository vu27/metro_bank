package views;

import model.Student;
import model.bank_accounts.Checkings;
import model.bank_accounts.Credit;
import model.bank_accounts.CreditApplication;
import model.bank_accounts.Savings;
import util.MySQLConnect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class StudentGUI extends JFrame {

    private JPanel contentPane;
    private JTextField txtTotal;
    private JTextField txtCheckings;
    private JTextField textSavings;
    private JTextField txtTransfers;
    JButton btnCreateCredit = new JButton("Apply for Credit Card");
    private JTextField textCheckingAccountNumber;
    private JTextField textCheckingRoutingNumber;
    private JTextField textDebitCardNumber;
    private JTextField textSavingsAcountNumber;
    private JTextField textSavingsRoutingNumber;
    private JTextField txtTotalCredit;
    private JTextField txtCreditNum;
    private JTextField txtCreditBalance;
    JButton btnPayCreditcard = new JButton("Pay Credit Card");
    Checkings checkingsAccount;
    Savings savingsAccount;
    Credit creditAccount;
    CreditApplication creditApplication;

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
        setBounds(100, 100, 1379, 559);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTotal = new JLabel("Total $");
        lblTotal.setBounds(21, 204, 142, 64);
        contentPane.add(lblTotal);

        txtTotal = new JTextField();
        txtTotal.setBounds(111, 212, 210, 48);
        contentPane.add(txtTotal);
        txtTotal.setColumns(10);

        txtCheckings = new JTextField();
        txtCheckings.setColumns(10);
        txtCheckings.setBounds(111, 92, 210, 48);
        contentPane.add(txtCheckings);

        JLabel lblChecking = new JLabel("Checking $");
        lblChecking.setBounds(21, 84, 142, 64);
        contentPane.add(lblChecking);

        textSavings = new JTextField();
        textSavings.setColumns(10);
        textSavings.setBounds(111, 152, 210, 48);
        contentPane.add(textSavings);

        JLabel lblSavings = new JLabel("Savings $");
        lblSavings.setBounds(21, 144, 142, 64);
        contentPane.add(lblSavings);

        txtCreditBalance = new JTextField();
        txtCreditBalance.setColumns(10);
        txtCreditBalance.setBounds(1022, 100, 279, 48);
        txtCreditBalance.setEditable(false);
        contentPane.add(txtCreditBalance);

        JLabel lblTotal_1_1 = new JLabel("$");
        lblTotal_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotal_1_1.setBounds(933, 92, 142, 64);
        contentPane.add(lblTotal_1_1);



        JLabel lblStudentHeader = new JLabel("Student");
        lblStudentHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblStudentHeader.setBounds(476, 0, 368, 56);
        contentPane.add(lblStudentHeader);

        JLabel lblNewLabel_1_1 = new JLabel("Credit Balance");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setBounds(933, 41, 368, 56);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Cash");
        lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1_1.setBounds(21, 24, 368, 56);
        contentPane.add(lblNewLabel_1_1_1_1);

        JButton btnPayCreditcard = new JButton("Pay Credit Card");
        btnPayCreditcard.setBounds(1049, 328, 216, 35);


        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Accounts Information");
        lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1_1_1.setBounds(367, 24, 368, 56);
        contentPane.add(lblNewLabel_1_1_1_1_1);

        JLabel lblCheckingAccountNumber = new JLabel("Checking Account Number");
        lblCheckingAccountNumber.setBounds(333, 82, 216, 64);
        contentPane.add(lblCheckingAccountNumber);

        JLabel lblCheckingRoutingNumber = new JLabel("Checking Routing Number");
        lblCheckingRoutingNumber.setBounds(333, 144, 216, 64);
        contentPane.add(lblCheckingRoutingNumber);

        JLabel lblDebitCardNumber = new JLabel("Debit Card Number");
        lblDebitCardNumber.setBounds(333, 204, 142, 64);
        contentPane.add(lblDebitCardNumber);

        textCheckingAccountNumber = new JTextField();
        textCheckingAccountNumber.setColumns(10);
        textCheckingAccountNumber.setBounds(595, 92, 210, 48);
        contentPane.add(textCheckingAccountNumber);

        textCheckingRoutingNumber = new JTextField();
        textCheckingRoutingNumber.setColumns(10);
        textCheckingRoutingNumber.setBounds(595, 152, 210, 48);
        contentPane.add(textCheckingRoutingNumber);

        textDebitCardNumber = new JTextField();
        textDebitCardNumber.setColumns(10);
        textDebitCardNumber.setBounds(595, 212, 210, 48);
        contentPane.add(textDebitCardNumber);

        JLabel lblSavingsAccountNumber = new JLabel("Savings Account Number");
        lblSavingsAccountNumber.setBounds(333, 264, 216, 64);
        contentPane.add(lblSavingsAccountNumber);

        JLabel lblSavingsRoutingNumber = new JLabel("Savings Routing Number");
        lblSavingsRoutingNumber.setBounds(333, 327, 216, 64);
        contentPane.add(lblSavingsRoutingNumber);

        textSavingsAcountNumber = new JTextField();
        textSavingsAcountNumber.setColumns(10);
        textSavingsAcountNumber.setBounds(595, 272, 210, 48);
        contentPane.add(textSavingsAcountNumber);

        textSavingsRoutingNumber = new JTextField();
        textSavingsRoutingNumber.setColumns(10);
        textSavingsRoutingNumber.setBounds(595, 335, 210, 48);
        contentPane.add(textSavingsRoutingNumber);

        txtTotalCredit = new JTextField();
        txtTotalCredit.setEditable(false);
        txtTotalCredit.setColumns(10);
        txtTotalCredit.setBounds(1022, 196, 279, 48);
        contentPane.add(txtTotalCredit);

        JLabel lblNewLabel_1_1_1 = new JLabel("Credit Information");
        lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1.setBounds(964, 141, 368, 56);
        contentPane.add(lblNewLabel_1_1_1);

        JLabel lblTotal_1_1_1 = new JLabel("$");
        lblTotal_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotal_1_1_1.setBounds(933, 188, 121, 64);
        contentPane.add(lblTotal_1_1_1);

        JLabel lblNewLabel_1_1_1_2 = new JLabel("Total Credit");
        lblNewLabel_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1_2.setBounds(728, 195, 368, 56);
        contentPane.add(lblNewLabel_1_1_1_2);

        txtCreditNum = new JTextField();
        txtCreditNum.setEditable(false);
        txtCreditNum.setColumns(10);
        txtCreditNum.setBounds(1022, 258, 279, 48);
        //contentPane.add(txtCreditNum);

        JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Credit Card Number");
        lblNewLabel_1_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1_2_1.setBounds(738, 258, 368, 56);
        //contentPane.add(lblNewLabel_1_1_1_2_1);

        //JButton btnPayCreditcard = new JButton("Pay Credit Card");
        btnPayCreditcard.setBounds(1049, 328, 216, 35);
        contentPane.add(btnPayCreditcard);

        JButton btnExit = new JButton("Log Off");
        btnExit.setBounds(1071, 462, 179, 35);
        contentPane.add(btnExit);

        JButton btnViewStatus = new JButton("View Credit Card Status");
        btnViewStatus.setBounds(1049, 364, 216, 35);
        contentPane.add(btnViewStatus);

        JButton btnApplyCredit = new JButton("Apply For a Credit Card");
        btnApplyCredit.setBounds(1049, 400, 216, 35);
        contentPane.add(btnApplyCredit);






        btnViewStatus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    creditApplication = retrieveCreditApplication(student);
                    if(creditApplication != null ){

                        creditAppStatus appStatus = new creditAppStatus(student);
                        appStatus.setVisible(true);
                    }
                    else{
                        JLabel usernotfound = new JLabel("Target not found");
                        usernotfound.setForeground(Color.RED);
                        usernotfound.setBounds(165, 414, 663, 26);
                        JOptionPane.showMessageDialog(usernotfound, "User doesn't have a credit application");
                    }



                } catch (Exception ex) {

                }

            }
        });

        btnApplyCredit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    creditApplication = retrieveCreditApplication(student);
                    creditAccount = retrieveCreditAccount(student);
                    if(creditApplication == null  && creditAccount != null ){
                        applyCreditExisting applyCredit = new applyCreditExisting(student);
                        applyCredit.setVisible(true);
                    }
                    else{
                        JLabel usernotfound = new JLabel("Target not found");
                        usernotfound.setForeground(Color.RED);
                        usernotfound.setBounds(165, 414, 663, 26);
                        JOptionPane.showMessageDialog(usernotfound, "User already have a credit application or Credit Card");
                    }


                } catch (Exception ex) {

                }

            }
        });

        btnPayCreditcard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {

                    creditAccount = retrieveCreditAccount(student);

                    if(creditAccount != null ){
                        dispose();
                        payCreditCard payCard = new payCreditCard(student);
                        payCard.setVisible(true);
                    }
                    else{
                        JLabel usernotfound = new JLabel("Target not found");
                        usernotfound.setForeground(Color.RED);
                        usernotfound.setBounds(165, 414, 663, 26);
                        JOptionPane.showMessageDialog(usernotfound, "Credit Card Not Found");
                    }





                } catch (Exception ex) {

                }

            }
        });




        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {




                    dispose();

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

        // Fill in credit account information
        creditAccount = retrieveCreditAccount(student);
        creditApplication = retrieveCreditApplication(student);




        // Fill in total
        txtTotal.setText(String.valueOf(calculateTotal(checkingsAccount, savingsAccount)));

        // Fill in accounts information
        textCheckingAccountNumber.setText(Long.valueOf(checkingsAccount.getAccountNumber()).toString());
        textCheckingRoutingNumber.setText(Long.valueOf(checkingsAccount.getRoutingNumber()).toString());
        textDebitCardNumber.setText(Long.valueOf(checkingsAccount.getDebitCardNumber()).toString());
        textSavingsAcountNumber.setText(Long.valueOf(savingsAccount.getAccountNumber()).toString());
        textSavingsRoutingNumber.setText(Long.valueOf(savingsAccount.getRoutingNumber()).toString());

// Credit stuff
        txtTotalCredit.setText("N/A");
        txtCreditBalance.setText("N/A");
        txtCreditNum.setText("N/A");
        btnPayCreditcard.setEnabled(false);
        btnApplyCredit.setEnabled(true);
        btnViewStatus.setEnabled(true);
        if(creditAccount!=null){
            btnPayCreditcard.setEnabled(true);
            contentPane.add(btnPayCreditcard);
            txtTotalCredit.setText(String.valueOf(creditAccount.getAvailableCredit()));
            txtCreditBalance.setText(String.valueOf(creditAccount.getBalance()));

        }

        if(creditApplication != null){
            btnApplyCredit.setEnabled(false);
            btnViewStatus.setEnabled(true);
        }

        if(creditApplication == null){
            btnViewStatus.setEnabled(false);
        }







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
                isOverdrafted,
                Long.parseLong(resultList.get(0).get("account_number").toString()),
                Long.parseLong(resultList.get(0).get("routing_number").toString()),
                Long.parseLong(resultList.get(0).get("debit_card_number").toString()));

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
                Double.parseDouble(resultList.get(0).get("interest").toString()),
                Long.parseLong(resultList.get(0).get("account_number").toString()),
                Long.parseLong(resultList.get(0).get("routing_number").toString()));

        return savingsAccount;
    }

    public Credit retrieveCreditAccount(Student student) {
        MySQLConnect mySQLConnect = new MySQLConnect();
        String queryString = "SELECT * FROM credit WHERE student_id = " + student.getId() + ";";
        List<Map<String, Object>> resultList = mySQLConnect.getData(queryString);


        try{
            boolean isActive = (boolean) resultList.get(0).get("is_active");
            boolean paymentMade = (boolean) resultList.get(0).get("payment_made");

            Credit creditAccount = new Credit(Integer.parseInt(resultList.get(0).get("id").toString()),
                    resultList.get(0).get("date_opened").toString(), isActive,
                    Integer.parseInt(resultList.get(0).get("student_id").toString()),
                    Double.parseDouble(resultList.get(0).get("balance").toString()),
                    Double.parseDouble(resultList.get(0).get("statement_balance").toString()),
                    Double.parseDouble(resultList.get(0).get("available_credit").toString()),
                    Double.parseDouble(resultList.get(0).get("apr").toString()),
                    paymentMade);

            return creditAccount;
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }


        //return creditAccount;
    }

    public CreditApplication retrieveCreditApplication(Student student) {
        MySQLConnect mySQLConnect = new MySQLConnect();
        String queryString = "SELECT * FROM credit_application WHERE student_id = " + student.getId() + ";";
        List<Map<String, Object>> resultList = mySQLConnect.getData(queryString);

        //System.out.println(resultList.get(0).get("student_id"));

        try{
            //boolean isActive = resultList.get(0).get("is_active").toString() == "1" ? true : false;

            CreditApplication creditApplication = new CreditApplication(Integer.parseInt(resultList.get(0).get("id").toString()),
                    resultList.get(0).get("fname").toString(), resultList.get(0).get("lname").toString(),
                    resultList.get(0).get("address").toString(), resultList.get(0).get("city").toString(),
                    resultList.get(0).get("state").toString(), resultList.get(0).get("email").toString(),
                    resultList.get(0).get("phone").toString(), Integer.parseInt(resultList.get(0).get("ssn").toString()),
                    Integer.parseInt(resultList.get(0).get("credit_score").toString()), Double.parseDouble(resultList.get(0).get("income").toString()),
                    resultList.get(0).get("password").toString(), String.valueOf(resultList.get(0).get("student_id")), resultList.get(0).get("status").toString(),
                    resultList.get(0).get("date_applied").toString());


            return creditApplication;
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }


        //return creditAccount;
    }




    public double calculateTotal(Checkings checkings, Savings savings) {
        return checkings.getTotal() + savings.getTotal();
    }
}