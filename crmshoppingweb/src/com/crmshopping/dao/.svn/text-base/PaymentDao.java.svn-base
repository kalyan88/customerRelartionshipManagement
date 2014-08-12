package com.crmshopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crmshopping.dto.Payment;
import com.crmshopping.util.ConnectionFactory;
import com.crmshopping.util.DataAccessException;
import com.crmshopping.util.Utils;

public class PaymentDao {
	
		
		public String createPayment(Payment payment) throws DataAccessException {
			Connection connection = null;
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			String id = null;
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection
						.prepareStatement("SELECT PAYMENTID_SEQ.NEXTVAL FROM DUAL");
				resultSet = statement.executeQuery();
				if (resultSet.next()) {
					id = "PAY" + resultSet.getString(1);

					statement = connection
							.prepareStatement("INSERT INTO PAYMENT(PAYMENTID,CUSTOMERID,SCHEMEID,DATEOFPAYMENT,AMOUNT) VALUES (?,?,?,?,?)");
					statement.setString(1, payment.getPaymentId());
					statement.setString(2, payment.getCustomerId());
					statement.setString(3, payment.getSchemeId());
					statement.setDate(4, new java.sql.Date(payment.getDateOfPayment().getTime()));
					statement.setDouble(5, payment.getAmount());
					
					
					int count = statement.executeUpdate();
					if (count == 0) {
						id = null;
					}
				}
				return id;

			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataAccessException("Could not insert payment");
			} catch (DataAccessException e) {
				e.printStackTrace();
				throw new DataAccessException("Could not insert payment");
			} finally {
				ConnectionFactory.close(connection, statement, resultSet);
			}

		}





public boolean updatePayment(Payment payment) throws DataAccessException {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	try {
		connection = ConnectionFactory.getConnection();

		statement = connection
				.prepareStatement("UPDATE PAYMENT SET NAME=? WHERE PAYMENTID=?");
		statement.setString(1, payment.getPaymentId());
		statement.setString(2, payment.getCustomerId());
		statement.setString(3, payment.getSchemeId());
		statement.setDate(4, new java.sql.Date(payment.getDateOfPayment().getTime()));
		statement.setDouble(5, payment.getAmount());
		int count = statement.executeUpdate();
		return count>0;

	} catch (SQLException e) {
		e.printStackTrace();
		throw new DataAccessException("Could not insert payment");
	} catch (DataAccessException e) {
		e.printStackTrace();
		throw new DataAccessException("Could not insert payment");
	} finally {
		ConnectionFactory.close(connection, statement, resultSet);
	}
}


public Payment getPaymentById(String PaymentId) throws DataAccessException {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
    Payment payment=null;
	try {
		connection = ConnectionFactory.getConnection();

		statement = connection
				.prepareStatement("SELECT PAYMENTID,CUSTOMERID,SCHEMEID,DATEOFPAYMENT,AMOUNT FROM PAYMENT WHERE PAYMENTID=?");
		statement.setString(1, PaymentId);
		
		resultSet = statement.executeQuery();
		if (resultSet.next()) {
			payment=new Payment();
			payment.setPaymentId(resultSet.getString(1));
			payment.setCustomerId(resultSet.getString(2));
			payment.setSchemeId(resultSet.getString(3));
			payment.setDateOfPayment(Utils.sqlToUtil(resultSet.getDate(4)));
			payment.setAmount(resultSet.getDouble(5));
		}
		return payment;
	} catch (SQLException e) {
		e.printStackTrace();
		throw new DataAccessException("Could not insert payment");
	} catch (DataAccessException e) {
		e.printStackTrace();
		throw new DataAccessException("Could not insert payment");
	} finally {
		ConnectionFactory.close(connection, statement, resultSet);
	}
}

}


