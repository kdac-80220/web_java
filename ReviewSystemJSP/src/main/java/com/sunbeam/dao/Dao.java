package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.sunbeam.util.DbUtil;

public class Dao implements AutoCloseable {

	protected Connection con;
	
	public Dao() throws SQLException
	{
		con = DbUtil.getConnection();
	}
	@Override
	public void close() throws Exception {

		if(con!=null)
		{
			con.close();
		}
	}
		
	
}	
