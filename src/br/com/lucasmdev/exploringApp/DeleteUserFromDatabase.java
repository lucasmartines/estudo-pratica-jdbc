package br.com.lucasmdev.exploringApp;

import java.sql.SQLException;

import br.com.lucasmdev.exploringApp.dao.UserDAO;
import br.com.lucasmdev.exploringApp.model.user.User;
import br.com.lucasmdev.exploringApp.model.user.exceptions.FieldIsNullOrEmptyException;
import br.com.lucasmdev.exploringApp.utils.DbConnector;

public class DeleteUserFromDatabase {
	public static void main(String[] args) throws SQLException, FieldIsNullOrEmptyException {
		
		DbConnector.connect();
		
		
		User u = new User();
		u.setId( 15 );
		System.out.println( 
			UserDAO.DeleteUser( u )
		);
		
		DbConnector.close();
		
	}
}
