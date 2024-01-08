package com.sunbeam.beans;

import com.sunbeam.dao.ReviewDao;

public class UpdateBean {
	private int id;
	private String review;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UpdateBean() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	public void updateReview()
	{
		try(ReviewDao reviewDao=new ReviewDao())
		{
			int i=reviewDao.updateReviewById(id, review);
			if(i!=0) {
				this.message="Data updated Successfully";
			}else {
				this.message="Some error occered";
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
