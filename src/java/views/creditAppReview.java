package views;

import model.Manager;
import model.Student;
import model.bank_accounts.CreditApplication;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class creditAppReview extends  JFrame{

    private JPanel contentPane;
    private JTextField txtAppID;
    private JTextField txtEmail;
    private  JTextField txtStuID;
    public static Student student;
    public static CreditApplication creditApp;
    private List<Student> students = new ArrayList<>(); //holds all students
    private List<CreditApplication> creditApplications = new ArrayList<>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    creditAppReview frame = new creditAppReview();
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
    public creditAppReview() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 526, 419);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Application ID");
        lblNewLabel.setBounds(21, 95, 118, 26);
        contentPane.add(lblNewLabel);

        txtAppID = new JTextField();
        txtAppID.setBounds(170, 92, 186, 32);
        contentPane.add(txtAppID);
        txtAppID.setColumns(10);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(21, 154, 118, 26);
        contentPane.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        txtEmail.setBounds(170, 151, 186, 32);
        contentPane.add(txtEmail);

        JLabel lblStuID = new JLabel("Student ID");
        lblStuID.setBounds(21, 200, 118, 26);
        contentPane.add(lblStuID);

        txtStuID = new JTextField();
        txtStuID.setColumns(10);
        txtStuID.setBounds(170, 200, 186, 32);
        contentPane.add(txtStuID);


        JLabel lblOr = new JLabel("OR");
        lblOr.setBounds(170, 180, 118, 26);
        contentPane.add(lblOr);
        JLabel lblOr2 = new JLabel("OR");
        lblOr2.setBounds(170, 130, 118, 26);
        contentPane.add(lblOr2);


        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(317, 253, 141, 35);
        contentPane.add(btnSearch);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(104, 253, 141, 35);
        contentPane.add(btnExit);


        //students = Manager.getStudents();
        creditApplications = Manager.getCreditApplication();

        btnExit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                dispose();
            }

            ;
        });

        btnSearch.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {

                try {
                    if(getApps() != null ){
                        creditAppReview2 credit = new creditAppReview2();
                        credit.setVisible(true);
                        //System.out.print("Student found");

                            //applyCreditExisting applycreditexist = new applyCreditExisting();
                            //applycreditexist.setVisible(true);
                            dispose();


                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }




            }

            ;
        });


    }



    public static void setter(Student studentNew){
        student = studentNew;
    }

    public CreditApplication getApps(){
        int size = creditApplications.size(); //how many students in list
        int id = 0; //ID to search with


        if(!txtAppID.getText().isEmpty()){
            if(!allDigits(txtAppID.getText())){ //if Id isnt a number throw error
                JLabel useriderror = new JLabel("must enter a proper ID number");
                useriderror.setForeground(Color.RED);
                useriderror.setBounds(165, 414, 663, 26);
                JOptionPane.showMessageDialog(useriderror, "must enter a proper ID number");
                return null;
            }
            else
                id = Integer.parseInt(txtAppID.getText().toString());
        }

        //search for target in arrayList
        for(int i = 0; i < size; i++){

            // if found set textfields to targets data
            if((creditApplications.get(i).getEmail().equalsIgnoreCase(txtEmail.getText()) || creditApplications.get(i).getId() == id ||
            creditApplications.get(i).getStudentId().equals(txtStuID.getText()) ) ){

                if(creditApplications.get(i).getStatus().equals("Approved") || creditApplications.get(i).getStatus().equals("Denied")){
                    JLabel usernotfound = new JLabel("Application has been processed");
                    usernotfound.setForeground(Color.RED);
                    usernotfound.setBounds(165, 414, 663, 26);
                    JOptionPane.showMessageDialog(usernotfound, "App has been processed already");
                    return null;
                }

                creditApp = creditApplications.get(i);

                return creditApp;
            }

        } //if target not found throw error
        JLabel usernotfound = new JLabel("Target not found");
        usernotfound.setForeground(Color.RED);
        usernotfound.setBounds(165, 414, 663, 26);
        JOptionPane.showMessageDialog(usernotfound, "Target not found");

        return null;


    }

    public static CreditApplication getter(){
        return creditApp;
    }


    public static boolean allDigits(String s) {
        return s.replaceAll("\\d", "").equals("");
    }

    public boolean ifAppExists(CreditApplication creditApplication){

        creditApplications = Manager.getCreditApplication();

        for(int i = 0; i < creditApplications.size(); i++){

            //System.out.println(student.getEmail());

            if(creditApplications.get(i).getEmail().equals(creditApp.getEmail()) ||
                    creditApplications.get(i).getStudentId().equals(String.valueOf(creditApp.getId()))){
                JLabel lblAddSuccess = new JLabel("");
                lblAddSuccess.setForeground(Color.RED);
                lblAddSuccess.setBounds(165, 414, 663, 26);
                JOptionPane.showMessageDialog(lblAddSuccess, "Application Already Exists");
                return true;
            }
        }

        return false;
    }


}
