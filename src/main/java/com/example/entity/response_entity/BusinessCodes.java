package com.example.entity.response_entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BusinessCodes {
    Parameter_Verification_Failed("40001","Parameter verification failed. "),
    AuthenticationFailed("40002","Authentication failed. "),
    Other_Error("39999","Something went wrong. "),;


    private final String code;
    private final String message;
}

