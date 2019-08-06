package com.rogo.controller;

import com.rogo.bean.Question;
import com.rogo.bean.UserLogin;
import com.rogo.service.QuestionService;
import com.rogo.service.QuestionServiceImpl;
import com.rogo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RogoController {
    @Autowired
    QuestionService questionService;
    @Autowired
    UserService userService;
    @GetMapping(path="/getquestion/{id}")
    @ResponseBody
    public ResponseEntity<List<Question>> GetMcqQuestions(@PathVariable("id") String id) {
        return new ResponseEntity(questionService.getAll(id), HttpStatus.OK);
    }

    @PostMapping(path="/login")
    public ResponseEntity<Object> login(@RequestBody UserLogin user){
        Map responseMap  = userService.userLogin(user);
        return new ResponseEntity(userService.userLogin(user), responseMap.containsKey("error") ? HttpStatus.UNAUTHORIZED : HttpStatus.OK);
    }

    @GetMapping("/home")
    public ResponseEntity home(){
        return new ResponseEntity(new Object[]{"d1","v1"}, HttpStatus.OK);
    }

}
