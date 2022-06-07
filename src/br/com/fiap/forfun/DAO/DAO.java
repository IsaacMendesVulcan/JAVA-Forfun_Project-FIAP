package br.com.fiap.forfun.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

	private Connection conn;
	
	public DAO () {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		//TODO
		openConnection();
		return this.conn;
	}
	
	public void openConnection() {
		try {
			if (this.conn == null) {
				this.conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM92508", "060697");
			}
			System.out.println("Conexão está aberta");
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
	}
	
	
	public static void main(String[] args) {
		DAO dao =  new DAO();
		dao.openConnection();
	}
	
	private void closeConnection() {
		try {
			if (this.conn != null) {
				this.conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int executeCommand(PreparedStatement stmt) {
		int j = 0;
		try {
			j = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		return j;
	}
	//Responsável pela busca de dados na base (SELECT)
	public ResultSet getData(PreparedStatement stmt) {
		
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}


}








