package com.spring.dao;

import java.util.List;

import com.spring.model.UserRole;

public interface UserProfileDao {

	List<UserRole> findAll();
	
	UserRole findByType(String type);
	
	UserRole findById(int id);
}
