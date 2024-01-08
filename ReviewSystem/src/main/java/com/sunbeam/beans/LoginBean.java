package com.sunbeam.beans;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserInterfaceDao;
import com.sunbeam.pojo.UserPojo;

public class LoginBean {
	private String email;
	private String password;
	private boolean status;
	private UserPojo user;
	public LoginBean() {
		
	}
	
	public UserPojo getUser() {
		return user;
	}

	public void setUser(UserPojo user) {
		this.user = user;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void authenticate()
	{
		try(UserInterfaceDao userDao=new UserDao())
		{
			UserPojo u=userDao.findByEmail(email);
			if(u!=null && u.getPassword().equals(password))
			{
				this.user=u;
				status=true;
			}
			{
				status=false;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
