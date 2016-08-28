package com.sif.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sif.spring.model.DatabaseService;
import com.sif.spring.model.LoginBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		LoginBean loginForm = new LoginBean();		
		model.put("loginForm", loginForm);
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("loginForm") LoginBean login, 
			Map<String, Object> model) {
		
		// implement your own registration logic here...
		
		// for testing purpose:
		System.out.println("username: " + login.getUsername());
		System.out.println("password: " + login.getPassword());
		model.put("loggedInUser", login.getUsername());
		DatabaseService rec = new DatabaseService();
		boolean user = rec.is_user(login.getUsername(), login.getPassword());
		if (user)
			return "welcome";
		else 
			return "FailedLogin";
	}
}
