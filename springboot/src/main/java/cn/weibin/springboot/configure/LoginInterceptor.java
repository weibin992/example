package cn.weibin.springboot.configure;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import cn.weibin.springboot.common.SystemConst;
import cn.weibin.springboot.configure.exception.PermissionException;
import cn.weibin.springboot.model.User;

/**
 * token拦截器
 * 
 * @author weibin
 */
public class LoginInterceptor implements HandlerInterceptor {

    /** 允许任何人访问 */
    private final static Set<String> ALLOW_ANY_URI = new HashSet<>();

    /** 允许任何已登陆用户访问 */
    private final static Set<String> ALLOW_LOGIN_URI = new HashSet<>();
    static {
        ALLOW_ANY_URI.add("/");
        ALLOW_ANY_URI.add("/login");
        ALLOW_ANY_URI.add("/logout");
        ALLOW_ANY_URI.add("/getCaptcha");
        ALLOW_ANY_URI.add("/test");

        ALLOW_LOGIN_URI.add("/index");
        ALLOW_LOGIN_URI.add("/welcome");
        ALLOW_LOGIN_URI.add("/changePassword");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 项目路径
        String contextPath = request.getContextPath();
        // 请求资源路径, 去除项目路径
        String requestURI = request.getRequestURI().substring(contextPath.length());
        // 去除url后缀
        int suffixIndex = requestURI.indexOf('.');
        if (suffixIndex > 0) {
            requestURI = requestURI.substring(0, suffixIndex);
        }
        // 允许任何人访问
        if (ALLOW_ANY_URI.contains(requestURI)) {
            return true;
        }
        // 验证登陆超时
        User user = (User)request.getSession().getAttribute(SystemConst.SESSION_USER);
        if (user == null) {
            throw new PermissionException("用户未登录");
        }
        // 允许登录用户访问
        if (ALLOW_LOGIN_URI.contains(requestURI)) {
            return true;
        }
        // // 管理员可访问任何资源
        // if (RoleEnum.ADMIN.equals(user.getRoleCode())) {
        //     return true;
        // }
        // // 是否拥有访问权限
        // if (user.getPermitSet().contains(requestURI)) {
        //     return true;
        // }
        return false;
    }
}