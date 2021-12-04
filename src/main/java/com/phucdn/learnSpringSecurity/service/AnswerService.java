package com.phucdn.learnSpringSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phucdn.learnSpringSecurity.entity.AnswerEntity;

public interface AnswerService {

	<S extends AnswerEntity> List<S> findAll(Example<S> example, Sort sort);

	<S extends AnswerEntity> List<S> findAll(Example<S> example);

	AnswerEntity getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends AnswerEntity> entities);

	AnswerEntity getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	void delete(AnswerEntity entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	long count();

	void deleteAllInBatch(Iterable<AnswerEntity> entities);

	<S extends AnswerEntity> boolean exists(Example<S> example);

	<S extends AnswerEntity> long count(Example<S> example);

	void deleteInBatch(Iterable<AnswerEntity> entities);

	<S extends AnswerEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends AnswerEntity> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends AnswerEntity> S saveAndFlush(S entity);

	void flush();

	<S extends AnswerEntity> List<S> saveAll(Iterable<S> entities);

	Optional<AnswerEntity> findById(String id);

	List<AnswerEntity> findAllById(Iterable<String> ids);

	List<AnswerEntity> findAll(Sort sort);

	List<AnswerEntity> findAll();

	Page<AnswerEntity> findAll(Pageable pageable);

	<S extends AnswerEntity> Optional<S> findOne(Example<S> example);

	<S extends AnswerEntity> S save(S entity);

}
