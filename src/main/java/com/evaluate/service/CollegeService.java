package com.evaluate.service;


import java.util.List;
import java.util.Map;

public interface CollegeService {
    //学校列表
    List gradeList(Map<String,Object> param);
    //增加学院
    void addGrade(Map<String,Object> param);
    //修改学院
    void editGrade(Map<String,Object> param);
    //删除学院
    void delGrade(Map<String,Object> param);
    //专业Map
    List specialtyList(Map<String,Object> param);
    //增加专业
    void addSpecialty(Map<String,Object> param);
    //修改专业
    void editSpecialty(Map<String,Object> param);
    //删除专业
    void delSpecialty(Map<String,Object> param);
    //科系列表
    List departmentList(Map<String,Object> param);
    //班级列表
    List teamList(Map<String,Object> param);
    //添加班级
    void addTeam(Map<String,Object> param);
    //修改班级
    void editTeam(Map<String,Object> param);
    //删除班级
    void delTeam(Map<String,Object> param);
    //学期列表
    List termList(Map<String,Object> param);
    //增加学期
    void addTerm(Map<String,Object> param);
    //修改学期
    void editTerm(Map<String,Object> param);
    //删除学期
    void delTerm(Map<String,Object> param);
}
