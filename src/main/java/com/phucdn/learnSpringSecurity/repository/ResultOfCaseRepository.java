package com.phucdn.learnSpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.learnSpringSecurity.entity.ResultOfCaseEntity;

@Repository
public interface ResultOfCaseRepository extends JpaRepository<ResultOfCaseEntity, String> {

}
