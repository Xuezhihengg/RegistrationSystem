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

/**
 * <p>
 * 
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-04
 */
@Getter
@Setter
@TableName("Examination")
@Schema(name = "Examination", description = "")
public class Examination implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "考试编号")
    @TableId(value = "exam_id", type = IdType.AUTO)
    private Integer examId;

    @Schema(description = "批次")
    @TableField("batch_id")
    private Integer batchId;

    @Schema(description = "考场")
    @TableField("exam_room")
    private String examRoom;

    @Schema(description = "校区")
    @TableField("campus")
    private String campus;

    @Schema(description = "考试地点")
    @TableField("address")
    private String address;

    @Schema(description = "考试开始时间")
    @TableField("from_time")
    private LocalDate fromTime;

    @Schema(description = "考试结束时间")
    @TableField("end_time")
    private LocalDate endTime;
}
