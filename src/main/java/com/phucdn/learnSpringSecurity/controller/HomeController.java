package com.phucdn.learnSpringSecurity.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phucdn.learnSpringSecurity.dto.CaseDTO;
import com.phucdn.learnSpringSecurity.repository.CaseRepository;
import com.phucdn.learnSpringSecurity.repository.CategoryRepository;
import com.phucdn.learnSpringSecurity.service.CategoryService;
import com.phucdn.learnSpringSecurity.service.RoleOfUserService;
import com.phucdn.learnSpringSecurity.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CaseRepository caseRepository;
	
	@Autowired
	private RoleOfUserService roleOfUserService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String loadHomePage(Model model) {
		model.addAttribute("case", new CaseDTO());
		model.addAttribute("listCategory", categoryRepository.loadCategoryByActiveStatus());
		return "user/home";
	}
	@RequestMapping(value = "/api/v1/quizzHiHi", method = RequestMethod.GET)
	public String loadUserHomePage(Model model) {
		model.addAttribute("case", new CaseDTO());
		model.addAttribute("listCategory", categoryRepository.loadCategoryByActiveStatus());
		return "user/home";
	}
	@GetMapping("/api/v1/quizzHiHi/chooseSub")
	public String loadCaseByCateId(@ModelAttribute("case") CaseDTO caseDto, 
			Model model) {
		String cateId = caseDto.getCateId();
		System.out.println(cateId);
		model.addAttribute("listCase", caseRepository.loadCaseWithActiveStatusByCateId(cateId));
		model.addAttribute("case", new CaseDTO());
		model.addAttribute("listCategory", categoryRepository.loadCategoryByActiveStatus());
		return "user/home";
	}
	@RequestMapping(value = "/api/v1/admin", method = RequestMethod.GET)
	public String loadAdminHomePage(Model model,  Principal principal) {
		User loginnedUser = (User) ((Authentication) principal).getPrincipal();
		String userInfo = com.phucdn.learnSpringSecurity.utils.WebUtils.toString2(loginnedUser);
		model.addAttribute("userInfo", userInfo);
		return "userInfoPage";
	}
}
