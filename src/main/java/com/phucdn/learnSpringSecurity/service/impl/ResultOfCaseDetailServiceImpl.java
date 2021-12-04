package com.phucdn.learnSpringSecurity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phucdn.learnSpringSecurity.entity.ResultOfCaseDetailEntity;
import com.phucdn.learnSpringSecurity.repository.ResultOfCaseDetailRepository;
import com.phucdn.learnSpringSecurity.service.ResultOfCaseDetailService;

@Service
public class ResultOfCaseDetailServiceImpl implements ResultOfCaseDetailService{

	@Autowired
	private ResultOfCaseDetailRepository resultOfCaseDetailRepository;

	@Override
	public <S extends ResultOfCaseDetailEntity> S save(S entity) {
		return resultOfCaseDetailRepository.save(entity);
	}

	@Override
	public <S extends ResultOfCaseDetailEntity> Optional<S> findOne(Example<S> example) {
		return resultOfCaseDetailRepository.findOne(example);
	}

	@Override
	public Page<ResultOfCaseDetailEntity> findAll(Pageable pageable) {
		return resultOfCaseDetailRepository.findAll(pageable);
	}

	@Override
	public List<ResultOfCaseDetailEntity> findAll() {
		return resultOfCaseDetailRepository.findAll();
	}

	@Override
	public List<ResultOfCaseDetailEntity> findAll(Sort sort) {
		return resultOfCaseDetailRepository.findAll(sort);
	}

	@Override
	public List<ResultOfCaseDetailEntity> findAllById(Iterable<String> ids) {
		return resultOfCaseDetailRepository.findAllById(ids);
	}

	@Override
	public Optional<ResultOfCaseDetailEntity> findById(String id) {
		return resultOfCaseDetailRepository.findById(id);
	}

	@Override
	public <S extends ResultOfCaseDetailEntity> List<S> saveAll(Iterable<S> entities) {
		return resultOfCaseDetailRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		resultOfCaseDetailRepository.flush();
	}

	@Override
	public <S extends ResultOfCaseDetailEntity> S saveAndFlush(S entity) {
		return resultOfCaseDetailRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return resultOfCaseDetailRepository.existsById(id);
	}

	@Override
	public <S extends ResultOfCaseDetailEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		return resultOfCaseDetailRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends ResultOfCaseDetailEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return resultOfCaseDetailRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<ResultOfCaseDetailEntity> entities) {
		resultOfCaseDetailRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends ResultOfCaseDetailEntity> long count(Example<S> example) {
		return resultOfCaseDetailRepository.count(example);
	}

	@Override
	public <S extends ResultOfCaseDetailEntity> boolean exists(Example<S> example) {
		return resultOfCaseDetailRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<ResultOfCaseDetailEntity> entities) {
		resultOfCaseDetailRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return resultOfCaseDetailRepository.count();
	}

	@Override
	public void deleteById(String id) {
		resultOfCaseDetailRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		resultOfCaseDetailRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(ResultOfCaseDetailEntity entity) {
		resultOfCaseDetailRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		resultOfCaseDetailRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		resultOfCaseDetailRepository.deleteAllInBatch();
	}

	@Override
	public ResultOfCaseDetailEntity getOne(String id) {
		return resultOfCaseDetailRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends ResultOfCaseDetailEntity> entities) {
		resultOfCaseDetailRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		resultOfCaseDetailRepository.deleteAll();
	}

	@Override
	public ResultOfCaseDetailEntity getById(String id) {
		return resultOfCaseDetailRepository.getById(id);
	}

	@Override
	public <S extends ResultOfCaseDetailEntity> List<S> findAll(Example<S> example) {
		return resultOfCaseDetailRepository.findAll(example);
	}

	@Override
	public <S extends ResultOfCaseDetailEntity> List<S> findAll(Example<S> example, Sort sort) {
		return resultOfCaseDetailRepository.findAll(example, sort);
	}
	
	
}
