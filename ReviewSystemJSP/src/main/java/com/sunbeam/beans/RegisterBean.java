package com.sunbeam.beans;

import java.util.Date;

import com.sunbeam.dao.UserDao;
import com.sunbeam.pojo.UserPojo;

public class RegisterBean {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String mobile;
	private String birthdate;
	
	
	
	private boolean status;
	
	public RegisterBean()
	{
		
	}
	
	public int getId() {
		return id;
	}
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	public void registerUser()
	{
		try(UserDao userDao=new UserDao())
		{
			int i=userDao.save(new UserPojo(id,firstName,lastName,email,password,mobile,birthdate));
			if(i!=0)
			{
				status=true;
			}
			else {
				status=false;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
