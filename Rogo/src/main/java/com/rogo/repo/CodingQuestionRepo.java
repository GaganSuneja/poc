package com.rogo.repo;

import com.rogo.bean.CodingQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CodingQuestionRepo implements QuestionRepo<CodingQuestion> {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<CodingQuestion> getQuestion() {
        List<CodingQuestion> codingQuestions = null;

        try {
            codingQuestions = jdbcTemplate.query("SELECT * FROM coding_questions",
                    new BeanPropertyRowMapper<CodingQuestion>(CodingQuestion.class)
            );

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return codingQuestions;
    }

    ;

    @Override
    public void addQuestion(CodingQuestion question) {
        jdbcTemplate.update("insert into coding_question (q_text,q_mark) values(?,?)", new Object[]{
                question.getQ_text(), question.getQ_mark()
        });
    }
}
