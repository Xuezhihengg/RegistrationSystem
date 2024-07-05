package com.example.service.impl;

import com.example.entity.Auth;
import com.example.dao.AuthMapper;
import com.example.service.IAuthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl extends MPJBaseServiceImpl<AuthMapper, Auth> implements IAuthService {

}
