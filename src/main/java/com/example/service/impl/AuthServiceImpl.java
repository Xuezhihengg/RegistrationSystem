package com.example.service.impl;

import com.example.entity.Auth;
import com.example.dao.AuthMapper;
import com.example.service.IAuthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 注册表 服务实现类
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-04
 */
@Service
public class AuthServiceImpl extends ServiceImpl<AuthMapper, Auth> implements IAuthService {

}
