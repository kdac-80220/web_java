package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.dao.MovieDao;
import com.sunbeam.dao.MovieInterfaceDao;
import com.sunbeam.dao.ReviewDao;
import com.sunbeam.dao.ReviewInterfaceDao;
import com.sunbeam.pojo.MoviePojo;
import com.sunbeam.pojo.ReviewPojo;

public class ReviewBean {
	List<ReviewPojo> reviewList;
	List<MoviePojo> movieList;
	
	
	
	public List<MoviePojo> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<MoviePojo> movieList) {
		this.movieList = movieList;
	}

	public ReviewBean()
	{
		
	}
	
	public List<ReviewPojo> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<ReviewPojo> reviewList) {
		this.reviewList = reviewList;
	}
	
	public void getResultList()
	{
		try(ReviewInterfaceDao reviewDao=new ReviewDao())
		{
			reviewList=reviewDao.displayAllReviews();
			try(MovieDao movieDao=new MovieDao())
			{
				movieList=movieDao.findAll();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
