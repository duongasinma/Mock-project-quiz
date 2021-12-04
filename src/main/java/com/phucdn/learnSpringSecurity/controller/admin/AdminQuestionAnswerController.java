package com.phucdn.learnSpringSecurity.controller.admin;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.phucdn.learnSpringSecurity.dto.AnswerDTO;
import com.phucdn.learnSpringSecurity.dto.QuestionDTO;
import com.phucdn.learnSpringSecurity.entity.AnswerEntity;
import com.phucdn.learnSpringSecurity.entity.CaseEntity;
import com.phucdn.learnSpringSecurity.entity.QuestionEntity;
import com.phucdn.learnSpringSecurity.entity.QuestionTypeEntity;
import com.phucdn.learnSpringSecurity.repository.AnswerRepository;
import com.phucdn.learnSpringSecurity.repository.CaseRepository;
import com.phucdn.learnSpringSecurity.repository.QuestionRepository;
import com.phucdn.learnSpringSecurity.service.AnswerService;
import com.phucdn.learnSpringSecurity.service.CaseService;
import com.phucdn.learnSpringSecurity.service.QuestionService;

@Controller
@RequestMapping("/api/v1/admin/ques&ans")
public class AdminQuestionAnswerController {

	@Autowired
	private CaseService caseService;
	
	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private CaseRepository caseRepository;

	@Autowired
	private AnswerService answerService;

	@Autowired
	private AnswerRepository answerRepository;

	@GetMapping()
	public String loadCasePage(Model model) {
		model.addAttribute("listCase", caseService.findAll());
		return "admin/questions&answers/listCases";
	}
	
	@GetMapping("/detail/{id}")
	public String loadQuesAndAnsPage(Model model, @RequestParam("p") Optional<Integer> p, @PathVariable("id") String caseId) {
		//Pageable pageable = PageRequest.of(p.orElse(0), 10);
		//Page<QuestionEntity> page = questionService.findAllById(pageable, caseId);
		CaseEntity caseE = caseService.getById(caseId);
		String caseName = caseE.getCaseName();
		
		model.addAttribute("listQuestion", questionRepository.findByCaseEntity(caseE));
		model.addAttribute("caseId", caseId);
		model.addAttribute("caseName",caseName);

		return "admin/questions&answers/quesAndAns";
	}

	@GetMapping("/banQues/{id}")
	public String banQuestionByQuestionId(@PathVariable("id") String quesId) {
		questionRepository.banQuestionByQuestionId(quesId);
		QuestionEntity ques = questionService.getById(quesId);
		String caseId = ques.getCaseEntity().getCaseId();
		return "redirect:/api/v1/admin/ques&ans/detail/"+caseId;
	}

	@GetMapping("/reActivate/{id}")
	public String reActivateQuestionByQuestionId(@PathVariable("id") String quesId) {
		questionRepository.reActivateQuestionByQuestionId(quesId);
		QuestionEntity ques = questionService.getById(quesId);
		String caseId = ques.getCaseEntity().getCaseId();

		return "redirect:/api/v1/admin/ques&ans/detail/" + caseId;
	}

	@GetMapping("/addNewQues/{id}")
	public String loadAddNewQuestion(Model model, @PathVariable("id") String caseId) {
		CaseEntity caseE = caseService.getById(caseId);
		
		model.addAttribute("listAllQuestion", questionRepository.findByCaseEntity(caseE));
		model.addAttribute("question", new QuestionDTO());
		//model.addAttribute("listCase", caseRepository.loadCaseWithActiveStatus());
		model.addAttribute("caseId", caseId);
		return "admin/questions&answers/addNewQuestion";
	}

	@PostMapping("/saveQuestion")
	public ModelAndView addNewQues(ModelMap model, @ModelAttribute("question") QuestionDTO quesDTO, @RequestParam(name="caseId", required = false) String case_id) {
		quesDTO.setCaseId(case_id);
		QuestionEntity quesEntity = new QuestionEntity();
		BeanUtils.copyProperties(quesDTO, quesEntity);
		long mills = System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);
		quesEntity.setDateOfCreate(dateOfCreate);
		quesEntity.setStatus("Active");
		CaseEntity caseEntity = new CaseEntity();
		caseEntity.setCaseId(quesDTO.getCaseId());
//		System.out.println("Case Id: " + quesDTO.getCaseId());
		quesEntity.setCaseEntity(caseEntity);
		String quesId = "Q-" + dateOfCreate.getTime();
		quesEntity.setQuesId(quesId);
//		System.out.println(quesEntity.getQuesId());
//		System.out.println(quesEntity.getQuesName());
//		System.out.println(quesEntity.getStatus());

