package com.jajian.search.common;

public class CommonResult<T> {

    private int code;

    private T data;

    private String message;

    public CommonResult(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    private static int SUCCESS = 0000;
    private static int ERROR = 9999;

    public static CommonResult success(Object data) {
        return new CommonResult(SUCCESS, data, null);
    }

    public static CommonResult fail(Object data) {
        return new CommonResult(ERROR, data, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
