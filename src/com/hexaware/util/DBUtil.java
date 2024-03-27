package com.hexaware.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * The DBUtil class provides utility methods for working with the database.
 */
public class DBUtil {
	 /**
     * Retrieves a connection to the database.
     * 
     * @return a Connection object representing the database connection
     */
	static Connection con;
	public static Connection getDBConn(){
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crime","root","lokesh1908");
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		return con;
		
		
	}
	 /**
     * Main method for testing the database connection.
     * 
     * @param args command line arguments (not used)
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getDBConn());
	}

}

