package com.rogo.service;

import com.rogo.bean.CodingQuestion;
import com.rogo.bean.McqQuestion;
import com.rogo.bean.Question;

import java.util.List;
import java.util.stream.Collectors;

import com.rogo.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepo<McqQuestion> mcqQuestionRepo;
    @Autowired
    QuestionRepo<CodingQuestion> codingQuestionRepo;

    public List<Question> getAll(String id) {
        if(id.equals("1")){
            List<Question> questions = (List<Question>)(Object) mcqQuestionRepo.getQuestion();
          //  return  mcqQuestionRepo.getQuestion().stream().map(q -> (Question) q).collect(Collectors.toList());
            return questions;
        }else{
            //return  codingQuestionRepo.getQuestion().stream().map(q -> (Question) q).collect(Collectors.toList());
            return  (List)codingQuestionRepo.getQuestion();
        }
    }

    public void AddQuestion(Question question, int qTypeId) {

        if (qTypeId == 1) {
            mcqQuestionRepo.addQuestion((McqQuestion) question);
        } else {

        }
    }
}
