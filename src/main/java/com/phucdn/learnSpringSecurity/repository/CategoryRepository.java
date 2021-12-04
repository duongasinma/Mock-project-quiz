package com.phucdn.learnSpringSecurity.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.phucdn.learnSpringSecurity.entity.CategoryEntity;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {

	@Modifying
	@Query(value = "update categories set status = 0 "
			+ "where cate_id = ?1", nativeQuery = true)
	void updateCategoryStatusByCategoryId(String cateId);
	
	@Modifying
	@Query(value = "update categories set cate_name = :cateName, "
			+ "date_of_create = :dateOfUpdate "
			+ "where cate_id = :cateId", nativeQuery = true)
	void updateCategoryByCategoryId(@Param("cateId") String cateId, @Param("cateName") String cateName, @Param("dateOfUpdate") Date dateOfUpdate);
	
	@Query(value = "select * from categories "
			+ "where status = 1", nativeQuery = true)
	List<CategoryEntity> loadCategoryByActiveStatus();
}
