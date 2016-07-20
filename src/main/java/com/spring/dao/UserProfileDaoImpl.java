package com.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.spring.model.UserRole;



@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, UserRole>implements UserProfileDao{

	@SuppressWarnings("unchecked")
	public List<UserRole> findAll(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("type"));
		return (List<UserRole>)crit.list();
	}
	
	public UserRole findById(int id) {
		return getByKey(id);
	}
	
	public UserRole findByType(String type) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", type));
		return (UserRole) crit.uniqueResult();
	}
}
