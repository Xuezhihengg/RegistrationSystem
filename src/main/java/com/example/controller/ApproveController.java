package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.entity.Personnel;
import com.example.entity.SignUp;
import com.example.entity.business_entity.ApproveItemResponse;
import com.example.entity.business_entity.AproveRequest;
import com.example.entity.business_entity.DetailItem;
import com.example.entity.response_entity.BusinessCodes;
import com.example.entity.response_entity.BusinessException;
import com.example.entity.response_entity.ResponseResult;
import com.example.service.impl.PersonnelServiceImpl;
import com.example.service.impl.SignUpServiceImpl;
import com.example.utils.RoleToStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Approve",description = "审批相关操作接口")
@RestController
@RequestMapping("/approve")
public class ApproveController {
    @Autowired
    PersonnelServiceImpl personnelServiceImpl;

    @Autowired
    SignUpServiceImpl signUpServiceImpl;

    @Operation(summary = "获取指定工号的待审批列表",description = "报名审批--获取指定工号的待审批列表--考务科科长/副院长/综合办主任/研公办主任")
    @GetMapping("/{personnelId}&&{role}")
    public ResponseResult<List<ApproveItemResponse>> getApproveList(@PathVariable @NotEmpty String personnelId, @PathVariable @NotEmpty String role) throws BusinessException {
        if(role.equals("WORKER")) throw new BusinessException(BusinessCodes.Other_Error);

        Personnel personnel = personnelServiceImpl.getById(personnelId);
        if(personnel == null) throw new BusinessException(BusinessCodes.Other_Error);

        String unit = personnel.getUnit();
        int status = RoleToStatus.role2status(role);

        return ResponseResult.success(signUpServiceImpl.getApproveListByService(unit,status));
    }

    @Operation(summary = "提交审批",description = "报名审批/报名审批--提交审批--考务科科长/副院长/综合办主任/研公办主任")
    @PostMapping
    public ResponseResult<AproveRequest> approve(@RequestBody @Valid AproveRequest approveRequest) {
        UpdateWrapper<SignUp> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("personnel_id",approveRequest.getPersonnelId());
        updateWrapper.eq("batch_id",approveRequest.getBatchId());
        updateWrapper.set("approval_status",approveRequest.getStatus());
        updateWrapper.set("reason",approveRequest.getReason());

        signUpServiceImpl.update(updateWrapper);

        return ResponseResult.success(approveRequest);
    }

    @Operation(summary = "获取监考名单",description = "监考安排表/监考详细名单--获取监考名单--考务科科长/副院长/综合办主任/研公办主任")
    @GetMapping("/detail")
    public ResponseResult<List<DetailItem>> getDetailList() {
       return ResponseResult.success( signUpServiceImpl.getDetailItemByService());
    }
}


