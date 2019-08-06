package com.rogo.service;

import com.rogo.bean.User;
import com.rogo.bean.UserLogin;
import com.rogo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public HashMap<String, String> userLogin(UserLogin userLoginObj) {

        Map<String, String> responseMap = new HashMap<String, String>();

        User user = userRepo.getUserByUsername(userLoginObj.getUsername());

        if (user != null) {
            if (user.getUserPassword().compareTo(userLoginObj.getPassword()) == 0) {
                responseMap.put("Login", "Success");
            } else {
                responseMap.put("error", "Password do not match");
            }
            return (HashMap<String, String>) responseMap;
        }
        responseMap.put("error", "User Not Found");
        return (HashMap<String, String>) responseMap;

    }
}
