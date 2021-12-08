package com.phucdn.learnSpringSecurity.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.phucdn.learnSpringSecurity.dto.UserDTO;
import com.phucdn.learnSpringSecurity.entity.RoleOfUserEntity;
import com.phucdn.learnSpringSecurity.entity.UserEntity;
import com.phucdn.learnSpringSecurity.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping("/api/v1/signUp")
	public String loginPage(Model model) {
		model.addAttribute("user", new UserDTO());
		return "signUp";
	}

	@PostMapping("/api/v1/process_register")
	public String processRegistration(@Valid @ModelAttribute("user") UserDTO user,
										BindingResult bindingResult) {
		UserEntity userE = new UserEntity();
		BeanUtils.copyProperties(user, userE);
		RoleOfUserEntity roleUser = new RoleOfUserEntity();
		if(userService.useridHaveExist(user.getUserId())) {
			bindingResult.addError(new FieldError("user","userId", "Username adready exist! "));
			return "signUp";
		}
		else if(bindingResult.hasErrors()){
			return "signUp";
		}else {
		roleUser.setRoleId("user");
		userE.setRoleUser(roleUser);
		long mills = System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);
		userE.setDateOfCreate(dateOfCreate);
		userE.setStatus("Active");
		userE.setPassword(encoder.encode(user.getPassword()));
		userService.save(userE);
		
		
		return "redirect:/api/v1/login";
		}
	}

}
