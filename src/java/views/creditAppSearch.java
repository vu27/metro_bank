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


/**
 * Finds the credit application
 */
public class creditAppSearch extends JFrame{

    private JPanel contentPane;
    private JTextField txtAppID;
    private JTextField txtEmail;
    private  JTextField txtStuID;
    public static Student student;
    public static CreditApplication creditApp;
    private List<Student> students = new ArrayList<>(); //holds all students
    private List<CreditApplication> creditApplications = new ArrayList<>(); //holds all credit applications

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    creditAppSearch frame = new creditAppSearch();
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
    public creditAppSearch() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 526, 419);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Application ID");
        lblNewLabel.setBounds(21, 95, 118, 26);
        //contentPane.add(lblNewLabel);

        txtAppID = new JTextField();
        txtAppID.setBounds(170, 92, 186, 32);

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
        //contentPane.add(lblOr2);


        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(317, 253, 141, 35);
        contentPane.add(btnSearch);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(104, 253, 141, 35);
        contentPane.add(btnExit);

        creditApplications = Manager.getCreditApplication(); //get all credit applications
        students = Manager.getStudents(); // get all students

        btnExit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                dispose();
            }

            ;
        });

        btnSearch.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {

                try {
                    if(getStudent() != null && getApps() != null){
                        creditAppStatus credit = new creditAppStatus(student); //pass student into new window
                        credit.setVisible(true);
                        dispose();


                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JLabel useriderror = new JLabel("Error");
                    useriderror.setForeground(Color.RED);
                    useriderror.setBounds(165, 414, 663, 26);
                    JOptionPane.showMessageDialog(useriderror, "Error");
                }




            }

            ;
        });


    }


    /**
     * look for student
     * @return student that was being searched for
     */
    public Student getStudent(){
        int size = students.size(); //how many students in list
        int id = 0; //ID to search with


        //check if fields are valid
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
            if(students.get(i).getEmail().equalsIgnoreCase(txtEmail.getText()) ||
                    students.get(i).getId() == Integer.parseInt(txtStuID.getText())){
                student = students.get(i);

                return student;
            }

        } //if target not found throw error
        JLabel usernotfound = new JLabel("Target not found");
        usernotfound.setForeground(Color.RED);
        usernotfound.setBounds(165, 414, 663, 26);
        JOptionPane.showMessageDialog(usernotfound, "Application not found");

        return null;

    }


    /**
     * search for pending credit application
     * @return credit application object
     */
    public CreditApplication getApps(){
        int size = creditApplications.size(); //how many credit apps in list
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
            if(creditApplications.get(i).getEmail().equalsIgnoreCase(txtEmail.getText()) || creditApplications.get(i).getId() == id ||
                    creditApplications.get(i).getStudentId().equals(txtStuID.getText())){
                creditApp = creditApplications.get(i);

                return creditApp;
            }

        } //if target not found throw error
        JLabel usernotfound = new JLabel("Target not found");
        usernotfound.setForeground(Color.RED);
        usernotfound.setBounds(165, 414, 663, 26);
        JOptionPane.showMessageDialog(usernotfound, "Application not found");

        return null;


    }


    /**
     * check if string is all digits
     * @param s string to check
     * @return true if all digits
     */
    public static boolean allDigits(String s) {
        return s.replaceAll("\\d", "").equals("");
    }




}
