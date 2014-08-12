package com.crmshopping.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

	public static Connection getConnection() throws DataAccessException{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(
					"jdbc:oracle:thin:@newideas:1521:oracle", "crmshopping", "shopping");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DataAccessException("Cannot create connection");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Cannot create connection");
		} 
	}
	
	public static void close(Connection connection, Statement statement, ResultSet resultSet){
		if (resultSet!=null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement!=null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
