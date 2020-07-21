package org.login.beans;

public class Branch {
	
	// Creating object variables that represent info columns in the Branch table.
	private int branch_id;
	private String branch_Name;
	private int min_ASVAB_Score;
	
	// Create constructor
	public Branch(int branch_id, String branch_Name, int min_ASVAB_Score) {
		super();
		this.branch_id = branch_id;
		this.branch_Name = branch_Name;
		this.min_ASVAB_Score = min_ASVAB_Score;
	}
	
	// Setters and getters.
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	public String getBranch_Name() {
		return branch_Name;
	}
	public void setBranch_Name(String branch_Name) {
		this.branch_Name = branch_Name;
	}
	public int getMin_ASVAB_Score() {
		return min_ASVAB_Score;
	}
	public void setMin_ASVAB_Score(int min_ASVAB_Score) {
		this.min_ASVAB_Score = min_ASVAB_Score;
	}
	
	// Creating a toString method for testing.
	@Override
	public String toString() {
		return "Branch [branch_id=" + branch_id + ", branch_Name=" + branch_Name + ", min_ASVAB_Score="
				+ min_ASVAB_Score + "]";
	}
	
}
