package com.rogo.controller;

import com.rogo.bean.Question;
import com.rogo.bean.ResponseMap;
import com.rogo.bean.User;
import com.rogo.bean.UserLogin;
import com.rogo.service.QuestionService;
import com.rogo.service.UserService;
import com.rogo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@CrossOrigin
public class RogoController {
    @Autowired
    QuestionService questionService;
    @Autowired
    UserService userService;

    @GetMapping(path = "/question/{id}")
    @ResponseBody
    public ResponseEntity<List<Question>> getQuestions(@PathVariable("id") int id) {
        return new ResponseEntity<List<Question>>(questionService.getAll(id), HttpStatus.OK);
    }

    @PostMapping(path="/question/")
    public ResponseEntity addQuestion(@RequestBody LinkedHashMap question){
        ResponseMap responseMap = questionService.addQuestion(question);
        return new ResponseEntity(responseMap,responseMap.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
    }


    @PostMapping(path = "/login")
    public ResponseEntity login(@RequestBody UserLogin user) {
        ResponseMap responseMap = userService.userLogin(user);
        return new ResponseEntity<>(responseMap, responseMap.getError() ? HttpStatus.UNAUTHORIZED : HttpStatus.OK);
    }

    @PutMapping(path = "/signup")
    public ResponseEntity signUp(@RequestBody User newUser) {
        ResponseMap map =  userService.addUser(newUser);
        return new ResponseEntity<>(map,map.getError() ? HttpStatus.UNAUTHORIZED : HttpStatus.OK );
    }

    @GetMapping("/home")
    public ResponseEntity home() {
        return new ResponseEntity(new Object[]{"d1", "v1"}, HttpStatus.OK);
    }

}