package com.phucdn.learnSpringSecurity.service;

import java.text.ParseException;

import org.springframework.stereotype.Service;

import com.phucdn.learnSpringSecurity.dto.QuizzFormDTO;
import com.phucdn.learnSpringSecurity.entity.ResultOfCaseEntity;

@Service
public interface QuizService {
	ResultOfCaseEntity saveResultOfCase(QuizzFormDTO form) throws ParseException;
	void saveResultOfCaseDetail(QuizzFormDTO form, String rosId) throws ParseException;
}
