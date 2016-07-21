package com.spring.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.spring.model.User;
import com.spring.model.UserProfile;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	public void save(User user) {
		persist(user);
	}

	public User findById(int id) {
		return getByKey(id);
	}

	public User findBySSO(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		return (User) crit.uniqueResult();
	}
	

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		List<User> users = getSession().createQuery("SELECT u FROM User u ORDER BY u.firstName ASC").getResultList();
		return users;
	}

	public void deleteBySSO(String sso) {
		/*User user = (User) getEntityManager().createQuery("SELECT u FROM User u WHERE u.ssoId LIKE :ssoId")
				.setParameter("ssoId", sso).getSingleResult();
		delete(user);*/
		
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		User user = (User)crit.uniqueResult();
		delete(user);
		
	}

}
