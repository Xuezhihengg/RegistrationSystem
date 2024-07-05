package com.example.entity.response_entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public enum ResponseStatus {
    SUCCESS("200","success"),
    FAIL("500","fail"),
    HTTP_STATUS_200("200","ok"),
    HTTP_STATUS_500("500","server error"),
    HTTP_STATUS_400("400","bad request"),
    HTTP_STATUS_401("401","unauthorized"),
    HTTP_STATUS_403("403","forbidden");

    public static final List<ResponseStatus> HTTP_STATUS_ALL = Collections.unmodifiableList(
            Arrays.asList(HTTP_STATUS_200, HTTP_STATUS_400, HTTP_STATUS_401, HTTP_STATUS_403, HTTP_STATUS_500
            ));


    private final String responseCode;
    private final String responseMessage;

}

