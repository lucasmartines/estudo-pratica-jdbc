package br.com.lucasmdev.exploringApp.dao;

import java.security.InvalidParameterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.lucasmdev.exploringApp.model.user.User;
import br.com.lucasmdev.exploringApp.model.user.UserTableLabels;
import br.com.lucasmdev.exploringApp.model.user.exceptions.FieldIsNullOrEmptyException;
import br.com.lucasmdev.exploringApp.utils.DbConnector;

public class UserDAO {

	private static final String tableName = "usuarios";
	private static final String idField = "id";

/*
 * get the quantity of users in database */
	public static int count() throws SQLException {
		return GetQtdUsers();
	}
/*
 * get the quantity of users in database */
	public static int GetQtdUsers() throws SQLException {
		int qtd = 0;
		Connection connection = DbConnector.getConnection()  ;
		
		ResultSet resultRow = connection
		  .createStatement()
		  .executeQuery( "select count("+ idField+ ") as qtd from "+tableName);
		
		resultRow.next();		
		
		qtd = resultRow.getInt("qtd");
 		return qtd;
	}
/*
 * delete user 
 * it will delete a user using user.id parameter
 * it return true if someone in database has been deleted
 * or return false 
 * */
	public static boolean DeleteUser( User user ) 
		throws FieldIsNullOrEmptyException, SQLException {
		
		validateUserParam( user );
		
		ValidateString(
			user.getId().toString()
		);
		
		
		Connection connection = DbConnector.getConnection()  ;
		
		String sql = "DELETE FROM " + tableName 
			+ " WHERE " + idField + "=?";// + user.getId();
		
		PreparedStatement stmt =
				connection.prepareStatement(sql);
		stmt.setInt( 1 , user.getId() );
		
		int deleteCount = stmt.executeUpdate(  );
		
		stmt.close();
		
		if(  deleteCount > 0) {
			return true;
		}
		else{
			return false;
		}
		
	}


/**
 * Find a user by id if not found then return null
 **/
	public static User getUserById( Integer userId ) throws SQLException {
		
		
		Connection connection = DbConnector.getConnection()  ;
		
		String sql = 
				"SELECT * FROM " + tableName 
				+ " where " + idField + " =  ? " 
				+ " LIMIT 1";
		
		PreparedStatement stmt = 
				connection
				.prepareStatement(sql);
		
		stmt.setString( 1 , userId.toString() );
		
		ResultSet result = stmt
				.executeQuery( );
		
		/*if not find user*/
		if( !result.first()) {
			return null;
		}
		
		User newUser = new User(
			result.getInt( 1),
			result.getString(2),
			result.getString(3),
			result.getDate(4)
		);
		
		return newUser;
	}

	
/*
 * update user or lunch exception  of fieldIsNullOrEmptyException
 * */
	public static void updateUser( User user ) 
			throws FieldIsNullOrEmptyException, SQLException 
	{
		
		validateUserParam( user );
		
		ValidateStrings(
			user.getNome(),
			user.getIdade ().toString(),
			user.getTelefone().toString()
		);
		
		Connection c = DbConnector.getConnection()  ;

		String sql = "UPDATE " + tableName + " SET " 
			+ " nome=? ,"
			+ " telefone=? ,"
			+ " idade=? "
			+ " where " + idField + " = " + user.getId() ;
	
		PreparedStatement stmt = c.prepareStatement( 
			sql
		) ;
				
		stmt.setString( 1 , user.getNome() );
		stmt.setString( 2 , user.getTelefone() );
		stmt.setDate( 3 ,
			new java.sql.Date( user.getIdade().getTime() ) );
		
		stmt.execute();
		
		stmt.close();
			
	}
	

/*
 * Insert user or throw an FieldIsNullOrEmpty Exception
 * */
	public static void insertUser( User user ) 
			throws SQLException, FieldIsNullOrEmptyException {
		
		if( user == null) { // tested
			throw new InvalidParameterException("User cannot be null");
		}
		
		Connection c = DbConnector.getConnection()  ;
		
		ValidateStrings(
			user.getNome(),
			user.getIdade ().toString(),
			user.getTelefone().toString()
		);
		
		PreparedStatement stmt = c.prepareStatement( "INSERT INTO " + tableName 
		+ " ( nome , telefone , idade ) VALUES ( ? , ? , ?)" );
		
		stmt.setString( 1 , user.getNome() );
		stmt.setString( 2 , user.getTelefone() );
		stmt.setDate( 3 ,
			new java.sql.Date( user.getIdade().getTime() ) );
		
		stmt.execute();
		
		c.close();
	}
	
	
/*
 * get all users from database, if there is no user
 * i will receive a empty list
 */
	public static ArrayList<User> getUsers( ) throws SQLException {
		
		ResultSet userRows = DbConnector
			.getConnection()
			.createStatement()
			.executeQuery( "SELECT * FROM " + tableName);
		
		ArrayList<User> users = new ArrayList<>();
		
		
		
		/* while we have users, fetch all*/
		while( userRows.next() ) {
			
			User userFromDb = new User( 
				userRows.getInt   ( UserTableLabels.ID.get() ), 
				userRows.getString( UserTableLabels.NAME.get() ), 
				userRows.getString( UserTableLabels.TEL.get() ), 
				userRows.getDate  ( UserTableLabels.AGE.get() ) 
			);
						
			users.add( userFromDb );
		}
		
		
		userRows.close();
		
		return users;
	}

	
/************_____________**********_____________****************/
/************_____________VALIDATION_____________****************/
/************_____________**********_____________****************/

/**
 * Check if the @param  field is null or empty
 * if it is then lunch FieldIsNullOrEmptyException 
 * */
	public static void ValidateString( String field ) throws FieldIsNullOrEmptyException {
		
		if( field == "" || field == null) {
			throw new FieldIsNullOrEmptyException(field);
		}
	}
	
/**
* Check if the fields is null or empty
* if it is then lunch FieldIsNullOrEmptyException 
**/	
	
	
	public static void ValidateStrings( String ... fields ) throws FieldIsNullOrEmptyException {
		for( String field : fields) {
			ValidateString( field );
		}
	}


/**
 * check if user param is not null or if id is not null
 * if it is null then luch a InvalidParameterException
 **/
	public static void validateUserParam(User user) {
		if( user == null || 
			user.getId() == null   ) { // tested
			
			throw new InvalidParameterException(
				"User object or parameter user.id cannot be null");
		}		
	}

}
