package com.rogo.service;

import com.rogo.UtilityClasses.responseClasses.ResponseMap;
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
        User user = userRepo.getUserByUsername(userLoginObj.getUsername());
        ResponseMap responseMap = new ResponseMap();
        if (user != null) {
            if (user.getUserPassword().compareTo(userLoginObj.getPassword()) == 0) {
               responseMap.setMessage("Login Succesfull");
            } else {
               responseMap.setMessage("Password do not match");
            }
            return responseMap;
        }
        responseMap.setMessage("User not found!");
        return responseMap;

    }

    public ResponseMap addUser(User newUser) {
        int rowsAffected = userRepo.addUser(newUser);
        ResponseMap responseMap = new ResponseMap();
        boolean isUserAdded = (rowsAffected > 0);
        if (isUserAdded) {
            responseMap.setMessage("user added successfully");
        } else {
            responseMap.setMessage("user could not be added");
        }
        return responseMap;
    }



}
