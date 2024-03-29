package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import product.CRUD_Product;
import staff.CRUD_Staff;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewStaff {

	private JFrame frame;
	private JTable table;
	DefaultTableModel model;
	private JTable table_1;
	private JButton button;
	private int staff_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStaff window = new ViewStaff();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewStaff() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("TABLE STAFF");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 32));
		label.setBounds(235, 0, 311, 84);
		frame.getContentPane().add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 83, 783, 371);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int rowSeleted= table_1.getSelectedRow();
				staff_id= Integer.parseInt(table_1.getValueAt(rowSeleted, 0).toString());
			}
		});
		table_1.setBounds(0, 0, 1123, 538);
		DefaultTableModel modelStaff= new DefaultTableModel();
		table_1.setModel(modelStaff);
		String[] column1= {"ID", "Username", "Position", "Contact", "Salary", "Gender"};	
		modelStaff.setColumnIdentifiers(column1);
		try {
			CRUD_Staff crud = new CRUD_Staff();
			crud.findAll(modelStaff);
		} catch (Exception e) {
			System.out.println(e);
		}
		scrollPane.setViewportView(table_1);
		
		button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AdminSection admin = new AdminSection();
					admin.getFrame().setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBounds(12, 13, 134, 37);
		frame.getContentPane().add(button);
		
		JButton Delete = new JButton("Delete");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CRUD_Staff crud = new CRUD_Staff();
					if(crud.delete(staff_id)>0) {
						JOptionPane.showMessageDialog(null, "You have deleted a Staff Record");
						getFrame().dispose();
						ViewStaff view = new ViewStaff();
						view.getFrame().setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Invalid Information");
					}
				} catch (Exception e2) {
					System.out.println(e);
				}
			}
		});
		Delete.setFont(new Font("Tahoma", Font.BOLD, 20));
		Delete.setBounds(636, 13, 134, 37);
		frame.getContentPane().add(Delete);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
