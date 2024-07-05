package com.example.entity.business_entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApproveItemResponse {
    @Schema(description = "报名人")
    private String name;

    @Schema(description = "工号")
    private String personnelId;

    @Schema(description = "批次名称")
    private Integer batchName;

    @Schema(description = "意向校区")
    private String intendedCampus;
}
