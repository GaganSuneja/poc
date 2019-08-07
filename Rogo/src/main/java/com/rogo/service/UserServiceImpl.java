package com.rogo.service;

import com.rogo.bean.ResponseMap;
import com.rogo.bean.User;
import com.rogo.bean.UserLogin;
import com.rogo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    ResponseMap responseMap;

    public HashMap<String, String> userLogin(UserLogin userLoginObj) {

        Map<String, String> responseMap = new HashMap<String, String>();

        User user = userRepo.getUserByUsername(userLoginObj.getUsername());

        if (user != null) {
            if (user.getUserPassword().compareTo(userLoginObj.getPassword()) == 0) {
                responseMap.put("Login", "True");
            } else {
                responseMap.put("error", "True");
                responseMap.put("errorMessage", "Password do not match");
            }
            return (HashMap<String, String>) responseMap;
        }
        responseMap.put("error", "True");
        responseMap.put("errorMessage", "User Not Found");
        return (HashMap<String, String>) responseMap;

    }

    public HashMap<String, String> addUser(User newUser) {
        int rowsAffected = userRepo.addUser(newUser);
        boolean isUserAdded = (rowsAffected > 0);

        Map<String,String> responseMap2 = new HashMap<>();

        if (isUserAdded) {
            responseMap2.put("success", "true");
            responseMap2.put("successMessage", "user added successfully");
        } else {
            responseMap2.put("error", "true");
            responseMap2.put("errorMessage", "user could not be added!");
        }

        return (HashMap<String, String>) responseMap2;

    }

}
