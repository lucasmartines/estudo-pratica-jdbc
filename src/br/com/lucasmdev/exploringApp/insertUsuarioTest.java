package br.com.lucasmdev.exploringApp;

 import java.sql.SQLException;
import java.util.Calendar;
 
import br.com.lucasmdev.exploringApp.dao.UserDAO;
import br.com.lucasmdev.exploringApp.model.user.User;
import br.com.lucasmdev.exploringApp.model.user.exceptions.FieldIsNullOrEmptyException;
import br.com.lucasmdev.exploringApp.utils.DbConnector;

public class insertUsuarioTest {
 	public static void main(String[] args) 
			throws SQLException, FieldIsNullOrEmptyException {
		
		DbConnector.connect();
		
		System.out.println("Connected");
		
		Calendar c  = Calendar.getInstance();		 
		c.set ( 1999,  10, 10 );
		
		
		UserDAO.insertUser( 
			new User( 
				"Idiot", 
				"11966342289",
				 c.getTime()
			)
		);
		
		System.out.println("user inserted");

		DbConnector.close();
		
		
	}
}
