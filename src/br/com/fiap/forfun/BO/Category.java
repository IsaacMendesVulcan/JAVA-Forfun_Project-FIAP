package br.com.fiap.forfun.BO;

import java.sql.Date;

public class Category {
	
	private int idCategory;
	private String categoryName;
	private Date lastUpdate;
	
	
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", categoryName=" + categoryName + ", lastUpdate=" + lastUpdate
				+ "]";
	}

	
}


