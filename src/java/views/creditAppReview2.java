package views;

import model.Manager;
import model.Student;
import model.bank_accounts.Credit;
import model.bank_accounts.CreditApplication;
import util.MySQLConnect;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class creditAppReview2 extends JFrame {

    private JPanel contentPane;
    private JTextField txtFname;
    private JTextField txtLname;
    private JTextField txtAddress;
    private JTextField txtCity;
    private JTextField txtPhone;
    private JTextField txtEmail;
    private JTextField txtSSN;
    private JTextField txtCreditScore;
    private JTextField txtIncome;
    private JTextField txtCredit;
    private Date date = new Date();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    private JComboBox comboBoxstate = new JComboBox();
    private JTextField txtStuID;
    private Student student;
    private CreditApplication creditApplication;
    private JTextField txtAPR;
    private Credit credit;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    creditAppReview2 frame = new creditAppReview2();
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
    public creditAppReview2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 915, 671);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblFname = new JLabel("First Name");
        lblFname.setBounds(43, 102, 111, 49);
        contentPane.add(lblFname);

        txtFname = new JTextField();
        txtFname.setEditable(false);
        txtFname.setColumns(10);
        txtFname.setBounds(163, 102, 261, 49);
        contentPane.add(txtFname);

        txtLname = new JTextField();
        txtLname.setEditable(false);
        txtLname.setColumns(10);
        txtLname.setBounds(566, 102, 285, 49);
        contentPane.add(txtLname);

        JLabel lblLname = new JLabel("Last Name");
        lblLname.setBounds(445, 102, 111, 49);
        contentPane.add(lblLname);

        txtAddress = new JTextField();
        txtAddress.setEditable(false);
        txtAddress.setColumns(10);
        txtAddress.setBounds(163, 172, 688, 49);
        contentPane.add(txtAddress);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(43, 172, 111, 49);
        contentPane.add(lblAddress);

        JLabel lblCity = new JLabel("City");
        lblCity.setBounds(43, 242, 111, 49);
        contentPane.add(lblCity);

        txtCity = new JTextField();
        txtCity.setEditable(false);
        txtCity.setColumns(10);
        txtCity.setBounds(163, 242, 261, 49);
        contentPane.add(txtCity);

        JLabel lblState = new JLabel("State");
        lblState.setBounds(456, 242, 111, 49);
        contentPane.add(lblState);

        // JComboBox comboBoxstate = new JComboBox();
        // comboBoxstate.setMaximumRowCount(54);
        // comboBoxstate.setBounds(556, 242, 295, 48);
        // contentPane.add(comboBoxstate);

        txtPhone = new JTextField();
        txtPhone.setEditable(false);
        txtPhone.setColumns(10);
        txtPhone.setBounds(566, 312, 285, 49);
        contentPane.add(txtPhone);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(455, 312, 79, 49);
        contentPane.add(lblPhone);

        txtEmail = new JTextField();
        txtEmail.setEditable(false);
        txtEmail.setColumns(10);
        txtEmail.setBounds(164, 312, 258, 49);
        contentPane.add(txtEmail);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(43, 312, 65, 49);
        contentPane.add(lblEmail);

        JLabel lblSSN = new JLabel("SSN");
        lblSSN.setBounds(43, 394, 111, 49);
        contentPane.add(lblSSN);

        txtSSN = new JTextField();
        txtSSN.setEditable(false);
        txtSSN.setColumns(10);
        txtSSN.setBounds(163, 393, 225, 49);
        contentPane.add(txtSSN);

        JLabel lblCreditScore = new JLabel("Credit Score");
        lblCreditScore.setBounds(423, 463, 142, 49);
        contentPane.add(lblCreditScore);

        txtCreditScore = new JTextField();
        txtCreditScore.setColumns(10);
        txtCreditScore.setBounds(566, 463, 285, 49);
        contentPane.add(txtCreditScore);

        txtAPR = new JTextField();
        txtAPR.setColumns(10);
        txtAPR.setBounds(566, 520, 285, 49);
        contentPane.add(txtAPR);

        txtIncome = new JTextField();
        txtIncome.setColumns(10);
        txtIncome.setBounds(163, 463, 225, 49);
        contentPane.add(txtIncome);

        JLabel lblIncome = new JLabel("Income");
        lblIncome.setBounds(43, 464, 111, 49);
        contentPane.add(lblIncome);

        JLabel lblCredit = new JLabel("Credit");
        lblCredit.setBounds(43, 520, 111, 49);
        contentPane.add(lblCredit);

        JLabel lblDollar = new JLabel("$");
        lblDollar.setBounds(143, 520, 111, 49);
        contentPane.add(lblDollar);

        txtCredit = new JTextField();
        txtCredit.setColumns(10);
        txtCredit.setBounds(163, 520, 225, 49);
        contentPane.add(txtCredit);


        JLabel lblAPR = new JLabel("APR");
        lblAPR.setHorizontalAlignment(SwingConstants.CENTER);
        lblAPR.setBounds(380, 520, 241, 49);
        contentPane.add(lblAPR);

        JLabel lblPercent = new JLabel("%");
        lblPercent.setHorizontalAlignment(SwingConstants.CENTER);
        lblPercent.setBounds(750, 520, 241, 49);
        contentPane.add(lblPercent);


        JLabel lblNewLabel = new JLabel("Credit Card Application");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(315, 21, 241, 49);
        contentPane.add(lblNewLabel);


        JButton btnApprove = new JButton("Approve");
        btnApprove.setBounds(750, 600, 150, 42);
        contentPane.add(btnApprove);

        JButton btnDeny = new JButton("Deny");
        btnDeny.setBounds(600, 600, 150, 42);
        contentPane.add(btnDeny);




        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(163, 600, 208, 42);
        contentPane.add(btnExit);

        comboBoxstate.setModel(new DefaultComboBoxModel(new String[] { "Select", "Alabama", "Alaska", "Arizona",
                "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii",
                "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
                "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
                "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
                "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee",
                "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" }));
        comboBoxstate.setMaximumRowCount(54);
        comboBoxstate.setBounds(556, 241, 295, 48);
        comboBoxstate.setEditable(false);
        contentPane.add(comboBoxstate);

        txtStuID = new JTextField();
        txtStuID.setEditable(false);
        txtStuID.setColumns(10);
        txtStuID.setBounds(566, 382, 285, 49);
        contentPane.add(txtStuID);

        JLabel lblStudentId = new JLabel("Student ID");
        lblStudentId.setBounds(423, 382, 142, 49);
        contentPane.add(lblStudentId);


        txtIncome.setEditable(false);
        txtCreditScore.setEditable(false);



        setData();

        btnApprove.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                approveApplication();
            }

            ;
        });
        btnExit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                dispose();
            }

            ;
        });
        btnDeny.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                denyApplication();
            }

            ;
        });

    }

    public void approveApplication() {

            //String income = txtIncome.getText().replaceAll("[$,]", "");
            String date = Instant.now().toString();

            try
            {
               //double x = Double.parseDouble(txtAPR.getText());
               // System.out.println(x);
                float apr = Float.parseFloat(txtAPR.getText());
                double creditAmount = Double.parseDouble(txtCredit.getText());
                credit = new Credit(0, date,true,Integer.parseInt(creditApplication.getStudentId()),
                        0,0,
                        creditAmount, apr);


                Manager.processApp(credit);



                resetTextInputs();
                JLabel lblAddSuccess = new JLabel("");
                lblAddSuccess.setForeground(Color.RED);
                lblAddSuccess.setBounds(165, 414, 663, 26);
                JOptionPane.showMessageDialog(lblAddSuccess, "Application Created successfully");
            }
            catch(NumberFormatException e)
            {

                resetTextInputs();
                JLabel lblAddSuccess = new JLabel("");
                lblAddSuccess.setForeground(Color.RED);
                lblAddSuccess.setBounds(165, 414, 663, 26);
                JOptionPane.showMessageDialog(lblAddSuccess, "error");
                //not a double
            }





           // Manager.processApp(creditApplication);


            // add to datebase somehow





    }


    public void denyApplication() {

        //String income = txtIncome.getText().replaceAll("[$,]", "");
        String date = Instant.now().toString();

        try
        {

            MySQLConnect mysql = new MySQLConnect();

                String queryString = "Update metro_bank.credit_application" + " SET status = \"Denied\"" +
                        " WHERE id = " + creditApplication.getId() + " AND student_id = " + creditApplication.getStudentId() +
                        ";";

            mysql.executeStatement(queryString);

            resetTextInputs();
            JLabel lblAddSuccess = new JLabel("");
            lblAddSuccess.setForeground(Color.RED);
            lblAddSuccess.setBounds(165, 414, 663, 26);
            JOptionPane.showMessageDialog(lblAddSuccess, "Application Denied successfully");



        }
        catch(NumberFormatException e)
        {
            resetTextInputs();
            JLabel lblAddSuccess = new JLabel("");
            lblAddSuccess.setForeground(Color.RED);
            lblAddSuccess.setBounds(165, 414, 663, 26);
            JOptionPane.showMessageDialog(lblAddSuccess, "error");
            //not a double
        }





        // Manager.processApp(creditApplication);


        // add to datebase somehow





    }

    public boolean isTextFieldsValid() {
        // Verify all fields have values
        if (txtFname.getText().isEmpty() || txtLname.getText().isEmpty() || txtAddress.getText().isEmpty()
                || txtCity.getText().isEmpty() || txtEmail.getText().isEmpty() || txtPhone.getText().isEmpty()
                || txtSSN.getText().isEmpty() || txtIncome.getText().isEmpty()
                || String.valueOf(comboBoxstate.getSelectedItem()).contentEquals("Select")
                || txtCreditScore.getText().isEmpty()) {

            JLabel lblFieldIsEmpty = new JLabel("");
            lblFieldIsEmpty.setForeground(Color.RED);
            lblFieldIsEmpty.setBounds(165, 414, 663, 26);
            JOptionPane.showMessageDialog(lblFieldIsEmpty, "Input fields cannot be empty.");
            return false;
        }

        return true;
    }

    public boolean validCreditScore(){
        if(Integer.parseInt(txtCreditScore.getText()) > 300 && Integer.parseInt(txtCreditScore.getText()) < 850)
            return true;

        JLabel lblFieldIsEmpty = new JLabel("");
        lblFieldIsEmpty.setForeground(Color.RED);
        lblFieldIsEmpty.setBounds(165, 414, 663, 26);
        JOptionPane.showMessageDialog(lblFieldIsEmpty, "Credit Score Invalid.");
        return false;
    }

    public boolean isDouble(){
        return true;
    }


    public boolean validNumber(){
        String regex = "[0-9, /,]+";

        if(txtIncome.getText().contains(regex) && txtCreditScore.getText().contains(regex)){
            return true;
        }
        JLabel lblFieldIsEmpty = new JLabel("");
        lblFieldIsEmpty.setForeground(Color.RED);
        lblFieldIsEmpty.setBounds(165, 414, 663, 26);
        JOptionPane.showMessageDialog(lblFieldIsEmpty, "Income and/or Credit Score not valid");
        return false;

    }





    public void setData(){
        //student = applyCreditSearch.getter();
        creditApplication = creditAppReview.getter();
        txtFname.setText(creditApplication.getFirstName());
        txtLname.setText(creditApplication.getLastName());
        txtAddress.setText(creditApplication.getAddress());
        txtEmail.setText(creditApplication.getEmail());
        txtCity.setText(creditApplication.getCity());
        txtPhone.setText(creditApplication.getPhone());
        txtSSN.setText(String.valueOf(creditApplication.getSSN()));
        txtStuID.setText(String.valueOf(creditApplication.getStudentId()));
        comboBoxstate.setEditable(true);
        comboBoxstate.getModel().setSelectedItem(creditApplication.getState());
        comboBoxstate.setEditable(false);
        comboBoxstate.setEnabled(false);
        txtCreditScore.setText(String.valueOf(creditApplication.getCreditSore()));
        txtIncome.setText(String.valueOf(creditApplication.getIncome()));
    }


    /**
     * reset the text fields to null
     */
    public void resetTextInputs() {
        txtEmail.setText("");
        //txtManID.setText("");
        txtFname.setText("");
        txtLname.setText("");
        txtEmail.setText("");
        //txtPassword.setText("");
        txtPhone.setText("");
        //txtID.setText("");
        txtIncome.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtSSN.setText("");
        txtCreditScore.setText("");
        txtIncome.setText("");
        txtAPR.setText("");
        comboBoxstate.setSelectedIndex(0);
        txtStuID.setText("");

    }


}
