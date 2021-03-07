package views;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class applyCredit extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    applyCredit frame = new applyCredit();
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
    public applyCredit() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 350, 465);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JButton btnExisting = new JButton("Existing Account");
	btnExisting.setBounds(69, 101, 205, 41);
	contentPane.add(btnExisting);

	JButton btnNew = new JButton("New Account");
	btnNew.setBounds(69, 163, 205, 41);
	contentPane.add(btnNew);

	JButton btnExit = new JButton("Exit");
	btnExit.setBounds(69, 225, 205, 41);
	contentPane.add(btnExit);

	btnExisting.addMouseListener(new MouseAdapter() {
	    public void mouseClicked(MouseEvent arg0) {
		//WinBuilder.applyCreditExisting applyCreditExist = new WinBuilder.applyCreditExisting();
		applyCreditSearch search = new applyCreditSearch();
		search.setVisible(true);
		//applyCreditExist.setVisible(true);
		dispose();
	    }

	    ;
	});

	btnNew.addMouseListener(new MouseAdapter() {
	    public void mouseClicked(MouseEvent arg0) {
		WinBuilder.applyCreditNew applycreditnew = new WinBuilder.applyCreditNew();
		applycreditnew.setVisible(true);
		dispose();
	    }

	    ;
	});

	btnExit.addMouseListener(new MouseAdapter() {
	    public void mouseClicked(MouseEvent arg0) {
		dispose();
	    }

	    ;
	});

    }
}
