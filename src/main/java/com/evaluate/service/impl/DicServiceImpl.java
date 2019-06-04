package com.evaluate.service.impl;


import com.evaluate.mapper.DicMapper;
import com.evaluate.service.DicService;
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
public class DicServiceImpl implements DicService {

    @Resource
    private DicMapper dicMapper;


    @Override
    public List usersList(Map<String, Object> param) {
        return dicMapper.usersList(param);
    }

    @Override
    public List dicGrade(Map<String, Object> param) {
        return dicMapper.dicGrade(param);
    }

    @Override
    public List dicDepartment(Map<String, Object> param) {
        return dicMapper.dicDepartment(param);
    }

    @Override
    public List dicSpecialty(Map<String, Object> param) {
        return dicMapper.dicSpecialty(param);
    }

    @Override
    public List dicTeam(Map<String, Object> param) {
        return dicMapper.dicTeam(param);
    }
}
