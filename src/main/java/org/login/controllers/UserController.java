package org.login.controllers;

import java.io.IOException;
import java.util.List;
import org.login.beans.User;
import org.login.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserController {
	
	// Create a User Service object to interact with.
	UserService userService = new UserService();
	
	// Input User method.
	public void inputUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// Create a User object to fill and send to the User table, filled with information from the request.
		User user = new ObjectMapper().readValue(req.getInputStream(), User.class);
		
		// Create another User object to bring back as a response, map it, write as a string, and send back in a write(JSON).
		User savedUser = userService.inputUser(user);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(savedUser);
		resp.getWriter().write(json);
	}
	
	// Will delete User from User table.
	public void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		// Create Id variable and set it by pulling id value from parameter in URL, setting it to a real integer using a Parse method.
		int id = Integer.parseInt(req.getParameter("id"));
		userService.deleteUser(id);
		
		// System-Out for testing.
		System.out.println("User has been deleted. Test for null: " + userService.pullUserById(id));
	}
	
	// Pull User or whole table. Pulled technique from MVC Project.
	public void pullUserOrTable(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		// Create a response type.
		resp.setContentType("application/json");
		
		// Creating an If-Else to determine if we should pull one User or the whole table.
		// Ensures the ID is a single id, if so, pull single User.
		if(req.getParameter("id") != null) {
			
			// Create Id variable and set it by pulling id value from parameter in URL, setting it to a real integer using a Parse method.
			int id = Integer.parseInt(req.getParameter("id"));
			
			// Create a User object, fill it by pulling a User information by calling pullUserById method, using new id variable.
			User user = userService.pullUserById(id);
			
			// Object mapping will convert SQL/Java data and convert it to a JSON object.
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(user);
			resp.getWriter().write(json);
		}
		
		// If there are not parameters within the URL, then we are going to request a pull of the full table from the User database.
		else{
			
		// Object mapping will convert SQL/Java data and convert it to a JSON object.
		ObjectMapper mapper = new ObjectMapper();
		List<User> usersTable = userService.pullTable();
		String json = mapper.writeValueAsString(usersTable);
		resp.getWriter().write(json);
		}
	}
	
	// Going to update a User in the Users table.
	public void updateUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		// Convert request object into a User java object and then send that Java object to userService(updateUser()).
		User updatedUser = new ObjectMapper().readValue(req.getInputStream(), User.class);
		userService.updateUser(updatedUser);
		
		// Send back a status code of 200.
		resp.setStatus(200);
	}

}
