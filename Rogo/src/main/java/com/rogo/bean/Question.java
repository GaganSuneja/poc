package com.rogo.bean;

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

    public int getQuestionMark() {
        return questionMark;
    }

    public void setQuestionMark(int questionMark) {
        this.questionMark = questionMark;
    }
}




