package com.rogo.service;

import com.rogo.bean.Question;
import com.rogo.responseClasses.ResponseDataMap;
import com.rogo.responseClasses.ResponseMap;

import java.util.LinkedHashMap;
import java.util.List;

public interface QuestionService {
    public List<Question> getAll(int id);

    public ResponseMap addQuestion(LinkedHashMap question);

    public ResponseDataMap getQuestionByTag(String questionTag);

}
