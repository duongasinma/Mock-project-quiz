package com.phucdn.learnSpringSecurity.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionTypeDTO implements Serializable{
	private String quesTypeId;
	private String quesTypeName;
	private Date dateOfCreate;
	private String description;
	private String status;
}
