package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.dao.ExaminationMapper;
import com.example.entity.Examination;
import com.example.service.impl.ExaminationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/examination")
public class ExaminationController {
    @Autowired
    ExaminationServiceImpl examinationServiceImpl;

    @GetMapping("{batch_id}")
    public List<Examination> getExaminationByBatchId(@PathVariable("batch_id") String batchId){
        QueryWrapper<Examination> sectionQueryWrapper = new QueryWrapper<>();
        sectionQueryWrapper.eq("batch_id", batchId);
        return examinationServiceImpl.list(sectionQueryWrapper);
    }
}
