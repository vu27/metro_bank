package views;

import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ManagerViewAllStudents extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    ManagerViewAllStudents frame = new ManagerViewAllStudents();
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
    public ManagerViewAllStudents() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 993, 520);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	Panel panel = new Panel();
	// JScrollPane scrPane = new JScrollPane(panel);
	panel.setBounds(10, 117, 707, 219);

	contentPane.add(panel);
	// contentPane.add(scrPane);

	table = new JTable();
	table.addMouseListener(new MouseAdapter() { // reacts to clicking on the Jtable
	    @Override
	    public void mouseClicked(MouseEvent mouseEvent) {
		JTable table = (JTable) mouseEvent.getSource();
		Point point = mouseEvent.getPoint();
		int row = table.rowAtPoint(point);
		int column = table.getSelectedColumn();

		if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) { // double click to trigger

		    System.out.println(row);
		    System.out.println(column);
		    String value = table.getModel().getValueAt(row, column).toString();
		    System.out.println(value);

		    // maybe open account view when double click on the table

		    //

		}

		// int column = table.getSelectedColumn();
		// int row = table.getSelectedRow();
		// String value = table.getModel().getValueAt(row, column).toString();
		// System.out.println(value);
	    }
	});
	table.setBounds(9, 5, 503, 284);
	table.setModel(new DefaultTableModel(new String[][] { { "Anthony", "Nguyen", null, null, null },
		{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
		{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
		{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
		{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
		{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
		{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
		{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
		{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
		{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
		{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
		{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
		{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, },
		new String[] { "First Name", "Last Name", "Address", "City", "Phone" }) {
	    boolean[] columnEditables = new boolean[] { false, false, false, false, false };

	    public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	    }
	});
	table.getColumnModel().getColumn(0).setPreferredWidth(130);
	table.getColumnModel().getColumn(1).setPreferredWidth(116);
	table.getColumnModel().getColumn(2).setPreferredWidth(107);
	JTableHeader header = table.getTableHeader();
	panel.setLayout(null);
	JScrollPane pane = new JScrollPane(table);
	pane.setBounds(0, 0, 520, 200);
	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	panel.add(pane);

	JLabel lblNewLabel = new JLabel("View All Student");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(195, 52, 276, 41);
	contentPane.add(lblNewLabel);

	JButton btnNewButton = new JButton("Exit");
	btnNewButton.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {

		try {

		    dispose();
		    dispose();

		} catch (Exception ex) {

		}

	    }
	});
	btnNewButton.setBounds(787, 346, 180, 82);
	contentPane.add(btnNewButton);
	// frame.add(panel);
	// JScrollPane pane = new JScrollPane(table);
	// panel.setLayout(null);

	// scroll_table = new JScrollPane(table);

	// panel.add(table);

	// Scrollbar scrollbar = new Scrollbar();
	// scrollbar.setBounds(486, 5, 34, 214);
	// panel.add(scrollbar);
    }
}
