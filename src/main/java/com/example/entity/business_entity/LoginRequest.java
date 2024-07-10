package com.example.entity.business_entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginRequest {
    @Schema(description = "工号")
    private String personnelId;

    @Schema(description = "密码")
    private String password;
}
