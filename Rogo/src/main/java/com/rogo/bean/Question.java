package com.rogo.bean;

public class Question {

    private int q_id;
    private String q_text;
    private int q_type_id;
    private int q_mark;

    public int getQuestionId() {
        return q_id;
    }

    public void setQuestionId(int q_id) {
        this.q_id = q_id;
    }

    public String getQuestionText() {
        return q_text;
    }

    public void setQuestionText(String q_text) {
        this.q_text = q_text;
    }

    public int getQuestionTypeId() {
        return q_type_id;
    }

    public void setQuestionTypeId(int q_type_id) {
        this.q_type_id = q_type_id;
    }

    public int getQuestionMarks() {
        return q_mark;
    }

    public void setQuestionMarks(int q_mark) {
        this.q_mark = q_mark;
    }
}




