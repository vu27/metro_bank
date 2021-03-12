package views;

import model.Manager;
import model.Student;
import model.bank_accounts.CreditApplication;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


public class applyCreditStudentFinal extends JFrame {

    private JPanel contentPane;
    private JTextField txtIncome;
    private JTextField txtCreditScore;
    private JTextField txtPassword;
    public static Student student;
    JPasswordField password = new JPasswordField();
    private List<Student> students = new ArrayList<>(); //holds all students
    private List<CreditApplication> creditApplications = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    applyCreditStudentFinal frame = new applyCreditStudentFinal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public applyCreditStudentFinal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 526, 419);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Salary");
        lblNewLabel.setBounds(21, 95, 118, 26);
        contentPane.add(lblNewLabel);

        txtIncome = new JTextField();
        txtIncome.setBounds(170, 92, 186, 32);
        contentPane.add(txtIncome);
        txtIncome.setColumns(10);

        JLabel lblEmail = new JLabel("Credit Score");
        lblEmail.setBounds(21, 154, 118, 26);
        contentPane.add(lblEmail);

        txtCreditScore = new JTextField();
        txtCreditScore.setColumns(10);
        txtCreditScore.setBounds(170, 151, 186, 32);
        contentPane.add(txtCreditScore);

        JButton btnFinish = new JButton("Finish");
        btnFinish.setBounds(317, 253, 141, 35);
        contentPane.add(btnFinish);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(104, 253, 141, 35);
        contentPane.add(btnExit);




        btnExit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                dispose();
            }

            ;
        });

        btnFinish.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {

                if(textFieldValid()){
                    Student student = applyCreditStudent.getter();

                    String income = txtIncome.getText().replaceAll("[$,]", "");
                    String date = Instant.now().toString();

                    if(ifAppExists(student)){
                        dispose();
                        return;
                    }
                    CreditApplication creditApplication = new CreditApplication(0,student.getFname(), student.getLname(),
                            student.getAddress(),student.getCity(),
                            student.getEmail(), student.getPhone(), student.getState(),
                            student.getSsn(), Integer.parseInt(txtCreditScore.getText()),Double.parseDouble(income),
                            student.getPassword(), String.valueOf(student.getId()),
                            "In review", date);

                    Manager.processApp(creditApplication);
                    JLabel lblAddSuccess = new JLabel("");
                    lblAddSuccess.setForeground(Color.RED);
                    lblAddSuccess.setBounds(165, 414, 663, 26);
                    JOptionPane.showMessageDialog(lblAddSuccess, "Application Created");
                    dispose();
                }





            }

            ;
        });


    }

    public boolean textFieldValid(){
        if(txtCreditScore.getText().isEmpty() || txtIncome.getText().isEmpty()){
            JLabel lblAddSuccess = new JLabel("");
            lblAddSuccess.setForeground(Color.RED);
            lblAddSuccess.setBounds(165, 414, 663, 26);
            JOptionPane.showMessageDialog(lblAddSuccess, "Fill in all fields");
            return false;
        }


        return true;
    }


    public boolean ifAppExists(Student student){

        creditApplications = Manager.getCreditApplication();

        for(int i = 0; i < creditApplications.size(); i++){
            if(creditApplications.get(i).getEmail().equals(student.getEmail())){
                JLabel lblAddSuccess = new JLabel("");
                lblAddSuccess.setForeground(Color.RED);
                lblAddSuccess.setBounds(165, 414, 663, 26);
                JOptionPane.showMessageDialog(lblAddSuccess, "Application Already Exisits");
                return true;
            }
        }


        return false;
    }


}
