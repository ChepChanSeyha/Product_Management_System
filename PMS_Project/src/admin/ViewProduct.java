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
import product.Product;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewProduct {

	private JFrame frame;
	private JTable table;
	DefaultTableModel model;
	private JTable table_1;
	DefaultTableModel modelProduct= new DefaultTableModel();
	private JButton button;
	private int product_id;
	private Product product;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProduct window = new ViewProduct();
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
	public ViewProduct() {
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
		
		JLabel label = new JLabel("TABLE PRODUCT");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 32));
		label.setBounds(235, 0, 311, 84);
		frame.getContentPane().add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 83, 783, 370);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		table_1 = new JTable();
		table_1.setFillsViewportHeight(true);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int rowSeleted= table_1.getSelectedRow();
					product_id= Integer.parseInt(table_1.getValueAt(rowSeleted, 0).toString());
					try {
						CRUD_Product crud_Product = new CRUD_Product();
						product= crud_Product.find(product_id);
						crud_Product.closeConnection();
						
						UpdateProduct updateProduct = new UpdateProduct();
						updateProduct.setIndextable(rowSeleted);
						updateProduct.setProduct(product);
						updateProduct.setModelProduct(modelProduct);
						updateProduct.getFrame().setVisible(true);
						updateProduct.getName().setText(product.getName());
						updateProduct.getSupplier().setText(product.getSupplier());
						updateProduct.getSale().setText(product.getSale()+"");
						updateProduct.getBuy().setText(product.getBuy()+"");
						updateProduct.getStock().setText(product.getStock());
						
						
					} catch (Exception e) {
						System.out.println(e);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		table_1.setBounds(0, 0, 1123, 538);
		table_1.setModel(modelProduct);
		String[] column1= {"ID","Name","Supplier","Sale","Buy","Stock"};	
		modelProduct.setColumnIdentifiers(column1);
		try {
			CRUD_Product crud = new CRUD_Product();
			crud.findAll(modelProduct);
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
		button.setBounds(12, 25, 134, 37);
		frame.getContentPane().add(button);
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
