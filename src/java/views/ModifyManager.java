package views;

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
 * this class creates a GUI so the user can edit a manager information by search for the ID or email
 * @since 2021.28.02
 * @author Everyone
 * @version 1.2.5
 */
public class ModifyManager extends JFrame {

    private JPanel contentPane;
    private List<Manager> managers = new ArrayList<>(); //holds all Managers
    private Manager manager;
    private JTextField txtFname2;
    private JTextField txtEmail;
    private JTextField txtManID;
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
                    ModifyManager frame = new ModifyManager();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * creates GUI and implements action listener for buttons
     */
    public ModifyManager(){

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

        txtManID = new JTextField();
        txtManID.setFont(new Font("Tahoma", Font.PLAIN, 30));
        txtManID.setColumns(10);
        txtManID.setBounds(173, 87, 269, 55);
        contentPane.add(txtManID);

        JLabel lblManagerId = new JLabel("Manager ID");
        lblManagerId.setHorizontalAlignment(SwingConstants.CENTER);
        lblManagerId.setBounds(21, 94, 154, 41);
        contentPane.add(lblManagerId);

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

        JLabel lblSearchManager = new JLabel("Search Manager");
        lblSearchManager.setBounds(264, 21, 178, 45);
        contentPane.add(lblSearchManager);

        JLabel lblUpdateManager = new JLabel("Update Manager");
        lblUpdateManager.setBounds(1198, 21, 178, 45);
        contentPane.add(lblUpdateManager);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(174, 263, 199, 55);
        contentPane.add(btnSearch);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(959, 553, 199, 55);
        contentPane.add(btnUpdate);

        txtID = new JTextField();
        txtID.setColumns(10);
        txtID.setBounds(969, 312, 269, 55);
        contentPane.add(txtID);

        JLabel lblSalary = new JLabel("Date Created");
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

        managers = Manager.getManagers(); //get all managers and put into the list

        //searches for manager
        btnSearch.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                getManagers();
            }
        });

        //update the info
        btnUpdate.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {

                updateManager();
                managers = Manager.getManagers();

            }
        });

        //close the window
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
     * get manager by using the ID or email to serach
     */
    public void getManagers(){
        int size = managers.size(); //how many students in list
        int id = 0;


        if(!txtManID.getText().isEmpty()){
            if(!allDigits(txtManID.getText())){
                //System.out.println("error");
                JLabel useriderror = new JLabel("must enter a proper ID number");
                useriderror.setForeground(Color.RED);
                useriderror.setBounds(165, 414, 663, 26);
                JOptionPane.showMessageDialog(useriderror, "must enter a proper ID number");


                return;
            }
            else
                id = Integer.parseInt(txtManID.getText().toString());
        }


        for(int i = 0; i < size; i++){ // loop arraylist until target is found

            //if found set the textfields to the targets data
            if(managers.get(i).getEmail().equalsIgnoreCase(txtEmail.getText()) || managers.get(i).getId() == id){
                manager = managers.get(i);
                txtFname2.setText(manager.getFname());
                txtLName2.setText(manager.getLname());
                txtEmail2.setText(manager.getEmail());
                txtPassword.setText(manager.getPassword());
                textPhone.setText(manager.getPhone());
                txtID.setText(String.valueOf(manager.getId()));
                txtSalary.setText(String.valueOf(manager.getSalary()));
                textAddress.setText(manager.getAddress());
                textCity.setText(manager.getCity());
                textSSN.setText(String.valueOf(manager.getSsn()));
                comboBoxstate2.setEditable(true);
                comboBoxstate2.getModel().setSelectedItem(manager.getState());
                comboBoxstate2.setEditable(false);
                return;
            }

        } //if target not found throw error
        JLabel usernotfound = new JLabel("User not found");
        usernotfound.setForeground(Color.RED);
        usernotfound.setBounds(165, 414, 663, 26);
        JOptionPane.showMessageDialog(usernotfound, "User not found");
    }

    /**
     * update the manager information by passing the text fields to the manager class to update the database
     */
    public void updateManager(){
        int size = managers.size(); //how many students in list

        //check if ID and salary is correct
        if(txtSalary.getText().matches("\\d*\\.?\\d+") && allDigits(txtID.getText())) {
            Manager.updateManager(manager, txtFname2.getText(), txtLName2.getText(), manager.getEmail(),
                    Integer.parseInt(txtID.getText()), textPhone.getText(), txtPassword.getText(),
                    Double.parseDouble(txtSalary.getText()), textAddress.getText(), textCity.getText(),
                    comboBoxstate2.getSelectedItem().toString(), Integer.parseInt(textSSN.getText()));

            resetTextInputs(); // make all text fields blank
        }

        else if(!txtSalary.getText().matches("\\d*\\.?\\d+") || !allDigits(txtID.getText())){
            JLabel useriderror = new JLabel("must enter a proper ID number and/or salary");
            useriderror.setForeground(Color.RED);
            useriderror.setBounds(165, 414, 663, 26);
            JOptionPane.showMessageDialog(useriderror, "must enter a proper ID number and/or salary");
        }

    }


    /**
     * check if string only contains numbers
     * @param s to check
     * @return bool if only contains numbers
     */
    public static boolean allDigits(String s) {
        return s.replaceAll("\\d", "").equals("");
    }

    /**
     * reset the text fields to null
     */
    public void resetTextInputs() {
        txtEmail.setText("");
        txtManID.setText("");
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

}
