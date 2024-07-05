package com.example.entity.business_entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AproveRequest {
    @NotEmpty
    @Schema(description = "申请人工号")
    private String personnelId;

    @NotNull
    @Schema(description = "申请批次")
    private int batchId;

    @NotNull
    @Schema(description = "更新后的审批状态")
    private int status;

    @Schema(description = "不同意理由")
    private String reason;
}
