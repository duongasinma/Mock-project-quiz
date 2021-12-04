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
@Table(name = "answers")
public class AnswerEntity implements Serializable {
	@Id
	@Column(name = "ans_id", nullable = false,columnDefinition = "nvarchar(100)")
	private String ansId;
	@Column(name = "ans_name", columnDefinition = "ntext null")
	private String ansName;
	@Column(name = "is_correct", columnDefinition = "bit null")
	private boolean isCorrect;
	@Column(name = "status", columnDefinition = "nvarchar(50) null")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "ques_id", nullable = false)
	private QuestionEntity questionEntity;
}
