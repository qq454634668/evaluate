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
    public List collegeList(Map<String, Object> param,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return collegeMapper.collegeList(param);
    }

    @Override
    public void addCollege(Map<String, Object> param) {
        int flag = collegeMapper.addCollege(param);
        if(flag <= 0){
            throw new RuntimeException("添加失败");
        }
    }

    @Override
    public void editCollege(Map<String, Object> param) {
        int flag = collegeMapper.editCollege(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public void delCollege(Map<String, Object> param) {
        int flag = collegeMapper.delCollege(param);
        if(flag <= 0){
            throw new RuntimeException("删除失败");
        }
    }
}
