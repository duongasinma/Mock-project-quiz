package com.phucdn.learnSpringSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.phucdn.learnSpringSecurity.entity.QuestionTypeEntity;

@Repository
public interface QuestionTypeService {

	<S extends QuestionTypeEntity> List<S> findAll(Example<S> example, Sort sort);

	<S extends QuestionTypeEntity> List<S> findAll(Example<S> example);

	QuestionTypeEntity getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends QuestionTypeEntity> entities);

	QuestionTypeEntity getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	void delete(QuestionTypeEntity entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	long count();

	void deleteAllInBatch(Iterable<QuestionTypeEntity> entities);

	<S extends QuestionTypeEntity> boolean exists(Example<S> example);

	<S extends QuestionTypeEntity> long count(Example<S> example);

	void deleteInBatch(Iterable<QuestionTypeEntity> entities);

	<S extends QuestionTypeEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends QuestionTypeEntity> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends QuestionTypeEntity> S saveAndFlush(S entity);

	void flush();

	<S extends QuestionTypeEntity> List<S> saveAll(Iterable<S> entities);

	Optional<QuestionTypeEntity> findById(String id);

	List<QuestionTypeEntity> findAllById(Iterable<String> ids);

	List<QuestionTypeEntity> findAll(Sort sort);

	List<QuestionTypeEntity> findAll();

	Page<QuestionTypeEntity> findAll(Pageable pageable);

	<S extends QuestionTypeEntity> Optional<S> findOne(Example<S> example);

	<S extends QuestionTypeEntity> S save(S entity);

}
