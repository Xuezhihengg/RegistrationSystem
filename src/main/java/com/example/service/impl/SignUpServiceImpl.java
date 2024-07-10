package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.*;
import com.example.dao.SignUpMapper;
import com.example.entity.business_entity.ApproveItemResponse;
import com.example.entity.business_entity.DetailItem;
import com.example.entity.response_entity.BusinessCodes;
import com.example.entity.response_entity.BusinessException;
import com.example.service.ISignUpService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignUpServiceImpl extends MPJBaseServiceImpl<SignUpMapper, SignUp> implements ISignUpService {

    @Autowired
    private SignUpMapper signUpMapper;

    public SignUp getByKeys(String personnelId, int batchId) {
        return signUpMapper.getByKeys(batchId, personnelId);
    }

    //从工号单位联表得到所有报名表中同单位的报名者  ?? issue Cannot determine value type from string '王五'
    public List<ApproveItemResponse> getApproveListByService(String unit, int status) throws BusinessException {
        List<ApproveItemResponse> list = signUpMapper.selectJoinList(ApproveItemResponse.class,
                new MPJLambdaWrapper<SignUp>()
                        .select(SignUp::getIntendedCampus)
                        .select(Personnel::getPersonnelId)
                        .select(Personnel::getName)
                        .select(Batch::getBatchName)
                        .leftJoin(Personnel.class, Personnel::getPersonnelId, SignUp::getPersonnelId)
                        .leftJoin(Batch.class, Batch::getBatchId, SignUp::getBatchId)
                        .eq(Personnel::getUnit, unit)
                        .eq(SignUp::getApprovalStatus, status)
        );

        if (list == null || list.isEmpty()) throw new BusinessException(BusinessCodes.Other_Error);
        return list;
    }

    //联表查询监考详细信息
    public List<DetailItem> getDetailItemsByBatchId(Integer batchId) throws BusinessException {
        MPJLambdaWrapper<SignUp> wrapper = new MPJLambdaWrapper<SignUp>()
                .select(Personnel::getName)
                .select(Personnel::getGender)
                .select(Personnel::getPersonnelId)
                .select(Personnel::getUnit)
                .select(Personnel::getPhone)
                .select(Examination::getExamRoom)
                .select(Examination::getFromTime)
                .select(Examination::getEndTime)
                .leftJoin(Personnel.class, Personnel::getPersonnelId, SignUp::getPersonnelId)
                .leftJoin(Examination.class, Examination::getExamId, SignUp::getExamId)
                .eq(SignUp::getApprovalStatus, 5);

        if (batchId != null) wrapper.eq(SignUp::getBatchId, batchId);

        List<DetailItem> list = signUpMapper.selectJoinList(DetailItem.class,wrapper);
        if (list == null || list.isEmpty()) throw new BusinessException(BusinessCodes.Other_Error);
        return list;
    }
}
