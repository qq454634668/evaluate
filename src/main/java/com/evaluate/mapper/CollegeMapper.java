package com.evaluate.mapper;

import java.util.List;
import java.util.Map;

public interface CollegeMapper {
    //学校列表
    List gradeList(Map<String,Object> param);
    //增加学院
    int addGrade(Map<String,Object> param);
    //修改学院
    int editGrade(Map<String,Object> param);
    //删除学院
    int delGrade(Map<String,Object> param);
    //科系列表
    List departmentList(Map<String,Object> param);
    //专业列表
    List specialtyList(Map<String,Object> param);
    //增加专业
    int addSpecialty(Map<String,Object> param);
    //修改专业
    int editSpecialty(Map<String,Object> param);
    //删除专业
    int delSpecialty(Map<String,Object> param);

}
