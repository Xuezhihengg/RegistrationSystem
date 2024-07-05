package com.example.service.impl;

import com.example.entity.Batch;
import com.example.dao.BatchMapper;
import com.example.service.IBatchService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BatchServiceImpl extends MPJBaseServiceImpl<BatchMapper, Batch> implements IBatchService {

}
