package com.example.entity.response_entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseResult<T> {
    private long timestamp;
    private String status;
    private String message;
    private T data;

    public static <T> ResponseResult<T> success() {
        return success(null);
    }

    public  static <T> ResponseResult<T> success(T data) {
        return ResponseResult.<T>builder().data(data)
                .message(ResponseStatus.SUCCESS.getResponseMessage())
                .status(ResponseStatus.SUCCESS.getResponseCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }

    public static <T> ResponseResult<T> fail(String status,String message){
        return fail(status,message,null);
    }

    public static <T> ResponseResult<T> fail(String status, String message,T data){
        return ResponseResult.<T>builder().data(data)
                .status(status)
                .message(message)
                .timestamp(System.currentTimeMillis())
                .build();
    }
}
