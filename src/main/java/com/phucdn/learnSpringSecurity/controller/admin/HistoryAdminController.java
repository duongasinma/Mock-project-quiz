package com.phucdn.learnSpringSecurity.controller.admin;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phucdn.learnSpringSecurity.dto.CaseDTO;
import com.phucdn.learnSpringSecurity.dto.CategoryDTO;
import com.phucdn.learnSpringSecurity.entity.CaseEntity;
import com.phucdn.learnSpringSecurity.entity.CategoryEntity;
import com.phucdn.learnSpringSecurity.entity.ResultOfCaseDetailEntity;
import com.phucdn.learnSpringSecurity.entity.UserEntity;
import com.phucdn.learnSpringSecurity.repository.CaseRepository;
import com.phucdn.learnSpringSecurity.repository.CategoryRepository;
import com.phucdn.learnSpringSecurity.service.CaseService;
import com.phucdn.learnSpringSecurity.service.ResultOfCaseDetailService;

@Controller
public class HistoryAdminController {
	@Autowired
	private ResultOfCaseDetailService ResultOfCaseDetailService; ;

	@GetMapping("/api/v1/admin/questions&answers/history")
	public String loadCasePage(Model model) {
		model.addAttribute("listResult", ResultOfCaseDetailService.findAll());
		return "admin/questions&answers/history";
	}
