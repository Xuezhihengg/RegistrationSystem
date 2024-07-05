package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@TableName("Invite")
@Schema(name = "Invite", description = "邀请表")
public class Invite implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "邀约编号")
    @TableId(value = "invite_id", type = IdType.AUTO)
    private Integer inviteId;

    @Schema(description = "批次")
    @TableField("batch_id")
    @NotNull
    private Integer batchId;

    @Schema(description = "工号")
    @TableField("personnel_id")
    @NotNull
    private String personnelId;

    @Schema(description = "考试编号")
    @TableField("exam_id")
    private String examId;

    @Schema(description = "邀请方式")
    @NotNull
    @TableField("type")
    private Boolean type;
}
