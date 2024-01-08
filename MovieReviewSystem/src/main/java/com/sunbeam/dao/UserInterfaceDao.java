package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.pojo.UserPojo;

public interface UserInterfaceDao extends AutoCloseable {

	 public int save(UserDao u) throws Exception;
	 public int update(UserDao u) throws Exception;
	 public int updatePassword(int userId, String newPassword) throws Exception;
	 public UserPojo findByEmail(String email) throws Exception;
	 public List<UserPojo> findAll() throws Exception;
}
