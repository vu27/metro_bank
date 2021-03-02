package views;

import model.Employee;
import model.Manager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddManagerGUI extends JFrame {

    private JPanel contentPane;
    private JTextField txtFname;
    private JTextField txtLname;
    private JTextField txtStreetAddress;
    private JTextField txtCity;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JTextField txtSocialSecurity;
    private JTextField txtSalary;
    private JPasswordField textPassword;
    private JComboBox comboBoxstate;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddManagerGUI frame = new AddManagerGUI();
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
    public AddManagerGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1049, 599);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtFname = new JTextField();
        txtFname.setColumns(10);
        txtFname.setBounds(174, 43, 269, 55);
        contentPane.add(txtFname);

        txtLname = new JTextField();
        txtLname.setColumns(10);
        txtLname.setBounds(587, 43, 295, 55);
        contentPane.add(txtLname);

        JLabel lblFname = new JLabel("First Name");
        lblFname.setHorizontalAlignment(SwingConstants.CENTER);
        lblFname.setBounds(42, 50, 133, 41);
        contentPane.add(lblFname);

        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
        lblLastName.setBounds(448, 50, 133, 41);
        contentPane.add(lblLastName);

        JLabel lblstreet = new JLabel("Street Address");
        lblstreet.setHorizontalAlignment(SwingConstants.CENTER);
        lblstreet.setBounds(21, 123, 154, 41);
        contentPane.add(lblstreet);

        txtStreetAddress = new JTextField();
        txtStreetAddress.setColumns(10);
        txtStreetAddress.setBounds(174, 116, 269, 55);
        contentPane.add(txtStreetAddress);

        JLabel lblcity = new JLabel("City");
        lblcity.setHorizontalAlignment(SwingConstants.CENTER);
        lblcity.setBounds(21, 199, 154, 41);
        contentPane.add(lblcity);

        txtCity = new JTextField();
        txtCity.setColumns(10);
        txtCity.setBounds(174, 192, 269, 55);
        contentPane.add(txtCity);

        comboBoxstate = new JComboBox();
        comboBoxstate.setModel(new DefaultComboBoxModel(new String[]{"Select", "Alabama", "Alaska", "Arizona",
                "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii",
                "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
                "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
                "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
                "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee",
                "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"}));
        comboBoxstate.setMaximumRowCount(51);
        comboBoxstate.setBounds(587, 192, 295, 48);
        contentPane.add(comboBoxstate);

        JLabel lblstate = new JLabel("State");
        lblstate.setHorizontalAlignment(SwingConstants.CENTER);
        lblstate.setBounds(444, 195, 149, 48);
        contentPane.add(lblstate);

        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        txtEmail.setBounds(174, 261, 269, 55);
        contentPane.add(txtEmail);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail.setBounds(21, 268, 154, 41);
        contentPane.add(lblEmail);

        txtPhone = new JTextField();
        txtPhone.setColumns(10);
        txtPhone.setBounds(587, 261, 295, 55);
        contentPane.add(txtPhone);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhone.setBounds(448, 268, 154, 41);
        contentPane.add(lblPhone);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(174, 444, 282, 55);
        contentPane.add(btnExit);

        JButton btnAddManager = new JButton("Add Manager");
        btnAddManager.setBounds(587, 444, 282, 55);
        contentPane.add(btnAddManager);

        txtSocialSecurity = new JTextField();
        txtSocialSecurity.setColumns(10);
        txtSocialSecurity.setBounds(587, 116, 269, 55);
        contentPane.add(txtSocialSecurity);

        JLabel lblSocialSecurity = new JLabel("Social Security");
        lblSocialSecurity.setHorizontalAlignment(SwingConstants.CENTER);
        lblSocialSecurity.setBounds(439, 123, 154, 41);
        contentPane.add(lblSocialSecurity);

        txtSalary = new JTextField();
        txtSalary.setColumns(10);
        txtSalary.setBounds(587, 337, 295, 55);
        contentPane.add(txtSalary);

        JLabel lblSalary = new JLabel("Salary");
        lblSalary.setHorizontalAlignment(SwingConstants.CENTER);
        lblSalary.setBounds(448, 351, 154, 41);
        contentPane.add(lblSalary);

        textPassword = new JPasswordField();
        textPassword.setColumns(10);
        textPassword.setBounds(174, 337, 269, 55);
        textPassword.setFont(new Font("font", Font.PLAIN, 30));
        textPassword.setEchoChar('*');
        contentPane.add(textPassword);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setBounds(21, 344, 154, 41);
        contentPane.add(lblPassword);

        btnAddManager.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                addManagerBtnClicked();
            }

            ;
        });
    }

//	private JTextField txtFname;
//	private JTextField txtLname;
//	private JTextField txtStreetAddress;
//	private JTextField txtCity;
//	private JTextField txtEmail;
//	private JTextField txtPhone;
//	private JTextField txtSocialSecurity;
//	private JTextField txtSalary;

    public boolean isTextFieldsValid() {
        // Verify all fields have values
        if (txtFname.getText().isBlank()
                || txtLname.getText().isBlank()
                || txtStreetAddress.getText().isBlank()
                || txtCity.getText().isBlank()
                || txtEmail.getText().isBlank()
                || txtPhone.getText().isBlank()
                || txtSocialSecurity.getText().isBlank()
                || txtSalary.getText().isBlank()
                || String.valueOf(comboBoxstate.getSelectedItem()).isBlank()
                || textPassword.getText().isBlank()) {

            JLabel lblFieldIsEmpty = new JLabel("");
            lblFieldIsEmpty.setForeground(Color.RED);
            lblFieldIsEmpty.setBounds(165, 414, 663, 26);
            JOptionPane.showMessageDialog(lblFieldIsEmpty, "Input fields cannot be empty.");
        }

        return true;
    }

    public void addManagerBtnClicked() {
        if (isTextFieldsValid()) {
            Manager newManager = new Manager(0, txtFname.getText(),
                    txtLname.getText(),
                    txtPhone.getText(),
                    txtEmail.getText(),
                    textPassword.getText(),
                    Double.parseDouble(txtSalary.getText()),
                    Integer.parseInt(txtSocialSecurity.getText()),
                    txtStreetAddress.getText(),
                    txtCity.getText(),
                    String.valueOf(comboBoxstate.getSelectedItem()));

            Manager.addManager(newManager);
            resetFields();

            JLabel lblAddSuccess = new JLabel("");
            lblAddSuccess.setForeground(Color.RED);
            lblAddSuccess.setBounds(165, 414, 663, 26);
            JOptionPane.showMessageDialog(lblAddSuccess, "New manager added successfully.");
        }
    }

    public void resetFields() {
        txtFname.setText("");
        txtLname.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        textPassword.setText("");
        txtSalary.setText("");
        txtSocialSecurity.setText("");
        txtStreetAddress.setText("");
        txtCity.setText("");
        comboBoxstate.setSelectedIndex(0);
    }
}