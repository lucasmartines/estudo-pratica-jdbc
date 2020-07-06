package br.com.lucasmdev.exploringApp.model.user.exceptions;

public class FieldIsNullOrEmptyException extends Exception {

	private static final long serialVersionUID = 1L;

	public FieldIsNullOrEmptyException(String field) {
		super("Field["+ field+"] cannot be null or Empty");
		
	}
}
