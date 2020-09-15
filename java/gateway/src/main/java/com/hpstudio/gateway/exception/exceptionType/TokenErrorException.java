package com.hpstudio.gateway.exception.exceptionType;

/**
 * @author mawen
 * @date 2020/9/10 17:04
 * @email 455766076@qq.com
 */
public class TokenErrorException extends RuntimeException {
    public TokenErrorException(){
        super("登录信息验证失败！");
    }
}
