package com.koku.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.koku.pojo.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public User findUserByUsername(String username) {
		User userTemp = new User();
		// use jdbc to connect mysql(kokudb)
		String url = "jdbc:mysql://localhost/kokudb";
		String user = "root";
		String password = "123456";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			// get drivermanager
			Class.forName("com.mysql.cj.jdbc.Driver");
			// get connectiong
			conn = DriverManager.getConnection(url, user, password);
			// sql to get a user from username
			String userSql = "select * from user where username = ?";
			statement = conn.prepareStatement(userSql);
			statement.setString(1, username);
			// get resultset
			rs = statement.executeQuery();
			// loop fo resultset to get all of student
			while (rs.next()) {
	
				userTemp.setUsername(rs.getString("username"));
				userTemp.setPassword(rs.getString("password"));
				userTemp.setAuth(rs.getString("auth"));
				userTemp.setRegisterdate(rs.getString("registerdate"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// do not forget to close the resultset,statement,connection
			try {
				rs.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// return the list of the student
		return userTemp;
	}

	@Override
	public int createUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUserByUsername(String username) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
