package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.entity.Auth;
import com.example.entity.Personnel;
import com.example.entity.business_entity.ChangePasswordRequest;
import com.example.entity.business_entity.LoginRequest;
import com.example.entity.business_entity.LoginResponse;
import com.example.entity.response_entity.BusinessCodes;
import com.example.entity.response_entity.BusinessException;
import com.example.entity.response_entity.ResponseResult;
import com.example.service.impl.AuthServiceImpl;
import com.example.service.impl.PersonnelServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Auth", description = "登录接口")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthServiceImpl authServiceImpl;
    @Autowired
    PersonnelServiceImpl personnelServiceImpl;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/change_password")
    @Operation(summary = "更该密码")
    public ResponseResult<Boolean> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) throws BusinessException {
        Auth auth = authServiceImpl.getById(changePasswordRequest.getPersonnelId());
        if (auth == null) throw new BusinessException(BusinessCodes.Other_Error);

        String encodedNewPassword = passwordEncoder.encode(changePasswordRequest.getNewPassword());

        if (!passwordEncoder.matches(changePasswordRequest.getOldPassword(), auth.getPassword()))
            throw new BusinessException(BusinessCodes.Other_Error);

        UpdateWrapper<Auth> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("password", encodedNewPassword);
        updateWrapper.eq("personnel_id", changePasswordRequest.getPersonnelId());

        authServiceImpl.update(updateWrapper);

        return ResponseResult.success(true);
    }

    @PostMapping("/login")
    @Operation(summary = "登录")
    public ResponseResult<LoginResponse> login(@RequestBody LoginRequest loginRequest) throws BusinessException {
        String personnelId = loginRequest.getPersonnelId();
        Auth auth = authServiceImpl.getById(personnelId);
        if (auth == null) throw new BusinessException(BusinessCodes.Other_Error);

        if (!passwordEncoder.matches(loginRequest.getPassword(), auth.getPassword())) {
            return ResponseResult.success(LoginResponse.builder()
                    .isLogin(false)
                    .personnelId(personnelId)
                    .personnelName("")
                    .role("")
                    .build());
        }
        Personnel personnel = personnelServiceImpl.getById(personnelId);

        String personnelName = personnel.getName();

        return ResponseResult.success(LoginResponse.builder()
                .isLogin(true)
                .personnelId(personnelId)
                .personnelName(personnelName)
                .role(auth.getRole())
                .build());
    }
}
