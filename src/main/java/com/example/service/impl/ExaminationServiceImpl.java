package com.example.service.impl;

import com.example.entity.Examination;
import com.example.dao.ExaminationMapper;
import com.example.service.IExaminationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ExaminationServiceImpl extends MPJBaseServiceImpl<ExaminationMapper, Examination> implements IExaminationService {

}
