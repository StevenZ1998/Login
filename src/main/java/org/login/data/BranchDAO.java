package org.login.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.login.beans.Branch;

// THE CODE HERE WILL BE VERY SIMILAR TO USERDAO SINCE THE METHODS ARE THE SAME.
public class BranchDAO implements BranchDAOInterface{
	
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
	
	// Will input a new Branch into the database.
	@Override
	public Branch inputBranch(Branch branch) {
		
		// Branch insert attempt.
		try {
			// Get Connection using connection method.
			getConnection();
			
			// Inserting values to create a new Branch into the Branch table. 
			PreparedStatement statementVar = conn.prepareStatement("INSERT INTO branch (Branch_Id, Branch_Name, Min_ASVAB_Score) VALUES (?, ?, ?)");
			statementVar.setInt(1, branch.getBranch_id());
			statementVar.setString(2, branch.getBranch_Name());
			statementVar.setInt(3, branch.getMin_ASVAB_Score());
			
			// Update query.
			statementVar.executeUpdate();
			
		}
		
		// Boiler try/catch/finally from this point on.
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Could not input into table, problem occured in BranchDAO.inputBranch().");
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
		
		return branch;
	}
	
	// Will delete a Branch from the Branch data table.
	@Override
	public void deleteBranch(int branch_id) {
		
		// Branch insert attempt.
		try {
			// Get Connection using connection method.
			getConnection();
			
			// Deletes Branch by Id.
			PreparedStatement statementVar = conn.prepareStatement("DELETE FROM branch WHERE Branch_Id = ?");
			statementVar.setInt(1, branch_id);
			
			// Update query.
			statementVar.executeUpdate();
			
		}
		
		// Boiler try/catch/finally from this point on.
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Could not delete from table, problem occured in BranchDAO.delete.Branch().");
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
	
	// Will pull entire table from Branch data table.
	@Override
	public List<Branch> pullTable() {
		
		// Must create a Branch object to fill and bring to the request.
		List<Branch> table = new ArrayList<>();
		
		try {
			// Get Connection using connection method.
			getConnection();
			
			PreparedStatement statementVar = conn.prepareStatement("SELECT * FROM branch");
			ResultSet rs = statementVar.executeQuery();
			
			while(rs.next()) {
				table.add(new Branch(rs.getInt(1), rs.getString(2), rs.getInt(3)));	
			}
		}
		
		// Boiler try/catch/finally from this point on.
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Could not pull table, problem occured in BranchDAO.pullTable().");
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
	
	// Will pull a Branch from the Branch table, by Id.
	@Override
	public Branch pullBranchById(int branch_Id) {
		
		// Must create a Branch object to fill and bring to the request.
		Branch pulledBranch = null;
		
		try {
			getConnection();
			
			// Selects the Branch by Id and puts it in a result set.
			PreparedStatement statementVar = conn.prepareStatement("SELECT * FROM branch WHERE Branch_Id = ?");
			statementVar.setInt(1, branch_Id);
			ResultSet rs = statementVar.executeQuery();
			
			// This is how we have to bring the resultSet and display it.
			while(rs.next()) {
				pulledBranch = new Branch(rs.getInt(1), rs.getString(2), rs.getInt(3));
			}
		}
		// Boiler try/catch/finally from this point on.
		catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Could not pull Branch, problem occured in BranchDAO.pullBranchById().");
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
		return pulledBranch;
	}
	
	// Updates the Branch by Id in the Branch table.
	@Override
	public void updateBranch(Branch updatedBranch) {
		
		try {
			getConnection();
			
			// Prepared Statement for update, assigning each value.
			PreparedStatement statementVar = conn.prepareStatement("UPDATE branch SET Branch_Name = ?, Min_ASVAB_Score = ? where Branch_Id = ?");
			statementVar.setString(1, updatedBranch.getBranch_Name());
			statementVar.setInt(2, updatedBranch.getMin_ASVAB_Score());
			statementVar.setInt(3, updatedBranch.getBranch_id());
			statementVar.executeUpdate();
		}
		// BOILERPLATE CODE
		catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Could not input all values. Error occurred in BranchDAO.updateBranch()");
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
