package com.example.controller;

import com.example.entity.SignUp;
import com.example.service.impl.SignUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 报名表 前端控制器
 * </p>
 *
 * @author xuezhihengg
 * @since 2024-07-04
 */
@RestController
@RequestMapping("/signup")
public class SignUpController {
    @Autowired
    SignUpServiceImpl signUpServiceImpl;

    @GetMapping("status/{personnelId}&&{batchId}")
    public Integer getStatus(@PathVariable String personnelId, @PathVariable int batchId) {
        //SignUp实体的id为personnelId
        SignUp signUp = signUpServiceImpl.getByKeys(personnelId,batchId);
        return signUp.getApprovalStatus();
    }
}
