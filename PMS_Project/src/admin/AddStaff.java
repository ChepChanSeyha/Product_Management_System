package admin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import staff.CRUD_Staff;
import staff.Staff;
import javax.swing.JComboBox;

public class AddStaff {

	private JFrame frame;
	private JTextField username;
	private JTextField password;
	@SuppressWarnings("rawtypes")
	private JComboBox position;
	private JTextField contact;
	private JTextField salary;
	private JTextField gender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStaff window = new AddStaff();
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
	public AddStaff() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 627);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("$");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button.setBounds(346, 363, 50, 38);
		frame.getContentPane().add(button);
		
		JLabel lblAdminLogin = new JLabel("ADD STAFF");
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblAdminLogin.setBounds(85, 0, 311, 84);
		frame.getContentPane().add(lblAdminLogin);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(39, 90, 134, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(39, 156, 134, 37);
		frame.getContentPane().add(lblPassword);
		
		username = new JTextField();
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		username.setBounds(198, 90, 197, 37);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password.setColumns(10);
		password.setBounds(198, 156, 197, 37);
		frame.getContentPane().add(password);
		
		JLabel lblGender = new JLabel("Position");
		lblGender.setHorizontalAlignment(SwingConstants.LEFT);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGender.setBounds(39, 226, 134, 37);
		frame.getContentPane().add(lblGender);
		
		String[] pos = { "Cashier"};
		position = new JComboBox(pos);
		position.setFont(new Font("Tahoma", Font.PLAIN, 20));
		position.setBounds(198, 226, 197, 37);
		frame.getContentPane().add(position);
		
		contact = new JTextField();
		contact.setHorizontalAlignment(SwingConstants.CENTER);
		contact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contact.setColumns(10);
		contact.setBounds(199, 294, 197, 37);
		frame.getContentPane().add(contact);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setHorizontalAlignment(SwingConstants.LEFT);
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContact.setBounds(40, 294, 134, 37);
		frame.getContentPane().add(lblContact);
		
		salary = new JTextField();
		salary.setHorizontalAlignment(SwingConstants.CENTER);
		salary.setFont(new Font("Tahoma", Font.PLAIN, 20));
		salary.setColumns(10);
		salary.setBounds(198, 363, 152, 37);
		frame.getContentPane().add(salary);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setHorizontalAlignment(SwingConstants.LEFT);
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSalary.setBounds(39, 363, 134, 37);
		frame.getContentPane().add(lblSalary);
		
		JLabel lblGender_1 = new JLabel("Gender");
		lblGender_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblGender_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGender_1.setBounds(39, 435, 134, 37);
		frame.getContentPane().add(lblGender_1);
		
		gender = new JTextField();
		gender.setHorizontalAlignment(SwingConstants.CENTER);
		gender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		gender.setColumns(10);
		gender.setBounds(198, 435, 197, 37);
		frame.getContentPane().add(gender);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
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
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(68, 514, 134, 37);
		frame.getContentPane().add(btnBack);
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if( username.getText().isEmpty() || password.getText().isEmpty() ||  position.getSelectedItem().toString().isEmpty() || contact.getText().isEmpty() 
							|| salary.getText().isEmpty() || gender.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Invalid Information");
						return;
					}
					CRUD_Staff crud = new CRUD_Staff();
					Staff s = new Staff();
					String sname= username.getText();
					String spass= password.getText();
					String sposition= position.getSelectedItem().toString();
					String scontact= contact.getText();
					double ssalary= Double.parseDouble(salary.getText());
					String sgender= gender.getText();
					
					switch (add.getText()) {
					case "Add":	
							Staff staffCreate= new Staff(0, sname, spass, sposition, scontact, ssalary, sgender);
							if(crud.create(staffCreate)>0) {
								JOptionPane.showMessageDialog(null, "You have created a Staff Record");
							}else {
								JOptionPane.showMessageDialog(null, "Invalid Information");
							}
							
						break;
					case "Update":
						Staff staffUpdate= new Staff(s.getId(), sname, spass, sposition, scontact, ssalary, sgender);
						if(crud.create(staffUpdate)>0) {
							JOptionPane.showMessageDialog(null, "You have updated a Staff Record");
						}else {
							JOptionPane.showMessageDialog(null, "Invalid Information");
						}
						
						break;
					default:
						break;
					}
					
					getFrame().dispose();
					ViewStaff view = new ViewStaff();
					view.getFrame().setVisible(true);
					
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		add.setFont(new Font("Tahoma", Font.BOLD, 20));
		add.setBounds(262, 514, 134, 37);
		frame.getContentPane().add(add);
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

	public JTextField getTextField_3() {
		return contact;
	}

	public void setTextField_3(JTextField textField_3) {
		this.contact = textField_3;
	}

	public JTextField getTextField_4() {
		return salary;
	}

	public void setTextField_4(JTextField textField_4) {
		this.salary = textField_4;
	}
}
