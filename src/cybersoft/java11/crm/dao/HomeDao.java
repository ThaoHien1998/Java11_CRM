package cybersoft.java11.crm.dao;

// dao : Database Access Object

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import cybersoft.java11.crm.config.MySQLConnection;

public class HomeDao {
	public boolean testConnection() {
		Connection connection = MySQLConnection.getConnection();
		if (connection == null) {
			return false;
		}
		return true;
	}
	public boolean checkHealth() {
		boolean result = false;
		Connection connection = MySQLConnection.getConnection();
		if (connection == null) 
			return result;
		
		String test = "select 1 from Dual";
		Statement statement;
		try {
			statement = connection.createStatement();
			result = statement.execute(test);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;	
	}
}
