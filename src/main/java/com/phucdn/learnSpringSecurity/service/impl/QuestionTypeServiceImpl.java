package com.phucdn.learnSpringSecurity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phucdn.learnSpringSecurity.entity.QuestionTypeEntity;
import com.phucdn.learnSpringSecurity.repository.QuestionTypeRepository;
import com.phucdn.learnSpringSecurity.service.QuestionTypeService;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService{

	@Autowired
	private QuestionTypeRepository questionTypeRepository;

	@Override
	public <S extends QuestionTypeEntity> S save(S entity) {
		return questionTypeRepository.save(entity);
	}

	@Override
	public <S extends QuestionTypeEntity> Optional<S> findOne(Example<S> example) {
		return questionTypeRepository.findOne(example);
	}

	@Override
	public Page<QuestionTypeEntity> findAll(Pageable pageable) {
		return questionTypeRepository.findAll(pageable);
	}

	@Override
	public List<QuestionTypeEntity> findAll() {
		return questionTypeRepository.findAll();
	}

	@Override
	public List<QuestionTypeEntity> findAll(Sort sort) {
		return questionTypeRepository.findAll(sort);
	}

	@Override
	public List<QuestionTypeEntity> findAllById(Iterable<String> ids) {
		return questionTypeRepository.findAllById(ids);
	}

	@Override
	public Optional<QuestionTypeEntity> findById(String id) {
		return questionTypeRepository.findById(id);
	}

	@Override
	public <S extends QuestionTypeEntity> List<S> saveAll(Iterable<S> entities) {
		return questionTypeRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		questionTypeRepository.flush();
	}

	@Override
	public <S extends QuestionTypeEntity> S saveAndFlush(S entity) {
		return questionTypeRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return questionTypeRepository.existsById(id);
	}

	@Override
	public <S extends QuestionTypeEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		return questionTypeRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends QuestionTypeEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return questionTypeRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<QuestionTypeEntity> entities) {
		questionTypeRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends QuestionTypeEntity> long count(Example<S> example) {
		return questionTypeRepository.count(example);
	}

	@Override
	public <S extends QuestionTypeEntity> boolean exists(Example<S> example) {
		return questionTypeRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<QuestionTypeEntity> entities) {
		questionTypeRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return questionTypeRepository.count();
	}

	@Override
	public void deleteById(String id) {
		questionTypeRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		questionTypeRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(QuestionTypeEntity entity) {
		questionTypeRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		questionTypeRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		questionTypeRepository.deleteAllInBatch();
	}

	@Override
	public QuestionTypeEntity getOne(String id) {
		return questionTypeRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends QuestionTypeEntity> entities) {
		questionTypeRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		questionTypeRepository.deleteAll();
	}

	@Override
	public QuestionTypeEntity getById(String id) {
		return questionTypeRepository.getById(id);
	}

	@Override
	public <S extends QuestionTypeEntity> List<S> findAll(Example<S> example) {
		return questionTypeRepository.findAll(example);
	}

	@Override
	public <S extends QuestionTypeEntity> List<S> findAll(Example<S> example, Sort sort) {
		return questionTypeRepository.findAll(example, sort);
	}
	
	
}
