package com.example.entity.business_entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class ApplyRequest {

    @NotEmpty(message = "工号不能为空")
    @Pattern(regexp = "^\\d{5}$",message = "工号格式不匹配")
    @Schema(description = "申请人工号")
    private String applyPersonnelId;

    @NotNull(message ="批次不能为空")
    @Schema(description = "报名批次")
    private Integer applyBatchId;

    @NotEmpty(message = "意向校区不能为空")
    @Schema(description = "意向校区")
    private String applyCampus;
}
