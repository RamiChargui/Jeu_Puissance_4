package app.Model.dba;

import java.sql.Connection;
import java.util.List; 
public abstract class DAO<T>{
	MYSQLCONNECT connection = null;
	Connection conn;
	public DAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=connection.getInstance();
			
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Execption");
		}
		
	}
	public Connection getconnection() {
		return conn;
	}
	public abstract T create(T t);
	public abstract T Find(int id);
	public abstract T Delete(T t);
	public abstract List<T> FindAll();
	

}
