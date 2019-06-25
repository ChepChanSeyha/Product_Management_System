package connections;

import java.sql.*;

public class ConnectDB {
	
	private Connection connection;
	public ConnectDB() {
		super();
		this.initialConnection();
	}
	public void initialConnection() {
		try {
			 this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms_project?verifyServerCertificate=false&useSSL=true", "CalvinSey", "Seyha192837");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void closeConnection() {
		try {
			this.connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Connection getConnection() {
		return connection;
	}

}
