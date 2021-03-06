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
    //添加评分
    void addScore(Map<String,Object> param);
    //指标列表
    List quotaList(Map<String, Object> param);
    List quotaList2(Map<String, Object> param);
    List scoreXqList(Map<String, Object> param);
    //判断学生和老师是否是同一班级，list大于0是同一班级，等于0不同一班级
    List pdStuTer(Map<String, Object> param);
}
