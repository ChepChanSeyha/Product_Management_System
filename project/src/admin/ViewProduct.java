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
						UpdateProduct updateProduct = new UpdateProduct();
						updateProduct.getFrame().setVisible(true);
						
						CRUD_Product crud = new CRUD_Product();
						Product gotProduct = crud.find(product_id);
						AddProduct add = new AddProduct();
						add.setProduct(gotProduct);
						add.setFrame(getFrame());
						
						crud.edit(gotProduct);
						
						add.getName().setText(gotProduct.getName());
						
					} catch (Exception e) {
						System.out.println(e);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		table_1.setBounds(0, 0, 1123, 538);
		DefaultTableModel modelProduct= new DefaultTableModel();
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
		
//		JButton Delete = new JButton("Delete");
//		Delete.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					CRUD_Product crud= new CRUD_Product();
//					if(crud.delete(product_id)>0) {
//						JOptionPane.showMessageDialog(null, "You have deleted a Staff Record");
//						getFrame().dispose();
//						ViewProduct view = new ViewProduct();
//						view.getFrame().setVisible(true);
//					}else {
//						JOptionPane.showMessageDialog(null, "Invalid Information");
//					}
//				} catch (Exception e2) {
//					System.out.println(e);
//				}
//			}
//		});
//		Delete.setFont(new Font("Tahoma", Font.BOLD, 20));
//		Delete.setBounds(200, 403, 134, 37);
//		frame.getContentPane().add(Delete);
		
//		JButton update = new JButton("Update");
//		update.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					CRUD_Product crud = new CRUD_Product();
//					AddProduct addp = new AddProduct();
//					String cname= addp.getName().getText();
//					String sup= addp.getSupplier().getText();
//					double csale= Double.parseDouble(addp.getSale().getText());
//					double cbuy= Double.parseDouble(addp.getBuy().getText());
//					String cstock= addp.getStock().getText(); 
//					
//					switch (update.getText()) {
//					case "Update":	
//							Product productUpdate= new Product(0, cname, sup, csale, cbuy, cstock);
//							productUpdate.toString();
//							if(crud.edit(productUpdate)>0) {
//								JOptionPane.showMessageDialog(null, "You have updated a Product.");
//							}else {
//								JOptionPane.showMessageDialog(null, "Invalid Information");
//							}
//						break;
//					
//					default:
//						break;
//					}
//					
//					getFrame().dispose();
//					ViewProduct view = new ViewProduct();
//					view.getFrame().setVisible(true);
//					
//				} catch (Exception e1) {
//					System.out.println(e1);
//				}
//			}
//		});
//		update.setFont(new Font("Tahoma", Font.BOLD, 20));
//		update.setBounds(449, 403, 134, 37);
//		frame.getContentPane().add(update);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
