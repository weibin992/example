package cn.weibin.springboot.mapper;

import cn.weibin.springboot.model.User;
import cn.weibin.springboot.model.UserExample;
import java.util.List;

public interface UserMapper {
    long countByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);
}