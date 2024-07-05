package com.example.service.impl;

import com.example.entity.SignUp;
import com.example.dao.SignUpMapper;
import com.example.service.ISignUpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 报名表 服务实现类
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-04
 */
@Service
public class SignUpServiceImpl extends ServiceImpl<SignUpMapper, SignUp> implements ISignUpService {

    @Autowired
    private SignUpMapper signUpMapper;

    public SignUp getByKeys(String personnelId,int batchId){
        return signUpMapper.getByKeys(batchId,personnelId);
    }
}
