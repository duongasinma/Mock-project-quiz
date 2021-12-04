package com.phucdn.learnSpringSecurity.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "results_of_cases")
public class ResultOfCaseEntity implements Serializable{
	@Id
	@Column(name = "ros_id", nullable = false,columnDefinition = "nvarchar(100)")
	private String rosId;
	@Column(name = "date_of_begin", columnDefinition = "datetime null")
	private Date dateOfBegin;
	@Column(name = "date_of_finish", columnDefinition = "datetime null")
	private Date dateOfFinish;
	@Column(name = "number_correct", columnDefinition = "int null")
	private int numberCorrect;
	@Column(name = "total_point", columnDefinition = "float null")
	private double totalPoint;
	
	@OneToMany(mappedBy = "resultOfCase")
	private Set<ResultOfCaseDetailEntity> resultOfCaseDetails;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "case_id", nullable = false)
	private CaseEntity caseEntity;
}
