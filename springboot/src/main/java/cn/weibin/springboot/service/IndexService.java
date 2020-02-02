package cn.weibin.springboot.service;

import cn.weibin.springboot.model.User;

/**
 * index服务
 * @author weibin
 */
public interface IndexService {

    /**
     * 查询用户
     * @param userName
     * @param password
     * @return
     */
    User selectUser(String userName, String password);

}