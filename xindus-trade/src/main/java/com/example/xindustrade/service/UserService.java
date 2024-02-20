package com.example.xindustrade.service;

import com.example.xindustrade.Exception.UserException;
import com.example.xindustrade.Model.Users;

public interface UserService {

    public Users registerUser(Users users) throws UserException;

}
