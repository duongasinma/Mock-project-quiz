package com.phucdn.learnSpringSecurity.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phucdn.learnSpringSecurity.dto.UserDTO;
import com.phucdn.learnSpringSecurity.entity.UserEntity;
import com.phucdn.learnSpringSecurity.repository.UserRepository;
import com.phucdn.learnSpringSecurity.service.RoleOfUserService;
import com.phucdn.learnSpringSecurity.service.UserService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/api/v1/admin/users")
public class AdminUserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleOfUserService roleOfUserService;
	
	@GetMapping()
	public String loadUserPage(Model model) {
		model.addAttribute("listUser", userService.findAll());		
		return "admin/users/user";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String banUser(@PathVariable("id") String userId) {
		userRepository.banUserByUserId(userId);
		return "redirect:/api/v1/admin/users";
	}
	
	@GetMapping("/reActivate/{id}")
	public String reActivateUser(@PathVariable("id") String userId) {
		
		userRepository.reActivateUserByUserId(userId);
		return "redirect:/api/v1/admin/users";
	}
	
	@GetMapping("/view-de/{id}")
	public ModelAndView viewUserDetails(@PathVariable("id") String userId) {
		ModelAndView mav = new ModelAndView("admin/users/viewUserDetail");
		UserEntity userEntity = userService.getById(userId);
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(userEntity, userDTO);
		String roleId = userEntity.getRoleUser().getRoleId();
		userDTO.setRoleId(roleId);
		mav.addObject("userDetail", userDTO);
		return mav;
	}
}
