package com.phucdn.learnSpringSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phucdn.learnSpringSecurity.entity.CaseEntity;

public interface CaseService {

	<S extends CaseEntity> List<S> findAll(Example<S> example, Sort sort);

	<S extends CaseEntity> List<S> findAll(Example<S> example);

	CaseEntity getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends CaseEntity> entities);

	CaseEntity getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	void delete(CaseEntity entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	long count();

	void deleteAllInBatch(Iterable<CaseEntity> entities);

	<S extends CaseEntity> boolean exists(Example<S> example);

	<S extends CaseEntity> long count(Example<S> example);

	void deleteInBatch(Iterable<CaseEntity> entities);

	<S extends CaseEntity> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends CaseEntity> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends CaseEntity> S saveAndFlush(S entity);

	void flush();

	<S extends CaseEntity> List<S> saveAll(Iterable<S> entities);

	Optional<CaseEntity> findById(String id);

	List<CaseEntity> findAllById(Iterable<String> ids);

	List<CaseEntity> findAll(Sort sort);

	List<CaseEntity> findAll();

	Page<CaseEntity> findAll(Pageable pageable);

	<S extends CaseEntity> Optional<S> findOne(Example<S> example);

	<S extends CaseEntity> S save(S entity);

}
