package com.hpstudio.gateway.exception.exceptionType;

/**
 * @author mawen
 * @date 2020/9/10 17:02
 * @email 455766076@qq.com
 */
public class PasswordErrorException extends RuntimeException {
    public PasswordErrorException(){
        super("密码错误！");
    }
}
