package com.rogo.service;

import com.rogo.exception.RogoCustomException;
import com.rogo.UtilityClasses.responseClasses.ResponseMap;
import org.springframework.dao.DataAccessException;

import java.util.LinkedHashMap;

public interface QuestionService {
    ResponseMap getQuestions(Integer questionTypeId) ;

    ResponseMap addQuestion(LinkedHashMap question) ;

    ResponseMap getQuestionByTag(String questionTag) ;

    ResponseMap editQuestion(LinkedHashMap question) ;

    ResponseMap getQuestion(Integer questionTypeId, Integer questionId) throws RogoCustomException;

    ResponseMap deleteQuestion(Integer questionTypeId, Integer questionId) ;
}
