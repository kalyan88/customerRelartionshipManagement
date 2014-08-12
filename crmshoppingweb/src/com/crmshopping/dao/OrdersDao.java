package com.crmshopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crmshopping.dto.Orders;
import com.crmshopping.util.ConnectionFactory;
import com.crmshopping.util.DataAccessException;
import com.crmshopping.util.Utils;

public class OrdersDao


        {
	
	public String createOrders(Orders orders) throws DataAccessException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String id = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection
					.prepareStatement("SELECT ORDERID_SEQ.NEXTVAL FROM DUAL");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				id = "ORD" + resultSet.getString(1);

				statement = connection
						.prepareStatement("INSERT INTO ORDERS(ORDERID,CUSTOMERID,PRODUCTID,QUANTITY,DATEOFORDER) VALUES (?,?,?,?,?,?,?,?)");
				statement.setString(1, id);
				statement.setString(2, orders.getCustomerId());
				statement.setString(3, orders.getProductId());
				statement.setInt(4, orders.getQuantity());
				statement.setDate(5, new java.sql.Date(orders.getDateOfOrder().getTime()));
			
				int count = statement.executeUpdate();
				if (count == 0) {
					id = null;
				}
			}
			return id;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert orders");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert orders");
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}

	}



public boolean updateOrders(Orders orders) throws DataAccessException {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	try {
		connection = ConnectionFactory.getConnection();

		statement = connection
				.prepareStatement("UPDATE ORDERS SET NAME=? WHERE ORDERID=?");
		statement.setString(1, orders.getOrderId());
		statement.setString(2, orders.getCustomerId());
		statement.setString(3, orders.getProductId());
		statement.setInt(4, orders.getQuantity());
		statement.setDate(5, new java.sql.Date(orders.getDateOfOrder().getTime()));
		
		int count = statement.executeUpdate();
		return count>0;

	} catch (SQLException e) {
		e.printStackTrace();
		throw new DataAccessException("Could not insert orders");
	} catch (DataAccessException e) {
		e.printStackTrace();
		throw new DataAccessException("Could not insert orders");
	} finally {
		ConnectionFactory.close(connection, statement, resultSet);
	}

}

public Orders getAgentById(String OrderId) throws DataAccessException {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	Orders orders=null;
	try {
		connection = ConnectionFactory.getConnection();

		statement = connection
				.prepareStatement("SELECT CUSTOMERID,CUSTOMERNAME FROM CUSTOMER WHERE CUSTOMERID=?");
		statement.setString(1, OrderId);
		resultSet = statement.executeQuery();
		if (resultSet.next()) {
			orders=new Orders();
			orders.setOrderId(resultSet.getString(1));
			orders.setCustomerId(resultSet.getString(2));
			orders.setProductId(resultSet.getString(3));
			orders.setQuantity(resultSet.getInt(4));
			orders.setDateOfOrder(Utils.sqlToUtil(resultSet.getDate(4)));
			
		}
		return orders;
	} catch (SQLException e) {
		e.printStackTrace();
		throw new DataAccessException("Could not insert Orders");
	} catch (DataAccessException e) {
		e.printStackTrace();
		throw new DataAccessException("Could not insert Orders");
	} finally {
		ConnectionFactory.close(connection, statement, resultSet);
	}
}
}
