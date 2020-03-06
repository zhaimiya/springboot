package com.example.utils.response;

public interface CommonError {
    public  int getErrCode();
    String getErrMsg();
    CommonError setErrMsg(String errMsg);
}
