package com.hpstudio.gateway.exception.exceptionType;

/**
 * @author mawen
 * @date 2020/9/10 17:01
 * @email 455766076@qq.com
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException(){
        super("账号不存在！");
    }
}
