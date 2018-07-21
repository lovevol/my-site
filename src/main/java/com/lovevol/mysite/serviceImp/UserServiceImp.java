package com.lovevol.mysite.serviceImp;

import com.lovevol.mysite.dao.UserMapper;
import com.lovevol.mysite.model.User;
import com.lovevol.mysite.model.UserExample;
import com.lovevol.mysite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("UserService")
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(User user) {
        userMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> getAllUser() {
        return userMapper.selectByExample(new UserExample());
    }
}
