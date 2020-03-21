package com.dataobject.utils.response;

public class CommonReturnType {
    /**
     * success：请求成功
     * fail：请求失败
     */
    private String status;
    /**
     * 当status=success，正常返回json数据
     * 当status=fail,统一调用通用的错误码格式
     */
    private Object data;

    public static CommonReturnType sendResponse(Object result) {
        return CommonReturnType.sendResponse("success", result);
    }

    public static CommonReturnType sendResponse(String status, Object result) {
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }

    public String getStatus() {
        return status;
    }

    public CommonReturnType setStatus(String status) {
        this.status = status;
        return this;
    }

    public Object getData() {
        return data;
    }

    public CommonReturnType setData(Object data) {
        this.data = data;
        return this;
    }
}
