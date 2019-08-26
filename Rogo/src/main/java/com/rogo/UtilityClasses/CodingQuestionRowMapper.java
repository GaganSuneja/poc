package com.rogo.UtilityClasses;

import com.rogo.bean.CodingQuestion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CodingQuestionRowMapper implements RowMapper<CodingQuestion> {
    @Override
    public CodingQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
        CodingQuestion codingQuestion = new CodingQuestion();
        codingQuestion.setQuestionId(rs.getInt("q_id"));
        codingQuestion.setQuestionTypeId(rs.getInt("q_type_id"));
        codingQuestion.setQuestionMark(rs.getInt("q_mark"));
        codingQuestion.setQuestionText(rs.getString("q_text"));
        if (rs.getString("q_tag").isEmpty()) {
            codingQuestion.setQuestionTag("");
        } else {
            codingQuestion.setQuestionTag(rs.getString("q_tag"));
        }

        return codingQuestion;
    }
}
