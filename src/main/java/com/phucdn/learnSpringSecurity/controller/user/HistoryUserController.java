package com.phucdn.learnSpringSecurity.controller.user;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.phucdn.learnSpringSecurity.entity.CaseEntity;
import com.phucdn.learnSpringSecurity.entity.ResultOfCaseEntity;
import com.phucdn.learnSpringSecurity.entity.UserEntity;
import com.phucdn.learnSpringSecurity.service.ResultOfCaseService;
import com.phucdn.learnSpringSecurity.service.UserService;


@Controller
public class HistoryUserController {
	@Autowired
	ResultOfCaseService resultOfCaseService;
	
	@Autowired
	UserService userService;

	@GetMapping("/api/v1/user/quizzes/historyuser")
	public String loadCasePage(Model model, Principal principal) {
		User loginnedUser = (User) ((Authentication) principal).getPrincipal();
		UserEntity user = userService.getById(loginnedUser.getUsername());
		List<ResultOfCaseEntity> listRos = resultOfCaseService.findByUser(user);
		model.addAttribute("listRos",listRos);
		return "/user/quizzes/historyuser";
	}


	
}
