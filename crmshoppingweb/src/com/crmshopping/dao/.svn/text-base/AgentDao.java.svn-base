package com.crmshopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crmshopping.dto.Agent;
import com.crmshopping.util.ConnectionFactory;
import com.crmshopping.util.DataAccessException;

public class AgentDao {
	
	public String createAgent(Agent agent) throws DataAccessException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String id = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection
					.prepareStatement("SELECT AGENTID_SEQ.NEXTVAL FROM DUAL");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				id = "A" + resultSet.getString(1);

				statement = connection
						.prepareStatement("INSERT INTO AGENT(AGENTID,PASSWORD,NAME,DOB,GENDER,CONTACT,ADDRESS,EMAIL) VALUES (?,?,?,?,?,?,?,?)");
				statement.setString(1, id);
				statement.setString(2, agent.getPassword());
				statement.setString(3, agent.getName());
				statement.setDate(4, new java.sql.Date(agent.getDob().getTime()));
				statement.setString(5, agent.getGender());
				statement.setString(6, agent.getContact());
				statement.setString(7, agent.getAddress());
				statement.setString(8, agent.getEmail());
				int count = statement.executeUpdate();
				if (count == 0) {
					id = null;
				}
			}
			return id;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert agent");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DataAccessException("Could not insert agent");
		} finally {
			ConnectionFactory.close(connection, statement, resultSet);
		}

	}



public boolean updateAgent(Agent agent) throws DataAccessException {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	try {
		connection = ConnectionFactory.getConnection();

		statement = connection
				.prepareStatement("UPDATE AGENT SET NAME=? WHERE AGENTID=?");
		statement.setString(1, agent.getAgentId());
		statement.setString(2, agent.getPassword());
		statement.setString(3, agent.getName());
		statement.setDate(4, new java.sql.Date(agent.getDob().getTime()));
		statement.setString(5, agent.getGender());
		statement.setString(6, agent.getContact());
		statement.setString(7, agent.getAddress());
		statement.setString(8, agent.getEmail());
		int count = statement.executeUpdate();
		return count>0;

	} catch (SQLException e) {
		e.printStackTrace();
		throw new DataAccessException("Could not insert agent");
	} catch (DataAccessException e) {
		e.printStackTrace();
		throw new DataAccessException("Could not insert agent");
	} finally {
		ConnectionFactory.close(connection, statement, resultSet);
	}

}
public Agent getAgentById(String AgentId) throws DataAccessException {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	Agent agent=null;
	try {
		connection = ConnectionFactory.getConnection();

		statement = connection
				.prepareStatement("SELECT CUSTOMERID,CUSTOMERNAME FROM CUSTOMER WHERE CUSTOMERID=?");
		statement.setString(1, AgentId);
		resultSet = statement.executeQuery();
		if (resultSet.next()) {
			agent=new Agent();
			agent.setAgentId(resultSet.getString(1));
			agent.setPassword(resultSet.getString(2));
			agent.setName(resultSet.getString(3));
			agent.setDob(resultSet.getDate(4));
			agent.setGender(resultSet.getString(5));
			agent.setContact(resultSet.getString(6));
			agent.setAddress(resultSet.getString(7));
			agent.setEmail(resultSet.getString(8));
		}
		return agent;
	} catch (SQLException e) {
		e.printStackTrace();
		throw new DataAccessException("Could not insert Agent");
	} catch (DataAccessException e) {
		e.printStackTrace();
		throw new DataAccessException("Could not insert Agent");
	} finally {
		ConnectionFactory.close(connection, statement, resultSet);
	}
}
}


