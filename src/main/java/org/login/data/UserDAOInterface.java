package org.login.data;
import java.util.List;

// import java.util.List;
import org.login.beans.User;

public interface UserDAOInterface {
	
	// Inputs a User into a table.
	public User inputUser(User user);
	
	// Removes a User from the table.
	public void deleteUser(int userId);
	
	// Pulls entire table for display.
	public List<User> pullTable();
	
	// Create a search by Id.
	public User pullUserById(int userId);
	
	// Updates a single User entry.
	public void updateUser(User updatedUser);
}
