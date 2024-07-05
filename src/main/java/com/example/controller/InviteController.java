package com.example.controller;

import com.example.entity.Invite;
import com.example.entity.response_entity.ResponseResult;
import com.example.service.impl.InviteServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invite")
@Tag(name = "Invite" ,description = "邀请表操作接口")
public class InviteController {

    @Autowired
    private InviteServiceImpl inviteServiceImpl;

    @Operation(summary = "提交邀约",description = "报名审批/邀约--提交邀约--考务科科长/副院长/综合办主任/研公办主任")
    @PostMapping
    public ResponseResult<Invite> invite(@RequestBody @Valid Invite invite) {
        inviteServiceImpl.save(invite);
        return ResponseResult.success(invite);
    }
}
