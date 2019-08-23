package com.rogo.repo;

import com.rogo.bean.Question;
import com.rogo.exception.RogoCustomException;
import io.micrometer.core.lang.Nullable;

import java.util.List;

public interface QuestionRepo<T extends Question> {

    List<T> getQuestions();

    Question getQuestion(@Nullable Integer id) throws RogoCustomException;

    int addQuestion(T question);

    List<T> getQuestionByTag(String questionTag);

    int updateQuestion(T question);

    int deleteQuestion(Integer questionId);

}
