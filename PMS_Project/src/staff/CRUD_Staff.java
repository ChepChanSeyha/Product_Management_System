package staff;

import javax.swing.table.DefaultTableModel;

import connection.Connections;

import java.sql.*;

public class CRUD_Staff {

	public CRUD_Staff() {
		super();
	}
	
	Connections ConnectDB = new Connections();
	
	public void findAll(DefaultTableModel model) {
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String[] row= new String[7];
				row[0]= rs.getInt(1)+"";
				row[1]= rs.getString(2);
				row[2]= rs.getString(4);
				row[3]= rs.getString(5);
				row[4]= rs.getDouble(6)+"";
				row[5]= rs.getString(7);
			
				model.addRow(row);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	public Staff find(int id) {
		Staff staff= null;
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("select * from user where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int sid= rs.getInt(1);
				String susername= rs.getString(2);
				String spassword= rs.getString(3);
				String sposition= rs.getString(4);
				String scontact= rs.getString(5);
				double ssalary= rs.getDouble(6);
				String sgender= rs.getString(7);
				staff = new Staff(sid, susername, spassword, sposition, scontact, ssalary, sgender);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return staff;
		
	}
	
	public int create(Staff s) {
		int effectedRow=0;
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("INSERT INTO `user` ( `UserName`, `Password`, `Position`, `Contact`, `Salary`, `Gender`) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setString(1, s.getUsername());
			ps.setString(2, s.getPassword());
			ps.setString(3, s.getPosition());
			ps.setString(4, s.getContact());
			ps.setDouble(5, s.getSalary());
			ps.setString(6, s.getGender());
			effectedRow=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return effectedRow;
	}

	public int edit(Staff s) {
		int effectedRow=0;
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("update user set UserName=?, Password=?, Position=?, Contact=?, Salary=?, Gender=? where ID=?");
			ps.setString(1, s.getUsername());
			ps.setString(2, s.getPassword());
			ps.setString(3, s.getPosition());
			ps.setString(4, s.getContact());
			ps.setDouble(5, s.getSalary());
			ps.setString(6, s.getGender());
			effectedRow=ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return effectedRow;
	}
	
	public int delete(int id) {
		int effectedRow=0;
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("delete from user where ID=? ");
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
