package com.evaluate.service.impl;


import com.evaluate.mapper.QuotaMapper;
import com.evaluate.service.QuotaService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QuotaServiceImpl implements QuotaService {

    @Resource
    private QuotaMapper quotaMapper;



    @Override
    public void addQuota(Map<String, Object> param) {
        int flag = quotaMapper.addQuota(param);
        if(flag <= 0){
            throw new RuntimeException("添加失败");
        }
    }

    @Override
    public void editQuota(Map<String, Object> param) {
        int flag = quotaMapper.editQuota(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
        }
    }


}
