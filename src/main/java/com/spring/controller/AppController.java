package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.User;
import com.spring.model.UserProfile;
import com.spring.service.UserProfileService;
import com.spring.service.UserService;


@Controller
public class AppController {

	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	UserService userService;
	
	/*@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("greeting", "Hi, Welcome to mysite");
		return "welcome";
	}*/
	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String UserPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "welcome";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "admin";
	}

	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "dba";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	
	@RequestMapping(value = "/userslist", method = RequestMethod.GET)
	public String usersListPage() {
		return "userslist";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "newuser";
	}
	
	 @RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
	    public String deleteUser(@PathVariable String ssoId) {
	        userService.deleteUserBySSO(ssoId);
	        return "redirect:/userslist";
	    }

	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveRegistration(@Valid User user,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			System.out.println("There are errors");
			return "newuser";
		}
		userService.save(user);
		
		System.out.println("First Name : "+user.getFirstName());
		System.out.println("Last Name : "+user.getLastName());
		System.out.println("SSO ID : "+user.getSsoId());
		System.out.println("Password : "+user.getPassword());
		System.out.println("Email : "+user.getEmail());
		System.out.println("Checking UsrProfiles....");
		if(user.getUserProfiles()!=null){
			for(UserProfile profile : user.getUserProfiles()){
				System.out.println("Profile : "+ profile.getType());
			}
		}
		
		model.addAttribute("success",   user.getFirstName() + " has been registered successfully");
		return "registrationsuccess";
	}
	
	 @RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.GET)
	    public String editUser(@PathVariable String ssoId, ModelMap model) {
	        User user = userService.findBySso(ssoId);
	        model.addAttribute("user", user);
	        model.addAttribute("edit", true);
	        return "newuser";
	    }
	     
	    /**
	     * This method will be called on form submission, handling POST request for
	     * updating user in database. It also validates the user input
	     */
	    @RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.POST)
	    public String updateUser(@Valid User user, BindingResult result,
	            ModelMap model, @PathVariable String ssoId) {
	 
	        if (result.hasErrors()) {
	            return "newuser";
	        }
	 
	        /*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
	        if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
	            FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
	            result.addError(ssoError);
	            return "registration";
	        }*/
	 
	 
	        userService.updateUser(user);
	 
	        model.addAttribute("success",  user.getFirstName() + " "+ user.getLastName() + " updated successfully");
	        return "registrationsuccess";
	    }

	
	
	
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	
	
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}

}
