package com.phucdn.learnSpringSecurity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phucdn.learnSpringSecurity.entity.CaseEntity;
import com.phucdn.learnSpringSecurity.repository.CaseRepository;
import com.phucdn.learnSpringSecurity.service.CaseService;

@Service
public class CaseServiceImpl implements CaseService{

	@Autowired
	private CaseRepository caseRepository;

	@Override
	public <S extends CaseEntity> S save(S entity) {
		return caseRepository.save(entity);
	}

	@Override
	public <S extends CaseEntity> Optional<S> findOne(Example<S> example) {
		return caseRepository.findOne(example);
	}

	@Override
	public Page<CaseEntity> findAll(Pageable pageable) {
		return caseRepository.findAll(pageable);
	}

	@Override
	public List<CaseEntity> findAll() {
		return caseRepository.findAll();
	}

	@Override
	public List<CaseEntity> findAll(Sort sort) {
		return caseRepository.findAll(sort);
	}

	@Override
	public List<CaseEntity> findAllById(Iterable<String> ids) {
		return caseRepository.findAllById(ids);
	}

	@Override
	public Optional<CaseEntity> findById(String id) {
		return caseRepository.findById(id);
	}

	@Override
	public <S extends CaseEntity> List<S> saveAll(Iterable<S> entities) {
		return caseRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		caseRepository.flush();
	}

	@Override
	public <S extends CaseEntity> S saveAndFlush(S entity) {
		return caseRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return caseRepository.existsById(id);
	}

	@Override
	public <S extends CaseEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		return caseRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends CaseEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return caseRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<CaseEntity> entities) {
		caseRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends CaseEntity> long count(Example<S> example) {
		return caseRepository.count(example);
	}

	@Override
	public <S extends CaseEntity> boolean exists(Example<S> example) {
		return caseRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<CaseEntity> entities) {
		caseRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return caseRepository.count();
	}

	@Override
	public void deleteById(String id) {
		caseRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		caseRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(CaseEntity entity) {
		caseRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		caseRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		caseRepository.deleteAllInBatch();
	}

	@Override
	public CaseEntity getOne(String id) {
		return caseRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends CaseEntity> entities) {
		caseRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		caseRepository.deleteAll();
	}

	@Override
	public CaseEntity getById(String id) {
		return caseRepository.getById(id);
	}

	@Override
	public <S extends CaseEntity> List<S> findAll(Example<S> example) {
		return caseRepository.findAll(example);
	}

	@Override
	public <S extends CaseEntity> List<S> findAll(Example<S> example, Sort sort) {
		return caseRepository.findAll(example, sort);
	}
	
	
}
