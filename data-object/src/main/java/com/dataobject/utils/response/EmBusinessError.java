package com.dataobject.utils.response;

public enum EmBusinessError implements CommonError {
    USER_NOT_EXIST(10001, "用户不存在"),
    UNKNOWN_ERROR(20001, "未知错误");

    private  int errCode;
    private  String errMsg;

    EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }


    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
