package com.phucdn.learnSpringSecurity.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultOfCaseDetailDTO implements Serializable{
	private String rosDeId;
	private String quesId;
	private String quesName;
	private String ansId;
	private String ansName;
	private boolean isCorrect;
	private String userId;
}
