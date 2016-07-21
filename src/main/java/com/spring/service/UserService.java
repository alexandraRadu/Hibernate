package com.spring.service;

import java.util.List;

import com.spring.model.User;

public interface UserService {

	void save(User user);
	
	User findById(int id);
	
	User findBySso(String sso);
	
	void updateUser(User user);
    
    void deleteUserBySSO(String sso);
 
    List<User> findAllUsers(); 
}
