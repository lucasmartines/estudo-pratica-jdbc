package br.com.lucasmdev.exploringApp.dao;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TestUserDAO {

	@Test
	void TestShouldLuchExceptionWhenInsertUserParameterIsNull() {
		
		Assertions.assertThrows( 
			InvalidParameterException.class, 
			() -> UserDAO.insertUser( null ) );
	}
	@Test
	void TestShouldLuchExceptionWhenUpdateUserParameterIsNull() {
		
		Assertions.assertThrows( 
			InvalidParameterException.class, 
			() -> UserDAO.updateUser( null ) );
	}

}
