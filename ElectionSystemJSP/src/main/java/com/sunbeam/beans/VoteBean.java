package com.sunbeam.beans;

import javax.management.RuntimeErrorException;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class VoteBean {
	private int candId;
	private int userId;
	private String message;
	
	public VoteBean()
	{
		
	}
	
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void doVoting()
	{
		try(UserDao userDao=new UserDaoImpl())
		{
			
			User user=userDao.findById(userId);
			
			if(user.getStatus()!=0)
			{
				this.message="You have already voted";
			}
			
			try(CandidateDao candidateDao=new CandidateDaoImpl())
			{
				int count=candidateDao.incrementVote(candId);
				if(count==1)
				{
					count=userDao.updateStatus(count, true);
					if(count==1)
						this.message="Your vote registered successfully";
				}
				if(count==0)
				{
					this.message="Voting faild, try again";
				}
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
