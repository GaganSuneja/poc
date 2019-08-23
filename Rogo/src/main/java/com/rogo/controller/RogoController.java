package com.rogo.controller;

import com.rogo.exception.RogoCustomException;
import com.rogo.responseClasses.ResponseMap;
import com.rogo.bean.User;
import com.rogo.bean.UserLogin;
import com.rogo.service.QuestionService;
import com.rogo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
@CrossOrigin(origins = "*")
public class RogoController {
    @Autowired
    QuestionService questionService;
    @Autowired
    UserService userService;

    ResponseMap response;

    @GetMapping(path = "/question/{questionTypeId}/{questionId}")
    public ResponseEntity getQuestion(@PathVariable("questionTypeId") Integer questionTypeId,
                                      @PathVariable("questionId") Integer questionId) throws RogoCustomException {
        return new ResponseEntity<>(questionService.getQuestion(questionTypeId, questionId), HttpStatus.OK);
    }

    @GetMapping(path = "/question/{questionTypeId}")
    public ResponseEntity getQuestions(@PathVariable("questionTypeId") Integer questionTypeId) {
        return new ResponseEntity<>(questionService.getQuestions(questionTypeId), HttpStatus.OK);
    }

    @GetMapping(path = "/question/tag/{questionTag}")
    public ResponseEntity getQuestionsByTag(@PathVariable("questionTag") String questionTag) {
        response = questionService.getQuestionByTag(questionTag);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PostMapping(path = "/question/")
    public ResponseEntity addQuestion(@RequestBody LinkedHashMap question) {
        response = questionService.addQuestion(question);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PutMapping(path = "/question/")
    public ResponseEntity editQuestion(@RequestBody LinkedHashMap question) {
        response = questionService.editQuestion(question);
        return new ResponseEntity(response, response.getStatus());
    }

    @PostMapping(path = "/login")
    public ResponseEntity login(@RequestBody UserLogin user) {
        ResponseMap response = userService.userLogin(user);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PostMapping(path = "/signup")
    public ResponseEntity signUp(@RequestBody User newUser) {
        response = userService.addUser(newUser);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @DeleteMapping(path = "/question/{questionTypeId}/{questionId}")
    public ResponseEntity deleteQuestion(@PathVariable("questionTypeId") Integer questionTypeId,
                                         @PathVariable("questionId") Integer questionId) {
        response = questionService.deleteQuestion(questionTypeId, questionId);
        return new ResponseEntity(response, response.getStatus());
    }
}