package com.example.utils;

import lombok.NonNull;

public class RoleToStatus {
    public static int role2status(@NonNull String role){
        return switch (role) {
            case "研公办主任" -> 1; //status:1 表示用户已提交申请，现在需要综合部主任审批
            case "综合办主任" -> 2;
            case "副院长" -> 3;
            case "考务科科长" -> 4; //status:5 表示全部审批完毕
            default -> 0;
        };
    }
}
