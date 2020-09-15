package com.hpstudio.gateway.constant;

/**
 * @author mawen
 * @date 2020/9/15 9:31
 * @email 455766076@qq.com
 */
public interface ErrorCodeConstant {
    //token为空
    int TOKEN_NULL_CODE = 0;
    String TOKEN_NULL_MSG = "token不能为空";

    //没有当前用户信息
    int USER_NULL_CODE = 1;
    String USER_NULL_MSG = "没有该用户信息";

    //密码不正确
    int PASSWORD_NOTMATCH_CODE = 2;
    String PASSWORD_NOTMATCH_MSG = "密码不正确";

    int TOKEN_TIMEOUT_CODE = 3;
    String TOKEN_TIMEOUT_MSG = "token超时，请重新登录";

    //token错误
    int TOKEN_ERROR_CODE = 1;
}
