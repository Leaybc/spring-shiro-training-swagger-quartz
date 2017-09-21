package com.lee.commons.scan;

/**
 * 自定义异常,service可以抛出该异常,供前台展示
 */
public class BusinessException extends RuntimeException {
    private Integer errorCode;


    private String message;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 重写 fillInStackTrace 去除业务异常堆栈信息，提高性能
     * <p>
     * 业务逻辑异常是可预料异常范围，不需要堆栈信息，堆栈信息会大大提高系统开销，影响系统性能
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    public BusinessException(Integer errorCode, String message) {
        super();
        this.errorCode = errorCode;
        this.message = message;
    }

    public BusinessException(BusinessException ex) {
        super(ex);
    }

    public BusinessException(String message) {
        super();
        this.message = message;
    }
}
