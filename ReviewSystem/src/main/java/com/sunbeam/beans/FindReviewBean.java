package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.pojo.ReviewPojo;

public class FindReviewBean {
	private int id;
	private ReviewPojo reviewPojo;
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public ReviewPojo getReviewPojo() {
		return reviewPojo;
	}



	public void setReviewPojo(ReviewPojo reviewPojo) {
		this.reviewPojo = reviewPojo;
	}



	public void findReview()
	{
		try(ReviewDao reviewDao=new ReviewDao())
		{
			this.reviewPojo=reviewDao.findById(id);
		}catch(Exception e) {
			
		}
	}
}
