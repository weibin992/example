package cn.weibin.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller公共方法
 * 
 * @author weibin
 */
public abstract class BaseController {

    /** 日志记录 */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** 成功响应码 */
    private final int successCode = 0;

    /**
     * 成功响应
     * 
     * @return 响应包装数据
     */
    protected ResponseBean success() {
        ResponseBean response = new ResponseBean();
        response.setCode(successCode);
        return response;
    }

    /**
     * 构造响应实体
     * 
     * @param data 结果数据
     * @return 响应包装数据
     */
    protected ResponseBean success(Object data) {
        ResponseBean response = new ResponseBean();
        response.setCode(successCode);
        response.setData(data);
        return response;
    }

    /**
     * 失败响应
     * 
     * @param message 失败消息
     * @return 响应包装数据
     */
    protected ResponseBean failure(String message) {
        ResponseBean response = new ResponseBean();
        response.setCode(-1);
        response.setMessage(message);
        return response;
    }

    /**
     * 失败响应
     * 
     * @param code    失败代码
     * @param message 失败消息
     * @return 响应包装数据
     */
    protected ResponseBean failure(int code, String message) {
        if (code == successCode) {
            throw new RuntimeException("失败代码不允许为" + successCode);
        }
        ResponseBean response = new ResponseBean();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    /**
     * Controller响应消息
     * 
     * @author weibin
     */
    protected class ResponseBean {

        private int code;

        private String message;

        private Object data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}