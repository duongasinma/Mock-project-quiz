package com.phucdn.learnSpringSecurity.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questions")
public class QuestionEntity implements Serializable{
	@Id
	@Column(name = "ques_id", nullable = false,columnDefinition = "nvarchar(50)")
	private String quesId;
	@Column(name = "ques_name", columnDefinition = "ntext null")
	private String quesName;
	@Column(name = "date_of_create", columnDefinition = "datetime null")
	private Date dateOfCreate;
	@Column(name = "status", columnDefinition = "nvarchar(50) null")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "case_id", nullable = false)
	private CaseEntity caseEntity;
	
	@ManyToOne
	@JoinColumn(name = "ques_type_id", nullable = false)
	private QuestionTypeEntity questionType;
	
	@OneToMany(mappedBy = "questionEntity")
	private Set<AnswerEntity> answers;
}
