package com.evaluate.service.impl;


import com.evaluate.mapper.CollegeMapper;
import com.evaluate.service.CollegeService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Resource
    private CollegeMapper collegeMapper;


    @Override
    public List gradeList(Map<String, Object> param,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return collegeMapper.gradeList(param);
    }

    @Override
    public void addGrade(Map<String, Object> param) {
        int flag = collegeMapper.addGrade(param);
        if(flag <= 0){
            throw new RuntimeException("添加失败");
        }
    }

    @Override
    public void editGrade(Map<String, Object> param) {
        int flag = collegeMapper.editGrade(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public void delGrade(Map<String, Object> param) {
        int flag = collegeMapper.delGrade(param);
        if(flag <= 0){
            throw new RuntimeException("删除失败");
        }
    }
}
