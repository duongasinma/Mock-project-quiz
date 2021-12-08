package com.phucdn.learnSpringSecurity.controller.user;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
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
import com.phucdn.learnSpringSecurity.entity.ResultOfCaseEntity;
import com.phucdn.learnSpringSecurity.entity.UserEntity;
import com.phucdn.learnSpringSecurity.repository.AnswerRepository;
import com.phucdn.learnSpringSecurity.repository.CaseRepository;
import com.phucdn.learnSpringSecurity.repository.QuestionRepository;
import com.phucdn.learnSpringSecurity.service.CaseService;
import com.phucdn.learnSpringSecurity.service.QuizService;
import com.phucdn.learnSpringSecurity.service.ResultOfCaseService;
import com.phucdn.learnSpringSecurity.service.UserService;

@Controller
@RequestMapping("/api/v1/quizzHiHi/quizzes")
public class UserQuizzController {
	@Autowired
	private CaseService caseService;

	@Autowired
	private CaseRepository caseRepository;

	@Autowired
	private QuizService quizService;

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private UserService userService;

	Boolean submitted = false;

	@GetMapping("/playTest")
	public String loadTestCase(@RequestParam(value = "quizCaseId") String caseId, Model model) {
		int numOfQues = caseRepository.getNumberQuesOfCase(caseId);
		System.out.println(numOfQues);
		String quesName = null;
		String quesId = null;
		QuestionAndAnswerDTO quesAndAns = new QuestionAndAnswerDTO();
		List<QuestionAndAnswerDTO> listQuesAndAns = new ArrayList<>();
		List<QuestionEntity> lisQues = questionRepository.getQuestionByCaseId(caseId, numOfQues);
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
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatDateTime = now.format(formatter);
		qForm.setDateOfStart(formatDateTime);
		model.addAttribute("qForm", qForm);
		return "user/quizzes/quizPage";
	}

	@PostMapping("/submit")
	public String submit(@ModelAttribute QuizzFormDTO form, Model m, Principal principal) throws ParseException {
		User loginnedUser = (User) ((Authentication) principal).getPrincipal();
		form.setUserId(loginnedUser.getUsername());
		ResultOfCaseEntity rosEntity = quizService.saveResultOfCase(form);
		if (rosEntity == null) {
			m.addAttribute("Submit", submitted);
		}
		m.addAttribute("rosEntity", rosEntity);
		m.addAttribute("numOfQues", form.getListQuesAndAns().size());
		return "user/quizzes/result";
	}
}
