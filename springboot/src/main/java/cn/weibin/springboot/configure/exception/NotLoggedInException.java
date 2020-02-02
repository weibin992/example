package cn.weibin.springboot.configure.exception;

/**
 * 用户未登录异常
 * @author weibin
 */
public class NotLoggedInException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotLoggedInException(String message) {
        super(message);
    }
}