package com.ykly.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * Created by hongwei on 2016/12/1.
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = Throwable.class)
    public ResMsg throwableHandler(Throwable t) throws Exception {
        
        if (t instanceof MissingServletRequestParameterException) {
            MissingServletRequestParameterException msrpe = (MissingServletRequestParameterException) t;
            return ResMsg.fail(RetCodeEnum.INPUT_ERROR, "", msrpe.getMessage());
        }
        if (t instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException manve = (MethodArgumentNotValidException) t;
            return ResMsg
                    .fail(RetCodeEnum.INPUT_ERROR, "", manve.getBindingResult().getFieldError().getDefaultMessage());
        }
        if (t instanceof ConstraintViolationException) {
            ConstraintViolationException cve = (ConstraintViolationException) t;
            return ResMsg.fail(RetCodeEnum.INPUT_ERROR, "", cve.getConstraintViolations().toString());
        }

        /*未作处理的异常抛出未知异常*/
        log.error("--> GlobalExceptionHandler ", t);
        return ResMsg.unknowWithMsg(t.toString());
    }
    
}
