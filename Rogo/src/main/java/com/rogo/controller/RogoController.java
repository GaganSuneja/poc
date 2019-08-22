package com.rogo.controller;

import com.rogo.responseClasses.ResponseDataMap;
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
@CrossOrigin
public class RogoController {
    @Autowired
    QuestionService questionService;
    @Autowired
    UserService userService;

    @GetMapping(path = "/question/{questionTypeId}/{questionId}")
    public ResponseEntity getQuestion( @PathVariable("questionTypeId") Integer questionTypeId,
                                       @PathVariable("questionId") Integer questionId) {
        return new ResponseEntity<>(questionService.getQuestion(questionTypeId, questionId), HttpStatus.OK);
    }

    @GetMapping(path = "/question/{questionTypeId}")
    public ResponseEntity getQuestions( @PathVariable("questionTypeId") Integer questionTypeId) {
        return new ResponseEntity<>(questionService.getQuestions(questionTypeId), HttpStatus.OK);
    }

    @GetMapping(path = "/question/tag/{questionTag}")
    public ResponseEntity getQuestionsByTag(@PathVariable("questionTag") String questionTag) {
        ResponseDataMap questionByTagMap = questionService.getQuestionByTag(questionTag);
        return new ResponseEntity<>(questionByTagMap, HttpStatus.OK);
    }

    @PostMapping(path = "/question/")
    public ResponseEntity addQuestion(@RequestBody LinkedHashMap question) {
        ResponseMap responseMap = questionService.addQuestion(question);
        return new ResponseEntity<>(responseMap, responseMap.getError() ? HttpStatus.INTERNAL_SERVER_ERROR :
                HttpStatus.OK);
    }

    @PutMapping(path = "/question/")
    public ResponseEntity editQuestion(@RequestBody LinkedHashMap question) {
        ResponseDataMap responseDataMap = questionService.editQuestion(question);
        return new ResponseEntity<>(responseDataMap, responseDataMap.getError() ? HttpStatus.INTERNAL_SERVER_ERROR :
                HttpStatus.OK);
    }

    @PostMapping(path = "/login")
    public ResponseEntity login(@RequestBody UserLogin user) {
        ResponseMap responseMap = userService.userLogin(user);
        return new ResponseEntity<>(responseMap, responseMap.getError() ? HttpStatus.UNAUTHORIZED : HttpStatus.OK);
    }

    @PostMapping(path = "/signup")
    public ResponseEntity signUp(@RequestBody User newUser) {
        ResponseMap map = userService.addUser(newUser);
        return new ResponseEntity<>(map, map.getError() ? HttpStatus.UNAUTHORIZED : HttpStatus.OK);
    }


}