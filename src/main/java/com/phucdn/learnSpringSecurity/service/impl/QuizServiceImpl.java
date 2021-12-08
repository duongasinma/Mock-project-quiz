package com.phucdn.learnSpringSecurity.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phucdn.learnSpringSecurity.dto.QuestionAndAnswerDTO;
import com.phucdn.learnSpringSecurity.dto.QuizzFormDTO;
import com.phucdn.learnSpringSecurity.entity.AnswerEntity;
import com.phucdn.learnSpringSecurity.entity.CaseEntity;
import com.phucdn.learnSpringSecurity.entity.ResultOfCaseDetailEntity;
import com.phucdn.learnSpringSecurity.entity.ResultOfCaseEntity;
import com.phucdn.learnSpringSecurity.entity.UserEntity;
import com.phucdn.learnSpringSecurity.repository.AnswerRepository;
import com.phucdn.learnSpringSecurity.service.CaseService;
import com.phucdn.learnSpringSecurity.service.QuizService;
import com.phucdn.learnSpringSecurity.service.ResultOfCaseDetailService;
import com.phucdn.learnSpringSecurity.service.ResultOfCaseService;
import com.phucdn.learnSpringSecurity.service.UserService;

@Service
public class QuizServiceImpl implements QuizService {
	@Autowired
	private CaseService caseService;

	@Autowired
	private UserService userService;

	@Autowired
	private ResultOfCaseService resultOfCaseService;

	@Autowired
	private ResultOfCaseDetailService resultOfCaseDetailService;

	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public ResultOfCaseEntity saveResultOfCase(QuizzFormDTO form) throws ParseException {
		if (form.getListQuesAndAns().size() > 0) {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(form.getDateOfStart());
			int numberAnsCorrect = 0;
			double total = 0;
			String rosId = "ros-" + date.getTime();
			ResultOfCaseEntity rosEntity = new ResultOfCaseEntity();
			rosEntity.setRosId(rosId);
			rosEntity.setDateOfBegin(date);
			long mills = System.currentTimeMillis();
			Date dateOffinish = new Date(mills);
			rosEntity.setDateOfFinish(dateOffinish);
			CaseEntity caseE = caseService.getById(form.getCaseId());
			rosEntity.setCaseEntity(caseE);
			UserEntity userE = userService.getById(form.getUserId());
			rosEntity.setUser(userE);

//		check correct and save result detail
			for (QuestionAndAnswerDTO quesAndAns : form.getListQuesAndAns()) {
				// count correct answer
				String ansChoose = quesAndAns.getAnsId();
				if (ansChoose != null) {
					List<AnswerEntity> listCorrectAnswer = answerRepository
							.getCorrectAnswerByQuestionId(quesAndAns.getQuesId());
					for (AnswerEntity ansE : listCorrectAnswer) {
						if (ansChoose.equalsIgnoreCase(ansE.getAnsId())) {
							numberAnsCorrect++;
							break;
						}
					}
				}
			}
			if (numberAnsCorrect != 0) {
				total = ((double) numberAnsCorrect / (double) (form.getListQuesAndAns().size())) * 10;
				total = (double) Math.round(total * 100) / 100;
			} else
				total = 0;
			rosEntity.setTotalPoint(total);
			rosEntity.setNumberCorrect(numberAnsCorrect);

			resultOfCaseService.save(rosEntity);
			this.saveResultOfCaseDetail(form, rosId);
			return rosEntity;
		}
		System.out.println("Size null");
		return null;
	}

	@Override
	public void saveResultOfCaseDetail(QuizzFormDTO form, String rosId) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(form.getDateOfStart());
		ResultOfCaseEntity rosEntity = resultOfCaseService.getById(rosId);
		for (QuestionAndAnswerDTO quesAndAns : form.getListQuesAndAns()) {
			ResultOfCaseDetailEntity rosDetail = new ResultOfCaseDetailEntity();
			rosDetail.setRosDeId("rosDe-" + quesAndAns.getQuesId() + "-" + date.getTime());// trung ten
			rosDetail.setResultOfCase(rosEntity);
			rosDetail.setQuesId(quesAndAns.getQuesId());
			rosDetail.setQuesName(quesAndAns.getQuesName());
			rosDetail.setCorrect(false);
			rosDetail.setAnsId(quesAndAns.getAnsId());
			// count correct answer
			String ansChoose = quesAndAns.getAnsId();
			if (ansChoose != null) {
				List<AnswerEntity> listCorrectAnswer = answerRepository
						.getCorrectAnswerByQuestionId(quesAndAns.getQuesId());
				for (AnswerEntity ansE : listCorrectAnswer) {
					if (ansChoose.equalsIgnoreCase(ansE.getAnsId())) {
						rosDetail.setCorrect(true);
						break;
					}
				}
			}
			resultOfCaseDetailService.save(rosDetail);
		}

	}

}
