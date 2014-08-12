package com.crmshopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crmshopping.dto.Customer;
import com.crmshopping.util.ConnectionFactory;
import com.crmshopping.util.DataAccessException;

public class CustomerDao {

	public boolean createCustomer(Customer customer) throws DataAccessException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String id=null;
		boolean success=true;
		try {
			connection = ConnectionFactory.getConnection();
			
			
				 

				statement = connection
						.prepareStatement("INSERT INTO CUSTOMER(CUSTOMERID,PASSWORD,NAME,DOB,GENDER,CONTACT,ADDRESS,EMAIL) VALUES (?,?,?,?,?,?,?,?)");
				statement.setString(1, customer.getCustomerId());
				statement.setString(2, customer.getPassword());
				statement.setString(3, customer.getName());
				statement.setDate(4, new java.sql.Date(customer.getDob()
						.getTime()));
				statement.setString(5, customer.getGender());
				statement.setString(6, customer.getContact());
				statement.setString(7, customer.getAddress());
				statement.setString(8, customer.getEmail());

				int count = statement.executeUpdate();
				return count>0;
		
		

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert Customer");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert Customer");
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}
		

	}

	public boolean updateCustomer(Customer customer) throws DataAccessException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();

			statement = connection.prepareStatement("UPDATE CUSTOMER SET NAME=? WHERE CUSTOMERID=?");
			statement.setString(1, customer.getCustomerId());
			statement.setString(2, customer.getPassword());
			statement.setString(3, customer.getName());
			statement.setDate(4, new java.sql.Date(customer.getDob().getTime()));
			statement.setString(5, customer.getGender());
			statement.setString(6, customer.getContact());
			statement.setString(7, customer.getAddress());
			statement.setString(8, customer.getEmail());
			int count = statement.executeUpdate();
			return count > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert Customer");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert Customer");
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}
	}

	public Customer getCustomerById(String CustomerId)
			throws DataAccessException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Customer customer = null;
		try {
			connection = ConnectionFactory.getConnection();

			statement = connection.prepareStatement("SELECT CUSTOMERID,PASSWORD,NAME,DOB,GENDER,CONTACT,ADDRESS,EMAIL FROM CUSTOMER WHERE CUSTOMERID=? ");
			statement.setString(1, CustomerId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				customer = new Customer();
				customer.setCustomerId(resultSet.getString(1));
				customer.setPassword(resultSet.getString(2));
				customer.setName(resultSet.getString(3));
				customer.setDob(resultSet.getDate(4));
				customer.setGender(resultSet.getString(5));
				customer.setContact(resultSet.getString(6));
				customer.setAddress(resultSet.getString(7));
				customer.setEmail(resultSet.getString(8));
			}
			return customer;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert Customer");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert Customer");
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}

	}

	public boolean isValidUser(String CustomerId, String Password)
			throws DataAccessException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();

			statement = connection.prepareStatement("SELECT * FROM CUSTOMER WHERE CUSTOMERID=? AND PASSWORD=?");
			statement.setString(1, CustomerId);
			statement.setString(2, Password);
			resultSet = statement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert Customer");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert Customer");
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}
	}

}
