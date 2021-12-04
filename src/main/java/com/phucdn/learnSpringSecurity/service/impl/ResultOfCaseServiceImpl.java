package com.phucdn.learnSpringSecurity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phucdn.learnSpringSecurity.entity.ResultOfCaseEntity;
import com.phucdn.learnSpringSecurity.repository.ResultOfCaseRepository;
import com.phucdn.learnSpringSecurity.service.ResultOfCaseService;

@Service
public class ResultOfCaseServiceImpl implements ResultOfCaseService{

	@Autowired
	private ResultOfCaseRepository resultOfCaseRepository;

	@Override
	public <S extends ResultOfCaseEntity> S save(S entity) {
		return resultOfCaseRepository.save(entity);
	}

	@Override
	public <S extends ResultOfCaseEntity> Optional<S> findOne(Example<S> example) {
		return resultOfCaseRepository.findOne(example);
	}

	@Override
	public Page<ResultOfCaseEntity> findAll(Pageable pageable) {
		return resultOfCaseRepository.findAll(pageable);
	}

	@Override
	public List<ResultOfCaseEntity> findAll() {
		return resultOfCaseRepository.findAll();
	}

	@Override
	public List<ResultOfCaseEntity> findAll(Sort sort) {
		return resultOfCaseRepository.findAll(sort);
	}

	@Override
	public List<ResultOfCaseEntity> findAllById(Iterable<String> ids) {
		return resultOfCaseRepository.findAllById(ids);
	}

	@Override
	public Optional<ResultOfCaseEntity> findById(String id) {
		return resultOfCaseRepository.findById(id);
	}

	@Override
	public <S extends ResultOfCaseEntity> List<S> saveAll(Iterable<S> entities) {
		return resultOfCaseRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		resultOfCaseRepository.flush();
	}

	@Override
	public <S extends ResultOfCaseEntity> S saveAndFlush(S entity) {
		return resultOfCaseRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return resultOfCaseRepository.existsById(id);
	}

	@Override
	public <S extends ResultOfCaseEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		return resultOfCaseRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends ResultOfCaseEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return resultOfCaseRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<ResultOfCaseEntity> entities) {
		resultOfCaseRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends ResultOfCaseEntity> long count(Example<S> example) {
		return resultOfCaseRepository.count(example);
	}

	@Override
	public <S extends ResultOfCaseEntity> boolean exists(Example<S> example) {
		return resultOfCaseRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<ResultOfCaseEntity> entities) {
		resultOfCaseRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return resultOfCaseRepository.count();
	}

	@Override
	public void deleteById(String id) {
		resultOfCaseRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		resultOfCaseRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(ResultOfCaseEntity entity) {
		resultOfCaseRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		resultOfCaseRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		resultOfCaseRepository.deleteAllInBatch();
	}

	@Override
	public ResultOfCaseEntity getOne(String id) {
		return resultOfCaseRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends ResultOfCaseEntity> entities) {
		resultOfCaseRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		resultOfCaseRepository.deleteAll();
	}

	@Override
	public ResultOfCaseEntity getById(String id) {
		return resultOfCaseRepository.getById(id);
	}

	@Override
	public <S extends ResultOfCaseEntity> List<S> findAll(Example<S> example) {
		return resultOfCaseRepository.findAll(example);
	}

	@Override
	public <S extends ResultOfCaseEntity> List<S> findAll(Example<S> example, Sort sort) {
		return resultOfCaseRepository.findAll(example, sort);
	}
	
	
}
