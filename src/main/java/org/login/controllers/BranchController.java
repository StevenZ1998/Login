package org.login.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.login.beans.Branch;
import org.login.service.BranchService;

import com.fasterxml.jackson.databind.ObjectMapper;

// Code here will be very similar to User controller.

public class BranchController {
	
	// Create a Branch Service object to interact with.
	BranchService branchService = new BranchService();
	
	// Input Branch method.
	public void inputBranch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// Create a Branch object to fill and send to the Branch table, filled with information from the request.
		Branch branch = new ObjectMapper().readValue(req.getInputStream(), Branch.class);
		
		// Create another Branch object to bring back as a response, map it, write as a string, and send back in a write(JSON).
		Branch savedBranch = branchService.inputBranch(branch);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(savedBranch);
		resp.getWriter().write(json);
	}
	
	// Delete Branch from Branch table.
	public void deleteBranch(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		// Create Id variable and set it by pulling id value from parameter in URL, setting it to a real integer using a Parse method.
		int id = Integer.parseInt(req.getParameter("id"));
		branchService.deleteBranch(id);
		
		// System-Out for testing.
		System.out.println("Branch has been deleted. Test for null: " + branchService.pullBranchById(id));
	}
	
	// Pull Branch or whole table. Pulled technique from MVC Project.
	public void pullBranchOrTable(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		// Create a response type.
		resp.setContentType("application/json");
		
		// Creating an If-Else to determine if we should pull one Branch or the whole table.
		// Ensures the ID is a single id, if so, pull single Branch.
		if(req.getParameter("id") != null) {
			
			// Create Id variable and set it by pulling id value from parameter in URL, setting it to a real integer using a Parse method.
			int id = Integer.parseInt(req.getParameter("id"));
			
			// Create a Branch object, fill it by pulling a Branch information by calling pullBranchById method, using new id variable.
			Branch branch = branchService.pullBranchById(id);
			
			// Object mapping will convert SQL/Java data and convert it to a JSON object.
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(branch);
			resp.getWriter().write(json);
		}
		
		// If there are not parameters within the URL, then we are going to request a pull of the full table from the Branch database.
		else{
			
		// Object mapping will convert SQL/Java data and convert it to a JSON object.
		ObjectMapper mapper = new ObjectMapper();
		List<Branch> branchTable = branchService.pullTable();
		String json = mapper.writeValueAsString(branchTable);
		resp.getWriter().write(json);
		}
	}
	
	// Going to update a Branch in the Branch table.
	public void updateBranch(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		// Convert request object into a Branch java object and then send that Java object to branchService(updateBranch()).
		Branch updatedBranch = new ObjectMapper().readValue(req.getInputStream(), Branch.class);
		branchService.updateBranch(updatedBranch);
		
		// Send back a status code of 200.
		resp.setStatus(200);
	}
}
