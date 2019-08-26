package com.rogo.repo;

import com.rogo.bean.Question;
import com.rogo.exception.RogoCustomException;
import io.micrometer.core.lang.Nullable;
import org.postgresql.util.PSQLException;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface QuestionRepo<T extends Question> {

    List<T> getQuestions() throws DataAccessException;

    Question getQuestion(@Nullable Integer id) throws RogoCustomException, DataAccessException;

    int addQuestion(T question) throws DataAccessException;

    List<T> getQuestionByTag(String questionTag) throws DataAccessException;;

    int updateQuestion(T question) throws DataAccessException;;

    int deleteQuestion(Integer questionId) throws DataAccessException;;

}
