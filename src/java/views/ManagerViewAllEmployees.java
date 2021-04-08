package views;

/**
 * this creates a frame so the user can view all the employees in the MySQL server
 *
 *
 * @version alpha build 1.0.0
 * @date 2020.12.02
 */

import model.Employee;
import model.Manager;

import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ManagerViewAllEmployees extends JFrame {

    private JPanel contentPane;
    private JTable table;
	private List<Employee> employees = new ArrayList<>(); //holds all Employees
	private DefaultTableModel dtm = new DefaultTableModel(0, 0); //default table model

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    ManagerViewAllEmployees frame = new ManagerViewAllEmployees();
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
    public ManagerViewAllEmployees() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 613);
		contentPane = new JPanel(); //create Jpanel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel panel = new Panel(); //create panel to insert the jtable into
		panel.setBounds(10, 117, 1099, 249);
		contentPane.add(panel); //put panel into the Jpanel

		DefaultTableModel tableModel = new DefaultTableModel(); //create table
		table = new JTable(tableModel);
		String header[] =  new String[] { "ID","First Name", "Last Name", "Phone", "Email", "Password", "Salary", "SSN", "Address", "City", "State"  }; // columns name
		dtm.setColumnIdentifiers(header); //set column names to column
		table.setModel(dtm); //set table to default table model
		//for (int count = 1; count <= 2; count++) {
		//	dtm.addRow(new Object[] { null, null, null,
		//			null, null, });
		//}

		table.setBounds(9, 5, 503, 284); //set table to certain size

		//set the width of cells to certain size
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setPreferredWidth(116);
		table.getColumnModel().getColumn(2).setPreferredWidth(96);
		table.getColumnModel().getColumn(3).setPreferredWidth(220);
		table.getColumnModel().getColumn(4).setPreferredWidth(135);
		table.getColumnModel().getColumn(5).setPreferredWidth(135);
		table.getColumnModel().getColumn(6).setPreferredWidth(135);
		table.getColumnModel().getColumn(7).setPreferredWidth(135);
		table.getColumnModel().getColumn(8).setPreferredWidth(160);
		table.getColumnModel().getColumn(9).setPreferredWidth(135);
		table.getColumnModel().getColumn(10).setPreferredWidth(135);
		panel.setLayout(null);
		JScrollPane pane = new JScrollPane(table); // create scroll if table becomes too big
		pane.setBounds(0, 0, 690, 200);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		panel.add(pane); // add scroll to jtable pane

		// create label view students
		JLabel lblNewLabel = new JLabel("View All Employees");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(195, 52, 276, 41);
		contentPane.add(lblNewLabel);

		// create exit button
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {

					dispose(); //close screen
					dispose();

				} catch (Exception ex) {

				}

			}
		});
		btnNewButton.setBounds(714, 439, 180, 82);
		contentPane.add(btnNewButton);
		employees = Manager.getEmployees(); //get employees from function and return it to array list
		updateTable(); // put Employees into table
    }

	/**
	 * update table with employees information
	 */
	public void updateTable(){
		int size = employees.size(); //how many Employeess in list
		dtm.addRow(new Object[]{ null, null, null, null, null });// create empty row

		// put user info into table
		for(int i = 0; i < size; i++){

			table.getModel().setValueAt(employees.get(i).getId(),i,0);
			table.getModel().setValueAt(employees.get(i).getFname(),i,1);
			table.getModel().setValueAt(employees.get(i).getLname(),i,2);
			table.getModel().setValueAt(employees.get(i).getPhone().toString(),i,3);
			table.getModel().setValueAt(employees.get(i).getEmail(),i,4);
			table.getModel().setValueAt("******",i,5); //password is hidden
			table.getModel().setValueAt(employees.get(i).getSalary(),i,6);
			table.getModel().setValueAt(employees.get(i).getSsn(),i,7);
			table.getModel().setValueAt(employees.get(i).getAddress(),i,8);
			table.getModel().setValueAt(employees.get(i).getCity(),i,9);
			table.getModel().setValueAt(employees.get(i).getState(),i,10);
			dtm.addRow(new Object[]{ null, null, null, null, null }); // create a empty row
		}


	}

}
