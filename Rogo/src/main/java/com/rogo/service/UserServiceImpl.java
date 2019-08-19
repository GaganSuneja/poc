package com.rogo.service;

import com.rogo.responseClasses.ResponseMap;
import com.rogo.bean.User;
import com.rogo.bean.UserLogin;
import com.rogo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    public ResponseMap userLogin(UserLogin userLoginObj) {
        ResponseMap responseMap = new ResponseMap();
        User user = userRepo.getUserByUsername(userLoginObj.getUsername());
        if (user != null) {
            if (user.getUserPassword().compareTo(userLoginObj.getPassword()) == 0) {
               responseMap.setResponseSucess("Login Succesfull");
            } else {
               responseMap.setResponseError("Password do not match");
            }
            return responseMap;
        }
        responseMap.setResponseError("User not found!");
        return responseMap;

    }

    public ResponseMap addUser(User newUser) {
        int rowsAffected = userRepo.addUser(newUser);
        boolean isUserAdded = (rowsAffected > 0);
        ResponseMap responseMap = new ResponseMap();
        if (isUserAdded) {
            responseMap.setResponseSucess("user added successfully");
        } else {
            responseMap.setResponseError("user could not be added");
        }
        return responseMap;
    }

}
