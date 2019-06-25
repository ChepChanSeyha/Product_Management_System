package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.SwingConstants;

import admin.AdminSection;
import cashier.CashierSection;
import connection.Connections;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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

	public JTextField getTextField() {
		return username;
	}

	public void setTextField(JTextField textField) {
		this.username = textField;
	}

	public JTextField getTextField_1() {
		return password;
	}

	public void setTextField_1(JTextField textField_1) {
		this.password = textField_1;
	}

	/**
	 * Create the application.
	 */
	public Login() {
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
		
		JLabel lblAdminLogin = new JLabel("ADMIN LOGIN");
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblAdminLogin.setBounds(85, 13, 311, 84);
		frame.getContentPane().add(lblAdminLogin);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(65, 136, 134, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(65, 202, 134, 37);
		frame.getContentPane().add(lblPassword);
		
		username = new JTextField();
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		username.setBounds(199, 136, 197, 37);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password.setColumns(10);
		password.setBounds(199, 202, 197, 37);
		frame.getContentPane().add(password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connections connection= new Connections();
				try {
					String query = "SELECT * FROM User WHERE UserName LIKE ? AND Password LIKE ?";
					
					PreparedStatement pStatement= connection.getConnection().prepareStatement(query);
					pStatement.setString(1, username.getText());
					pStatement.setString(2, password.getText());
					ResultSet results= pStatement.executeQuery();
					
					while(results.next()) {
						if(results.getString(4).equals("admin")) {
							AdminSection adminsection = new AdminSection();
							frame.dispose();
							adminsection.getFrame().setVisible(true);
							connection.closeConnection();
							return;
						}
						else if(results.getString(4).equals("cashier")) {
							CashierSection cashiersection = new CashierSection();
							cashiersection.getFrame().setVisible(true);;
							frame.dispose();
							connection.closeConnection();
							return;
						}
					}
					JOptionPane.showMessageDialog(null, "Error! Something went wrong.");
				} catch (Exception e1) {
					System.out.print(e1);
				}
				connection.closeConnection();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.setBounds(262, 269, 134, 37);
		frame.getContentPane().add(btnLogin);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Login login = new Login();
					login.frame.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(82, 269, 134, 37);
		frame.getContentPane().add(btnBack);
	}
}
