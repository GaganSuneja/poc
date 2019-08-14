package com.rogo.repo;

import com.rogo.bean.Question;

import java.util.List;

public interface QuestionRepo<T extends Question> {

    List<T> getQuestion();

    int addQuestion(T question);

    List<T> getQuestionByTag(String questionTag);
}
