package views;

import javax.swing.*;

import model.Manager;
import model.Student;
import model.bank_accounts.Checkings;
import model.bank_accounts.Credit;
import model.bank_accounts.Savings;
import util.MySQLConnect;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * student can check for their due date for payment and how much to pay and they are able to make a payment in this
 * window
 */
public class payCreditCard extends JFrame {


    private JPanel contentPane;
    private JTable table; // table
    private DefaultTableModel dtm = new DefaultTableModel(0, 0); // default table model
    private JTextField textField;
    private JTextField txtPay;
    private JComboBox comboBox = new JComboBox();
    private List<Credit> credits = new ArrayList<>(); //holds all students credits
    Checkings checkingsAccount;
    Savings savingsAccount;
    Credit creditAccount;



    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    payCreditCard frame = new payCreditCard(new Student());
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * create frame
     * @param student
     * @throws ParseException
     */
    public payCreditCard(Student student) throws ParseException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 941, 613);
        contentPane = new JPanel(); // create Jpanel
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Panel panel = new Panel(); // create panel to insert the jtable into
        panel.setBounds(10, 117, 693, 202);
        contentPane.add(panel); // put panel into the Jpanel

        DefaultTableModel tableModel = new DefaultTableModel(); // create table
        table = new JTable(tableModel);
        String header[] = new String[] { "ID", "Balance", "Statement Balance", "credit line", "apr", "date opened"}; // columns name
        dtm.setColumnIdentifiers(header); // set column names to column
        table.setModel(dtm); // set table to default table model
        // for (int count = 1; count <= 2; count++) {
        dtm.addRow(new Object[] { null, null, null, null, null, });
        // }

        table.setBounds(9, 5, 503, 284); // set table to certain size

        // set the width of cells to certain size
        table.getColumnModel().getColumn(0).setPreferredWidth(130);
        table.getColumnModel().getColumn(1).setPreferredWidth(116);
        table.getColumnModel().getColumn(2).setPreferredWidth(96);
        table.getColumnModel().getColumn(3).setPreferredWidth(220);
        table.getColumnModel().getColumn(4).setPreferredWidth(135);
        table.getColumnModel().getColumn(5).setPreferredWidth(135);

        panel.setLayout(null);
        JScrollPane pane = new JScrollPane(table); // create scroll if table becomes too big
        pane.setBounds(0, 0, 690, 200);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setEnabled(false);
        panel.add(pane); // add scroll to jtable pane

        // create label view students
        JLabel lblNewLabel = new JLabel("View All Credit Applications");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(195, 52, 276, 41);
        contentPane.add(lblNewLabel);

        dtm.addRow(new Object[] { null, null, null, null, null }); // create a empty row
        // create exit button
        JButton btnNewButton = new JButton("Exit");
        btnNewButton.setBounds(714, 439, 180, 82);
        contentPane.add(btnNewButton);


        comboBox.setModel(new DefaultComboBoxModel(new String[] { "Select", "Checking", "Savings" }));
        comboBox.setBounds(55, 387, 228, 47);
        contentPane.add(comboBox);

        txtPay = new JTextField();
        txtPay.setBounds(359, 387, 195, 47);
        contentPane.add(txtPay);
        txtPay.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("$");
        lblNewLabel_1.setBounds(313, 387, 38, 47);
        contentPane.add(lblNewLabel_1);

        JButton btnPayCard = new JButton("Pay Card");
        btnPayCard.setBounds(369, 460, 187, 41);
        contentPane.add(btnPayCard);

        JLabel lnlDueDate = new JLabel("Due Date");
        lnlDueDate.setBounds(754, 84, 92, 26);
        contentPane.add(lnlDueDate);

        JTextField txtDueDate = new JTextField();
        txtDueDate.setEditable(false);
        txtDueDate.setBounds(749, 117, 110, 32);
        contentPane.add(txtDueDate);
        txtDueDate.setColumns(10);

        JLabel lblMinPayment = new JLabel("Min Payment");
        lblMinPayment.setBounds(738, 170, 137, 26);
        contentPane.add(lblMinPayment);

        JTextField txtMinPay = new JTextField();
        txtMinPay.setBounds(754, 214, 129, 32);
        contentPane.add(txtMinPay);
        txtMinPay.setColumns(10);

        JLabel lblDollar = new JLabel("$");
        lblDollar.setHorizontalAlignment(SwingConstants.CENTER);
        lblDollar.setBounds(687, 217, 92, 26);
        contentPane.add(lblDollar);

        credits = Manager.getCredit();
        creditAccount = retrieveCreditAccount(student);
        updateTable(student);
        checkingsAccount = retrieveCheckingsAccount(student);
        savingsAccount = retrieveSavingsAccount(student);
        txtMinPay.setText(String.valueOf(getMinPayment()));
        txtDueDate.setText(getDueDate(getMinPayment()));


        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                try {

                    dispose(); // close screen
                    dispose();
                    StudentGUI studentGUI = new StudentGUI(student); //open student gui
                    studentGUI.setVisible(true);

                } catch (Exception ex) {

                }

            }
        });

        btnPayCard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double total;
                double creditBalance;

                if(txtPay.getText().isEmpty()){ //check if field is valid
                    JLabel usernotfound = new JLabel("User was not found");
                    usernotfound.setForeground(Color.RED);
                    usernotfound.setBounds(165, 414, 663, 26);
                    JOptionPane.showMessageDialog(usernotfound, "enter amount");
                    return;
                }


                try {
                    double balance = creditAccount.getBalance(); //get balance
                    double pay = Double.parseDouble(txtPay.getText()); // get how much to be paid
                    double check = checkingsAccount.getTotal(); //checking account total
                    String x = String.valueOf(comboBox.getSelectedItem()); // checking or savings


                    switch (x) {
                        case "Checking":

                            //check it checking account have enough money and if account exisits
                            if(checkingsAccount != null && checkingsAccount.getTotal() >= Double.parseDouble(txtPay.getText()) ){

                                total = check - pay; //new checking account balance
                                creditBalance = balance - pay; // new balance


                                if(validPayment()){ //check if payment doesn't exceed balance too much
                                    updateChecking(total, student);
                                    updateCredit(creditBalance,student);
                                    txtPay.setText("");
                                    JLabel usernotfound = new JLabel("User was not found");
                                    usernotfound.setForeground(Color.RED);
                                    usernotfound.setBounds(165, 414, 663, 26);
                                    JOptionPane.showMessageDialog(usernotfound, "Payment Made");
                                    dispose();
                                    StudentGUI studentGUI = new StudentGUI(student);
                                    studentGUI.setVisible(true);
                                }
                                else{
                                    JLabel usernotfound = new JLabel("User was not found");
                                    usernotfound.setForeground(Color.RED);
                                    usernotfound.setBounds(165, 414, 663, 26);
                                    JOptionPane.showMessageDialog(usernotfound, "Payment is too large for balance");
                                }


                            }
                            else{
                                JLabel usernotfound = new JLabel("User was not found");
                                usernotfound.setForeground(Color.RED);
                                usernotfound.setBounds(165, 414, 663, 26);
                                JOptionPane.showMessageDialog(usernotfound, "not enough money in checking");
                            }

                            break;
                        case "Saving":

                            //check if saving account exists and if savings have enough money in it
                            if(savingsAccount != null && savingsAccount.getTotal() >= Double.parseDouble(txtPay.getText()) ){
                                total = check - pay; //new savings account balance
                                creditBalance = balance - pay ; // new credit card balance

                                if(validPayment()){ // check if payment isnt too great for the credit card balance
                                    updateSavings(total, student); //update the savings account
                                    updateCredit(creditBalance,student); // update the credit balance
                                    txtPay.setText("");
                                    JLabel usernotfound = new JLabel("User was not found");
                                    usernotfound.setForeground(Color.RED);
                                    usernotfound.setBounds(165, 414, 663, 26);
                                    JOptionPane.showMessageDialog(usernotfound, "Payment Made");
                                    dispose();
                                    StudentGUI studentGUI = new StudentGUI(student);
                                    studentGUI.setVisible(true);
                                }
                                else{
                                    JLabel usernotfound = new JLabel("User was not found");
                                    usernotfound.setForeground(Color.RED);
                                    usernotfound.setBounds(165, 414, 663, 26);
                                    JOptionPane.showMessageDialog(usernotfound, "Payment is too large for balance");
                                }


                            }
                            else{
                                JLabel usernotfound = new JLabel("User was not found");
                                usernotfound.setForeground(Color.RED);
                                usernotfound.setBounds(165, 414, 663, 26);
                                JOptionPane.showMessageDialog(usernotfound, "not enough money in checking");
                            }

                            break;
                        default:
                            JLabel usernotfound = new JLabel("User was not found");
                            usernotfound.setForeground(Color.RED);
                            usernotfound.setBounds(165, 414, 663, 26);
                            JOptionPane.showMessageDialog(usernotfound, "select checking or savings");
                            break;
                    }

                } catch (Exception ex) {

                }

            }
        });



    }

    /**
     * if payment is enough for the credit card balance
     * @return true if it is fine
     */
    public boolean validPayment(){
        if( -10 > (creditAccount.getBalance() - Integer.parseInt(txtPay.getText()))){
            return false;
        }
        return true;
    }


    /**
     * find the min payment of the statement balance
     * @return
     */
    public Double getMinPayment(){
        double minPayment = creditAccount.getStatementBalance(); //get statement balance
        if(minPayment < 35 && minPayment > 0){ //must be greater than 35$ for a min balance to be 5$
            return 5.00;
        }

        //if balance is 0
        if(minPayment == 0){
            return 0.00; //no min payment is now
        }

        else{ //10% of statement balance
            minPayment = minPayment * .1;
            return round(minPayment,2);
        }
    }



    /**
     * get the due date of the min payment by calculating through the opening account date
     * @param payment check to see if due date is requiered
     * @return string of due date
     * @throws ParseException
     */
    public String getDueDate(Double payment) throws ParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now(); //get todays date

        String[] str;
        String dateOpened = creditAccount.getDateOpened();
        str = dateOpened.split("T");

        LocalDate currentDate
                = LocalDate.parse(dtf.format(now)); //get current date

        LocalDate openedDate
                = LocalDate.parse(str[0]); // get date of account opened


        int year = currentDate.getYear(); //current year
        int month = currentDate.getMonthValue(); // current month
        int today = currentDate.getDayOfMonth(); // current day
        int day = openedDate.getDayOfMonth(); // day account opened


        System.out.println(checkingsAccount.isActive());

        //if balance is 0 then no payment is requried
        if(payment == 0.0 || creditAccount.getPaymentMade() == true){
            return "not required now";
        }


       else if(today <= day){ // if the today is less than account open(due date) then just use the same day but the current month
            String dateStr = String.valueOf(month) +"/"+ String.valueOf(day) +"/" + String.valueOf(year);
            return dateStr;
        }


        // if the day today is greater than day of acc opened then just add one to the month
        else if(today > day){
            //account if it is DEC
            if(month == 12){
                month = 0; // make it into janurary
                year++; // new year
            }


            String dateStr = String.valueOf(month + 1) +"/"+ String.valueOf(day) +"/" + String.valueOf(year);
            return dateStr;
        }

        return null;

    }


    /**
     * round up a number to a certain decimal place
     * @param value to round up
     * @param places to how many places
     * @return finish number
     */
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


    /**
     * get checking account
     * @param student get student checking
     * @return checking account
     */
    public Checkings retrieveCheckingsAccount(Student student) {
        MySQLConnect mySQLConnect = new MySQLConnect(); //run script
        String queryString = "SELECT * FROM checkings WHERE student_id = " + student.getId() + ";";
        List<Map<String, Object>> resultList = mySQLConnect.getData(queryString); // map the results

        try{
            boolean isActive = (boolean) resultList.get(0).get("is_active");
            boolean isOverdrafted = (boolean) resultList.get(0).get("is_overdrafted");

            //create new object
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
        } catch (Exception e) {
            //e.printStackTrace();
            return  null;
        }

    }

    /**
     * get the student's saving account from the database and return it
     * @param student to search for student's saving
     * @return savings
     */
    public Savings retrieveSavingsAccount(Student student) {
        MySQLConnect mySQLConnect = new MySQLConnect(); // connect to database
        String queryString = "SELECT * FROM savings WHERE student_id = " + student.getId() + ";"; // run script
        List<Map<String, Object>> resultList = mySQLConnect.getData(queryString); // map the result list

        try{

            boolean isActive = (boolean) resultList.get(0).get("is_active");

            //create new object
            Savings savingsAccount = new Savings(Integer.parseInt(resultList.get(0).get("id").toString()),
                    resultList.get(0).get("date_opened").toString(),
                    isActive,
                    Integer.parseInt(resultList.get(0).get("student_id").toString()),
                    Double.parseDouble(resultList.get(0).get("total").toString()),
                    Double.parseDouble(resultList.get(0).get("interest").toString()),
                    Long.parseLong(resultList.get(0).get("account_number").toString()),
                    Long.parseLong(resultList.get(0).get("routing_number").toString()));

            return savingsAccount;
        } catch (Exception e) {
            return null;
        }


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

    /**
     * payment is made with checking, so update the checking account dbms
     * @param total new balance of checking
     * @param student student object
     */
    public void updateChecking(double total, Student student){
        MySQLConnect mysql = new MySQLConnect(); // connect database
        String queryString = "UPDATE metro_bank.checkings SET total = \"" + total +
                "\""  + "WHERE student_id = \"" + student.getId() + "\";";

        mysql.executeStatement(queryString); // run script
    }

    /**
     * update the savings account the transaction made
     * @param total new balance of savings
     * @param student student object
     */
    public void updateSavings(double total, Student student){
        MySQLConnect mysql = new MySQLConnect(); //connect to dbms
        String queryString = "UPDATE savings SET total = \"" + total +
                "\""  + " WHERE student_id = \"" + student.getId() + "\";";

        mysql.executeStatement(queryString); //run script
    }

    /**
     * update credit after payment is made
     * @param creditBalance new balance
     * @param student
     */
    public void updateCredit(double creditBalance, Student student){
        MySQLConnect mysql = new MySQLConnect(); // connect to the database
        String queryString = "UPDATE credit SET balance = \"" + creditBalance +
                "\"" +", payment_made = 1 " + "WHERE student_id = \"" + student.getId() + "\"" + " AND id = \"" + creditAccount.getId()+ "\" ;";

        mysql.executeStatement(queryString); // run script
    }


    /**
     * update table with credit information
     * @param student
     */
    public void updateTable(Student student){
        int size = credits.size(); //how many students in list
        int row = 0;


        // put user info into table
        for(int i = 0; i < size; i++){

            if(student.getId() != credits.get(i).getStudentId()){
                continue;
            }
            table.getModel().setValueAt(credits.get(i).getId(),row,0);
            table.getModel().setValueAt(credits.get(i).getBalance(),row,1);
            table.getModel().setValueAt(credits.get(i).getStatementBalance(),row,2);
            table.getModel().setValueAt(credits.get(i).getAvailableCredit(),row,3);
            table.getModel().setValueAt(credits.get(i).getApr(),row,4);
            table.getModel().setValueAt(credits.get(i).getDateOpened(),row,5);

            row++;
            dtm.addRow(new Object[]{ null, null, null, null, null }); // create a empty row
        }


    }


}
