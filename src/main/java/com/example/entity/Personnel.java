package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@TableName("Personnel")
@Schema(name = "Personnel", description = "")
public class Personnel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "工号")
    @TableId("personnel_id")
    private String personnelId;

    @Schema(description = "姓名")
    @TableField("name")
    private String name;

    @Schema(description = "职位")
    @TableField("position")
    private String position;

    @Schema(description = "单位")
    @TableField("unit")
    private String unit;

    @Schema(description = "性别")
    @TableField("gender")
    private String gender;

    @Schema(description = "学历")
    @TableField("edu_background")
    private String eduBackground;

    @Schema(description = "电话")
    @TableField("phone")
    private String phone;

    @Schema(description = "电话(备用)")
    @TableField("backup_phone")
    private String backupPhone;

    @Schema(description = "照片")
    @TableField("photo")
    private String photo;
}
