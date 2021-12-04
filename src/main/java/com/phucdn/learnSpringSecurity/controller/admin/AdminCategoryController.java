package com.phucdn.learnSpringSecurity.controller.admin;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phucdn.learnSpringSecurity.dto.CategoryDTO;
import com.phucdn.learnSpringSecurity.entity.CategoryEntity;
import com.phucdn.learnSpringSecurity.repository.CategoryRepository;
import com.phucdn.learnSpringSecurity.service.CategoryService;

@Controller
@RequestMapping("/api/v1/admin/categories")
public class AdminCategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping()
	public String loadCategoryPage(Model model) {
		model.addAttribute("listCategory", categoryService.findAll());
		return "admin/categories/category";
	}
	
	@GetMapping("/addNewCategory")
	public String loadAddNewCategoryPage(Model model) {
		model.addAttribute("category", new CategoryDTO());
		
		return "admin/categories/addNewCategory";
	}
	
	@PostMapping("/saveCategory")
	public String saveNewCategory(@ModelAttribute("category") CategoryDTO cateDTO) {
		CategoryEntity entity = new CategoryEntity();
		BeanUtils.copyProperties(cateDTO, entity);
		Long mills = System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);
		entity.setDateOfCreate(dateOfCreate);
		entity.setStatus(true);
		
		categoryService.save(entity);
		
		return "redirect:/api/v1/admin/categories";
		
	}
	
	@GetMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable("id") String cateId) {
		categoryRepository.updateCategoryStatusByCategoryId(cateId);
		
		return "redirect:/api/v1/admin/categories";
		
	}
	
	@GetMapping("/editCategory/{id}")
	public ModelAndView showEditCategoryPage(@PathVariable("id") String cateId) {
		ModelAndView mav = new ModelAndView("admin/categories/updateCategory");
		CategoryEntity categoryEntity = categoryService.getById(cateId);
		CategoryDTO cateDTO = new CategoryDTO();
		BeanUtils.copyProperties(categoryEntity, cateDTO);
		mav.addObject("category", cateDTO);		
		return mav;
	}
	
	@PostMapping("/updateCategory")
	public String updateCategoryById(@ModelAttribute("category") CategoryDTO cateDTO) {
		String cateId = cateDTO.getCateId();
		String cateName = cateDTO.getCateName();
		long mills = System.currentTimeMillis();
		Date dateOfUpdate = new Date(mills);
		
		categoryRepository.updateCategoryByCategoryId(cateId, cateName, dateOfUpdate);
		
		return "redirect:/api/v1/admin/categories";
	}
}
