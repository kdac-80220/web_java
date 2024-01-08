package com.sunbeam.pojo;

import java.util.Date;

public class ReviewPojo {
	public int id;
	public int movieId;
	public String review;
	public int rating;
	public int userId;
	public Date modified;
	
	
	public ReviewPojo()
	{
		this.id=0;
		this.modified=null;
		this.movieId=0;
		this.rating=0;
		this.userId=0;
		this.review="";
	}
	
	public ReviewPojo(int id, int moiveId, String review, int rating, int userId, Date modified) {
		this.id = id;
		this.movieId = moiveId;
		this.review = review;
		this.rating = rating;
		this.userId = userId;
		this.modified = modified;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getMovieId() {
		return movieId;
	}


	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public Date getModified() {
		return modified;
	}


	public void setModified(Date modified) {
		this.modified = modified;
	}

	@Override
	public String toString() {
		return "ReviewPojo [id=" + id + ", movieId=" + movieId + ", review=" + review + ", rating=" + rating
				+ ", userId=" + userId + ", modified=" + modified + "]";
	}
	
	
}
