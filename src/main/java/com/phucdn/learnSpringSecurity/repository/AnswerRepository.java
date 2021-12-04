package com.phucdn.learnSpringSecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phucdn.learnSpringSecurity.entity.AnswerEntity;

@Repository
@Transactional
public interface AnswerRepository extends JpaRepository<AnswerEntity, String> {

	@Query(value = "select * from answers "
			+ "where ques_id = :quesId", nativeQuery = true)
	List<AnswerEntity> loadListAnswerByQuestionId(@Param("quesId") String quesId);
	
	@Modifying
	@Query(value = "update answers set ans_name =:ansName, "
			+ "is_correct = :isCorrect "
			+ "where ans_id = :ansId", nativeQuery = true)
	void updateAnswerByQuestionId(@Param("ansId") String ansId, 
			@Param("ansName") String ansName, @Param("isCorrect") boolean isCorrcet);
}
