package com.rogo.repo;

import com.rogo.bean.McqQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;


@Repository
public class McqQuestionRepo implements QuestionRepo<McqQuestion> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<McqQuestion> getQuestion() {
        List<McqQuestion> mcqQuestions = null;
        try {
            mcqQuestions = jdbcTemplate.query("select * from mcq_questions", new BeanPropertyRowMapper<McqQuestion>(McqQuestion.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return mcqQuestions;
    }

    public void addQuestion(McqQuestion mcqQuestion) {
        jdbcTemplate.update("insert into mcq_questions(q_text,option_a,option_b,option_c,option_d,answer_key,q_type_id,q_mark) values (?,?,?,?,?,?,?,?)",
                new Object[]{
                        mcqQuestion.getQuestionText(),
                        mcqQuestion.getOptionA(),
                        mcqQuestion.getOptionB(),
                        mcqQuestion.getoptionC(),
                        mcqQuestion.getOptionD(),
                        mcqQuestion.getAnswerKey(),
                        mcqQuestion.getQuestionId(),
                        mcqQuestion.getQuestionMarks()
                }
        );
    }

}
