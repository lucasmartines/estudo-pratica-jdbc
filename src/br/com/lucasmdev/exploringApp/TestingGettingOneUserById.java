package br.com.lucasmdev.exploringApp;

import java.sql.SQLException;

import br.com.lucasmdev.exploringApp.dao.UserDAO;
import br.com.lucasmdev.exploringApp.model.user.User;
import br.com.lucasmdev.exploringApp.model.user.exceptions.FieldIsNullOrEmptyException;
import br.com.lucasmdev.exploringApp.utils.DbConnector;

public class TestingGettingOneUserById {

	public static void main(String[] args) throws SQLException, FieldIsNullOrEmptyException {
		
		DbConnector.connect();
		System.out.println("Connected");
		
		User u = UserDAO.getUserById(9);

		// and update
		
		//Calendar c = Calendar.getInstance();
		//c.set(1997, 11, 22);
		//u.setIdade( c.getTime() );
		
		//u.setNome("Vitória");
		//UserDAO.updateUser( u  );
		
		System.out.println( u );
	}
}
