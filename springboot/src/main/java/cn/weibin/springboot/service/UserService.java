package cn.weibin.springboot.service;

import cn.weibin.springboot.model.User;

/**
 * 用户服务
 * @author weibin
 */
public interface UserService {

    /**
     * 根据Id查询用户
     * @param id
     * @return
     */
    User selectById(Integer id);
    
}