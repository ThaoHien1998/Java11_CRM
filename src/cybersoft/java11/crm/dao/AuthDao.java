package cybersoft.java11.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cybersoft.java11.crm.config.MySQLConnection;
import cybersoft.java11.crm.model.User;

public class AuthDao {
	public User login(String email,String password) throws SQLException {
		
		User user = null;
		Connection connection = MySQLConnection.getConnection();
		String query = "select id, email, fullname, address, phone, role_id\r\n" + 
				"from user\r\n" + 
				"where email = ? and password = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet result = preparedStatement.executeQuery();

			while(result.next()) {
				user = new User();
				user.setId(result.getInt("id"));
				user.setEmail(email);
				user.setFullname(result.getString("fullname"));
				user.setAddress(result.getString("address"));
				user.setPhone(result.getString("phone"));

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in select query.");
			e.printStackTrace();
		}finally {
			connection.close();
		}
		
		return user;
	}
}
