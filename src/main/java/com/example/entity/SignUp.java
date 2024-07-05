package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 报名表
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-04
 */
@Getter
@Setter
@TableName("SignUp")
@Schema(name = "SignUp", description = "报名表")
public class SignUp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "工号")
    @TableId("personnel_id")
    private String personnelId;

    @Schema(description = "批次")
    @TableField("batch_id")
    private Integer batchId;

    @Schema(description = "审批状态")
    @TableField("approval_status")
    private Integer approvalStatus;

    @Schema(description = "意向校区")
    @TableField("intended_campus")
    private String intendedCampus;

    @Schema(description = "不同意理由")
    @TableField("reason")
    private String reason;
}
