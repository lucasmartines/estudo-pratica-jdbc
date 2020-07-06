package br.com.lucasmdev.exploringApp;

import java.sql.SQLException;

import br.com.lucasmdev.exploringApp.dao.UserDAO;
import br.com.lucasmdev.exploringApp.utils.DbConnector;

public class TestGetQtdUsers {

	public static void main(String[] args) throws SQLException {
		
		DbConnector.connect();
		
		var qtd = UserDAO.GetQtdUsers();
		
		System.out.println("qtd users: "+qtd);
	}
}
