package com.phucdn.learnSpringSecurity.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "question_types")
public class QuestionTypeEntity implements Serializable{
	@Id
	@Column(name = "ques_type_id", columnDefinition = "nvarchar(50)")
	private String quesTypeId;
	@Column(name = "ques_type_name", columnDefinition = "nvarchar(100) null")
	private String quesTypeName;
	@Column(name = "date_of_create", columnDefinition = "date null")
	private Date dateOfCreate;
	@Column(name = "description", columnDefinition = "ntext null")
	private String description;
	@Column(name = "status", columnDefinition = "nvarchar(50) null")
	private String status;
	
	@OneToMany(mappedBy = "questionType")
	private Set<QuestionEntity> questions;
	
}
