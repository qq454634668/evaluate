package com.evaluate.service;


import java.util.List;
import java.util.Map;

public interface CollegeService {
    //学校列表
    List gradeList(Map<String,Object> param,int pageNum, int pageSize);
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
}
