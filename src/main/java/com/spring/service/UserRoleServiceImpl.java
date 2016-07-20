package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.UserProfileDao;
import com.spring.model.UserRole;



@Service("userProfileService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService{
	
	@Autowired
	UserProfileDao dao;
	
	public List<UserRole> findAll() {
		return dao.findAll();
	}

	public UserRole findByType(String type){
		return dao.findByType(type);
	}

	public UserRole findById(int id) {
		return dao.findById(id);
	}
}
