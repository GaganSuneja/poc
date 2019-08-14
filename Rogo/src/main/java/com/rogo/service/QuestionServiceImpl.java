package com.rogo.service;

import com.rogo.bean.CodingQuestion;
import com.rogo.bean.McqQuestion;
import com.rogo.bean.Question;
import com.rogo.config.*;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.rogo.responseClasses.ResponseDataMap;
import com.rogo.responseClasses.ResponseMap;
import com.rogo.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepo<McqQuestion> mcqQuestionRepo;
    @Autowired
    QuestionRepo<CodingQuestion> codingQuestionRepo;
    @Autowired
    ResponseMap responseMap;

    public List<Question> getAll(int id) {
        if (id == 1) {
            List<Question> questions = (List<Question>) (Object) mcqQuestionRepo.getQuestion();
            //  return  mcqQuestionRepo.getQuestion().stream().map(q -> (Question) q).collect(Collectors.toList());
            return questions;
        } else {
            //return  codingQuestionRepo.getQuestion().stream().map(q -> (Question) q).collect(Collectors.toList());
            return (List) codingQuestionRepo.getQuestion();
        }
    }

    public ResponseMap addQuestion(LinkedHashMap question) {
        Boolean isQuestionAdded;
        int questionTypeId = (int) question.get(constants.questionTypeId.toString());
        if (questionTypeId == 1) {
            McqQuestion mcqQuestion = new McqQuestion(question);
            isQuestionAdded = (mcqQuestionRepo.addQuestion(mcqQuestion) > 0);
            if (isQuestionAdded) {
                responseMap.setResponseSucess("Mcq question added successfully");
            } else {
                responseMap.setResponseError("Mcq question could not be added");
            }
            return responseMap;
        } else {
        }
        return responseMap;
    }
    public ResponseDataMap getQuestionByTag(String questionTag){
        List<CodingQuestion> codingQuestions = codingQuestionRepo.getQuestionByTag(questionTag);
        List<McqQuestion> mcqQuestions = mcqQuestionRepo.getQuestionByTag(questionTag);
        HashMap questionsMap = new HashMap();
        ResponseDataMap responseDataMap = new ResponseDataMap();
        if(codingQuestions == null){
            questionsMap.put("codingQuestions",new List[]{});
        }else
        {
            questionsMap.put("codingQuestions",codingQuestions);
        }
        if(mcqQuestions == null){
            questionsMap.put("mcqQuestions",new List[]{});
        }else{

            questionsMap.put("mcqQuestions",mcqQuestions);
        }

        responseDataMap.setResponseSucess("QuestionsFound");

        responseDataMap.putData("questions",questionsMap);
        return responseDataMap;
    }

}
