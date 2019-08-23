package com.rogo.repo;

import com.rogo.bean.CodingQuestion;
import com.rogo.bean.McqQuestion;
import com.rogo.bean.McqQuestionRowMapper;
import com.rogo.exception.RogoCustomException;
import io.micrometer.core.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
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

    public List<McqQuestion> getQuestions() {
        List<McqQuestion> mcqQuestions = null;
        try {
            mcqQuestions = jdbcTemplate.query("select * from mcq_questions", new McqQuestionRowMapper());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return mcqQuestions;
    }

    public McqQuestion getQuestion(@Nullable Integer questionId) throws RogoCustomException{
        McqQuestion mcqQuestion = null;
        try {
            mcqQuestion = jdbcTemplate.queryForObject("select * from mcq_questions where q_id = ?", new McqQuestionRowMapper()
                    , new Object[]{questionId});
        }catch(EmptyResultDataAccessException e){
            throw new RogoCustomException(HttpStatus.NOT_FOUND,"resource not found");
        }

        return mcqQuestion;
    }

    public int addQuestion(McqQuestion mcqQuestion) {
        int noOfRowsAffected = -1;
        try {
            noOfRowsAffected = jdbcTemplate.update("insert into mcq_questions(q_text," +
                            "option_a,option_b,option_c,option_d,answer_key,q_mark,q_tag)" +
                            " values (?,?,?,?,?,?,?,?)",
                    new Object[]{
                            mcqQuestion.getQuestionText(),
                            mcqQuestion.getOptionA(),
                            mcqQuestion.getOptionB(),
                            mcqQuestion.getoptionC(),
                            mcqQuestion.getOptionD(),
                            mcqQuestion.getAnswerKey(),
                            mcqQuestion.getQuestionMark(),
                            mcqQuestion.getQuestionTag()
                    }
            );
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return noOfRowsAffected;
    }

    public int updateQuestion(McqQuestion mcqQuestion) {

        int noOfRowsAffected = -1;

        noOfRowsAffected = jdbcTemplate.update("update mcq_questions set q_text = ?," +
                        "option_a = ?,option_b=?,option_c=?,option_d=?,answer_key=?,q_mark=?,q_tag=?" +
                        "where q_id = ?",
                new Object[]{
                        mcqQuestion.getQuestionText(),
                        mcqQuestion.getOptionA(),
                        mcqQuestion.getOptionB(),
                        mcqQuestion.getoptionC(),
                        mcqQuestion.getOptionD(),
                        mcqQuestion.getAnswerKey(),
                        mcqQuestion.getQuestionMark(),
                        mcqQuestion.getQuestionTag(),
                        mcqQuestion.getQuestionId()
                }
        );

        return noOfRowsAffected;
    }

    public List<McqQuestion> getQuestionByTag(String questionTag) {
        List<McqQuestion> mcqQuestions = null;
        String query = "select * from mcq_questions where q_tag = ?";
        try {
            mcqQuestions = jdbcTemplate.query(query, new Object[]{questionTag}, new McqQuestionRowMapper());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return mcqQuestions;
    }

    public int deleteQuestion(Integer questionId){
        int noOfRowsAffected = -1;

        noOfRowsAffected = jdbcTemplate.update("delete from mcq_questions where q_id = ?",
                new Object[]{questionId}
        );

        return noOfRowsAffected;

    }

}
