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
@Table(name = "cases")
public class CaseEntity implements Serializable{
	@Id
	@Column(name = "case_id", nullable = false, columnDefinition = "nvarchar(50)")
	private String caseId;
	@Column(name = "case_name", columnDefinition = "nvarchar(100) null")
	private String caseName;
	@Column(name = "date_of_create", columnDefinition = "datetime null")
	private Date dateOfCreate;
	@Column(name = "status", columnDefinition = "nvarchar(50) null")
	private String status;
	@Column(name = "duration", columnDefinition = "int null")
	private int duration;
	@Column(name = "number_question", columnDefinition = "int null")
	private int numberQuestion;
	
	@ManyToOne
	@JoinColumn(name = "cate_id")
	private CategoryEntity category;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToMany(mappedBy = "caseEntity")
	private Set<QuestionEntity> questions;
	
	@OneToMany(mappedBy = "caseEntity")
	private Set<ResultOfCaseEntity> resultOfCases;
}
