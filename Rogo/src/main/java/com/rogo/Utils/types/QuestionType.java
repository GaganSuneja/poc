package com.rogo.Utils.types;


public enum QuestionType {
    MCQ(1),
    CODING(2);

    public final Integer questionID;

    QuestionType(Integer questionID) {
        this.questionID = questionID;
    }
    public Integer questionID() {
        return questionID;
    }
}
