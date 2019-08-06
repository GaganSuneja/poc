package com.rogo.controller;

import com.rogo.bean.Question;
import com.rogo.service.QuestionService;
import com.rogo.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class RogoController {
    @Autowired
    QuestionService questionService;

    @GetMapping(path="/getquestion/{id}")
    @ResponseBody
    public ResponseEntity<List<Question>> GetMcqQuestions(@PathVariable("id") String id) {
        return new ResponseEntity(questionService.getAll(id), HttpStatus.OK);
    }

    @PostMapping(path="/login")
    public ResponseEntity login(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/home")
    public String getHome(){
        return "home";
    }

}
