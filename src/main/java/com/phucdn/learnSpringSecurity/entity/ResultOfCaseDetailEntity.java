package com.phucdn.learnSpringSecurity.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "results_of_case_details")
public class ResultOfCaseDetailEntity implements Serializable{
	@Id
	@Column(name = "ros_de_id", nullable = false, columnDefinition = "nvarchar(100)")
	private String rosDeId;
	@Column(name = "ques_id", columnDefinition = "nvarchar(50) null")
	private String quesId;
	@Column(name = "ques_name", columnDefinition = "ntext null")
	private String quesName;
	@Column(name = "ans_id", columnDefinition = "nvarchar(100) null")
	private String ansId;
	@Column(name = "ans_name", columnDefinition = "ntext null")
	private String ansName;
	@Column(name = "is_correct", columnDefinition = "bit null")
	private boolean isCorrect;
	
	@ManyToOne
	@JoinColumn(name = "ros_id", nullable = false)
	private ResultOfCaseEntity resultOfCase;
}
