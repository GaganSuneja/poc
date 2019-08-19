package com.rogo.repo;

import com.rogo.bean.Question;
import io.micrometer.core.lang.Nullable;

import java.util.List;

public interface QuestionRepo<T extends Question> {

    List<T> getQuestion(@Nullable Integer id);

    int addQuestion(T question);

    List<T> getQuestionByTag(String questionTag);


}
