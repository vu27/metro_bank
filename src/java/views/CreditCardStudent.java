package views;

import model.Student;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class CreditCardStudent extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField txtTransfer;
    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    CreditCardStudent frame = new CreditCardStudent();
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
    public CreditCardStudent() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1039, 548);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	scrollPane.setBounds(21, 106, 573, 290);
	contentPane.add(scrollPane);

	table = new JTable();
	table.setModel(new DefaultTableModel(
		new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
			{ null, null, null }, { null, null, null }, { null, null, null }, },
		new String[] { "Cost", "Location", "Date" }));
	table.getColumnModel().getColumn(1).setPreferredWidth(109);
	scrollPane.setViewportView(table);

	txtTransfer = new JTextField();
	txtTransfer.setColumns(10);
	txtTransfer.setBounds(713, 126, 279, 48);
	contentPane.add(txtTransfer);

	JComboBox comboBoxtransfer = new JComboBox();
	comboBoxtransfer.setModel(new DefaultComboBoxModel(new String[] { "Select", "Checking", "Savings" }));
	comboBoxtransfer.setBounds(713, 65, 103, 32);
	contentPane.add(comboBoxtransfer);

	JComboBox comboBoxtransfer2 = new JComboBox();
	comboBoxtransfer2.setModel(new DefaultComboBoxModel(new String[] { "Select", "Credit Card" }));
	comboBoxtransfer2.setBounds(874, 65, 103, 32);
	contentPane.add(comboBoxtransfer2);

	JLabel lblNewLabel = new JLabel("To");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(799, 68, 92, 26);
	contentPane.add(lblNewLabel);

	JLabel lblFrom = new JLabel("From");
	lblFrom.setHorizontalAlignment(SwingConstants.CENTER);
	lblFrom.setBounds(624, 68, 92, 26);
	contentPane.add(lblFrom);

	JLabel lblTotal_1_1 = new JLabel("$");
	lblTotal_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblTotal_1_1.setBounds(624, 118, 142, 64);
	contentPane.add(lblTotal_1_1);

	JButton btnTransfer = new JButton("Transfer");
	btnTransfer.setBounds(763, 224, 142, 35);
	contentPane.add(btnTransfer);

	JButton btnExit = new JButton("Exit");
	btnExit.setBounds(764, 361, 141, 35);
	contentPane.add(btnExit);
	btnExit.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {

		try {

		    // creditCardCustomer creditCard = new creditCardCustomer();
		    // System.exit(0);
		    // creditCard.setVisible(false);
		    // this.
		    // JFrame.DISPOSE_ON_CLOSE;
		    // frame.setVisible(false);
		    dispose();
		    StudentGUI custom = new StudentGUI(new Student());
		    custom.setVisible(true);
		    // System.exit(0);

		} catch (Exception ex) {

		}

	    }
	});

	JLabel lblNewLabel_1 = new JLabel("Credit Card Payment");
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setBounds(139, 21, 238, 48);
	contentPane.add(lblNewLabel_1);
    }
}
