package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.dao.MovieDao;
import com.sunbeam.dao.ReviewDao;
import com.sunbeam.pojo.MoviePojo;
import com.sunbeam.pojo.ReviewPojo;

public class MyReviewBean {
	private int id;
	private List <ReviewPojo> myReviewList;
	private List <MoviePojo> myMovieList;
	
	public MyReviewBean() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ReviewPojo> getMyReviewList() {
		return myReviewList;
	}

	public void setMyReviewList(List<ReviewPojo> myReviewList) {
		this.myReviewList = myReviewList;
	}

	public List<MoviePojo> getMyMovieList() {
		return myMovieList;
	}

	public void setMyMovieList(List<MoviePojo> myMovieList) {
		this.myMovieList = myMovieList;
	}
	
	public void myReview()
	{
		try(ReviewDao reviewDao=new ReviewDao())
		{
			myReviewList=reviewDao.displayMyReviews(id);
			
			try(MovieDao movieDao=new MovieDao())
			{
				myMovieList=movieDao.findAll();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
