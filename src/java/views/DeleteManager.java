package views;

import model.Employee;
import model.Manager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Search and delete the Manager from the databse
 */
public class DeleteManager extends JFrame{


    private JPanel contentPane;
    private JTextField txtEmpID;
    private Manager manager; //manager that was searched
    private List<Manager> managers = new ArrayList<>(); //holds all managers
    private JTextField txtEmail;
    private JTextField txtFname2;
    private JTextField txtLName2;
    private JTextField txtEmail2;
    private JTextField txtID;
    private JTextField txtSalary;
    private JTextField txtPassword;
    private JTextField textPhone;
    private JTextField textAddress;
    private JTextField textCity;
    private JTextField textSSN;
    private  JComboBox comboBoxstate2 = new JComboBox();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteManager frame = new DeleteManager();
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
    public DeleteManager() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1723, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblstreet = new JLabel("Email");
        lblstreet.setHorizontalAlignment(SwingConstants.CENTER);
        lblstreet.setBounds(21, 167, 154, 41);
        contentPane.add(lblstreet);

        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 30));
        txtEmail.setColumns(10);
        txtEmail.setBounds(174, 160, 513, 55);
        contentPane.add(txtEmail);

        JLabel lblstate = new JLabel("State");
        lblstate.setHorizontalAlignment(SwingConstants.CENTER);
        lblstate.setBounds(1248, 472, 149, 48);
        contentPane.add(lblstate);

        txtEmpID = new JTextField();
        txtEmpID.setFont(new Font("Tahoma", Font.PLAIN, 30));
        txtEmpID.setColumns(10);
        txtEmpID.setBounds(173, 87, 269, 55);
        contentPane.add(txtEmpID);

        JLabel lblEmployeeId = new JLabel("Manager ID");
        lblEmployeeId.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmployeeId.setBounds(21, 94, 154, 41);
        contentPane.add(lblEmployeeId);

        txtFname2 = new JTextField();
        txtFname2.setColumns(10);
        txtFname2.setBounds(969, 87, 269, 55);
        contentPane.add(txtFname2);

        txtLName2 = new JTextField();
        txtLName2.setColumns(10);
        txtLName2.setBounds(1382, 87, 295, 55);
        contentPane.add(txtLName2);

        JLabel lblFname_1 = new JLabel("First Name");
        lblFname_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblFname_1.setBounds(837, 94, 133, 41);
        contentPane.add(lblFname_1);

        JLabel lblLastName_1 = new JLabel("Last Name");
        lblLastName_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblLastName_1.setBounds(1243, 94, 133, 41);
        contentPane.add(lblLastName_1);

        JLabel lblstreet_1 = new JLabel("Email");
        lblstreet_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblstreet_1.setBounds(816, 167, 154, 41);
        contentPane.add(lblstreet_1);

        txtEmail2 = new JTextField();
        txtEmail2.setColumns(10);
        txtEmail2.setBounds(969, 160, 708, 55);
        contentPane.add(txtEmail2);

        comboBoxstate2.setModel(new DefaultComboBoxModel(new String[] { "Select", "Alabama", "Alaska", "Arizona",
                "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii",
                "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
                "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
                "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
                "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee",
                "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" }));
        comboBoxstate2.setMaximumRowCount(54);
        comboBoxstate2.setBounds(1386, 472, 295, 48);
        contentPane.add(comboBoxstate2);

        txtPassword = new JTextField();
        txtPassword.setColumns(10);
        txtPassword.setBounds(969, 236, 269, 55);
        contentPane.add(txtPassword);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setBounds(816, 243, 154, 41);
        contentPane.add(lblPassword);

        textPhone = new JTextField();
        textPhone.setColumns(10);
        textPhone.setBounds(1382, 236, 295, 55);
        contentPane.add(textPhone);

        JLabel lblPhone_1 = new JLabel("Phone");
        lblPhone_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhone_1.setBounds(1243, 243, 154, 41);
        contentPane.add(lblPhone_1);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(174, 553, 199, 55);
        contentPane.add(btnExit);

        JLabel lblSearchEmployee = new JLabel("Search Manager");
        lblSearchEmployee.setBounds(264, 21, 178, 45);
        contentPane.add(lblSearchEmployee);

        JLabel lblUpdateEmployee = new JLabel("Delete Manager");
        lblUpdateEmployee.setBounds(1198, 21, 178, 45);
        contentPane.add(lblUpdateEmployee);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(174, 263, 199, 55);
        contentPane.add(btnSearch);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(959, 553, 199, 55);
        contentPane.add(btnDelete);

        JLabel lblEmployeeId_1_1 = new JLabel("Manager ID");
        lblEmployeeId_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmployeeId_1_1.setBounds(816, 319, 154, 41);
        contentPane.add(lblEmployeeId_1_1);

        txtID = new JTextField();
        txtID.setColumns(10);
        txtID.setBounds(969, 312, 269, 55);
        contentPane.add(txtID);

        JLabel lblSalary = new JLabel("Salary");
        lblSalary.setHorizontalAlignment(SwingConstants.CENTER);
        lblSalary.setBounds(1243, 319, 154, 41);
        contentPane.add(lblSalary);

        txtSalary = new JTextField();
        txtSalary.setColumns(10);
        txtSalary.setBounds(1382, 312, 295, 55);
        contentPane.add(txtSalary);

        textAddress = new JTextField();
        textAddress.setColumns(10);
        textAddress.setBounds(969, 388, 708, 55);
        contentPane.add(textAddress);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
        lblAddress.setBounds(816, 395, 154, 41);
        contentPane.add(lblAddress);

        textCity = new JTextField();
        textCity.setColumns(10);
        textCity.setBounds(969, 465, 295, 55);
        contentPane.add(textCity);

        JLabel lblCity = new JLabel("City");
        lblCity.setHorizontalAlignment(SwingConstants.CENTER);
        lblCity.setBounds(816, 472, 154, 41);
        contentPane.add(lblCity);

        textSSN = new JTextField();
        textSSN.setColumns(10);
        textSSN.setBounds(1382, 553, 295, 55);
        contentPane.add(textSSN);

        JLabel lblSSN = new JLabel("SSN");
        lblSSN.setHorizontalAlignment(SwingConstants.CENTER);
        lblSSN.setBounds(1222, 560, 154, 41);
        contentPane.add(lblSSN);

        JLabel lblOr = new JLabel("OR");
        lblOr.setHorizontalAlignment(SwingConstants.CENTER);
        lblOr.setBounds(507, 87, 133, 41);
        contentPane.add(lblOr);

        managers = Manager.getManagers(); //gets the managers and put into arraylist

        btnSearch.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                getManager(); //get Manager when user clicks search button
            }
        });

        btnDelete.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                deleteManager(); //delete manager from database
                managers = Manager.getManagers(); //gets a new list with the updated information

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


    }

    /**
     * calls the Manager class to remove the target manager from database
     */
    public void deleteManager(){

        Manager.deleteManager(manager); // run sql script to remove manager from database
        JLabel useriderror = new JLabel("must enter a proper ID number and/or salary");
        useriderror.setForeground(Color.RED);
        useriderror.setBounds(165, 414, 663, 26);
        JOptionPane.showMessageDialog(useriderror, "Manager Deleted");

        resetTextInputs();

    }


    /**
     * updates Manager information into the data base by getting all fields from the txt box
     */

    public void getManager(){
        int size = managers.size(); //how many Employees in list
        int id = 0;

        //checks if ID is null if and check if user only entered digits
        if(!txtEmpID.getText().isEmpty()){
            if(!allDigits(txtEmpID.getText())){
                //System.out.println("error");
                JLabel useriderror = new JLabel("must enter a proper ID number");
                useriderror.setForeground(Color.RED);
                useriderror.setBounds(165, 414, 663, 26);
                JOptionPane.showMessageDialog(useriderror, "must enter a proper ID number");


                return;
            }
            else
                id = Integer.parseInt(txtEmpID.getText().toString());
        }

        // searches through array list for the employee
        for(int i = 0; i < size; i++){

            if(managers.get(i).getEmail().equalsIgnoreCase(txtEmail.getText()) || managers.get(i).getId() == id){
                manager = managers.get(i);
                txtFname2.setText(manager.getFname());
                txtLName2.setText(manager.getLname());
                txtEmail2.setText(manager.getEmail());
                txtPassword.setText(manager.getPassword());
                textPhone.setText(manager.getPhone());
                txtID.setText(String.valueOf(manager.getId()));
                txtSalary.setText(String.valueOf((manager.getSalary())));
                textAddress.setText(manager.getAddress());
                textCity.setText(manager.getCity());
                textSSN.setText(String.valueOf(manager.getSsn()));
                comboBoxstate2.setEditable(true);
                comboBoxstate2.getModel().setSelectedItem(manager.getState());
                comboBoxstate2.setEditable(false);

                setEditable();

                return;
            }
        }
        JLabel usernotfound = new JLabel("User was not found");
        usernotfound.setForeground(Color.RED);
        usernotfound.setBounds(165, 414, 663, 26);
        JOptionPane.showMessageDialog(usernotfound, "User not found");
    }

    /**
     * checks if all are digits
     * @param s string to check
     * @return bool if all are digits
     */
    public static boolean allDigits(String s) {
        return s.replaceAll("\\d", "").equals("");
    }

    /**
     * make all text fields empty
     */
    public void resetTextInputs() {

        txtEmail.setText("");
        txtEmpID.setText("");
        txtFname2.setText("");
        txtLName2.setText("");
        txtEmail2.setText("");
        txtPassword.setText("");
        textPhone.setText("");
        txtID.setText("");
        txtSalary.setText("");
        textAddress.setText("");
        textCity.setText("");
        textSSN.setText("");
        comboBoxstate2.setSelectedIndex(0);
    }

    /**
     * makes all fields un-editable
     */
    public void setEditable(){
        textAddress.setEditable(false);
        txtFname2.setEditable(false);
        txtLName2.setEditable(false);
        txtEmail2.setEditable(false);
        txtPassword.setEditable(false);
        textPhone.setEditable(false);
        txtID.setEditable(false);
        txtSalary.setEditable(false);
        textAddress.setEditable(false);
        textCity.setEditable(false);
        comboBoxstate2.setEnabled(false);

        textSSN.setEditable(false);
    }


}
