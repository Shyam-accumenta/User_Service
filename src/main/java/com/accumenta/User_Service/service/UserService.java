package com.accumenta.User_Service.service;

import com.accumenta.User_Service.model.User;

public interface UserService {
    User addUser(User user);
    User getUser(long userId);
    User updateUser(User user,long userId);
    boolean deleteUser(long userId);
}
