package com.example.controller;

import com.example.entity.Batch;
import com.example.service.impl.BatchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-04
 */
@RestController
@RequestMapping("/batch")
public class BatchController {
    @Autowired
    BatchServiceImpl batchServiceImpl;

    @GetMapping("all")
    public List<Batch> getAll() {
        return batchServiceImpl.list();
    }
}
