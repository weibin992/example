package cn.weibin.springboot.configure.exception;

/**
 * 权限异常
 * @author weibin
 */
public class PermissionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PermissionException(String message) {
        super(message);
    }

}