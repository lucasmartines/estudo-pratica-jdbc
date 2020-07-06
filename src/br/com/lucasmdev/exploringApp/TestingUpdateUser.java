package br.com.lucasmdev.exploringApp;

import java.sql.SQLException;
import java.util.Calendar;

import br.com.lucasmdev.exploringApp.dao.UserDAO;
import br.com.lucasmdev.exploringApp.model.user.User;
import br.com.lucasmdev.exploringApp.model.user.exceptions.FieldIsNullOrEmptyException;
import br.com.lucasmdev.exploringApp.utils.DbConnector;

public class TestingUpdateUser {

	public static void main(String[] args)
			throws SQLException, FieldIsNullOrEmptyException {
		
		DbConnector.connect();
		
		User u = new User(
			"Carlos",
			"9868889699", 
			Calendar.getInstance().getTime() );
		
		u.setId(6);
		
		UserDAO.updateUser( u );
		
		DbConnector.close();
	}
}
