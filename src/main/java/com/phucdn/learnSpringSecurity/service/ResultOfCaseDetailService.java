package com.phucdn.learnSpringSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phucdn.learnSpringSecurity.entity.ResultOfCaseDetailEntity;

public interface ResultOfCaseDetailService {

	<S extends ResultOfCaseDetailEntity> List<S> findAll(Example<S> example, Sort sort);

	<S extends ResultOfCaseDetailEntity> List<S> findAll(Example<S> example);

	ResultOfCaseDetailEntity getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends ResultOfCaseDetailEntity> entities);

	ResultOfCaseDetailEntity getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	void delete(ResultOfCaseDetailEntity entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	long count();

	void deleteAllInBatch(Iterable<ResultOfCaseDetailEntity> entities);

	<S extends ResultOfCaseDetailEntity> boolean exists(Example<S> example);

	<S extends ResultOfCaseDetailEntity> long count(Example<S> example);

	void deleteInBatch(Iterable<ResultOfCaseDetailEntity> entities);

	<S extends ResultOfCaseDetailEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends ResultOfCaseDetailEntity> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends ResultOfCaseDetailEntity> S saveAndFlush(S entity);

	void flush();

	<S extends ResultOfCaseDetailEntity> List<S> saveAll(Iterable<S> entities);

	Optional<ResultOfCaseDetailEntity> findById(String id);

	List<ResultOfCaseDetailEntity> findAllById(Iterable<String> ids);

	List<ResultOfCaseDetailEntity> findAll(Sort sort);

	List<ResultOfCaseDetailEntity> findAll();

	Page<ResultOfCaseDetailEntity> findAll(Pageable pageable);

	<S extends ResultOfCaseDetailEntity> Optional<S> findOne(Example<S> example);

	<S extends ResultOfCaseDetailEntity> S save(S entity);

}
