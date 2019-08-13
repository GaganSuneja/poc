package com.rogo.service;

import com.rogo.bean.CodingQuestion;
import com.rogo.bean.McqQuestion;
import com.rogo.bean.Question;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.rogo.bean.ResponseMap;
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
        if (question[co] == 1) {
            McqQuestion mcqQuestion = new McqQuestion(question);
            isQuestionAdded = (mcqQuestionRepo.addQuestion(mcqQuestion) > 0);
            if (isQuestionAdded) {
                responseMap.setSuccessMessage("Mcq question added successfully");
            } else {
                responseMap.setErrorMessage("Mcq question could not be added");
            }
            return responseMap;
        } else {
        }
        return responseMap;
    }
}
