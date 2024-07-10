package com.example.entity.business_entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChangePasswordRequest {
    @NotEmpty
    @Schema(description = "工号")
    private String personnelId;

    @NotEmpty
    @Schema(description = "旧密码")
    private String oldPassword;


    @NotEmpty
    @Schema(description = "新密码")
    private String newPassword;
}
