package com.rogo.service;

import com.rogo.responseClasses.ResponseMap;
import com.rogo.bean.User;
import com.rogo.bean.UserLogin;

public interface UserService {

    ResponseMap userLogin(UserLogin userLoginObj);

    ResponseMap addUser(User newUser);
}
