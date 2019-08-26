package com.rogo.service;

import com.rogo.UtilityClasses.responseClasses.ResponseMap;
import com.rogo.bean.User;
import com.rogo.bean.UserLogin;

public interface UserService {

    ResponseMap userLogin(UserLogin userLoginObj);

    ResponseMap addUser(User newUser);
}
