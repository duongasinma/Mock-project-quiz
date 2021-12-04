package com.phucdn.learnSpringSecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phucdn.learnSpringSecurity.entity.CaseEntity;
import com.phucdn.learnSpringSecurity.entity.QuestionEntity;

@Repository
@Transactional
public interface QuestionRepository extends JpaRepository<QuestionEntity, String>{

	@Modifying
	@Query(value = "update questions set status = 'InActive' "
			+ "where ques_id = :quesId", nativeQuery = true)
	void banQuestionByQuestionId(@Param("quesId") String quesId);
	
	@Modifying
	@Query(value = "update questions set status = 'Active' "
			+ "where ques_id = :quesId", nativeQuery = true)
	void reActivateQuestionByQuestionId(@Param("quesId") String quesId);
	
	@Modifying
	@Query(value = "update questions set ques_name =:quesName, "
			+ "case_id = :caseId "
			+ "where ques_id = :quesId", nativeQuery = true)
	void updateQuestionByQuestionId(@Param("quesId") String quesId, 
			@Param("quesName") String quesName, @Param("caseId") String caseId);
	
	@Query(value = "select top (:numQues) q.ques_id, q.ques_name, q.date_of_create, q.case_id, q.ques_type_id, q.[status]\r\n"
			+ "from questions q join cases c on\r\n"
			+ "q.case_id = c.case_id\r\n"
			+ "where q.[status] = 'Active' and q.case_id = :caseId\r\n"
			+ "order by NEWID()", nativeQuery = true)
	List<QuestionEntity> getQuestionByCaseId(@Param("caseId") String caseId, @Param("numQues") int numQues);
	
	List<QuestionEntity> findByCaseEntity(CaseEntity caseEntity);
}
