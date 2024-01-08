package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.dao.MovieDao;
import com.sunbeam.dao.ReviewDao;
import com.sunbeam.pojo.MoviePojo;
import com.sunbeam.pojo.ReviewPojo;

public class AddReviewBean {
	private int movieId;
	private int userId;
	private int rating;
	private String review;
	private String modified=null;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private List<MoviePojo> movieList;
	
	
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public List<MoviePojo> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<MoviePojo> movieList) {
		this.movieList = movieList;
	}

	public AddReviewBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void findAllMovies()
	{
		try(MovieDao movieDao=new MovieDao())
		{
			movieList=movieDao.findAll();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void addReview()
	{
		try(ReviewDao reviewDao=new ReviewDao())
		{
			int i=reviewDao.addReviewById(new ReviewPojo(movieId,review,rating,userId));
			if(i!=0)
			{
				this.message="Review Added Successfully";
			}
			else
			{
				this.message="Review Not Added";
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
