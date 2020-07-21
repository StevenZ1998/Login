package org.login.service;

import java.util.List;
import org.login.beans.User;
import org.login.data.UserDAO;

public class UserService {
	
	// Create DAO object to work with.
	private UserDAO userDAO = new UserDAO();
	
	// Inputs a User in the User table.
	public User inputUser(User user) {
		return userDAO.inputUser(user);
	}
	
	// Deletes a User by Id in the User table.
	public void deleteUser(int userId) {
		userDAO.deleteUser(userId);
	}
	
	// Pulls the entire User table.
	public List<User> pullTable(){
		return userDAO.pullTable();
	}
	
	// Pulls a User, identified by Id.
	public User pullUserById(int userId) {
		return userDAO.pullUserById(userId);
	}
	
	// Updates a User, identified by Id.
	public void updateUser(User updatedUser) {
		userDAO.updateUser(updatedUser);
	}
	
}
