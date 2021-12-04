package com.phucdn.learnSpringSecurity.controller.user;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.phucdn.learnSpringSecurity.dto.QuestionAndAnswerDTO;
import com.phucdn.learnSpringSecurity.dto.QuizzFormDTO;
import com.phucdn.learnSpringSecurity.entity.AnswerEntity;
import com.phucdn.learnSpringSecurity.entity.CaseEntity;
import com.phucdn.learnSpringSecurity.entity.QuestionEntity;
import com.phucdn.learnSpringSecurity.repository.AnswerRepository;
import com.phucdn.learnSpringSecurity.repository.CaseRepository;
import com.phucdn.learnSpringSecurity.repository.CategoryRepository;
import com.phucdn.learnSpringSecurity.repository.QuestionRepository;
import com.phucdn.learnSpringSecurity.service.CaseService;
import com.phucdn.learnSpringSecurity.service.QuizzService;

@Controller
@RequestMapping("/api/v1/quizzHiHi/quizzes")
public class UserQuizzController {
	@Autowired
	private CaseService caseService;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CaseRepository caseRepository;
	
	@Autowired
	private QuizzService quizzService;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
//	@GetMapping()
//	public String loadCasePage(Model model) {
//		model.addAttribute("listCase", caseRepository.loadCaseWithActiveStatus());
//		model.addAttribute("listCategory", categoryRepository.loadCategoryByActiveStatus());
//		return "user/quizzes/listQuizzes";
//	}
//	@GetMapping("/start/{id}")
//	public String loadQizzPage(Model model, Principal principal, @PathVariable("id") String caseId){
//		QuizzFormDTO form = quizzService.loadQuizzForm(caseId);
//		form.setUserId(principal.getName());
//		List<QuestionAndAnswerDTO> listQuesAndAns = new ArrayList<>(form.getQuizz().keySet());
//		CaseEntity caseE = caseService.getById(caseId);
//		String caseName = caseE.getCaseName();
//		
////		System.out.println("username: "+ principal.getName());
//		model.addAttribute("quizzForm", form);
//		model.addAttribute("caseName", caseName);
//		return "user/quizzes/quizzForm";
//	}
	// bonus
Boolean submitted = false;
	
	@GetMapping("/playTest")
	public String loadTestCase(@RequestParam(value = "quizCaseId") String caseId,
				Model model) {
		int numOfQues = caseRepository.getNumberQuesOfCase(caseId);
		System.out.println(numOfQues);
		String quesName = null;
		String quesId = null;
		QuestionAndAnswerDTO quesAndAns = new QuestionAndAnswerDTO();
		List<QuestionAndAnswerDTO> listQuesAndAns = new ArrayList<>();
//		List<AnswerDTO> listAnsReal = new ArrayList<>();
		List<QuestionEntity> lisQues  =  questionRepository.getQuestionByCaseId(caseId, numOfQues);		
		List<AnswerEntity> lisAns = new ArrayList<>();				
		
		for (QuestionEntity ques : lisQues) {			
			quesId = ques.getQuesId();
			quesName = ques.getQuesName();
			lisAns = answerRepository.loadListAnswerByQuestionId(quesId);
			
			quesAndAns = new QuestionAndAnswerDTO(quesId, quesName, null, lisAns);
			listQuesAndAns.add(quesAndAns);
		}
		QuizzFormDTO qForm = new QuizzFormDTO();
		qForm.setListQuesAndAns(listQuesAndAns);
		qForm.setCaseId(caseId);
		System.out.println("Case id: "+ caseId);
		model.addAttribute("qForm", qForm);
//		model.addAttribute("qForm", listQuesAndAns);
		return "user/quizzes/quizPage";
	}
	
	@PostMapping("/submit")
	public String submit(@ModelAttribute QuizzFormDTO form, Model m) {
		System.out.println("Case id: "+ form.getCaseId());

		int numOfQues = caseRepository.getNumberQuesOfCase(form.getCaseId());
		
		System.out.println("Size of quiz: "+numOfQues);
		System.out.println("Size: "+form.getListQuesAndAns().size());
		System.out.println("Hello World:" + form.getListQuesAndAns().get(0).getAnsId());
		System.out.println("question id:" + form.getListQuesAndAns().get(0).getQuesId());
//		System.out.println("question id:" + form.getListQuesAndAns().get(1).getQuesId());

//		System.out.println("Hello World:" + form.getListQuesAndAns().get(2).getAnswerId().toString());
		return "user/quizzes/result";
	}
}
