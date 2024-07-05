package com.example.service.impl;

import com.example.entity.Personnel;
import com.example.dao.PersonnelMapper;
import com.example.service.IPersonnelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PersonnelServiceImpl extends MPJBaseServiceImpl<PersonnelMapper, Personnel> implements IPersonnelService {

}
