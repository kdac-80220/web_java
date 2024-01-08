package com.sunbeam.dao;

import java.sql.SQLException;
import java.util.List;

import com.sunbeam.pojo.ReviewPojo;

public interface ReviewInterfaceDao {

	 public int save(ReviewDao r) throws Exception;
	 public int update(ReviewDao r) throws Exception;
	 public List<ReviewPojo> findAll() throws Exception;
	 public List<ReviewPojo> findByUserId(int userId) throws Exception;
	 public List<ReviewPojo> getSharedWithUser(int userId) throws Exception;
	 public ReviewPojo findById(int id) throws Exception;
	 public int deleteById(int reviewId) throws Exception;
	 public int shareReview(int reviewId, int userId) throws Exception;
	 public List<ReviewPojo> displayMyReviews(int myId) throws SQLException;
}
