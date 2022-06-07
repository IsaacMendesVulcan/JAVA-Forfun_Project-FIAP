package br.com.fiap.presentation;

/*import javax.swing.JOptionPane;*/

import br.com.fiap.forfun.BO.Category;
import br.com.fiap.forfun.DAO.CategoryDAO;

public class TesteCategory {
	
	public static void main(String[] args) {
		 Category cat = new Category(); 
		  /*cat.setCategoryName("ESTRATEGIA");*/ 
		 CategoryDAO cDao = new CategoryDAO(); 
		 /*System.out.println("Categoria cadastrada " + cDao.add(cat));
		 * for (Category c : cDao.getAll()) { 
		 * System.out.println(c); 
		 * }
		 */
		 
	    /*int x = Integer.parseInt(JOptionPane.showInputDialog("Deseja alterar qual categoria"));*/
		 
		cat.setIdCategory(88);
		cat.setCategoryName("LUTAS");
		System.out.println(cDao.update(cat));
	}

}
