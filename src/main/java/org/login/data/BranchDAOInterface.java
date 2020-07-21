package org.login.data;

import java.util.List;
import org.login.beans.Branch;

public interface BranchDAOInterface {
	
	// Inputs a Branch into a table.
	public Branch inputBranch(Branch branch);
	
	// Removes a Branch from the table.
	public void deleteBranch(int branch_Id);
	
	// Pulls entire table for display.
	public List<Branch> pullTable();
	
	// Create a search by Id.
	public Branch pullBranchById(int branch_Id);
	
	// Updates a single Branch entry.
	public void updateBranch(Branch updatedBranch);
}
