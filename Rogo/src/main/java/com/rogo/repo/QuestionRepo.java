package com.rogo.repo;

import com.rogo.bean.Question;

import java.util.List;

public interface QuestionRepo<T extends Question> {

    List<T> getQuestion();

    void addQuestion(T question);
}
