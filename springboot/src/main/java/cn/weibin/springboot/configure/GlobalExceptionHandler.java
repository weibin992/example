package cn.weibin.springboot.configure;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import cn.weibin.springboot.configure.exception.BusinessException;
import cn.weibin.springboot.configure.exception.NotLoggedInException;
import cn.weibin.springboot.configure.exception.PermissionException;

/**
 * 全局异常处理器
 * 
 * @author weibin
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /** logger */
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 业务异常处理
     * 
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public ModelAndView businessHandler(HttpServletRequest request, HttpServletResponse response, BusinessException e) {
        response.setStatus(500);
        return exceptionResponse(request, 500, e.getMessage());
    }

    /**
     * 无权限处理
     * 
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(PermissionException.class)
    public ModelAndView permissionHandler(HttpServletRequest request, HttpServletResponse response,
            PermissionException e) {
        response.setStatus(404);
        return exceptionResponse(request, 404, "找不到要访问的地址");
    }

    /**
     * 用户未登录异常
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(NotLoggedInException.class)
    public ModelAndView permissionHandler(HttpServletRequest request, HttpServletResponse response,
            NotLoggedInException e) {
        response.setStatus(401);
        return exceptionResponse(request, 401, "登录超时, 请重新登录");
    }

    /**
     * 其他异常处理
     * 
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ModelAndView globalHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        int errorCode = 500;
        String message = "系统异常，操作失败";
        if (e instanceof NoHandlerFoundException) {
            logger.warn("错误的请求地址: " + request.getRequestURI());
            errorCode = 404;
            message = "找不到要访问的地址";
        } else {
            logger.error(e.getMessage(), e);
        }
        response.setStatus(errorCode);
        return exceptionResponse(request, errorCode, message);
    }

    /**
     * 异常结果处理
     * 
     * @param request 请求实体
     * @param code    错误码
     * @param message 错误消息
     * @return
     */
    private ModelAndView exceptionResponse(HttpServletRequest request, int code, String message) {
        ModelAndView modelAndView = new ModelAndView();
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        Map<String, Object> param = new HashMap<>(2);
        param.put("code", code);
        param.put("message", message);
        view.setAttributesMap(param);
        modelAndView.setView(view);
        return modelAndView;
    }

}
