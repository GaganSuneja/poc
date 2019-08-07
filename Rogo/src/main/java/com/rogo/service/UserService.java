package com.rogo.service;

import com.rogo.bean.User;
import com.rogo.bean.UserLogin;

import java.util.HashMap;

public interface UserService {

     HashMap<String, String> userLogin(UserLogin userLoginObj);

      HashMap<String,String> addUser(User newUser);
}
