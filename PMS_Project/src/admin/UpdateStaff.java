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
import javax.swing.table.DefaultTableModel;

import staff.CRUD_Staff;
import staff.Staff;
import javax.swing.JComboBox;

public class UpdateStaff {

	private JFrame frame;
	private JTextField username;
	private JTextField password;
	@SuppressWarnings("rawtypes")
	private JComboBox position;
	private JTextField contact;
	private JTextField salary;
	private DefaultTableModel modelStaff;
	
	public JTextField getUsername() {
		return username;
	}

	public void setUsername(JTextField username) {
		this.username = username;
	}

	public JTextField getPassword() {
		return password;
	}

	public void setPassword(JTextField password) {
		this.password = password;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getPosition() {
		return position;
	}

	@SuppressWarnings("rawtypes")
	public void setPosition(JComboBox position) {
		this.position = position;
	}

	public JTextField getContact() {
		return contact;
	}

	public void setContact(JTextField contact) {
		this.contact = contact;
	}

	public JTextField getSalary() {
		return salary;
	}

	public void setSalary(JTextField salary) {
		this.salary = salary;
	}

	public JTextField getGender() {
		return gender;
	}

	public void setGender(JTextField gender) {
		this.gender = gender;
	}

	private JTextField gender;
	private Staff staff;
	private DefaultTableModel modelProduct;
	private int indextable;

	public DefaultTableModel getModelProduct() {
		return modelProduct;
	}

	public void setModelProduct(DefaultTableModel modelProduct) {
		this.modelProduct = modelProduct;
	}

	public int getIndextable() {
		return indextable;
	}

	public void setIndextable(int indextable) {
		this.indextable = indextable;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStaff window = new UpdateStaff();
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
	public UpdateStaff() {
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
		salary.setBounds(198, 363, 197, 37);
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
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idStaff= staff.getId();
					String nameStaff = username.getText();
					String passStaff = password.getText();
					String positionStaff = position.getSelectedItem().toString();
					String contactStaff = contact.getText();
					double salaryStaff= Double.parseDouble(salary.getText().toString());
					String genderStaff = gender.getText();
					Staff staffSta= new Staff(idStaff, nameStaff, passStaff, positionStaff, contactStaff, salaryStaff, genderStaff);
					
					CRUD_Staff crud = new CRUD_Staff();
					if(crud.edit(staffSta) > 0) {
						modelStaff.setValueAt(staffSta.getId(), indextable, 0);
						modelStaff.setValueAt(password.getText(), indextable, 1);
						modelStaff.setValueAt(position.getSelectedItem().toString(), indextable, 2);
						modelStaff.setValueAt(contact.getText(), indextable,3);
						modelStaff.setValueAt(salary.getText(), indextable, 4);
						modelStaff.setValueAt(gender.getText(), indextable, 5);
						getFrame().dispose();
						JOptionPane.showMessageDialog(null, "Is updated");
					};
					
					
				} catch (Exception e2) {
					System.out.println(e);
				}
			}
		});
		update.setFont(new Font("Tahoma", Font.BOLD, 20));
		update.setBounds(262, 514, 134, 37);
		frame.getContentPane().add(update);
		
		JButton btnBack = new JButton("Delete");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CRUD_Staff crud_Staff = new CRUD_Staff();
					if(crud_Staff.delete(staff.getId()) >0) {
						modelProduct.removeRow(getIndextable());
						getFrame().dispose();
						JOptionPane.showMessageDialog(null, "Is Deleted");
						crud_Staff.closeConnection();
					}else{
						JOptionPane.showMessageDialog(null, "Is failed");
					};
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(70, 514, 134, 37);
		frame.getContentPane().add(btnBack);
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

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
}
