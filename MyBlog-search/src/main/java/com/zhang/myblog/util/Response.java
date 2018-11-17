package com.zhang.myblog.util;

/**
 * @author created by Zhangdazhuang
 * @version v.0.1
 * @date 2018/11/2
 * @备注 封装返回对象
 **/
public class Response {
    //处理是否成功
    private boolean success;
    //处理后的消息提示
    private String message;
    //返回数据
    private Object body;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Response(boolean success, String message, Object body) {
        this.success = success;
        this.message = message;
        this.body = body;
    }
}
