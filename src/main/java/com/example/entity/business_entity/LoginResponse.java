package com.example.entity.business_entity;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    @Schema(description = "是否登录成功")
    private Boolean isLogin;

    @Schema(description = "工号")
    private String personnelId;

    @Schema(description = "姓名")
    private String personnelName;

    @Schema(description = "角色")
    private String role;
}
