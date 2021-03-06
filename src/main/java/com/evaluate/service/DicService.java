package com.evaluate.service;


import java.util.List;
import java.util.Map;

public interface DicService {
    //老师菜单
    List usersList(Map<String,Object> param);
    //年级字典
    List dicGrade(Map<String,Object> param);
    //选择科系
    List dicDepartment(Map<String,Object> param);
    //选择专业
    List dicSpecialty(Map<String,Object> param);
    //选择班级
    List dicTeam(Map<String,Object> param);
    //选择学生
    List dicStu(Map<String,Object> param);
    //选择角色
    List dicRole(Map<String,Object> param);
}
