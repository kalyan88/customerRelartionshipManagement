/**
 * 
 */
package com.crmshopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crmshopping.dto.Language;
import com.crmshopping.util.ConnectionFactory;
import com.crmshopping.util.DataAccessException;

/**
 * @author Administrator
 * 
 */
public class LanguageDao {

	public String createLanguage(Language language) throws DataAccessException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String id = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection
					.prepareStatement("SELECT LANGUAGEID_SEQ.NEXTVAL FROM DUAL");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				id = "LAN" + resultSet.getString(1);

				statement = connection
						.prepareStatement("INSERT INTO LANGUAGE(LANGUAGEID, LANGUAGENAME) VALUES (?,?)");
				statement.setString(1, id);
				statement.setString(2, language.getLanguageName());
				int count = statement.executeUpdate();
				if (count == 0) {
					id = null;
				}
			}
			return id;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert Language");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert Language");
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}
	}

	public boolean updateLanguage(Language language) throws DataAccessException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionFactory.getConnection();

			statement = connection
					.prepareStatement("UPDATE LANGUAGE SET LANGUAGENAME=? WHERE LANGUAGEID=?");
			statement.setString(1, language.getLanguageName());
			statement.setString(2, language.getLanguageId());
			int count = statement.executeUpdate();
			return count>0;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert Language");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert Language");
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}
	}

	public Language getLanguageById(String languageId) throws DataAccessException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Language language=null;
		try {
			connection = ConnectionFactory.getConnection();

			statement = connection
					.prepareStatement("SELECT LANGUAGEID,LANGUAGENAME FROM LANGUAGE WHERE LANGUAGEID=?");
			statement.setString(1, languageId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				language=new Language();
				language.setLanguageId(resultSet.getString(1));
				language.setLanguageName(resultSet.getString(2));
			}
			return language;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert Language");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert Language");
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}
	}

}
