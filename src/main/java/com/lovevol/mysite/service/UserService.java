package com.lovevol.mysite.service;

import com.lovevol.mysite.model.User;

import java.util.List;

public interface UserService{

    void saveUser(User user);
    
    List<User> getAllUser();
}
