package cn.weibin.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.weibin.springboot.mapper.UserMapper;
import cn.weibin.springboot.model.User;
import cn.weibin.springboot.model.UserExample;
import cn.weibin.springboot.service.IndexService;
import cn.weibin.springboot.util.EncryptUtil;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUser(String userName, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(userName).andPasswordEqualTo(EncryptUtil.md5(password));
        List<User> userList = userMapper.selectByExample(example);
        if (userList.isEmpty()) {
            return null;
        }
        return userList.get(0);
    }
}