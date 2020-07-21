package org.login.data;

// Imports needed.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.login.beans.User;

public class UserDAO implements UserDAOInterface{
	
	// Establish Connection variable.
	Connection conn = null;
	
	// Attempt connection method.
	public Connection getConnection() {
		try {
			// Need this for some reason, learned from MVC project.
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");
			return conn;
		}
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// Will input a new User into the database.
	@Override
	public User inputUser(User user) {
		
		// User insert attempt.
		try {
			// Get Connection using connection method.
			getConnection();
			
			// Inserting values to create a new User into the User table. 
			PreparedStatement statementVar = conn.prepareStatement("INSERT INTO users (First_Name, Last_Name, Username, Age, DOB, Gender, Email, Phone_Number, ASVAB_Score, Branch_Id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			statementVar.setString(1, user.getFirstName());
			statementVar.setString(2, user.getLastName());
			statementVar.setString(3, user.getUsername());
			statementVar.setInt(4, user.getAge());
			statementVar.setString(5, user.getDob());
			statementVar.setString(6, user.getGender());
			statementVar.setString(7, user.getEmail());
			statementVar.setString(8, user.getPhoneNumber());
			statementVar.setInt(9, user.getAsvabScore());
			statementVar.setInt(10, user.getBranch_id());
			
			// Update query.
			statementVar.executeUpdate();
			
			
		}
		
		// Boiler try/catch/finally from this point on.
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Could not input into table, error occurred in UserDAO.inputUser().");
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
			}
			catch (SQLException e ) {
				e.printStackTrace();
				System.out.println("Could not close connection, or connection did not exist.");
			}
		}
		
		return user;
	}
	
	// Will delete a User from the User data table.
	@Override
	public void deleteUser(int userId) {
		
		// User insert attempt.
		try {
			// Get Connection using connection method.
			getConnection();
			
			// Deletes user by Id.
			PreparedStatement statementVar = conn.prepareStatement("DELETE FROM users WHERE User_Id = ?");
			statementVar.setInt(1, userId);
			
			// Update query.
			statementVar.executeUpdate();
			
		}
		
		// Boiler try/catch/finally from this point on.
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Could not delete from table, error occurred in UserDAO.deleteUser()");
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
			}
			catch (SQLException e ) {
				e.printStackTrace();
				System.out.println("Could not close connection, or connection did not exist.");
			}
		}
	}
	
	// Will pull entire table from User data table.
	@Override
	public List<User> pullTable() {
		
		// Must create a User object to fill and bring to the request.
		List<User> table = new ArrayList<>();
		
		try {
			// Get Connection using connection method.
			getConnection();
			
			PreparedStatement statementVar = conn.prepareStatement("SELECT * FROM users");
			ResultSet rs = statementVar.executeQuery();
			
			while(rs.next()) {
				table.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11)));	
			}
		}
		
		// Boiler try/catch/finally from this point on.
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Could not pull table, problem occured in UserDAO.pullTable().");
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
			}
			catch (SQLException e ) {
				e.printStackTrace();
				System.out.println("Could not close connection, or connection did not exist.");
			}
		}
		
		return table;
		
	}
	
	// Will pull a User from the user table, by Id.
	@Override
	public User pullUserById(int userId) {
		
		// Must create a User object to fill and bring to the request.
		User pulledUser = null;
		
		try {
			getConnection();
			
			// Selects the User by Id and puts it in a result set.
			PreparedStatement statementVar = conn.prepareStatement("SELECT * FROM users WHERE User_Id = ?");
			statementVar.setInt(1, userId);
			ResultSet rs = statementVar.executeQuery();
			
			// This is how we have to bring the resultSet and display it.
			while(rs.next()) {
				pulledUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
			}
		}
		// Boiler try/catch/finally from this point on.
		catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Could not pull User, problem occured in UserDAO.pullUserById().");
			}
		finally {
				try {
					if(conn != null) {
						conn.close();
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Could not pull close connection, eiter was not created in the first place or something.");
				}	
			}
		return pulledUser;
	}
	
	// Updates the User by Id in the User table.
	@Override
	public void updateUser(User updatedUser) {
		
		try {
			getConnection();
			
			// Prepared Statement for update, assigning each value.
			PreparedStatement statementVar = conn.prepareStatement("UPDATE users SET First_Name = ? , Last_Name = ?, Username = ?, Age = ?, DOB = ?, Gender = ?, Email = ?, Phone_Number = ?, ASVAB_Score = ?, Branch_Id = ? WHERE User_id = ?");
			statementVar.setString(1, updatedUser.getFirstName());
			statementVar.setString(2, updatedUser.getLastName());
			statementVar.setString(3, updatedUser.getUsername());
			statementVar.setInt(4, updatedUser.getAge());
			statementVar.setString(5, updatedUser.getDob());
			statementVar.setString(6, updatedUser.getGender());
			statementVar.setString(7, updatedUser.getEmail());
			statementVar.setString(8, updatedUser.getPhoneNumber());
			statementVar.setInt(9, updatedUser.getAsvabScore());
			statementVar.setInt(10, updatedUser.getBranch_id());
			statementVar.setInt(11, updatedUser.getUserId());
			statementVar.executeUpdate();
		}
		// BOILERPLATE CODE
		catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Could not input all values.");
			}
		finally {
				try {
					if(conn != null) {
						conn.close();
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Could not close connection, either a connection was never established or an error occurred.");
				}	
			}
		}

}
