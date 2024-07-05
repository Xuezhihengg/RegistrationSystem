package com.example.service.impl;

import com.example.entity.Batch;
import com.example.dao.BatchMapper;
import com.example.service.IBatchService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-04
 */
@Service
public class BatchServiceImpl extends ServiceImpl<BatchMapper, Batch> implements IBatchService {

}
