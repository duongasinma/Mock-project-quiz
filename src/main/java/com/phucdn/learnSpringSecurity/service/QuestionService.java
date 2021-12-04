package com.phucdn.learnSpringSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phucdn.learnSpringSecurity.entity.QuestionEntity;

public interface QuestionService {

	<S extends QuestionEntity> List<S> findAll(Example<S> example, Sort sort);

	<S extends QuestionEntity> List<S> findAll(Example<S> example);

	QuestionEntity getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends QuestionEntity> entities);

	QuestionEntity getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	void delete(QuestionEntity entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	long count();

	void deleteAllInBatch(Iterable<QuestionEntity> entities);

	<S extends QuestionEntity> boolean exists(Example<S> example);

	<S extends QuestionEntity> long count(Example<S> example);

	void deleteInBatch(Iterable<QuestionEntity> entities);

	<S extends QuestionEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends QuestionEntity> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends QuestionEntity> S saveAndFlush(S entity);

	void flush();

	<S extends QuestionEntity> List<S> saveAll(Iterable<S> entities);

	Optional<QuestionEntity> findById(String id);

	List<QuestionEntity> findAllById(Iterable<String> ids);

	List<QuestionEntity> findAll(Sort sort);

	List<QuestionEntity> findAll();

	Page<QuestionEntity> findAll(Pageable pageable);

	<S extends QuestionEntity> Optional<S> findOne(Example<S> example);

	<S extends QuestionEntity> S save(S entity);

}
