package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.pojo.MoviePojo;

public interface MovieInterfaceDao extends AutoCloseable {

	 public List<MoviePojo> findAll() throws Exception;
	 public MoviePojo findById(int id) throws Exception;
	
}
