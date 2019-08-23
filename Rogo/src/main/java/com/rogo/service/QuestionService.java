package com.rogo.service;

import com.rogo.bean.Question;
import com.rogo.responseClasses.ResponseDataMap;
import com.rogo.responseClasses.ResponseMap;

import java.util.LinkedHashMap;
import java.util.List;

public interface QuestionService {
    public ResponseMap getQuestions(Integer questionTypeId);

    public ResponseMap addQuestion(LinkedHashMap question);

    public ResponseMap getQuestionByTag(String questionTag);

    public ResponseMap editQuestion(LinkedHashMap question);

    public ResponseMap getQuestion(Integer questionTypeId,Integer questionId);

    public ResponseMap deleteQuestion(Integer questionTypeId,Integer questionId);
}
