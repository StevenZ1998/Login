package org.login.service;

import java.util.List;
import org.login.beans.Branch;
import org.login.data.BranchDAO;

// Service will be similar to that of UserService.
public class BranchService {
	
	// Create DAO object to work with.
	private BranchDAO branchDAO = new BranchDAO();
	
	// Inputs a Branch in the Branch table.
	public Branch inputBranch(Branch branch) {
		return branchDAO.inputBranch(branch);
	}
	
	// Deletes a Branch by Id in the Branch table.
	public void deleteBranch(int branch_id) {
		branchDAO.deleteBranch(branch_id);
	}
	
	// Pulls the entire Branch table.
	public List<Branch> pullTable(){
		return branchDAO.pullTable();
	}
	
	// Pulls a Branch, identified by Id.
	public Branch pullBranchById(int branch_Id) {
		return branchDAO.pullBranchById(branch_Id);
	}
	
	// Updates a Branch, identified by Id.
	public void updateBranch(Branch updatedBranch) {
		branchDAO.updateBranch(updatedBranch);
	}
}
