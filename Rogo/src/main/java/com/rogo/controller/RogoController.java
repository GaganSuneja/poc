package com.rogo.controller;

import com.rogo.bean.User;
import com.rogo.exception.RogoCustomException;
import com.rogo.Utils.responseClasses.ResponseMap;
import com.rogo.bean.UserLogin;
import com.rogo.service.QuestionService;
import com.rogo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Api(value="Questions Management System", description="Question Management Api")

public class RogoController {
    @Autowired
    QuestionService questionService;
    @Autowired
    UserService userService;

    ResponseMap response;

    @ApiOperation(value="Get Question")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(path = "/question/{questionTypeId}/{questionId}")
    public ResponseEntity getQuestion(@PathVariable("questionTypeId") Integer questionTypeId,
                                      @PathVariable("questionId") Integer questionId) throws RogoCustomException, DataAccessException {
        response = questionService.getQuestion(questionTypeId, questionId);
        return new ResponseEntity<>(response,response.getStatus());
    }


    @ApiOperation(value="Get all Questions of a particular type",response=ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved question"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(path = "/question/{questionTypeId}")
    public ResponseEntity getQuestions(@PathVariable("questionTypeId") Integer questionTypeId) throws DataAccessException {
        response = questionService.getQuestions(questionTypeId);
        return new ResponseEntity<>(response,response.getStatus());
    }


    @ApiOperation(value="Get all Questions of a particular Tag",response=ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved questions"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(path = "/question/tag/{questionTag}")
    public ResponseEntity getQuestionsByTag(@PathVariable("questionTag") String questionTag) throws DataAccessException {
        response = questionService.getQuestionByTag(questionTag);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ApiOperation(value="Add a question",response=ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added a question"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping(path = "/question/")
    public ResponseEntity addQuestion(@RequestBody LinkedHashMap question) throws DataAccessException{
        response = questionService.addQuestion(question);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ApiOperation(value="Update a question",response=ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated question"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PutMapping(path = "/question/")
    public ResponseEntity editQuestion(@RequestBody LinkedHashMap question) throws DataAccessException {
        response = questionService.editQuestion(question);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ApiOperation(value="User Login",response=ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Login Successful"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping(path = "/login")
    public ResponseEntity login(@RequestBody UserLogin user) throws DataAccessException {
        response = userService.userLogin(user);
        return new ResponseEntity<>(response, response.getStatus());
    }
    @ApiOperation(value="User Signup",response=ResponseEntity.class)
    @PostMapping(path = "/signup")
    public ResponseEntity signUp(@RequestBody User newUser) throws DataAccessException {
        response = userService.addUser(newUser);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ApiOperation(value="Delete a particular question",response=ResponseEntity.class)
    @DeleteMapping(path = "/question/{questionTypeId}/{questionId}")
    public ResponseEntity deleteQuestion(@PathVariable("questionTypeId") Integer questionTypeId,
                                         @PathVariable("questionId") Integer questionId) throws DataAccessException {
        response = questionService.deleteQuestion(questionTypeId, questionId);
        return new ResponseEntity<>(response, response.getStatus());
    }
}