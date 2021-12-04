package com.phucdn.learnSpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.learnSpringSecurity.entity.QuestionTypeEntity;

@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionTypeEntity, String> {

}
