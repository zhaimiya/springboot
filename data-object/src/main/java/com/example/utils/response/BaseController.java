package com.example.utils.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handleException(HttpServletRequest request, Exception exception) {
        Map<String, Object> responseData = new HashMap<>();
        if(exception instanceof BusinessException){
            BusinessException businessException = (BusinessException) exception;
            responseData.put("errCode", businessException.getErrCode());
            responseData.put("errMsg", businessException.getErrMsg());
        }else{
            responseData.put("errCode", EmBusinessError.UNKNOWN_ERROR.getErrCode());
            responseData.put("errMsg",  EmBusinessError.UNKNOWN_ERROR.getErrMsg());
        }
        return CommonReturnType.sendResponse("fail", responseData);
    }
}
