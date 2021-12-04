package com.phucdn.learnSpringSecurity.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phucdn.learnSpringSecurity.entity.CaseEntity;

@Repository
@Transactional
public interface CaseRepository extends JpaRepository<CaseEntity, String>{

	@Modifying
	@Query(value = "update cases set status = 'InActive' "
			+ "where case_id = :caseId", nativeQuery = true)
	void banCaseByCaseId(@Param("caseId") String caseId);
	
	@Modifying
	@Query(value = "update cases set status = 'Active' "
			+ "where case_id = :caseId", nativeQuery = true)
	void reActivateCaseByCaseId(@Param("caseId") String caseId);
	
	@Query(value = "select * from cases "
			+ "where status = 'Active'", nativeQuery = true)
	List<CaseEntity> loadCaseWithActiveStatus();
	// Update case -AS
	@Query(value = "select * from cases "
			+ "where status = 'Active' "
			+ "and cate_id = :cateId", nativeQuery = true)
	List<CaseEntity> loadCaseWithActiveStatusByCateId(@Param("cateId") String caseId);
	@Modifying
	@Query(value = "update cases set case_name = :caseName, "
			+ "date_of_create = :dateOfUpdate, "
			+ "cate_id = :cateId, "
			+ "duration = :duration, number_question = :numberQ "
			+ "where case_id = :caseId", nativeQuery = true)
	void updateCaseByCaseId(@Param("caseId") String caseId, @Param("caseName") String caseName, @Param("dateOfUpdate") Date dateOfUpdate,
			@Param("cateId") String cateId,  @Param("duration") int duration, @Param("numberQ") int numberQ);
	
	@Query(value = "select number_question from cases "
			+ "where case_id = :caseId", nativeQuery = true)
	int getNumberQuesOfCase(@Param("caseId") String caseId);
}
