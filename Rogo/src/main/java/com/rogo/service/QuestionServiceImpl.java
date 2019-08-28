package com.rogo.service;

import com.rogo.bean.CodingQuestion;
import com.rogo.bean.McqQuestion;
import com.rogo.bean.Question;
import com.rogo.config.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

//import com.rogo.exceptions.NotFoundException;
import com.rogo.exception.ApiError;
import com.rogo.exception.RogoCustomException;
import com.rogo.responseClasses.ResponseDataMap;
import com.rogo.responseClasses.ResponseMap;
import com.rogo.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepo<McqQuestion> mcqQuestionRepo;
    @Autowired
    QuestionRepo<CodingQuestion> codingQuestionRepo;

    public ResponseMap getQuestion(Integer questionTypeId, Integer questionId) throws RogoCustomException {
        ResponseDataMap responseDataMap = new ResponseDataMap();

        if (questionTypeId == 1) {
            Question mcqQuestion = null;
            mcqQuestion = mcqQuestionRepo.getQuestion(questionId);
            responseDataMap.putData("question", mcqQuestion);
        } else {
            Question codingQuestion = null;
                codingQuestion = codingQuestionRepo.getQuestion(questionId);
                responseDataMap.putData("question", codingQuestion);
        }
        return responseDataMap;

    }

    public ResponseMap getQuestions(Integer questionTypeId) {
        ResponseDataMap responseDataMap = new ResponseDataMap();
        if (questionTypeId == 1) {
            List<Question> questions = (List<Question>) (Object) mcqQuestionRepo.getQuestions();
            responseDataMap.putData("questions",(questions == null)?new List[]{}:questions);
            return responseDataMap;
        } else {
            //return  codingQuestionRepo.getQuestion().stream().map(q -> (Question) q).collect(Collectors.toList());
            // return (List) codingQuestionRepo.getQuestion(questionId);
        }
        return responseDataMap;
    }

    public ResponseMap addQuestion(LinkedHashMap question) {
        ResponseMap responseMap = new ResponseMap();
        int questionTypeId = (int) question.get(constants.questionTypeId.toString());
        if (questionTypeId == 1) {
            McqQuestion mcqQuestion = new McqQuestion(question);
            if ((mcqQuestionRepo.addQuestion(mcqQuestion) > 0)) {
                responseMap.setMessage("Mcq question added successfully");
            } else {

            }
            return responseMap;
        } else {
        }
        return responseMap;
    }

    public ResponseMap getQuestionByTag(String questionTag) {
        List<CodingQuestion> codingQuestions = codingQuestionRepo.getQuestionByTag(questionTag);
        List<McqQuestion> mcqQuestions = mcqQuestionRepo.getQuestionByTag(questionTag);

        HashMap questionsMap = new HashMap();

        ResponseDataMap responseDataMap = new ResponseDataMap();

        questionsMap.put("codingQuestions", (codingQuestions == null) ? new List[]{} : codingQuestions);
        questionsMap.put("mcqQuestions", (mcqQuestions == null) ? new List[]{} : mcqQuestions);

        responseDataMap.setStatus(HttpStatus.OK);
        responseDataMap.setMessage("QuestionsFound");
        responseDataMap.putData("questions", questionsMap);

        return responseDataMap;
    }

    public ResponseMap editQuestion(LinkedHashMap question) {
        int questionTypeId = (int) question.get(constants.questionTypeId.toString());
        ResponseMap responseMap = new ResponseMap();
        if (questionTypeId == 1) {
            McqQuestion mcqQuestion = new McqQuestion(question, true);
            if ((mcqQuestionRepo.updateQuestion(mcqQuestion) > 0)) {
                responseMap.setStatus(HttpStatus.OK);
                responseMap.setMessage("Mcq question edited successfully");
                return responseMap;
            } else {
                ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
                apiError.setMessage("Question Not Found");
                return apiError;
            }
        } else {
            return responseMap;
        }

    }

    @Override
    public ResponseMap deleteQuestion(Integer questionTypeId, Integer questionId) {
        ResponseMap responseMap = new ResponseMap();
        if(questionTypeId==1) {
            if (mcqQuestionRepo.deleteQuestion(questionId) > 0) {
                responseMap.setMessage("question deleted");
                responseMap.setStatus(HttpStatus.OK);
                return responseMap;
            } else {
                ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
                apiError.setMessage("Question Not Found");
                return apiError;
            }
        }else{
            return  responseMap;
        }
    }
}
