package views;

import model.Manager;
import model.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * application GUI for student with existing account and to apply for a credit card
 */
public class applyCreditStudent extends JFrame {


    private JPanel contentPane;
    private JTextField txtStuID;
    private JTextField txtEmail;
    private JTextField txtPassword;
    public static Student student;
    JPasswordField password = new JPasswordField();
    private List<Student> students = new ArrayList<>(); //holds all students


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    applyCreditStudent frame = new applyCreditStudent();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public applyCreditStudent() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 526, 419);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Student ID");
        lblNewLabel.setBounds(21, 95, 118, 26);
        //contentPane.add(lblNewLabel);

        txtStuID = new JTextField();
        txtStuID.setBounds(170, 92, 186, 32);
        //contentPane.add(txtStuID);
        //txtStuID.setColumns(10);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(21, 154, 118, 26);
        contentPane.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        txtEmail.setBounds(170, 151, 186, 32);
        contentPane.add(txtEmail);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(317, 253, 141, 35);
        contentPane.add(btnSearch);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(104, 253, 141, 35);
        contentPane.add(btnExit);

        password.setColumns(10);
        password.setBounds(170, 200, 186, 32);
        password.setFont(new Font("font", Font.PLAIN, 30));
        password.setEchoChar('*');
        contentPane.add(password);


        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(21, 200, 118, 26);
        contentPane.add(lblPassword);

        students = Manager.getStudents();


        btnExit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                dispose();
            }

            ;
        });

        btnSearch.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {

                if (!textFieldValid()) {
                    return;
                }

               student = getStudents();


                try {
                    if (student != null) {

                        applyCreditStudentFinal applyCredit = new applyCreditStudentFinal();
                        applyCredit.setVisible(true);
                        resetTextInputs();
                        System.out.println(student.getEmail());
                        dispose();

                    }
                } catch (Exception e) {

                    resetTextInputs();
                    JLabel lblFieldIsEmpty = new JLabel("");
                    lblFieldIsEmpty.setForeground(Color.RED);
                    lblFieldIsEmpty.setBounds(165, 414, 663, 26);
                    JOptionPane.showMessageDialog(lblFieldIsEmpty, "Error try again");
                    System.out.println("Error");
                    resetTextInputs();
                    e.printStackTrace();
                    return;
                }


            }
        });
    }


    public Student getStudents(){
        int size = students.size(); //how many students in list
        int id = 0; //ID to search with


        for(int i = 0; i < size; i++){


            if(students.get(i).getEmail().equalsIgnoreCase(txtEmail.getText())){

                student = students.get(i);
                if(student.getPassword().equals(password.getText()))
                    return student;
            }

        } //if target not found throw error
        JLabel usernotfound = new JLabel("Target not found");
        usernotfound.setForeground(Color.RED);
        usernotfound.setBounds(165, 414, 663, 26);
        JOptionPane.showMessageDialog(usernotfound, "Target not found or Password incorrect");

        return null;


    }

    public boolean textFieldValid(){
        if(password.toString().isEmpty() || txtEmail.getText().isEmpty() ){
            return false;
        }

        return true;
    }



    public void resetTextInputs() {
        txtEmail.setText("");
        txtStuID.setText("");
        password.setText("");
        //txtPassword.setText("");

    }

    public static Student getter(){
                return student;
            }



}
