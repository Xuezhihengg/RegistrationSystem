package com.example.controller;

import com.example.entity.Batch;
import com.example.entity.response_entity.BusinessCodes;
import com.example.entity.response_entity.BusinessException;
import com.example.entity.response_entity.ResponseResult;
import com.example.service.impl.BatchServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Batch" ,description = "批次表操作接口")
@RestController
@RequestMapping("/batch")
public class BatchController {
    @Autowired
    BatchServiceImpl batchServiceImpl;

    @Operation(summary = "获取全部批次", description = "监考报名--获取批次列表--WORKER")
    @GetMapping("all")
    public ResponseResult<List<Batch>> getAll() throws BusinessException {
        List<Batch> responseData =batchServiceImpl.list() ;
        if(responseData.isEmpty()) throw new BusinessException(BusinessCodes.Other_Error);
        return ResponseResult.success(responseData);
    }

    @Operation(summary = "创建新批次",description = "监考管理/创建监考报名批次--创建新批次--考务科科长")
    @PostMapping
    public ResponseResult<Batch> add(@RequestBody Batch batch) throws BusinessException {
        if(batch == null) throw new BusinessException(BusinessCodes.Other_Error);
        batchServiceImpl.save(batch);
        return ResponseResult.success(batch);
    }
}
