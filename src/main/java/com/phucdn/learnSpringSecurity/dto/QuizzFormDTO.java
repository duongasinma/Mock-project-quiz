package com.phucdn.learnSpringSecurity.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizzFormDTO implements Serializable {
	private String userId;
	private String caseId;
	private String dateOfStart;
	private Date dateOfSubmit;
//	private Map<QuestionAndAnswerDTO, List<AnswerDTO>> quizz; 
	private List<QuestionAndAnswerDTO> listQuesAndAns;
}
