package com.mizuki.sinatv.bean;

/**
 * Created by Administrator on 2017/8/28.
 */

public class SignUpBean {
    /**
     * result : true
     * error_code : 0
     */

    private boolean result;
    private int error_code;
    /**
     * request :
     * error_msg : 手机号已经被注册
     */

    private String request;
    private String error_msg;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }
}
