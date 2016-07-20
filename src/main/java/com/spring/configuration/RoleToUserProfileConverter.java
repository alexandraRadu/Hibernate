package com.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.spring.model.UserRole;
import com.spring.service.UserRoleService;


@Component
public class RoleToUserProfileConverter implements Converter<Object, UserRole>{

	@Autowired
	UserRoleService userProfileService;

	/*
	 * Gets UserProfile by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	public UserRole convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		UserRole profile= userProfileService.findById(id);
		System.out.println("Profile : "+profile);
		return profile;
	}
	
	/*
	 * Gets UserProfile by type
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	/*
	public UserProfile convert(Object element) {
		String type = (String)element;
		UserProfile profile= userProfileService.findByType(type);
		System.out.println("Profile ... : "+profile);
		return profile;
	}
	*/

}
