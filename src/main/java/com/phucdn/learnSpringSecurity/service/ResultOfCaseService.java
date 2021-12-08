package com.phucdn.learnSpringSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phucdn.learnSpringSecurity.entity.ResultOfCaseEntity;
import com.phucdn.learnSpringSecurity.entity.UserEntity;

public interface ResultOfCaseService {

	<S extends ResultOfCaseEntity> List<S> findAll(Example<S> example, Sort sort);

	<S extends ResultOfCaseEntity> List<S> findAll(Example<S> example);

	ResultOfCaseEntity getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends ResultOfCaseEntity> entities);

	ResultOfCaseEntity getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	void delete(ResultOfCaseEntity entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	long count();

	void deleteAllInBatch(Iterable<ResultOfCaseEntity> entities);

	<S extends ResultOfCaseEntity> boolean exists(Example<S> example);

	<S extends ResultOfCaseEntity> long count(Example<S> example);

	void deleteInBatch(Iterable<ResultOfCaseEntity> entities);

	<S extends ResultOfCaseEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends ResultOfCaseEntity> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends ResultOfCaseEntity> S saveAndFlush(S entity);

	void flush();

	<S extends ResultOfCaseEntity> List<S> saveAll(Iterable<S> entities);

	Optional<ResultOfCaseEntity> findById(String id);

	List<ResultOfCaseEntity> findAllById(Iterable<String> ids);

	List<ResultOfCaseEntity> findAll(Sort sort);

	List<ResultOfCaseEntity> findAll();

	Page<ResultOfCaseEntity> findAll(Pageable pageable);

	<S extends ResultOfCaseEntity> Optional<S> findOne(Example<S> example);

	<S extends ResultOfCaseEntity> S save(S entity);
	
	List<ResultOfCaseEntity> findByUser(UserEntity user);

}
