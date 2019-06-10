package com.evaluate.service;


import java.util.List;
import java.util.Map;

public interface StudentService {
    //学生列表
    List stuList(Map<String,Object> param,int pageNum,int pageSize);
    //手动添加学生
    void addStu(Map<String,Object> param);
    //学生个人基本信息
    List stuOne(Map<String,Object> param);
    //修改学生
    void editStu(Map<String,Object> param);
    //删除用户
    void delStu(Map<String,Object> param);
}
