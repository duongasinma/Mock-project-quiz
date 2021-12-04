package com.phucdn.learnSpringSecurity.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO implements Serializable{
	private String quesId;
	private String quesName;
	private Date dateOfCreate;
	private String status;
	private String caseId;
	private String quesTypeId;	
}
