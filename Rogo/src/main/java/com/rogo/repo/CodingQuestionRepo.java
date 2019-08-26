package com.rogo.repo;

import com.rogo.bean.CodingQuestion;
import com.rogo.UtilityClasses.mappers.CodingQuestionRowMapper;
import com.rogo.exception.RogoCustomException;
import io.micrometer.core.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CodingQuestionRepo implements QuestionRepo<CodingQuestion> {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<CodingQuestion> getQuestions() throws DataAccessException {
        List<CodingQuestion> codingQuestions = null;

        codingQuestions = jdbcTemplate.query("SELECT * FROM coding_questions",
                new CodingQuestionRowMapper()
        );

        return codingQuestions;
    }

    public CodingQuestion getQuestion(@Nullable Integer questionId) throws RogoCustomException, DataAccessException {
        CodingQuestion codingQuestion = null;
        try {
            codingQuestion = jdbcTemplate.queryForObject("select * from coding_questions where q_id = ?",
                    new CodingQuestionRowMapper()
                    , new Object[]{questionId});
        } catch (EmptyResultDataAccessException e) {
            throw new RogoCustomException(HttpStatus.NOT_FOUND, "Question not Found");
        }

        return codingQuestion;
    }

    @Override
    public int addQuestion(CodingQuestion question) throws DataAccessException {
        int noOfRowAffected = -1;
        noOfRowAffected = jdbcTemplate.update("insert into coding_questions (q_text,q_mark,q_tag) values(?,?,?)",
                new Object[]{
                        question.getQuestionText(), question.getQuestionMark(), question.getQuestionTag()});
        return noOfRowAffected;
    }

    public List<CodingQuestion> getQuestionByTag(String questionTag) throws DataAccessException {
        List<CodingQuestion> codingQuestions = null;
        String query = "select * from coding_questions where q_tag = ?";
        codingQuestions = jdbcTemplate.query(query, new Object[]{questionTag}, new CodingQuestionRowMapper());
        return codingQuestions;
    }


    public int updateQuestion(CodingQuestion codingQuestion) throws DataAccessException {
        int noOfRowsAffected = -1;
        noOfRowsAffected = jdbcTemplate.update("update mcq_questions set q_text = ?," +
                        "q_mark=?,q_tag=?" +
                        "where q_id = ?",
                new Object[]{
                        codingQuestion.getQuestionText(),
                        codingQuestion.getQuestionMark(),
                        codingQuestion.getQuestionTag(),
                        codingQuestion.getQuestionId()
                }
        );
        return noOfRowsAffected;
    }

    public int deleteQuestion(Integer questionId) throws DataAccessException {
        int noOfRowsAffected = -1;

        noOfRowsAffected = jdbcTemplate.update("delete from coding_questions where q_id = ?",
                new Object[]{questionId}
        );
        return noOfRowsAffected;
    }
}
