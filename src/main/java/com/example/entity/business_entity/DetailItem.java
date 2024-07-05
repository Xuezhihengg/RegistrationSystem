package com.example.entity.business_entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetailItem {
    @Schema(description = "申请人姓名")
    private String name;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "工号")
    private String personnelId;

    @Schema(description = "单位")
    private String unit;

    @Schema(description = "电话")
    private String phone;

    @Schema(description = "考场")
    private String examRoom;

    @Schema(description = "监考开始时间")
    private String fromTime;

    @Schema(description = "监考结束时间")
    private String endTime;

}
