package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.Examination;
import com.example.entity.response_entity.BusinessCodes;
import com.example.entity.response_entity.BusinessException;
import com.example.entity.response_entity.ResponseResult;
import com.example.service.impl.ExaminationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Examination" ,description = "考试表操作接口")
@RestController
@RequestMapping("/examination")
public class ExaminationController {
    @Autowired
    ExaminationServiceImpl examinationServiceImpl;

    @Operation(summary = "获取指定批次的全部考试信息",description = "监考报名/监考批次详情--获取监考批次详情--WORKER")
    @GetMapping("{batch_id}")
    public ResponseResult<List<Examination>> getExaminationByBatchId(@PathVariable("batch_id") Integer batchId) throws BusinessException {
        QueryWrapper<Examination> sectionQueryWrapper = new QueryWrapper<>();
        sectionQueryWrapper.eq("batch_id", batchId);
        List<Examination> responseData = examinationServiceImpl.list(sectionQueryWrapper);
        if (responseData == null || responseData.isEmpty()) throw new BusinessException(BusinessCodes.Other_Error);

        return ResponseResult.success(responseData);
    }
}
