package com.hpstudio.gateway.exception.exceptionType;

/**
 * @author mawen
 * @date 2020/9/10 17:16
 * @email 455766076@qq.com
 */
public class TokenEmptyException extends RuntimeException {
    public TokenEmptyException(){
        super("token信息不能为空！");
    }
}
