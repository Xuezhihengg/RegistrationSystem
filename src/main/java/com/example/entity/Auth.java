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
 * 注册表
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-04
 */
@Getter
@Setter
@TableName("Auth")
@Schema(name = "Auth", description = "注册表")
public class Auth implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "工号")
    @TableId("personnel_id")
    private String personnelId;

    @Schema(description = "密码")
    @TableField("password")
    private String password;

    @Schema(description = "角色")
    @TableField("role")
    private String role;
}
