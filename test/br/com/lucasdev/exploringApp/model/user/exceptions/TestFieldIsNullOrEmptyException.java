package br.com.lucasdev.exploringApp.model.user.exceptions;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.lucasmdev.exploringApp.dao.UserDAO;
import br.com.lucasmdev.exploringApp.model.user.exceptions.FieldIsNullOrEmptyException;


class TestFieldIsNullOrEmptyException {

	@Test
	void testShouldLunchErrorWhenSomeStringIsEmpty() 
	{
		Assertions
			.assertThrows( 
				FieldIsNullOrEmptyException.class , 
				() -> UserDAO.ValidateStrings( "" , "algim parametro") 
		);	
		Assertions
		.assertThrows( 
			FieldIsNullOrEmptyException.class , 
			() -> UserDAO.ValidateStrings( "" , "") 
	);
	}
	@Test
	void testShouldLunchErrorWhenSomeStringIsNull() {
		
		Assertions
			.assertThrows( FieldIsNullOrEmptyException.class ,
				() -> UserDAO.ValidateStrings( null , "algum parametro")  ) ;
		Assertions
			.assertThrows( FieldIsNullOrEmptyException.class ,
				() -> UserDAO.ValidateStrings( null , null )  ) ;
	}

}
