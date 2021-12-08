package com.phucdn.learnSpringSecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.learnSpringSecurity.entity.ResultOfCaseEntity;
import com.phucdn.learnSpringSecurity.entity.UserEntity;

@Repository
public interface ResultOfCaseRepository extends JpaRepository<ResultOfCaseEntity, String> {
	List<ResultOfCaseEntity> findByUser(UserEntity user);
}
