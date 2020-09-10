package com.hpstudio.forummain.exception.exceptionType;

/**
 * wrapper工具类异常
 * @author mawen
 * @date 2020/9/9 17:29
 * @email 455766076@qq.com
 */
public class WrapperException extends RuntimeException {
    private String msg;

    public WrapperException(String msg){
        super(msg);
    }
}
