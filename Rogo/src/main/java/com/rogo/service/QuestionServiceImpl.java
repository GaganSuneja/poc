package com.rogo.service;

import com.rogo.bean.CodingQuestion;
import com.rogo.bean.McqQuestion;
import com.rogo.bean.Question;
import com.rogo.config.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

//import com.rogo.exceptions.NotFoundException;
import com.rogo.responseClasses.ResponseDataMap;
import com.rogo.responseClasses.ResponseMap;
import com.rogo.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepo<McqQuestion> mcqQuestionRepo;
    @Autowired
    QuestionRepo<CodingQuestion> codingQuestionRepo;

    public ResponseDataMap getQuestion(Integer questionTypeId,Integer questionId){
        ResponseDataMap responseDataMap = new ResponseDataMap();

        if(questionTypeId == 1){
            Question mcqQuestion = null;
            try{
                mcqQuestion = mcqQuestionRepo.getQuestion(questionId);
            }catch(DataAccessException e){
                e.printStackTrace();
            }
        }else{
            Question codingQuestion = null;
            try{
                codingQuestion = codingQuestionRepo.getQuestion(questionId);
            }catch(DataAccessException e) {
                e.printStackTrace();
            }
        }

        return responseDataMap;

    }
    public ResponseDataMap getQuestions(Integer questionTypeId) {
        ResponseDataMap responseDataMap = new ResponseDataMap();
        if (questionTypeId == 1) {

//            try{
//                List<Question> questions = (List<Question>) (Object) mcqQuestionRepo.getQuestions();
//                if(questions == null){
//                    throw new NotFoundException("Question Not Found");
//                }
//            }catch (NotFoundException nfe){
//                    nfe.printStackTrace();
//            }

//            if(questions!=null){
//                responseDataMap.setResponseSucess("Question Found");
//                responseDataMap.putData("questions", questions);
//            }else
//            {
//                responseDataMap.setResponseSucess("No Question Found");
//                responseDataMap.putData("questions", new List[]{});
//            }
            //  return  mcqQuestionRepo.getQuestion().stream().map(q -> (Question) q).collect(Collectors.toList());
            return responseDataMap;
        } else {
            //return  codingQuestionRepo.getQuestion().stream().map(q -> (Question) q).collect(Collectors.toList());
           // return (List) codingQuestionRepo.getQuestion(questionId);
        }
        return responseDataMap;
    }

    public ResponseMap addQuestion(LinkedHashMap question) {
        Boolean isQuestionAdded;
        ResponseMap responseMap = new ResponseMap();
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

    public ResponseDataMap getQuestionByTag(String questionTag) {
        List<CodingQuestion> codingQuestions = codingQuestionRepo.getQuestionByTag(questionTag);
        List<McqQuestion> mcqQuestions = mcqQuestionRepo.getQuestionByTag(questionTag);
        HashMap questionsMap = new HashMap();
        ResponseDataMap responseDataMap = new ResponseDataMap();
        if (codingQuestions == null) {
            questionsMap.put("codingQuestions", new List[]{});
        } else {
            questionsMap.put("codingQuestions", codingQuestions);
        }
        if (mcqQuestions == null) {
            questionsMap.put("mcqQuestions", new List[]{});
        } else {

            questionsMap.put("mcqQuestions", mcqQuestions);
        }

        responseDataMap.setResponseSucess("QuestionsFound");

        responseDataMap.putData("questions", questionsMap);
        return responseDataMap;
    }

    public ResponseDataMap editQuestion(LinkedHashMap question) {
        Boolean isQuestionAdded;
        int questionTypeId = (int) question.get(constants.questionTypeId.toString());
        ResponseDataMap responseDataMap = new ResponseDataMap();

        if (questionTypeId == 1) {
            McqQuestion mcqQuestion = new McqQuestion(question);
            isQuestionAdded = (mcqQuestionRepo.addQuestion(mcqQuestion) > 0);
            if (isQuestionAdded) {
                responseDataMap.setResponseSucess("Mcq question edited successfully");
            } else {
                responseDataMap.setResponseError("Mcq question could not be edited");
            }
            return responseDataMap;
        } else {
        }
        return responseDataMap;
    }

}
