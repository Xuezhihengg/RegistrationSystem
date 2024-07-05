package com.example.utils;

import com.example.entity.response_entity.BusinessCodes;
import com.example.entity.response_entity.BusinessException;
import com.example.entity.response_entity.ResponseResult;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@Slf4j
@RestControllerAdvice
public class CommonExpectionHandler {
    //校验异常处理
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder sb = new StringBuilder(BusinessCodes.Parameter_Verification_Failed.getMessage());
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(", ");
        }
        String message = sb.toString();
        log.warn(message);
        return ResponseResult.fail(HttpStatus.OK.toString(),message);
    }

    //校验违反约束异常处理
    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseResult handleConstraintViolationException(ConstraintViolationException e) {
        log.warn(e.getMessage());
        return ResponseResult.fail(HttpStatus.OK.toString(),e.getMessage());
    }

    //业务异常处理
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseResult handleBusinessException(BusinessException e) {
        log.warn(e.getMessage(),e);
        return ResponseResult.fail(e.getCode(),e.getMessage());
    }

    //SQL异常处理
    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseResult handleSQLException(SQLException e) {
        log.warn(e.getMessage(),e);
        return ResponseResult.fail(HttpStatus.OK.toString(),e.getMessage());
    }
}

