package br.com.fiap.forfun.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.fiap.forfun.BO.Category;

public class CategoryDAO {
	
	public int add(Category cat) {
		
		DAO dao = new DAO();
		try {
			//P SELECIONAR CADA COLUNA("INSERT INTO CATEGORY (IDCATEGORY, CATEGORY, LASTUPDATE) VALUES(1,2,3)");
			PreparedStatement stmt = dao.getConnection()
					.prepareStatement("INSERT INTO CATEGORY VALUES(SQ_IDCATEGORY.NEXTVAL, ?,?)");
			
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			stmt.setString(1, cat.getCategoryName());
			stmt.setDate(2, data);
			return dao.executeCommand(stmt);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		return 0;
		
		
	}

	public List<Category> getAll() {
		DAO dao = new DAO();
		java.util.List<Category> lst = new ArrayList<Category>();
		PreparedStatement stmt;
		try {
			stmt = dao.getConnection().prepareStatement("SELECT * FROM CATEGORY");
			ResultSet rs = null;
			rs = dao.getData(stmt);
			while (rs.next()) {
				Category c = new Category();
				c.setIdCategory(rs.getInt("idcategory"));
				c.setCategoryName(rs.getString("CATEGORY"));
				lst.add(c);
			 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return lst;
		
	}
	
	public int delete (int idCategory) {
		DAO dao = new DAO();
		PreparedStatement stmt;
		try {
			stmt = dao.getConnection().prepareStatement("DELETE FROM CATEGORY WHERE IDCATEGORY = ?");
			stmt.setInt(1, idCategory);
			return dao.executeCommand(stmt);
		
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		}
		return 0;
	
	}
	
	public int update (Category cat) {
		DAO dao = new DAO();
		PreparedStatement stmt;
		try {
			stmt = dao.getConnection().prepareStatement("UPDATE CATEGORY SET CATEGORY = ?, LASTUPDATE = ? WHERE IDCATEGORY = ? ");
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			stmt.setString(1, cat.getCategoryName());
			stmt.setDate(2, data);
			stmt.setInt(3, cat.getIdCategory());
			return dao.executeCommand(stmt);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return 0;
	}
}
