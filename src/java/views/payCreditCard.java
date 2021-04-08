package views;

import javax.swing.*;

import model.Manager;
import model.Student;

import model.bank_accounts.Checkings;
import model.bank_accounts.Credit;
import model.bank_accounts.CreditApplication;
import model.bank_accounts.Savings;
import util.MySQLConnect;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class payCreditCard extends JFrame {


    private JPanel contentPane;
    // private JPanel contentPane;
    private JTable table; // table
    // private List<CreditApplication> creditApp = new ArrayList<>(); //holds all
    // students
    private DefaultTableModel dtm = new DefaultTableModel(0, 0); // default table model
    private JTextField textField;
    private JTextField txtPay;
    private JComboBox comboBox = new JComboBox();
    private List<Credit> credits = new ArrayList<>();
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


    public payCreditCard(Student student) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 941, 613);
        contentPane = new JPanel(); // create Jpanel
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Panel panel = new Panel(); // create panel to insert the jtable into
        panel.setBounds(10, 117, 1099, 249);
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
        //table.getColumnModel().getColumn(6).setPreferredWidth(135);
        //table.getColumnModel().getColumn(7).setPreferredWidth(135);
        //table.getColumnModel().getColumn(8).setPreferredWidth(160);
        //table.getColumnModel().getColumn(9).setPreferredWidth(135);
        //table.getColumnModel().getColumn(10).setPreferredWidth(135);
        //table.getColumnModel().getColumn(11).setPreferredWidth(135);
        //table.getColumnModel().getColumn(12).setPreferredWidth(160);
        //table.getColumnModel().getColumn(13).setPreferredWidth(135);
        //table.getColumnModel().getColumn(14).setPreferredWidth(190);
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

        credits = Manager.getCredit();
        updateTable(student);
        checkingsAccount = retrieveCheckingsAccount(student);
        savingsAccount = retrieveSavingsAccount(student);




        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                try {

                    dispose(); // close screen
                    dispose();
                    StudentGUI studentGUI = new StudentGUI(student);
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


                if(txtPay.getText().isEmpty()){
                    JLabel usernotfound = new JLabel("User was not found");
                    usernotfound.setForeground(Color.RED);
                    usernotfound.setBounds(165, 414, 663, 26);
                    JOptionPane.showMessageDialog(usernotfound, "enter amount");
                    return;
                }


                try {
                    double balance = creditAccount.getBalance();
                    double pay = Double.parseDouble(txtPay.getText());
                    double check = checkingsAccount.getTotal();
                    String x = String.valueOf(comboBox.getSelectedItem());


                    switch (x) {
                        case "Checking":
                            System.out.println(checkingsAccount.getAccountNumber());
                            System.out.println(checkingsAccount.getTotal());
                            System.out.println(Double.parseDouble(txtPay.getText()));
                            //System.out.println(check - pay);




                            if(checkingsAccount != null && checkingsAccount.getTotal() >= Double.parseDouble(txtPay.getText()) ){
                                //System.out.println(pay);
                                total = check - pay;
                                creditBalance = balance - pay ;

                                //System.out.println(total);
                               // System.out.println(creditBalance);



                                updateChecking(total, student);
                                updateCredit(creditBalance,student);
                                txtPay.setText("");

                            }
                            else{
                                JLabel usernotfound = new JLabel("User was not found");
                                usernotfound.setForeground(Color.RED);
                                usernotfound.setBounds(165, 414, 663, 26);
                                JOptionPane.showMessageDialog(usernotfound, "not enough money in checking");
                            }




                            break;
                        case "Saving":

                            if(savingsAccount != null && savingsAccount.getTotal() >= Double.parseDouble(txtPay.getText()) ){
                                //System.out.println(pay);
                                total = check - pay;
                                creditBalance = balance - pay ;

                                //System.out.println(total);
                                // System.out.println(creditBalance);



                                updateSavings(total, student);
                                updateCredit(creditBalance,student);
                                txtPay.setText("");

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

    public Checkings retrieveCheckingsAccount(Student student) {
        MySQLConnect mySQLConnect = new MySQLConnect();
        String queryString = "SELECT * FROM checkings WHERE student_id = " + student.getId() + ";";
        List<Map<String, Object>> resultList = mySQLConnect.getData(queryString);

        try{
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
        } catch (Exception e) {
            //e.printStackTrace();
            return  null;
        }

    }

    public Savings retrieveSavingsAccount(Student student) {
        MySQLConnect mySQLConnect = new MySQLConnect();
        String queryString = "SELECT * FROM savings WHERE student_id = " + student.getId() + ";";
        List<Map<String, Object>> resultList = mySQLConnect.getData(queryString);

        try{
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
        } catch (Exception e) {
            //
            return null;
        }


    }

    public void updateChecking(double total, Student student){
        MySQLConnect mysql = new MySQLConnect();
        String queryString = "UPDATE metro_bank.checkings SET total = \"" + total +
                "\""  + "WHERE student_id = \"" + student.getId() + "\";";

        mysql.executeStatement(queryString);
    }

    public void updateSavings(double total, Student student){
        MySQLConnect mysql = new MySQLConnect();
        String queryString = "UPDATE savings SET total = \"" + total +
                "\""  + " WHERE student_id = \"" + student.getId() + "\";";

        mysql.executeStatement(queryString);
    }

    public void updateCredit(double creditBalance, Student student){
        MySQLConnect mysql = new MySQLConnect();
        String queryString = "UPDATE credit SET balance = \"" + creditBalance +
                "\""  + "WHERE student_id = \"" + student.getId() + "\"" + " AND id = \"" + creditAccount.getId()+ "\" ;";

        mysql.executeStatement(queryString);
    }







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
            creditAccount = credits.get(i);
            row++;



            // table.getModel().setValueAt("******",i,5); //password is hidden
            //table.getModel().setValueAt(creditApp.get(i).getDateApplied(),i,6);


            dtm.addRow(new Object[]{ null, null, null, null, null }); // create a empty row
        }


    }


}
