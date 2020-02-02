package cn.weibin.springboot.configure.exception;

/**
 * 业务异常
 * @author weibin
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BusinessException(String message) {
        super(message);
    }
}