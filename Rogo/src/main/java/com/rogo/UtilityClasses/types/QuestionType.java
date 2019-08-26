package com.rogo.UtilityClasses.types;


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
