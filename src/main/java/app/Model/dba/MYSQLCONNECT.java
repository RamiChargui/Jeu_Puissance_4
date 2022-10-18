package app.Model.dba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MYSQLCONNECT {
	
	private static MYSQLCONNECT myConnection;
	private static Connection conn;
	private MYSQLCONNECT(){
		try {
			conn = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/puissance4?autoReconnect=true&useSSL=false", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getInstance(){
		if(conn==null) {
			myConnection=new MYSQLCONNECT();
			return myConnection.conn;
		}
		return myConnection.conn;
	}
	

}
