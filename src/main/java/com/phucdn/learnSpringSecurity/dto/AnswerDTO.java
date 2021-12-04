package com.phucdn.learnSpringSecurity.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDTO implements Serializable{
	private String ansId;
	private String ansName;
	private String isCorrect;
	private String status;
	private String quesId;
}
