package admin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import product.CRUD_Product;
import product.Product;

public class UpdateProduct {

	private JFrame frame;
	private JTextField name;
	private JTextField supplier;
	private JTextField sale;
	private JTextField buy;
	private JTextField stock;
	private Product product;
	private DefaultTableModel modelProduct;
	private int indextable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateProduct window = new UpdateProduct();
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
	public UpdateProduct() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 559);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("UPDATE PRODUCT");
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogin.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblAdminLogin.setBounds(85, 0, 311, 84);
		frame.getContentPane().add(lblAdminLogin);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(39, 90, 134, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Supplier");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(39, 156, 134, 37);
		frame.getContentPane().add(lblPassword);
		
		name = new JTextField();
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		name.setBounds(198, 90, 197, 37);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		supplier = new JTextField();
		supplier.setHorizontalAlignment(SwingConstants.CENTER);
		supplier.setFont(new Font("Tahoma", Font.PLAIN, 20));
		supplier.setColumns(10);
		supplier.setBounds(198, 156, 197, 37);
		frame.getContentPane().add(supplier);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idPro= product.getId();
					String namePro= name.getText();
					String supplierPro= supplier.getText();
					double salePro= Double.parseDouble(sale.getText().toString());
					double buyPro= Double.parseDouble(buy.getText().toString());
					String stockPro= stock.getText().toString();
					Product productPro= new Product(idPro, namePro, supplierPro, salePro, buyPro, stockPro);
					
					CRUD_Product crud_Product = new CRUD_Product();
					if(crud_Product.edit(productPro) > 0) {
						modelProduct.setValueAt(productPro.getId(), indextable, 0);
						modelProduct.setValueAt(name.getText(), indextable, 1);
						modelProduct.setValueAt(supplier.getText(), indextable, 2);
						modelProduct.setValueAt(sale.getText(), indextable,3);
						modelProduct.setValueAt(buy.getText(), indextable, 4);
						modelProduct.setValueAt(stock.getText(), indextable, 5);
						getFrame().dispose();
						JOptionPane.showMessageDialog(null, "Is updated");
					};
					
					
				} catch (Exception e2) {
					System.out.println(e);
				}
			}
		});
		update.setFont(new Font("Tahoma", Font.BOLD, 20));
		update.setBounds(262, 443, 134, 37);
		frame.getContentPane().add(update);
		
		JLabel lblGender = new JLabel("Sale");
		lblGender.setHorizontalAlignment(SwingConstants.LEFT);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGender.setBounds(39, 226, 134, 37);
		frame.getContentPane().add(lblGender);
		
		sale = new JTextField();
		sale.setHorizontalAlignment(SwingConstants.CENTER);
		sale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sale.setColumns(10);
		sale.setBounds(198, 226, 197, 37);
		frame.getContentPane().add(sale);
		
		buy = new JTextField();
		buy.setHorizontalAlignment(SwingConstants.CENTER);
		buy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buy.setColumns(10);
		buy.setBounds(199, 294, 197, 37);
		frame.getContentPane().add(buy);
		
		JLabel lblContact = new JLabel("Buy");
		lblContact.setHorizontalAlignment(SwingConstants.LEFT);
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContact.setBounds(40, 294, 134, 37);
		frame.getContentPane().add(lblContact);
		
		stock = new JTextField();
		stock.setHorizontalAlignment(SwingConstants.CENTER);
		stock.setFont(new Font("Tahoma", Font.PLAIN, 20));
		stock.setColumns(10);
		stock.setBounds(198, 363, 197, 37);
		frame.getContentPane().add(stock);
		
		JLabel lblSalary = new JLabel("Stock");
		lblSalary.setHorizontalAlignment(SwingConstants.LEFT);
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSalary.setBounds(39, 363, 134, 37);
		frame.getContentPane().add(lblSalary);
		
		JButton btnBack = new JButton("Delete");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CRUD_Product crud_Product = new CRUD_Product();
					if(crud_Product.delete(product.getId()) >0) {
						modelProduct.removeRow(getIndextable());
						getFrame().dispose();
						JOptionPane.showMessageDialog(null, "Is Deleted");
						crud_Product.closeConnection();
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
		btnBack.setBounds(70, 443, 134, 37);
		frame.getContentPane().add(btnBack);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTextField() {
		return name;
	}

	public void setTextField(JTextField textField) {
		this.name = textField;
	}

	public JTextField getTextField_1() {
		return supplier;
	}

	public void setTextField_1(JTextField textField_1) {
		this.supplier = textField_1;
	}

	public JTextField getTextField_2() {
		return sale;
	}

	public void setTextField_2(JTextField textField_2) {
		this.sale = textField_2;
	}

	public JTextField getTextField_3() {
		return buy;
	}

	public void setTextField_3(JTextField textField_3) {
		this.buy = textField_3;
	}

	public JTextField getTextField_4() {
		return stock;
	}

	public void setTextField_4(JTextField textField_4) {
		this.stock = textField_4;
	}

	public JTextField getName() {
		return name;
	}

	public void setName(JTextField name) {
		this.name = name;
	}

	public JTextField getSupplier() {
		return supplier;
	}

	public void setSupplier(JTextField supplier) {
		this.supplier = supplier;
	}

	public JTextField getSale() {
		return sale;
	}

	public void setSale(JTextField sale) {
		this.sale = sale;
	}

	public JTextField getBuy() {
		return buy;
	}

	public void setBuy(JTextField buy) {
		this.buy = buy;
	}

	public JTextField getStock() {
		return stock;
	}

	public void setStock(JTextField stock) {
		this.stock = stock;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

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
	
}