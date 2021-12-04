package com.phucdn.learnSpringSecurity.controller.admin;

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

import com.phucdn.learnSpringSecurity.dto.QuestionTypeDTO;
import com.phucdn.learnSpringSecurity.entity.QuestionTypeEntity;
import com.phucdn.learnSpringSecurity.service.QuestionTypeService;

@Controller
@RequestMapping("/api/v1/admin/quesTypes")
public class AdminQuestionTypeController {
	
	@Autowired
	private QuestionTypeService questionTypeService;
	
	@GetMapping()
	public String loadQuesTypePage(Model model) {
		model.addAttribute("listQuestionType", questionTypeService.findAll());
		return "admin/questionTypes/questionType";
	}
	
	@GetMapping("/addNewQuesType")
	public String loadAddNewQuesTypePage(Model model) {
		model.addAttribute("quesType", new QuestionTypeDTO());
		return "admin/questionTypes/addNewQuesType";
	}
	
	@PostMapping("/saveQuesType")
	public ModelAndView addNewQuesType(ModelMap model, @ModelAttribute("quesType") QuestionTypeDTO quesTypeDTO) {
		QuestionTypeEntity quesTypeEntity = new QuestionTypeEntity();
		BeanUtils.copyProperties(quesTypeDTO, quesTypeEntity);
		long mills =  System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);
		quesTypeEntity.setDateOfCreate(dateOfCreate);
		quesTypeEntity.setStatus("Active");
		questionTypeService.save(quesTypeEntity);
		
		model.addAttribute("message", "Ques-Type is saved!");
		
		return new ModelAndView("redirect:/api/v1/admin/quesTypes", model);
	}
	
	@GetMapping("/view-detail/{id}")
	public ModelAndView viewQuesTypeDetail(@PathVariable("id") String quesTypeId) {
		ModelAndView mav = new ModelAndView("admin/questionTypes/viewQuesTypeDetail");
		
		QuestionTypeEntity quesTypeEntity = questionTypeService.getById(quesTypeId);
		QuestionTypeDTO quesTypeDTO = new QuestionTypeDTO();
		BeanUtils.copyProperties(quesTypeEntity, quesTypeDTO);
		
		mav.addObject("quesTypeDetail", quesTypeDTO);
		
		return mav;
	}
}
