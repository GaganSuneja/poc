package com.rogo.bean;

import com.rogo.config.constants;

import java.util.LinkedHashMap;

public class CodingQuestion extends Question {

    public CodingQuestion() {
    }

    public CodingQuestion(LinkedHashMap map){
        super(  (int)map.get(constants.questionMark.toString()),
                map.get(constants.questionTag.toString()).toString(),
                map.get(constants.questionText.toString()).toString());

    }

    public CodingQuestion(LinkedHashMap map,Boolean isUpdate){
        super(  (int)map.get(constants.questionMark.toString()),
                map.get(constants.questionTag.toString()).toString(),
                map.get(constants.questionText.toString()).toString(),
                (int) map.get(constants.questionId.toString()),
                (int) map.get(constants.questionTypeId.toString()));


    }
}
