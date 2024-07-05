package com.example.entity.business_entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplyStatusResponse {

    @Schema(description = "审批状态")
    private Integer applyStatus;

    @Schema(description = "不同意原因")
    private String reason;
}
