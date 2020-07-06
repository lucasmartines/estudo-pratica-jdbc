package br.com.lucasmdev.exploringApp.utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbConnector 
{
	private static Connection c = null;
	
	public static Connection connect() throws SQLException 
	{
		if( c == null) 
		{
			c = DriverManager.getConnection(
					"jdbc:mysql://localhost/padaria", /*connection string with driver mysql*/
					"root",/*user*/
					"");/*pass*/
		}
		
		return c;
	}
	
	public static void close() throws SQLException {
		c.close();
	}
	public static Connection getConnection() {
		return c;
	}


	public static void setConnection(Connection c) {
		DbConnector.c = c;
	}



}
