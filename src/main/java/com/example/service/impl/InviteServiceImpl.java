package com.example.service.impl;

import com.example.entity.Invite;
import com.example.dao.InviteMapper;
import com.example.service.IInviteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class InviteServiceImpl extends MPJBaseServiceImpl<InviteMapper, Invite> implements IInviteService {

}
