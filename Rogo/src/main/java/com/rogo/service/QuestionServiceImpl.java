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
import com.rogo.Utils.responseClasses.ResponseDataMap;
import com.rogo.Utils.responseClasses.ResponseMap;
import com.rogo.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.rogo.Utils.responseKeys.Questions.*;
import static com.rogo.Utils.responseMessages.ErrorMessages.Q_NOT_FOUND;
import static com.rogo.Utils.responseMessages.ErrorMessages.Q_TYPE_NOT_FOUND;
import static com.rogo.Utils.responseMessages.SuccessMessages.*;


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
            return buildErrorResponse(Q_TYPE_NOT_FOUND.message());
        }
        responseDataMap.putData(QUESTIONS.toString(), (questions == null) ? new List[]{} : questions);
        responseDataMap.setStatus(HttpStatus.OK);
        responseDataMap.setMessage(FOUND.toString());
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
            return buildErrorResponse(Q_TYPE_NOT_FOUND.message());
        }

        responseDataMap.putData(QUESTION.toString(), question);
        responseDataMap.setStatus(HttpStatus.OK);
        responseDataMap.setMessage(FOUND.toString());
        return responseDataMap;
    }


    public ResponseMap addQuestion(LinkedHashMap question) {
        int questionTypeId = (int) question.get(constants.questionTypeId.toString());
        if (questionTypeId == 1) {
            McqQuestion mcqQuestion = new McqQuestion(question);
            mcqQuestionRepo.addQuestion(mcqQuestion);
            return buildResponseMap(ADD.toString());
        } else if (questionTypeId == 2) {
            CodingQuestion codingQuestion = new CodingQuestion(question);
            codingQuestionRepo.addQuestion(codingQuestion);
            return buildResponseMap(ADD.toString());
        }
        return buildErrorResponse(Q_TYPE_NOT_FOUND.message());
    }

    public ResponseMap getQuestionByTag(String questionTag){
        List<CodingQuestion> codingQuestions = codingQuestionRepo.getQuestionByTag(questionTag);
        List<McqQuestion> mcqQuestions = mcqQuestionRepo.getQuestionByTag(questionTag);

        HashMap questionsMap = new HashMap();

        ResponseDataMap responseDataMap = new ResponseDataMap();

        questionsMap.put(CODING.toString(), (codingQuestions == null) ? new List[]{} : codingQuestions);
        questionsMap.put(MCQ.toString(), (mcqQuestions == null) ? new List[]{} : mcqQuestions);

        responseDataMap.setStatus(HttpStatus.OK);
        responseDataMap.setMessage(FOUND.toString());
        responseDataMap.putData(QUESTION.toString(), questionsMap);

        return responseDataMap;
    }

    public ResponseMap editQuestion(LinkedHashMap question) {
        int questionTypeId = (int) question.get(constants.questionTypeId.toString());

        switch (questionTypeId) {
            case 1:
                Question mcqQuestion = new McqQuestion(question, true);
                return (mcqQuestionRepo.updateQuestion((McqQuestion) mcqQuestion) > 0) ? buildResponseMap(EDIT.toString()) :
                        buildErrorResponse(Q_NOT_FOUND.message());
            case 2:
                Question codingQuestion = new CodingQuestion(question, true);
                return (codingQuestionRepo.updateQuestion((CodingQuestion) codingQuestion) > 0) ? buildResponseMap(EDIT.toString()) :
                        buildErrorResponse(Q_NOT_FOUND.message());
            default:
                return buildErrorResponse(Q_TYPE_NOT_FOUND.toString());
        }

    }

    @Override
    public ResponseMap deleteQuestion(Integer questionTypeId, Integer questionId) {
        switch (questionTypeId) {
            case 1:
                return (mcqQuestionRepo.deleteQuestion(questionId) > 0) ? buildResponseMap(DELETE.toString()) :
                        buildErrorResponse(Q_NOT_FOUND.message());
            case 2:
                return (codingQuestionRepo.deleteQuestion(questionId) > 0) ? buildResponseMap(DELETE.toString()) :
                        buildErrorResponse(Q_NOT_FOUND.message());
            default:
                return buildErrorResponse(Q_TYPE_NOT_FOUND.toString());
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
