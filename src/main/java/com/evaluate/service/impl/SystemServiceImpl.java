package com.evaluate.service.impl;


import com.evaluate.mapper.DicMapper;
import com.evaluate.mapper.SystemMapper;
import com.evaluate.service.DicService;
import com.evaluate.service.SystemService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SystemServiceImpl implements SystemService {

    @Resource
    private SystemMapper systemMapper;

    @Override
    public List usersList(Map<String, Object> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return systemMapper.usersList(param);
    }

    @Override
    public void addUsers(Map<String, Object> param) {
        int flag = systemMapper.addUsers(param);
        if(flag <= 0){
            throw new RuntimeException("添加失败");
        }
    }
}
