package com.phucdn.learnSpringSecurity.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.phucdn.learnSpringSecurity.entity.AnswerEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAndAnswerDTO implements Serializable{
	private String quesId;
	private String quesName;
	private String ansId;
	private List<AnswerEntity> listAns;
}
