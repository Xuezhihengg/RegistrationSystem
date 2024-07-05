package com.example.dao;

import com.example.entity.SignUp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 报名表 Mapper 接口
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-04
 */
public interface SignUpMapper extends BaseMapper<SignUp> {

    @Results(
            id = "signUpResult",
            value = {
                    @Result(id = true ,property = "personnelId",column = "personnel_id"),
                    @Result(property = "batchId",column = "batch_id"),
                    @Result(property = "approvalStatus", column = "approval_status"),
                    @Result(property = "intendedCampus",column = "intended_campus"),
                    @Result(property = "reason",column = "reason")
            }
    )
    @Select("select * from SignUp where batch_id=#{batchId} and personnel_id=#{personnelId}")
    SignUp getByKeys(@Param("batchId") int batchId, @Param("personnelId") String personnelId);

}