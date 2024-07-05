package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 邀请表
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-05
 */
@Getter
@Setter
@TableName("Invite")
@Schema(name = "Invite", description = "邀请表")
public class Invite implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "邀约编号")
    @TableId(value = "invite_id", type = IdType.AUTO)
    private Integer inviteId;

    @Schema(description = "批次")
    @TableField("batch_id")
    private Integer batchId;

    @Schema(description = "工号")
    @TableField("personnel_id")
    private String personnelId;

    @Schema(description = "邀请方式")
    @TableField("type")
    private Boolean type;
}
