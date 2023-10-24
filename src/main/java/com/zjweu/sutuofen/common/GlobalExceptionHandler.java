package com.zjweu.sutuofen.common;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 异常处理方法
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.error(ex.getMessage());

        if(ex.getMessage().contains("Duplicate entry")){
            String[] split = ex.getMessage().split(" ");
            String msg = split[2] + "已存在";
            return R.error(msg);
        }

        return R.error("未知错误");
    }


/**
 * 异常处理方法
 * @return
 */
    @ExceptionHandler(SignatureVerificationException.class)
    public R<String> RuntimeException(SignatureVerificationException ex){
        log.error(ex.getMessage());

        return R.error("token修改错误");
    }

    @ExceptionHandler(Exception.class)
    public R<String> Exception(Exception ex){
        log.error(ex.getMessage());
        return R.error("服务器发生异常");
    }


}