		QuestionTypeEntity quesType = new QuestionTypeEntity();
		quesType.setQuesTypeId("qt-001");
		quesEntity.setQuestionType(quesType);
		questionService.save(quesEntity);

		model.addAttribute("addQuesSuccess", "Question is saved!");
		QuestionEntity quesFindById = questionService.getById(quesId);
		QuestionDTO quesReturn = new QuestionDTO();
		BeanUtils.copyProperties(quesFindById, quesReturn);
		String caseId = quesFindById.getCaseEntity().getCaseId();
		quesReturn.setCaseId(caseId);
		model.addAttribute("question", quesReturn);
		model.addAttribute("answer", new AnswerDTO());
		return new ModelAndView("admin/questions&answers/addNewAns", model);
	}

	@PostMapping("/saveAns/{id}")
	public ModelAndView addAnsInQues(@PathVariable("id") String quesId, ModelMap model,
			@ModelAttribute("answer") AnswerDTO ansDTO) {
		AnswerEntity ansEntity = new AnswerEntity();
		BeanUtils.copyProperties(ansDTO, ansEntity);
		String correctText = ansDTO.getIsCorrect();
		if (correctText.equalsIgnoreCase("Yes")) {
			ansEntity.setCorrect(true);
		} else if (correctText.equalsIgnoreCase("No")) {
			ansEntity.setCorrect(false);
		}

		long mills = System.currentTimeMillis();
		Date dateOfCreate = new Date(mills);
		String ansId = "AN-" + dateOfCreate.getTime();
		ansEntity.setAnsId(ansId);
		ansEntity.setStatus("Active");
		QuestionEntity quesEntity = new QuestionEntity();
		quesEntity.setQuesId(quesId);
		ansEntity.setQuestionEntity(quesEntity);

		answerService.save(ansEntity);
		model.addAttribute("addAnsSuccess", "Add Answer is successful!");
		
		QuestionEntity quesFindById = questionService.getById(quesId);
		QuestionDTO quesReturn = new QuestionDTO();
		BeanUtils.copyProperties(quesFindById, quesReturn);
		String caseId = quesFindById.getCaseEntity().getCaseId();
		quesReturn.setCaseId(caseId);

		model.addAttribute("question", quesReturn);
		model.addAttribute("answer", new AnswerDTO());
		model.addAttribute("listAnswerByQuesId", answerRepository.loadListAnswerByQuestionId(quesId));
		return new ModelAndView("admin/questions&answers/addNewAns", model);
	}
	
	@GetMapping("/view-or-edit-ques/{id}")
	public ModelAndView viewQuestionDetail(@PathVariable("id") String quesId, ModelMap model) {
		QuestionEntity quesFindById = questionService.getById(quesId);
		QuestionDTO quesReturn = new QuestionDTO();
		BeanUtils.copyProperties(quesFindById, quesReturn);
		String caseId = quesFindById.getCaseEntity().getCaseId();
		quesReturn.setCaseId(caseId);

		model.addAttribute("question", quesReturn);
		model.addAttribute("answer", new AnswerDTO());
		model.addAttribute("listAnswerByQuesId", answerRepository.loadListAnswerByQuestionId(quesId));
		return new ModelAndView("admin/questions&answers/addNewAns", model);
		
	}
	
	@PostMapping("/updateQues/{id}")
	public String updateQuestion(@PathVariable("id") String quesId,
			@ModelAttribute("question") QuestionDTO quesDTO) {
		String quesName = quesDTO.getQuesName();
		String caseIdUp = quesDTO.getCaseId();
		questionRepository.updateQuestionByQuestionId(quesId, quesName, caseIdUp);
		return ("redirect:/api/v1/admin/ques&ans/view-or-edit-ques/"+quesId);
	}
	
	@GetMapping("/deleteAns/{id}")
	public String deleteAnswer(@PathVariable("id") String ansId) {
		AnswerEntity ans = answerService.getById(ansId);
		String quesId = ans.getQuestionEntity().getQuesId();
		answerService.deleteById(ansId);
		
		return ("redirect:/api/v1/admin/ques&ans/view-or-edit-ques/"+quesId);
	}
	
	@PostMapping("/updateAns/{id}")
	public String updateAnswer(@PathVariable("id") String ansId,  @RequestParam(name="ans", required = false) String ansName, @RequestParam(name="isCorrect", required = false) String isCorrect) {
		AnswerEntity ans = answerService.getById(ansId);
		String quesId = ans.getQuestionEntity().getQuesId();
		
		boolean correct;
		if(isCorrect.equalsIgnoreCase("Yes"))
			correct = true;
		else correct=false;
		answerRepository.updateAnswerByQuestionId(ansId, ansName, correct);
		return ("redirect:/api/v1/admin/ques&ans/view-or-edit-ques/"+quesId);
	}
}
