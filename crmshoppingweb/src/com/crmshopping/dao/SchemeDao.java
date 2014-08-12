package com.crmshopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crmshopping.dto.Scheme;
import com.crmshopping.util.ConnectionFactory;
import com.crmshopping.util.DataAccessException;


public class SchemeDao {

	public String createPayment(Scheme scheme) throws DataAccessException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String id = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection
					.prepareStatement("SELECT SCHEMEID_SEQ.NEXTVAL FROM DUAL");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				id = "SCH" + resultSet.getString(1);

				statement = connection
						.prepareStatement("INSERT INTO PAYMENT(SCHEMEID,SCHEMEVALIDITY,SCHEMENAME,SCHEMEDETAILS) VALUES (?,?,?,?,?)");
				statement.setString(1, scheme.getSchemeId());
				statement.setString(3, scheme.getValidity());
				statement.setString(2, scheme.getSchemeName());
				statement.setString(4, scheme.getDetails());
				
				
				int count = statement.executeUpdate();
				if (count == 0) {
					id = null;
				}
			}
			return id;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert scheme");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert scheme");
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}

	}



public boolean updateScheme(Scheme scheme) throws DataAccessException {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	try {
		connection = ConnectionFactory.getConnection();

		statement = connection
				.prepareStatement("UPDATE SCHEME SET NAME=? WHERE SCHEMEID=?");
		statement.setString(1, scheme.getSchemeId());
		statement.setString(2, scheme.getValidity());
		statement.setString(3, scheme.getSchemeName());
		statement.setString(4, scheme.getDetails());
		int count = statement.executeUpdate();
		return count>0;

	} catch (SQLException e) {
		e.printStackTrace();
		throw new DataAccessException("Could not insert Scheme");
	} catch (DataAccessException e) {
		e.printStackTrace();
		throw new DataAccessException("Could not insert Scheme");
	} finally {
		ConnectionFactory.close(connection, statement, resultSet);
	}
}

	public Scheme getSchemeById(String SchemeId) throws DataAccessException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
	    Scheme scheme=null;
		try {
			connection = ConnectionFactory.getConnection();

			statement = connection
					.prepareStatement("SELECT PAYMENTID,CUSTOMERID,SCHEMEID,DATEOFPAYMENT,AMOUNT FROM PAYMENT WHERE PAYMENTID=?");
			statement.setString(1, SchemeId);
			
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				scheme=new Scheme();
				scheme.setSchemeId(resultSet.getString(1));
				scheme.setValidity(resultSet.getString(2));
				scheme.setSchemeName(resultSet.getString(3));
				scheme.setDetails(resultSet.getString(4));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert scheme");
		} catch (DataAccessException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}
		return scheme;
	}

	}





