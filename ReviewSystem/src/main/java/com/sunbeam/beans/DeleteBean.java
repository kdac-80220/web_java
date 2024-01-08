package com.sunbeam.beans;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewInterfaceDao;

public class DeleteBean {
	private int id;
	
	
	public DeleteBean()
	{
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void deleteReview()
	{
		try(ReviewInterfaceDao reviewDao=new ReviewDao())
		{
			int i=reviewDao.deleteById(id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
