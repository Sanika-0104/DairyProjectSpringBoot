package com.role.implementation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.role.implementation.DTO.UserLoginDTO;
import com.role.implementation.model.Admin;
import com.role.implementation.service.DefaultUserService;

@Controller
@RequestMapping("/adlogin")
public class AdminLoginController {
	@Autowired
	private DefaultUserService userService;

	
	private Admin admin;
	
	public AdminLoginController(Admin admin) {
		this.admin=admin;
	}

	@ModelAttribute("user")
	public UserLoginDTO userLoginDTO() {
		return new UserLoginDTO();
	}

	@GetMapping
	public String adminlogin() {
		return "adminLogin";
	}

	@PostMapping("/success")
	public String loginUser(HttpServletRequest request, Model model) {
	    // Static verification of username and password
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");


	    if (admin != null && username != null && admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
	        return "adminDashboard";
	    }

	    return "redirect:error";
	}


}
