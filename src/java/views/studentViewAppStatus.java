package views;
import model.Manager;
import model.Student;
import model.bank_accounts.Credit;
import model.bank_accounts.CreditApplication;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class studentViewAppStatus extends JFrame {

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
    private JTextField txtStatus;
    private Date date = new Date();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    private JComboBox comboBoxstate = new JComboBox();
    private JTextField txtStuID;
    private Student student;
    private CreditApplication creditApplication;
    private JTextField txtAPR;
    private Credit credit;
    private List<CreditApplication> creditApplications = new ArrayList<>();


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    creditAppStatus frame = new creditAppStatus();
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
    public studentViewAppStatus() {
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
        // contentPane.add(txtAPR);

        txtIncome = new JTextField();
        txtIncome.setColumns(10);
        txtIncome.setBounds(163, 463, 225, 49);
        contentPane.add(txtIncome);

        JLabel lblIncome = new JLabel("Income");
        lblIncome.setBounds(43, 464, 111, 49);
        contentPane.add(lblIncome);

        JLabel lblCredit = new JLabel("Comment");
        lblCredit.setBounds(43, 520, 111, 49);
        contentPane.add(lblCredit);

        JLabel lblDollar = new JLabel("$");
        lblDollar.setBounds(143, 520, 111, 49);
        // contentPane.add(lblDollar);

        txtStatus = new JTextField();
        txtStatus.setColumns(10);
        txtStatus.setBounds(163, 520, 225, 49);
        contentPane.add(txtStatus);


        JLabel lblAPR = new JLabel("APR");
        lblAPR.setHorizontalAlignment(SwingConstants.CENTER);
        lblAPR.setBounds(380, 520, 241, 49);
        // contentPane.add(lblAPR);

        JLabel lblPercent = new JLabel("%");
        lblPercent.setHorizontalAlignment(SwingConstants.CENTER);
        lblPercent.setBounds(750, 520, 241, 49);
        // contentPane.add(lblPercent);


        JLabel lblNewLabel = new JLabel("Credit Card Application");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(315, 21, 241, 49);
        contentPane.add(lblNewLabel);


        JButton btnApprove = new JButton("Approve");
        btnApprove.setBounds(750, 600, 150, 42);
        //contentPane.add(btnApprove);

        JButton btnDeny = new JButton("Deny");
        btnDeny.setBounds(600, 600, 150, 42);
        // contentPane.add(btnDeny);


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



        creditApplications = Manager.getCreditApplication();




        try{
            //creditApplication = creditAppSearch.getter();
            //student.getId();
            getData();
            setData();

        } catch (Exception e) {
            e.printStackTrace();

        }




        btnApprove.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                //  approveApplication();
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
                //denyApplication();
            }

            ;
        });

    }






    public void setData(){



        //student = applyCreditSearch.getter();
        creditApplication = creditAppSearch.getter();
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
        //txtCredit.setText(creditApplication.getCreditSore());
        txtCreditScore.setText(String.valueOf(creditApplication.getCreditSore()));
        txtIncome.setText(String.valueOf(creditApplication.getIncome()));
        //txtCredit.setText();
        txtStatus.setText(creditApplication.getStatus());





    }

    public CreditApplication getData(){
        int size = creditApplications.size();

        for(int i = 0; i < size; i++){

            // if found set textfields to targets data
            if(creditApplications.get(i).getStudentId().equals(student.getId())){
                creditApplication = creditApplications.get(i);

                return creditApplication;
            }

        }
        JLabel usernotfound = new JLabel("App not found");
        usernotfound.setForeground(Color.RED);
        usernotfound.setBounds(165, 414, 663, 26);
        JOptionPane.showMessageDialog(usernotfound, "Application Not Found, Now closing");

        dispose();

        return null;
    }


}
