package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.UserDao;
import com.spring.model.User;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	public void save(User user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}
	
	public User findById(int id) {
		return dao.findById(id);
	}

	public User findBySso(String sso) {
		return dao.findBySSO(sso);
	}

	public void updateUser(User user) {
		 User entity = dao.findById(user.getId());
	        if(entity!=null){
	            entity.setSsoId(user.getSsoId());
	            entity.setPassword(user.getPassword());
	            entity.setFirstName(user.getFirstName());
	            entity.setLastName(user.getLastName());
	            entity.setEmail(user.getEmail());
	            entity.setUserProfiles(user.getUserProfiles());
	        }
		
	}

	public void deleteUserBySSO(String sso) {
		 dao.deleteBySSO(sso);
		
	}

	public List<User> findAllUsers() {
		 return dao.findAllUsers();
	}
	
	
}
