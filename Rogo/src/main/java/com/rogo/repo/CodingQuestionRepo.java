package com.rogo.repo;

import com.rogo.bean.CodingQuestion;
import com.rogo.bean.CodingQuestionRowMapper;
import com.rogo.responseClasses.ResponseMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CodingQuestionRepo implements QuestionRepo<CodingQuestion> {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    ResponseMap responseMap;
    @Override
    public List<CodingQuestion> getQuestion() {
        List<CodingQuestion> codingQuestions = null;

        try {
            codingQuestions = jdbcTemplate.query("SELECT * FROM coding_questions",
                    new CodingQuestionRowMapper()
            );

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return codingQuestions;
    }

    @Override
    public int addQuestion(CodingQuestion question) {
        jdbcTemplate.update("insert into coding_question (q_text,q_mark) values(?,?)", new Object[]{
                question.getQuestionText(), question.getQuestionMarks()
        });

        return 1;
    }

    public List<CodingQuestion> getQuestionByTag(String questionTag) {
        List<CodingQuestion> codingQuestions = null;

        String query = "select * from coding_questions where q_tag = ?";
        try {
            codingQuestions = jdbcTemplate.query(query,new Object[]{questionTag},new CodingQuestionRowMapper());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return codingQuestions;
    }
}
