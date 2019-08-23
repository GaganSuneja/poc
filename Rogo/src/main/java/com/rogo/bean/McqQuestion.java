package com.rogo.bean;


import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;
import com.rogo.config.*;
public class McqQuestion extends Question {

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private int answerKey;

    public McqQuestion() {
    }

    public McqQuestion(String optionA, String optionB, String optionC, String optionD, int answerKey) {
        setOptionsAndAnswerKey(optionA,optionB,optionC,optionD,answerKey);
    }

    public McqQuestion(LinkedHashMap map){
        super(  (int)map.get(constants.questionMark.toString()),
                map.get(constants.questionTag.toString()).toString(),
                map.get(constants.questionText.toString()).toString());

        setOptionsAndAnswerKey(
                map.get(constants.optionA.toString()).toString(),
                map.get(constants.optionB.toString()).toString(),
                map.get(constants.optionC.toString()).toString(),
                map.get(constants.optionD.toString()).toString(),
                (int) map.get(constants.answerKey.toString())
        );

    }

    public McqQuestion(LinkedHashMap map,Boolean isUpdate){
        super(  (int)map.get(constants.questionMark.toString()),
                map.get(constants.questionTag.toString()).toString(),
                map.get(constants.questionText.toString()).toString(),
                (int) map.get(constants.questionId.toString()),
                (int) map.get(constants.questionTypeId.toString()));

        setOptionsAndAnswerKey(
                map.get(constants.optionA.toString()).toString(),
                map.get(constants.optionB.toString()).toString(),
                map.get(constants.optionC.toString()).toString(),
                map.get(constants.optionD.toString()).toString(),
                (int) map.get(constants.answerKey.toString())
        );

    }


    public void setOptionsAndAnswerKey(String optionA, String optionB, String optionC, String optionD, int answerKey){
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answerKey = answerKey;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getoptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public int getAnswerKey() {
        return answerKey;
    }

    public void setAnswerKey(int answerKey) {
        this.answerKey = answerKey;
    }

}
