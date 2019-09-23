package com.offcn.service;

import com.offcn.bean.User;

public interface UserService {
   
	public User login(String username,String password);
	
	public int addUser(User user);
	
	public User getUserByUsername(String username);
}
