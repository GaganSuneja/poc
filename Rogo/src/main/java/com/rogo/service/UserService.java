package com.rogo.service;

import com.rogo.bean.ResponseMap;
import com.rogo.bean.User;
import com.rogo.bean.UserLogin;

import java.util.HashMap;

public interface UserService {

    ResponseMap userLogin(UserLogin userLoginObj);

    ResponseMap addUser(User newUser);
}
