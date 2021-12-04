package com.phucdn.learnSpringSecurity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phucdn.learnSpringSecurity.entity.QuestionEntity;
import com.phucdn.learnSpringSecurity.repository.QuestionRepository;
import com.phucdn.learnSpringSecurity.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public <S extends QuestionEntity> S save(S entity) {
		return questionRepository.save(entity);
	}

	@Override
	public <S extends QuestionEntity> Optional<S> findOne(Example<S> example) {
		return questionRepository.findOne(example);
	}

	@Override
	public Page<QuestionEntity> findAll(Pageable pageable) {
		return questionRepository.findAll(pageable);
	}

	@Override
	public List<QuestionEntity> findAll() {
		return questionRepository.findAll();
	}

	@Override
	public List<QuestionEntity> findAll(Sort sort) {
		return questionRepository.findAll(sort);
	}

	@Override
	public List<QuestionEntity> findAllById(Iterable<String> ids) {
		return questionRepository.findAllById(ids);
	}

	@Override
	public Optional<QuestionEntity> findById(String id) {
		return questionRepository.findById(id);
	}

	@Override
	public <S extends QuestionEntity> List<S> saveAll(Iterable<S> entities) {
		return questionRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		questionRepository.flush();
	}

	@Override
	public <S extends QuestionEntity> S saveAndFlush(S entity) {
		return questionRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return questionRepository.existsById(id);
	}

	@Override
	public <S extends QuestionEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		return questionRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends QuestionEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return questionRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<QuestionEntity> entities) {
		questionRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends QuestionEntity> long count(Example<S> example) {
		return questionRepository.count(example);
	}

	@Override
	public <S extends QuestionEntity> boolean exists(Example<S> example) {
		return questionRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<QuestionEntity> entities) {
		questionRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return questionRepository.count();
	}

	@Override
	public void deleteById(String id) {
		questionRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		questionRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(QuestionEntity entity) {
		questionRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		questionRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		questionRepository.deleteAllInBatch();
	}

	@Override
	public QuestionEntity getOne(String id) {
		return questionRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends QuestionEntity> entities) {
		questionRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		questionRepository.deleteAll();
	}

	@Override
	public QuestionEntity getById(String id) {
		return questionRepository.getById(id);
	}

	@Override
	public <S extends QuestionEntity> List<S> findAll(Example<S> example) {
		return questionRepository.findAll(example);
	}

	@Override
	public <S extends QuestionEntity> List<S> findAll(Example<S> example, Sort sort) {
		return questionRepository.findAll(example, sort);
	}
	
	
}
