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
import com.phucdn.learnSpringSecurity.entity.UserEntity;
import com.phucdn.learnSpringSecurity.repository.CaseRepository;
import com.phucdn.learnSpringSecurity.repository.CategoryRepository;
import com.phucdn.learnSpringSecurity.service.CaseService;

@Controller
@RequestMapping("/api/v1/admin/cases")
public class AdminCaseController {

	@Autowired
	private CaseService caseService;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CaseRepository caseRepository;

	@GetMapping()
	public String loadCasePage(Model model) {
		model.addAttribute("listCase", caseService.findAll());
		return "admin/cases/case";
	}

	@GetMapping("/addNewCase")
	public String loadAddNewCasePage(Model model) {
		model.addAttribute("case", new CaseDTO());
		model.addAttribute("listCategory", categoryRepository.loadCategoryByActiveStatus());
		return "admin/cases/addNewCase";
	}

	@PostMapping("/saveCase")
	public ModelAndView addNewCase(ModelMap model, @ModelAttribute("case") CaseDTO caseDTO, Principal principal) {
		CaseEntity caseEntity = new CaseEntity();
		BeanUtils.copyProperties(caseDTO, caseEntity);
		CategoryEntity cateEntity = new CategoryEntity();
		cateEntity.setCateId(caseDTO.getCateId());
		caseEntity.setCategory(cateEntity);
		long mills = System.currentTimeMillis();
		
		Date dateOfCreate = new Date(mills);
		String caseId = "case-"+ dateOfCreate.getTime();
		caseEntity.setCaseId(caseId);
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(principal.getName());
		caseEntity.setUser(userEntity);
		caseEntity.setDateOfCreate(dateOfCreate);
		caseEntity.setStatus("Active");

		caseService.save(caseEntity);

		model.addAttribute("message", "Case is saved!");

		return new ModelAndView("redirect:/api/v1/admin/cases", model);
	}

	@GetMapping("/deleteCase/{id}")
	public String banCaseByCaseId(@PathVariable("id") String caseId) {
		caseRepository.banCaseByCaseId(caseId);
		return "redirect:/api/v1/admin/cases";
	}
	
	@GetMapping("/reActivateCase/{id}")
	public String reActivateCaseByCaseId(@PathVariable("id") String caseId) {
		caseRepository.reActivateCaseByCaseId(caseId);
		return "redirect:/api/v1/admin/cases";
	}
	//Edit case - AS
	@GetMapping("/editCase/{id}")
	public ModelAndView showEditCasePage(@PathVariable("id") String caseId) {
		ModelAndView mav = new ModelAndView("admin/cases/updateCase");
		CaseEntity caseEntity = caseService.getById(caseId);
		CaseDTO caseDTO = new CaseDTO();
		BeanUtils.copyProperties(caseEntity, caseDTO);
		String cateId = caseEntity.getCategory().getCateId();
		caseDTO.setCateId(cateId);
		mav.addObject("case", caseDTO);		
		mav.addObject("listCategory", categoryRepository.loadCategoryByActiveStatus());
		return mav;
	}
	
	@PostMapping("/updateCase")
	public String updateCaseById(@ModelAttribute("case") CaseDTO caseDTO) {
		String caseId = caseDTO.getCaseId();
		String caseName = caseDTO.getCaseName();
		long mills = System.currentTimeMillis();
		Date dateOfUpdate = new Date(mills);
		String cateId = caseDTO.getCateId();
		int duration = caseDTO.getDuration();
		int numberQ = caseDTO.getNumberQuestion();
		//caseRepository.updateCategoryByCategoryId(cateId, cateName, dateOfUpdate);
		caseRepository.updateCaseByCaseId(caseId, caseName, dateOfUpdate, cateId, duration, numberQ);
		
		return "redirect:/api/v1/admin/cases";
	}
	
}
