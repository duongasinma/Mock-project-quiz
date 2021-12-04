package com.phucdn.learnSpringSecurity.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseDTO implements Serializable{
	private String caseId;
	private String caseName;
	private Date dateOfCreate;
	private String status;
	private int duration;
	private int numberQuestion;
	private String cateId;
	private String userId;
}
