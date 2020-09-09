package com.hpstudio.forummain.entity;

import lombok.Data;

/**
 * @author mawen
 * @date 2020/9/9 9:35
 * @email 455766076@qq.com
 */
@Data
public final class Result {
    private int code;

    private String msg;

    private Object data;

    private final static int SUCCESS_CODE = 0;
    private final static int FAIL_CODE = 1;

    private final static String SUCCESS_MSG = "数据请求成功";
    private final static String FAIL_MSG = "程序开小差啦~";

    private Result() {
    }


    private Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static Result success(Object data) {
        return new Result(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static Result success() {
        return new Result(SUCCESS_CODE, SUCCESS_MSG, 1);
    }

    public static Result fail(Object data) {
        return new Result(FAIL_CODE, FAIL_MSG, data);
    }

    public static Result fail() {
        return new Result(FAIL_CODE, FAIL_MSG);
    }
}