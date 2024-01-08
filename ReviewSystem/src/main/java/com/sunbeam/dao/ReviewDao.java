package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.sunbeam.pojo.ReviewPojo;
import com.sunbeam.util.DbUtil;


public class ReviewDao implements ReviewInterfaceDao{
	private Connection con;
	public ReviewDao() throws Exception
	{
		con=DbUtil.getConnection();
	}
	
	
	
	@Override
	public void close()
	{
		try {
			if(con!=null)
				con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public int updateReviewById(int id,String review) throws SQLException {
			System.out.println("ID -"+id);
		String sql = "UPDATE reviews set review=?, modified=now() WHERE rev_id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, review);
			stmt.setInt(2, id);
			int cnt = stmt.executeUpdate();
			System.out.println("CNt="+cnt);
			return cnt;
		} //stmt.close();
	}
  
	
	public int addReviewById(ReviewPojo r) throws SQLException {
		String sql = "insert into reviews(movie_id,review,rating,user_id,modified) values (?,?,?,?,now())";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, r.getMovieId());
			stmt.setString(2, r.getReview());
			stmt.setInt(3, r.getRating());
			stmt.setInt(4, r.getUserId());
			int cnt = stmt.executeUpdate();
			return cnt;
		} //stmt.close();
	}
	
	public int deleteById(int id) throws SQLException {
		String sql = "DELETE FROM reviews WHERE rev_id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			int cnt = stmt.executeUpdate();
			return cnt;
		} //stmt.close();
	}

	
	public List<ReviewPojo> displayAllReviews() throws SQLException
	{
		List<ReviewPojo>list = new ArrayList<>();
		String sql = "SELECT * from reviews";
		try(PreparedStatement stmt = con.prepareStatement(sql))
		{
			try(ResultSet rs = stmt.executeQuery())
			{
				while(rs.next())
				{
					ReviewPojo rs1 = new ReviewPojo();
					rs1.id = rs.getInt("rev_id");
					rs1.movieId = rs.getInt("movie_id");
					rs1.review = rs.getString("review");
					rs1.rating = rs.getInt("rating");
					rs1.userId = rs.getInt("user_id");
					rs1.modified=rs.getDate("modified");
					list.add(rs1);					
				}
			}
		}
		
		return list;
		
	}
	
	public List<ReviewPojo> displayMyReviews(int myId) throws SQLException
	{
		System.out.println("Id: "+myId);
		String sql = "SELECT * from reviews where user_id=?";
		List<ReviewPojo> list=new ArrayList<ReviewPojo>();
		try(PreparedStatement stmt = con.prepareStatement(sql))
		{
			stmt.setInt(1,myId);
			try(ResultSet rs = stmt.executeQuery())
			{
				
				while(rs.next())
				{
					ReviewPojo rs1 = new ReviewPojo();
					rs1.id = rs.getInt("rev_id");
					rs1.movieId = rs.getInt("movie_id");
					rs1.review = rs.getString("review");
					rs1.rating = rs.getInt("rating");
					rs1.userId = rs.getInt("user_id");
					rs1.modified=rs.getDate("modified");
					list.add(rs1);
					System.out.println(rs1.toString());
				}
			}
		}
		return list;
	}
	public int reviewSharedWithMe(int id) throws SQLException
	{
		String sql = "insert into reviews where userid=?";
		try(PreparedStatement stmt = con.prepareStatement(sql))
		{
			
		}
		return id;
	}



	@Override
	public int save(ReviewDao r) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int update(ReviewDao r) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<ReviewPojo> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<ReviewPojo> findByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<ReviewPojo> getSharedWithUser(int userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ReviewPojo findById(int id) throws Exception {
		String sql = "SELECT * from reviews where rev_id=?";
		ReviewPojo rs1 = new ReviewPojo();
		try(PreparedStatement stmt = con.prepareStatement(sql))
		{
			stmt.setInt(1, id);
			try(ResultSet rs = stmt.executeQuery())
			{
				while(rs.next())
				{
					
					rs1.id = rs.getInt("rev_id");
					rs1.movieId = rs.getInt("movie_id");
					rs1.review = rs.getString("review");
					rs1.rating = rs.getInt("rating");
					rs1.userId = rs.getInt("user_id");
					rs1.modified=rs.getDate("modified");
										
				}
			}
		}
		return rs1;
	}



	@Override
	public int shareReview(int reviewId, int userId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}