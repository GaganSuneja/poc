package com.rogo.UtilityClasses;

import com.rogo.bean.McqQuestion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class McqQuestionRowMapper implements RowMapper<McqQuestion> {
    @Override
    public McqQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
        McqQuestion mcqQuestion = new McqQuestion();
        mcqQuestion.setQuestionId(rs.getInt("q_id"));
        mcqQuestion.setQuestionTypeId(rs.getInt("q_type_id"));
        mcqQuestion.setQuestionMark(rs.getInt("q_mark"));
        mcqQuestion.setQuestionText(rs.getString("q_text"));
        mcqQuestion.setOptionA(rs.getString("option_a"));
        mcqQuestion.setOptionB(rs.getString("option_b"));
        mcqQuestion.setOptionC(rs.getString("option_c"));
        mcqQuestion.setOptionD(rs.getString("option_d"));
        mcqQuestion.setAnswerKey(rs.getInt("answer_key"));
        if (rs.getString("q_tag") == null) {
            mcqQuestion.setQuestionTag("");
        } else {
            mcqQuestion.setQuestionTag(rs.getString("q_tag"));
        }

        return mcqQuestion;
    }
}
