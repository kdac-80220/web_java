package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginBean {
	private String email;
	private String password;
	private boolean status;
	private User user;
	
	public LoginBean()
	{
		
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
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
	
	public void authenticate()
	{
		try(UserDaoImpl userDao=new UserDaoImpl())
		{
			User u=userDao.findByEmail(email);
			if(u!=null && u.getPassword().equals(password))
			{
				status=true;
				this.user=u;
			}
			else{
				status=false;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
