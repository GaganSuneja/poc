package com.rogo.bean;


public class McqQuestion extends Question{

    private String option_a;
    private String option_b;
    private String option_c;
    private String option_d;
    private int answer_key;

    public McqQuestion() {}

    public McqQuestion(String option_a, String option_b, String option_c, String option_d, int answer_key) {
        this.option_a = option_a;
        this.option_b = option_b;
        this.option_c = option_c;
        this.option_d = option_d;
        this.answer_key = answer_key;
    }

    public String getOptionA() {
        return option_a;
    }

    public void setOptionA(String option_a) {
        this.option_a = option_a;
    }

    public String getOptionB() {
        return option_b;
    }

    public void setOptionB(String option_b) {
        this.option_b = option_b;
    }

    public String getoptionC() {
        return option_c;
    }

    public void setOptionC(String option_c) {
        this.option_c = option_c;
    }

    public String getOptionD() {
        return option_d;
    }

    public void setOptionD(String option_d) {
        this.option_d = option_d;
    }

    public int getAnswerKey() {
        return answer_key;
    }

    public void setAnswerKey(int answer_key) {
        this.answer_key = answer_key;
    }

}
