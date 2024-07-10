package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.SignUp;
import com.example.entity.business_entity.ApplyRequest;
import com.example.entity.business_entity.ApplyStatusResponse;
import com.example.entity.response_entity.BusinessCodes;
import com.example.entity.response_entity.BusinessException;
import com.example.entity.response_entity.ResponseResult;
import com.example.service.impl.SignUpServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "SignUp", description = "报名表操作接口")
@RestController
@RequestMapping("/signup")
@Validated
public class SignUpController {
    @Autowired
    SignUpServiceImpl signUpServiceImpl;

    @Operation(summary = "获取报名审批状态", description = "监考报名/提交报名--获取当前报名审批状态--WORKER")
    @GetMapping("status/{personnelId}&&{batchId}")
    public ResponseResult<ApplyStatusResponse> getStatus(@PathVariable @NotEmpty String personnelId, @PathVariable @NotNull int batchId) throws BusinessException{
        //SignUp实体的id为personnelId
        SignUp signUp = signUpServiceImpl.getByKeys(personnelId, batchId);
        if(signUp == null) throw new BusinessException(BusinessCodes.Other_Error);
        return ResponseResult.success(ApplyStatusResponse.builder()
                .applyStatus(signUp.getApprovalStatus())
                .reason(signUp.getReason())
                .build());
    }

    @Operation(summary = "获取指定工号的所有报名信息",description = "我的申请记录--获取指定工号的所有报名信息--WORKER")
    @GetMapping("status/{personnelId}")
    public ResponseResult<List<SignUp>> getSignUpList(@PathVariable @NotEmpty String personnelId) throws BusinessException{
        List<SignUp> list =  signUpServiceImpl.list(new QueryWrapper<SignUp>().eq("personnel_id", personnelId));
        if(list == null) throw new BusinessException(BusinessCodes.Other_Error);
        return ResponseResult.success(list);
    }

    @Operation(summary = "提交报名表", description = "监考报名/提交报名--提交报名表数据入库--WORKER")
    @PostMapping
    public ResponseResult<SignUp> signUp(@RequestBody @Valid ApplyRequest applyRequest) throws BusinessException {
        SignUp signUp = SignUp.builder()
                .personnelId(applyRequest.getApplyPersonnelId())
                .batchId(applyRequest.getApplyBatchId())
                .intendedCampus(applyRequest.getApplyCampus())
                .approvalStatus(1) //status:1 代表申请人以完成并提交报名
                .reason(null)
                .build();

        if(signUp.getPersonnelId() == null) {
            System.out.println("error");
            throw new BusinessException(BusinessCodes.Other_Error);
        };

        //报名数据入库
        signUpServiceImpl.save(signUp);
        return ResponseResult.success(signUp);
    }
}
