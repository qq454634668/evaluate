package com.evaluate.service.impl;



import com.evaluate.mapper.StudentMapper;
import com.evaluate.service.StudentService;
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
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;


    @Override
    public List stuList(Map<String, Object> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return studentMapper.stuList(param);
    }

    @Override
    public void addStu(Map<String, Object> param) {
        int flag = studentMapper.addStu(param);
        if(flag <= 0){
            throw new RuntimeException("添加失败");
        }
    }

    @Override
    public List stuOne(Map<String, Object> param) {
        return studentMapper.stuOne(param);
    }

    @Override
    public void editStu(Map<String, Object> param) {
        int flag = studentMapper.editStu(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public void delStu(Map<String, Object> param) {
        int flag = studentMapper.delStu(param);
        if(flag <= 0){
            throw new RuntimeException("删除失败");
        }
    }
}
