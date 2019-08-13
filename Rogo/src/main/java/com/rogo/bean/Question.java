package com.rogo.bean;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = McqQuestion.class, name = "mcq"),
//        @JsonSubTypes.Type(value = CodingQuestion.class, name = "coding")
//})
public class Question {
    private int questionId;
    private int questionTypeId;
    private int questionMark;

    private String questionTag;
    private String questionText;

    Question(){}

    Question(int questionMark, String questionTag, String questionText) {
        this.questionMark = questionMark;
        this.questionTag = questionTag;
        this.questionText = questionText;
    }

    public String getQuestionTag() {
        return questionTag;
    }

    public void setQuestionTag(String questionTag) {
        this.questionTag = questionTag;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public int getQuestionMarks() {
        return questionMark;
    }

    public void setQuestionMarks(int questionMark) {
        this.questionMark = questionMark;
    }
}




