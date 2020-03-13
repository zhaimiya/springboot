package com.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(assignableTypes=HelloController.class)
public class HelloControllerAdvice {
    @ModelAttribute("msg")
    public String msg(){
        return "hello- ~~";
    }

    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language")String acceptLanguage){
        return acceptLanguage;
    }

    @ModelAttribute("sessionId")
    public String sessionId(@CookieValue("JSESSIONID")String sessionId){
        return sessionId;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> onException(Throwable throwable){
        return  ResponseEntity.ok(throwable.getMessage());

    }
}
