package com.rogo.service;

import com.rogo.bean.CodingQuestion;
import com.rogo.bean.McqQuestion;
import com.rogo.bean.Question;
import com.rogo.config.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.rogo.exception.ApiError;
import com.rogo.exception.RogoCustomException;
import com.rogo.UtilityClasses.responseClasses.ResponseDataMap;
import com.rogo.UtilityClasses.responseClasses.ResponseMap;
import com.rogo.repo.QuestionRepo;
import com.rogo.UtilityClasses.responseKeys.Questions;
import com.rogo.UtilityClasses.responseMessages.ErrorMessages;
import com.rogo.UtilityClasses.responseMessages.SuccessMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepo<McqQuestion> mcqQuestionRepo;
    @Autowired
    QuestionRepo<CodingQuestion> codingQuestionRepo;

    public ResponseMap getQuestions(Integer questionTypeId) {
        ResponseDataMap responseDataMap = new ResponseDataMap();
        List<Question> questions = null;

        if (questionTypeId == 1) {
            questions = (List<Question>) (Object) mcqQuestionRepo.getQuestions();
        } else if (questionTypeId == 2) {
            questions = (List<Question>) (Object) codingQuestionRepo.getQuestions();
        } else {
            return buildErrorResponse(ErrorMessages.Q_TYPE_NOT_FOUND.toString());
        }
        responseDataMap.putData(Questions.QUESTIONS.toString(), (questions == null) ? new List[]{} : questions);
        responseDataMap.setStatus(HttpStatus.OK);
        responseDataMap.setMessage(SuccessMessages.FOUND.toString());
        return responseDataMap;

    }


    public ResponseMap getQuestion(Integer questionTypeId, Integer questionId) throws RogoCustomException {
        ResponseDataMap responseDataMap = new ResponseDataMap();
        Question question = null;
        if (questionTypeId == 1) {
            question = mcqQuestionRepo.getQuestion(questionId);
        } else if (questionTypeId == 2) {
            question = codingQuestionRepo.getQuestion(questionId);

        } else {
            return buildErrorResponse(ErrorMessages.Q_TYPE_NOT_FOUND.toString());
        }

        responseDataMap.putData(Questions.QUESTION.toString(), question);
        responseDataMap.setStatus(HttpStatus.OK);
        responseDataMap.setMessage(SuccessMessages.FOUND.toString());
        return responseDataMap;
    }


    public ResponseMap addQuestion(LinkedHashMap question) {
        int questionTypeId = (int) question.get(constants.questionTypeId.toString());
        if (questionTypeId == 1) {
            McqQuestion mcqQuestion = new McqQuestion(question);
            mcqQuestionRepo.addQuestion(mcqQuestion);
            return buildResponseMap(SuccessMessages.ADD.toString());
        } else if (questionTypeId == 2) {
            CodingQuestion codingQuestion = new CodingQuestion(question);
            codingQuestionRepo.addQuestion(codingQuestion);
            return buildResponseMap(SuccessMessages.ADD.toString());
        }
        return buildErrorResponse(ErrorMessages.Q_TYPE_NOT_FOUND.toString());
    }

    public ResponseMap getQuestionByTag(String questionTag){
        List<CodingQuestion> codingQuestions = codingQuestionRepo.getQuestionByTag(questionTag);
        List<McqQuestion> mcqQuestions = mcqQuestionRepo.getQuestionByTag(questionTag);

        HashMap questionsMap = new HashMap();

        ResponseDataMap responseDataMap = new ResponseDataMap();

        questionsMap.put(Questions.CODING.toString(), (codingQuestions == null) ? new List[]{} : codingQuestions);
        questionsMap.put(Questions.MCQ.toString(), (mcqQuestions == null) ? new List[]{} : mcqQuestions);

        responseDataMap.setStatus(HttpStatus.OK);
        responseDataMap.setMessage(SuccessMessages.FOUND.toString());
        responseDataMap.putData(Questions.QUESTION.toString(), questionsMap);

        return responseDataMap;
    }

    public ResponseMap editQuestion(LinkedHashMap question) {
        int questionTypeId = (int) question.get(constants.questionTypeId.toString());

        switch (questionTypeId) {
            case 1:
                McqQuestion mcqQuestion = new McqQuestion(question, true);
                return (mcqQuestionRepo.updateQuestion(mcqQuestion) > 0) ? buildResponseMap(SuccessMessages.EDIT.toString()) :
                        buildErrorResponse(ErrorMessages.Q_NOT_FOUND.toString());
            case 2:
                CodingQuestion codingQuestion = new CodingQuestion(question, true);
                return (codingQuestionRepo.updateQuestion(codingQuestion) > 0) ? buildResponseMap(SuccessMessages.EDIT.toString()) :
                        buildErrorResponse(ErrorMessages.Q_NOT_FOUND.toString());
            default:
                return buildErrorResponse(ErrorMessages.Q_TYPE_NOT_FOUND.toString());
        }

    }

    @Override
    public ResponseMap deleteQuestion(Integer questionTypeId, Integer questionId) {
        switch (questionTypeId) {
            case 1:
                return (mcqQuestionRepo.deleteQuestion(questionId) > 0) ? buildResponseMap(SuccessMessages.DELETE.toString()) :
                        buildErrorResponse(ErrorMessages.Q_NOT_FOUND.toString());
            case 2:
                return (codingQuestionRepo.deleteQuestion(questionId) > 0) ? buildResponseMap(SuccessMessages.DELETE.toString()) :
                        buildErrorResponse(ErrorMessages.Q_NOT_FOUND.toString());
            default:
                return buildErrorResponse(ErrorMessages.Q_TYPE_NOT_FOUND.toString());
        }
    }

    private ApiError buildErrorResponse(String message) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(message);
        return apiError;
    }

    private ResponseMap buildResponseMap(String message) {
        ResponseMap responseMap = new ResponseMap();
        responseMap.setStatus(HttpStatus.OK);
        responseMap.setMessage(message);
        return responseMap;
    }


}
