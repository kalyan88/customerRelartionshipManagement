package com.crmshopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crmshopping.dto.Agent;
import com.crmshopping.dto.Agentproduct;
import com.crmshopping.dto.Product;
import com.crmshopping.util.ConnectionFactory;
import com.crmshopping.util.DataAccessException;

public class ProductDao {


	public String createProduct(Product product) throws DataAccessException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String id = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection
					.prepareStatement("SELECT PRODUCTID_SEQ.NEXTVAL FROM DUAL");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				id = "PROD" + resultSet.getString(1);

				statement = connection
						.prepareStatement("INSERT INTO PRODUCT(PRODUCTID,SCHEMEID,CATEGORYID,NAME,DESCRIPTION,COST) VALUES (?,?,?,?,?,?)");
				statement.setString(1, id);
				statement.setString(2, product.getSchemeId());
				statement.setString(3, product.getCategoryId());
				statement.setString(4, product.getName());
				statement.setString(5, product.getDescription());
				statement.setDouble(6, product.getCost());
				
				int count = statement.executeUpdate();
				if (count == 0) {
					id = null;
				}
			}
			return id;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert product");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert product");
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}

	}
	
	public boolean updateProduct(Product product) throws DataAccessException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();

			statement = connection
					.prepareStatement("UPDATE PRODUCT SET NAME=? WHERE PRODUCTID=?");
			statement.setString(1, product.getProductId());
			statement.setString(2, product.getSchemeId());
			statement.setString(3, product.getCategoryId());
			statement.setString(4, product.getName());
			statement.setString(5, product.getDescription());
			statement.setDouble(6, product.getCost());
			int count = statement.executeUpdate();
			return count>0;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert Product");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert Product");
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}
	}
	
	public Product getProductById(String ProductId) throws DataAccessException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Product product=null;
		try {
			connection = ConnectionFactory.getConnection();

			statement = connection
					.prepareStatement("SELECT PRODUCTID,SCHEMEID,CATEGORYID,NAME,DESCRIPTION,COST FROM CUSTOMER WHERE CUSTOMERID=?");
			statement.setString(1, ProductId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				product=new Product();
				product.setProductId(resultSet.getString(1));
				product.setSchemeId(resultSet.getString(2));
				product.setCategoryId(resultSet.getString(3));
				product.setName(resultSet.getString(4));
				product.setDescription(resultSet.getString(5));
				product.setCost(resultSet.getDouble(6));
			}
			return product;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert Product");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert Product");
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}
	}

	public ArrayList<Product> getProductByCategoryId(String categoryId) throws DataAccessException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			connection = ConnectionFactory.getConnection();

			statement = connection
					.prepareStatement(" SELECT PRODUCTID,NAME,DESCRIPTION,COST,SCHEMEID,CATEGORYID FROM PRODUCT WHERE CATEGORYID=?");
			
			statement.setString(1, categoryId);
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Product product=new Product();
				product.setProductId(resultSet.getString(1));
				product.setName(resultSet.getString(2));
				product.setDescription(resultSet.getString(3));
				product.setCost(resultSet.getDouble(4));
				product.setSchemeId(resultSet.getString(5));
				product.setCategoryId(resultSet.getString(6));
				System.out.println("prd:"+product.getName());
				products.add(product);
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException();
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException();
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}
	}

	public Agent getAgentByProductId(String productId) throws DataAccessException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Agent agent=null;
		try {
			connection = ConnectionFactory.getConnection();

			statement = connection
					.prepareStatement("SELECT AGENT.AGENTID, AGENT.CONTACT FROM AGENT LEFT OUTER JOIN AGENTPRODUCT ON AGENT.AGENTID=AGENTPRODUCT.AGENTID WHERE AGENTPRODUCT.PRODUCTID=?");
			
			statement.setString(1, productId);
			
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				 agent=new Agent();
				agent.setAgentId(resultSet.getString(1));
				agent.setContact(resultSet.getString(2));	
			}
			return agent;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException();
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException();
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}
		
	}

}
	
	
	
	
	
