package admin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import login.Login;

public class AdminSection {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSection window = new AdminSection();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the application.
	 */
	public AdminSection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdminSection = new JLabel("ADMIN SECTION");
		lblAdminSection.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminSection.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblAdminSection.setBounds(78, 13, 326, 84);
		frame.getContentPane().add(lblAdminSection);
		
		JButton btnAddCashier = new JButton("Add Staff");
		btnAddCashier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					AddStaff adds = new AddStaff();
					adds.getFrame().setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
				
			}
		});
		btnAddCashier.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddCashier.setBounds(50, 110, 166, 51);
		frame.getContentPane().add(btnAddCashier);
		
		JButton btnViewCashier = new JButton("View Staff");
		btnViewCashier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ViewStaff viewS = new ViewStaff();
					viewS.getFrame().setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnViewCashier.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnViewCashier.setBounds(50, 188, 166, 51);
		frame.getContentPane().add(btnViewCashier);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Login login = new Login();
					login.getFrame().setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogout.setBounds(158, 266, 166, 51);
		frame.getContentPane().add(btnLogout);
		
		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddProduct addp = new AddProduct();
					addp.getFrame().setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnAddProduct.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddProduct.setBounds(265, 110, 166, 51);
		frame.getContentPane().add(btnAddProduct);
	
		JButton btnViewProduct = new JButton("View Product");
		btnViewProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					admin.ViewProduct view = new admin.ViewProduct();
					view.getFrame().setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnViewProduct.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnViewProduct.setBounds(265, 188, 166, 51);
		frame.getContentPane().add(btnViewProduct);
	}

}
