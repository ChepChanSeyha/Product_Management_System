package product;

import javax.swing.table.DefaultTableModel;

import connection.Connections;

import java.sql.*;

public class CRUD_Product {

	public CRUD_Product() {
		super();
	}
	
	Connections ConnectDB = new Connections();
	
	public void findAll(DefaultTableModel model) {
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("select * from product");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String[] row= new String[6];
				row[0]= rs.getInt(1)+"";
				row[1]= rs.getString(2);
				row[2]= rs.getString(3);
				row[3]= rs.getDouble(4)+"";
				row[4]= rs.getDouble(5)+"";
				row[5]= rs.getString(6);
				model.addRow(row);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	public Product find(int id) {
		Product product= null;
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("select * from product where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int cid= rs.getInt(1);
				String cname= rs.getString(2);
				String csup= rs.getString(3);
				double csale= rs.getDouble(4);
				double cbuy= rs.getDouble(5);
				String cstock= rs.getString(6);
				product = new Product(cid, cname, csup, csale, cbuy, cstock);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return product;
		
	}
	
	public int create(Product p) {
		int effectedRow=0;
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("INSERT INTO `product` ( `Name`, `Supplier`, `Sale`, `Buy`, `Stock`) VALUES (?, ?, ?, ?, ?)");
			ps.setString(1, p.getName());
			ps.setString(2, p.getSupplier());
			ps.setDouble(3, p.getSale());
			ps.setDouble(4, p.getBuy());
			ps.setString(5, p.getStock());
			effectedRow=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return effectedRow;
	}

	public int edit(Product p) {
		int effectedRow=0;
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("update product set Name=?, Supplier=?, Sale=?, Buy=?, Stock=? where ID=?");
			ps.setString(1, p.getName());
			ps.setString(2, p.getSupplier());
			ps.setDouble(3, p.getSale());
			ps.setDouble(4, p.getBuy());
			ps.setString(5, p.getStock());
			ps.setInt(6, p.getId());
			effectedRow= ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return effectedRow;
	}
	
	public int delete(int id) {
		int effectedRow=0;
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("DELETE FROM product WHERE ID=? ");
			ps.setInt(1, id);
			effectedRow= ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return effectedRow;
	}
	
	public void closeConnection() {
		this.ConnectDB.closeConnection();
	}
}
