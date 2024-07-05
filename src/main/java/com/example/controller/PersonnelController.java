package com.example.controller;

import com.example.entity.Personnel;
import com.example.entity.response_entity.BusinessCodes;
import com.example.entity.response_entity.BusinessException;
import com.example.entity.response_entity.ResponseResult;
import com.example.service.impl.PersonnelServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Personnel",description = "人员表操作接口")
@RestController
@RequestMapping("/personnel")
public class PersonnelController {
    @Autowired
    PersonnelServiceImpl personnelServiceImpl;

    @Operation(summary = "获取指定人员的详细信息",description = "监考报名/提交报名--自动填充报名表部分信息--WORKER")
    @GetMapping("/{personnelId}")
    public ResponseResult<Personnel> getPersonnel(@PathVariable("personnelId") String personnelId) throws BusinessException {
        Personnel responseData = personnelServiceImpl.getById(personnelId);
        if (responseData == null) throw new BusinessException(BusinessCodes.Other_Error);
        return ResponseResult.success(responseData);
    }

}
