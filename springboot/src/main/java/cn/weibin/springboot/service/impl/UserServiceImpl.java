package cn.weibin.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.weibin.springboot.mapper.UserMapper;
import cn.weibin.springboot.model.User;
import cn.weibin.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(Integer id) {
        if (id == null) {
            return null;
        }
        return userMapper.selectByPrimaryKey(id);
    }

}