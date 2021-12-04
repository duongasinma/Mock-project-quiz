package com.phucdn.learnSpringSecurity.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.phucdn.learnSpringSecurity.dto.AnswerDTO;
import com.phucdn.learnSpringSecurity.dto.QuestionAndAnswerDTO;
import com.phucdn.learnSpringSecurity.dto.QuizzFormDTO;
import com.phucdn.learnSpringSecurity.entity.AnswerEntity;
import com.phucdn.learnSpringSecurity.entity.CaseEntity;
import com.phucdn.learnSpringSecurity.entity.QuestionEntity;
import com.phucdn.learnSpringSecurity.repository.AnswerRepository;
import com.phucdn.learnSpringSecurity.repository.CaseRepository;
import com.phucdn.learnSpringSecurity.repository.QuestionRepository;

@Controller
public class QuizzService {
	
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
	
//	 public QuizzFormDTO loadQuizzForm(String caseId) {
//		 QuizzFormDTO form = new QuizzFormDTO();
//		 Map<QuestionAndAnswerDTO, List<AnswerDTO>> quizz = new HashMap<>();
//		 
//		 CaseEntity caseE = caseService.getById(caseId);
//		 List<QuestionEntity> listQues = questionRepository.findByCaseEntity(caseE);
////		 System.out.println("Question List 1st: "+ listQues.get(0).getQuesName());
//		 
//		 for(QuestionEntity quesE : listQues) {
//			 QuestionAndAnswerDTO quesAndAns = new QuestionAndAnswerDTO();
//			 quesAndAns.setQuesId(quesE.getQuesId());
//			 quesAndAns.setQuesName(quesE.getQuesName());
//			 
//			 List<AnswerEntity> listAnsE = answerRepository.loadListAnswerByQuestionId(quesE.getQuesId());
//			 List<AnswerDTO> listAnsD = new ArrayList<AnswerDTO>();
//			 for(AnswerEntity ansE: listAnsE) {
//				 AnswerDTO ansD = new AnswerDTO();
//				 BeanUtils.copyProperties(ansE , ansD);
//				 ansD.setQuesId(ansE.getQuestionEntity().getQuesId());
//				 listAnsD.add(ansD);
//			 }
////			 System.out.println("Question: "+ quesAndAns.getQuesName());
////			 System.out.println("Answer: "+ listAnsD.get(0).getAnsName());
//			 quizz.put(quesAndAns, listAnsD);			 
//		 }
//		 System.out.println("Leng "+ quizz.size());
//		 form.setQuizz(quizz);
//		 System.out.println("Leng form "+ form.getQuizz().size());
//		 long mills = System.currentTimeMillis();			
//		 Date dateOfStart = new Date(mills);
//		 form.setDateOfStart(dateOfStart);
//		 for(Map.Entry<QuestionAndAnswerDTO, List<AnswerDTO>> entry : form.getQuizz().entrySet()) {
//			 System.out.println("List answer: "+entry.getValue());
//		 }
//		 //System.out.println("size answer name: "+ form.getQuizz().get().size());
//
//		 return form;
//	 }
}
