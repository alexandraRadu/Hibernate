package com.spring.service;

import java.util.List;

import com.spring.model.UserRole;



public interface UserRoleService {

	List<UserRole> findAll();
	
	UserRole findByType(String type);
	
	UserRole findById(int id);
}
