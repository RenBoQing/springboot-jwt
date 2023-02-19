package com.rbq.service.impl;

import com.rbq.entity.User;
import com.rbq.mapper.UserMapper;
import com.rbq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author RenBoQing
 * @date 2023年02月07日 16:49
 * @Description
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        User login = userMapper.login(user);
        if (login != null) {
            return login;
        } else {
            throw new RuntimeException("登陆失败");
        }
    }
}
