package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("Batch")
@Schema(name = "Batch", description = "")
public class Batch implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "批次")
    @TableId(value = "batch_id", type = IdType.AUTO)
    private Integer batchId;

    @Schema(description = "批次名称")
    @TableField("batch_name")
    private String batchName;

    @Schema(description = "关联年份")
    @TableField("year")
    private String year;

    @Schema(description = "报名开始时间")
    @TableField("start_date")
    private LocalDate startDate;

    @Schema(description = "报名结束时间")
    @TableField("end_date")
    private LocalDate endDate;

    @Schema(description = "描述")
    @TableField("description")
    private String description;

    @Schema(description = "附件")
    @TableField("attachment")
    private String attachment;
}
