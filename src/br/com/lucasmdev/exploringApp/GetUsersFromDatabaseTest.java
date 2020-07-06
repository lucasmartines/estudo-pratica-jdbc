package br.com.lucasmdev.exploringApp;

import java.sql.*;
import java.util.ArrayList;

import br.com.lucasmdev.exploringApp.dao.UserDAO;
import br.com.lucasmdev.exploringApp.model.user.User;
import br.com.lucasmdev.exploringApp.utils.DbConnector;

public class GetUsersFromDatabaseTest {

	public static void main(String[] args) throws SQLException {

		
		DbConnector.connect();
		
		System.out.println("Connected");
		
		
		ArrayList<User> users =  UserDAO.getUsers();
		for( User u : users) {
			System.out.println( u );
		}
		
				
		DbConnector.close();
	}

}
