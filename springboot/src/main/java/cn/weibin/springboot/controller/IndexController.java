package cn.weibin.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.weibin.springboot.common.SystemConst;
import cn.weibin.springboot.model.User;
import cn.weibin.springboot.service.IndexService;

@RestController
public class IndexController extends BaseController {

    @Autowired
    private IndexService indexService;

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public Object login(HttpSession session, String userName, String password) {
        User user = indexService.selectUser(userName, password);
        if (user == null) {
            return failure("登录失败, 用户名或密码错误");
        }
        session.setAttribute(SystemConst.SESSION_USER, user);
        return success();
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public Object logout(HttpSession session) {
        session.removeAttribute(SystemConst.SESSION_USER);
        return success();
    }
}