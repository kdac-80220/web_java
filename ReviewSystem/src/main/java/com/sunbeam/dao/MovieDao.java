package com.sunbeam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sunbeam.pojo.MoviePojo;

public class MovieDao extends Dao implements AutoCloseable {

	public MovieDao() throws SQLException {
		
	}
	
	
	public List<MoviePojo> findAll() throws Exception {
		List<MoviePojo> list = new ArrayList<>();
		String sql = "SELECT * FROM movie";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					Date modified = rs.getDate("release_date");
					java.util.Date uDate = new java.util.Date( modified.getTime());
					
					MoviePojo m = new MoviePojo(id, title, uDate);
					list.add(m);
				}
			} // rs.close();
		} // stmt.close();
		return list;
	}	

	public MoviePojo findById(int id) throws Exception {
		String sql = "SELECT * FROM movies WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try(ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					id = rs.getInt("id");
					String title = rs.getString("title");
					Date modified = rs.getDate("release_date");
					java.util.Date uDate = new java.util.Date( modified.getTime() );
					MoviePojo m = new MoviePojo(id, title, uDate);
					return m;
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}	
	
}
