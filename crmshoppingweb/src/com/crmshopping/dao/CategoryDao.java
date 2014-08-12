package com.crmshopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.crmshopping.dto.Category;
import com.crmshopping.util.ConnectionFactory;
import com.crmshopping.util.DataAccessException;

public class CategoryDao {

	public String createCategory(Category category) throws DataAccessException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String id = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection
					.prepareStatement("SELECT CATEGORYID_SEQ.NEXTVAL FROM DUAL");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				id = "CAT" + resultSet.getString(1);

				statement = connection
						.prepareStatement("INSERT INTO CATEGORY(CATEGORYID,CATEGORYNAME,SUPERCATEGORYID) VALUES (?,?,?)");
				statement.setString(1, category.getCategoryId());
				statement.setString(2, category.getCategoryName());
				statement.setString(3, category.getSuperCategoryId());

				int count = statement.executeUpdate();
				if (count == 0) {
					id = null;
				}
			}
			return id;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert category");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert category");
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}

	}

	public boolean updateCategory(Category category) throws DataAccessException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();

			statement = connection
					.prepareStatement("UPDATE CATEGORY SET NAME=? WHERE CATEGORYID=?");
			statement.setString(1, category.getCategoryId());
			statement.setString(2, category.getCategoryName());
			statement.setString(3, category.getSuperCategoryId());
			int count = statement.executeUpdate();
			return count > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert category");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert category");
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}
	}

	public Category getCategoryById(String CategoryId)
			throws DataAccessException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Category category = null;
		try {
			connection = ConnectionFactory.getConnection();

			statement = connection
					.prepareStatement("SELECT CATEGORYRID,CATEGORYNAME,SUPERCATEGORYID FROM CATEGORY WHERE CATEGORYID=?");
			statement.setString(1, CategoryId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				category = new Category();
				category.setCategoryId(resultSet.getString(1));
				category.setCategoryName(resultSet.getString(2));
				category.setSuperCategoryId(resultSet.getString(3));
			}
			return category;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert category");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert category");
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}
	}

	public ArrayList<Category> getAllCategories(String superCategoryId)
			throws DataAccessException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		ArrayList<Category> categories = new ArrayList<Category>();
		try {
			connection = ConnectionFactory.getConnection();
			
			String query = "";
			if(superCategoryId == null){
				query =	"SELECT CATEGORYID, CATEGORYNAME FROM CATEGORY WHERE SUPERCATEGORYID IS NULL";
			}else{
			query = "SELECT CATEGORY.CATEGORYID,CATEGORY.CATEGORYNAME,"
					+ "SUPERCATEGORY.CATEGORYID,SUPERCATEGORY.CATEGORYNAME FROM "
					+ "CATEGORY, CATEGORY SUPERCATEGORY WHERE "
					+ "CATEGORY.SUPERCATEGORYID = SUPERCATEGORY.CATEGORYID";
			}
			
			if(superCategoryId != null){
				query = query + " AND CATEGORY.SUPERCATEGORYID = '"+superCategoryId +"'";
			}
			System.out.println("Query in CategoryDao - getAllCategories method is "+query);
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Category category = new Category();
				category.setCategoryId(resultSet.getString(1));
				category.setCategoryName(resultSet.getString(2));
				if(superCategoryId != null){
					category.setSuperCategoryId(resultSet.getString(3));
					category.setSuperCategoryName(resultSet.getString(4));
				}
				categories.add(category);
			}
			return categories;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert category");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert category");
		}catch(Exception e){
			e.printStackTrace();
			throw new DataAccessException("Could not insert category");
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}
	}
}