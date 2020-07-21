package org.login.beans;

public class User {
	
	// Create values of table data.
	private int userId;
	private String firstName;
	private String lastName;
	private String username;
	private int age;
	private String dob;
	private String gender;
	private String email;
	private String phoneNumber;
	private int asvabScore;
	private int branch_id;
	
	public User() {
		super();
	}

	// Create User constructor.
	public User(int userId, String firstName, String lastName, String username, int age, String dob, String gender,
			String email, String phoneNumber, int asvabScore, int branch_id) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.age = age;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.asvabScore = asvabScore;
		this.branch_id = branch_id;
	}
	
	// Create getters/setters.
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAsvabScore() {
		return asvabScore;
	}

	public void setAsvabScore(int asvabScore) {
		this.asvabScore = asvabScore;
	}

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	
	// ToString method for testing purposes.
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", age=" + age + ", dob=" + dob + ", gender=" + gender + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", asvabScore=" + asvabScore + ", branch_id=" + branch_id + "]";
	}
	
	
	
}