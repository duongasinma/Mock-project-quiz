package com.phucdn.learnSpringSecurity.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phucdn.learnSpringSecurity.entity.AnswerEntity;
import com.phucdn.learnSpringSecurity.repository.AnswerRepository;
import com.phucdn.learnSpringSecurity.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public <S extends AnswerEntity> S save(S entity) {
		return answerRepository.save(entity);
	}

	@Override
	public <S extends AnswerEntity> Optional<S> findOne(Example<S> example) {
		return answerRepository.findOne(example);
	}

	@Override
	public Page<AnswerEntity> findAll(Pageable pageable) {
		return answerRepository.findAll(pageable);
	}

	@Override
	public List<AnswerEntity> findAll() {
		return answerRepository.findAll();
	}

	@Override
	public List<AnswerEntity> findAll(Sort sort) {
		return answerRepository.findAll(sort);
	}

	@Override
	public List<AnswerEntity> findAllById(Iterable<String> ids) {
		return answerRepository.findAllById(ids);
	}

	@Override
	public Optional<AnswerEntity> findById(String id) {
		return answerRepository.findById(id);
	}

	@Override
	public <S extends AnswerEntity> List<S> saveAll(Iterable<S> entities) {
		return answerRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		answerRepository.flush();
	}

	@Override
	public <S extends AnswerEntity> S saveAndFlush(S entity) {
		return answerRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return answerRepository.existsById(id);
	}

	@Override
	public <S extends AnswerEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		return answerRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends AnswerEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		return answerRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<AnswerEntity> entities) {
		answerRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends AnswerEntity> long count(Example<S> example) {
		return answerRepository.count(example);
	}

	@Override
	public <S extends AnswerEntity> boolean exists(Example<S> example) {
		return answerRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<AnswerEntity> entities) {
		answerRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return answerRepository.count();
	}

	@Override
	public void deleteById(String id) {
		answerRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		answerRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(AnswerEntity entity) {
		answerRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		answerRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		answerRepository.deleteAllInBatch();
	}

	@Override
	public AnswerEntity getOne(String id) {
		return answerRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends AnswerEntity> entities) {
		answerRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		answerRepository.deleteAll();
	}

	@Override
	public AnswerEntity getById(String id) {
		return answerRepository.getById(id);
	}

	@Override
	public <S extends AnswerEntity> List<S> findAll(Example<S> example) {
		return answerRepository.findAll(example);
	}

	@Override
	public <S extends AnswerEntity> List<S> findAll(Example<S> example, Sort sort) {
		return answerRepository.findAll(example, sort);
	}
	
	
}
