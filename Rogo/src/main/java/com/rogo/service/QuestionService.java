package com.rogo.service;

import com.rogo.exception.RogoCustomException;
import com.rogo.UtilityClasses.responseClasses.ResponseMap;
import org.springframework.dao.DataAccessException;

import java.util.LinkedHashMap;

public interface QuestionService {
    ResponseMap getQuestions(Integer questionTypeId) throws DataAccessException;

    ResponseMap addQuestion(LinkedHashMap question) throws DataAccessException;

    ResponseMap getQuestionByTag(String questionTag) throws DataAccessException;

    ResponseMap editQuestion(LinkedHashMap question) throws DataAccessException;

    ResponseMap getQuestion(Integer questionTypeId, Integer questionId) throws RogoCustomException, DataAccessException;

    ResponseMap deleteQuestion(Integer questionTypeId, Integer questionId) throws DataAccessException;
}
