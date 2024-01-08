package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sunbeam.pojo.MoviePojo;
import com.sunbeam.pojo.UserPojo;

public class UserDao extends Dao implements UserInterfaceDao {
	
	public UserDao() throws SQLException {
		
	}

	public int save(UserPojo u) throws Exception {
		String sql = "INSERT INTO users(id, first_name, last_name, email, mobile, birth, password) VALUES(default, ?, ?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, u.getFirstName());
			stmt.setString(2, u.getLastName());
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getMobile());
			
			Date modified = u.getbDate();
			java.sql.Date sDate = new java.sql.Date( modified.getTime());
			
			stmt.setDate(5, sDate);
			stmt.setString(6, u.getPassword());
			int count = stmt.executeUpdate();
			return count;
		} //stmt.close();
	}
	
	public int update(UserPojo u) throws Exception {
		String sql = "UPDATE users SET first_name=?, last_name=?, mobile=?, birth=? WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, u.getFirstName());
			stmt.setString(2, u.getLastName());
			stmt.setString(3, u.getEmail());

			Date modified = u.getbDate();
			java.sql.Date sDate = new java.sql.Date( modified.getTime());
			
			stmt.setDate(4,(java.sql.Date)u.getbDate());
			stmt.setInt(5, u.getId());
			int count = stmt.executeUpdate();
			return count;
		} //stmt.close();
	}

	public int updatePassword(int userId, String newPassword) throws Exception {
		String sql = "UPDATE users SET password=? WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, newPassword);
			stmt.setInt(2, userId);
			int count = stmt.executeUpdate();
			return count;
		} //stmt.close();
	}

	public UserPojo findByEmail(String email) throws Exception {
		String sql = "SELECT * FROM users WHERE email=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, email);
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String fname = rs.getString("first_name");
					String lname = rs.getString("last_name");
					String password = rs.getString("password");
					email = rs.getString("email");
					String mobile = rs.getString("mobile");
					
					Date modified = rs.getDate("birth");
					java.util.Date uDate = new java.util.Date( modified.getTime() );
					return new UserPojo(id, fname, lname,email,password, mobile,uDate);
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}

	public List<UserPojo> findAll() throws Exception {
		List<UserPojo> list = new ArrayList<UserPojo>();
		String sql = "SELECT * FROM users";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String fname = rs.getString("first_name");
					String lname = rs.getString("last_name");
					String password = rs.getString("password");
					String email = rs.getString("email");
					String mobile = rs.getString("mobile");
					
					Date modified = rs.getDate("birth");
					java.util.Date uDate = new java.util.Date( modified.getTime() );
					
					UserPojo u = new UserPojo(id, fname, lname, email, password, mobile,uDate);
					list.add(u);
				}
			} // rs.close();
		} // stmt.close();
		return list;
	}

	@Override
	public int save(UserDao u) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UserDao u) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}



}
