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
@RequestMapping(value = "/")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		LoginBean loginForm = new LoginBean();		
		model.put("loginForm", loginForm);
		return "index";
	}
}
