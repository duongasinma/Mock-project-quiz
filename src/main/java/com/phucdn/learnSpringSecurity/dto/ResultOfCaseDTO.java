package com.phucdn.learnSpringSecurity.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultOfCaseDTO implements Serializable{
	private String rosId;
	private Date dateOfBegin;
	private Date dateOfFinish;
	private int numberCorrect;
	private double totalPoint;
	private String userId;
	private String caseId;
}
