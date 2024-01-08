package com.sunbeam.pojo;

import java.util.Date;

public class UserPojo {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String mobile;
	private Date bDate;
	
	
	public UserPojo() {
		super();
	}

	public UserPojo(int id, String firstName, String lastName, String email, String password, String mobile,
			Date bDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.bDate = bDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	@Override
	public String toString() {
		return "UserPojo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", mobile=" + mobile + ", bDate=" + bDate + "]";
	}
	
		
}
