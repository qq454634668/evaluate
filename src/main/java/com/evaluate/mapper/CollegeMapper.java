package com.evaluate.mapper;

import java.util.List;
import java.util.Map;

public interface CollegeMapper {
    //学级列表
    List gradeList(Map<String,Object> param);
    //增加学级
    int addGrade(Map<String,Object> param);
    //修改学级
    int editGrade(Map<String,Object> param);
    //删除学级
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
    //班级列表
    List teamList(Map<String,Object> param);
    //年级列表根据specialty_id查询
    List gradeList2(Map<String,Object> param);
    //添加班级
    int addTeam(Map<String,Object> param);
    //修改班级
    int editTeam(Map<String,Object> param);
    //删除班级
    int delTeam(Map<String,Object> param);
    //学期列表
    List termList(Map<String,Object> param);
    //增加学期
    int addTerm(Map<String,Object> param);
    //修改学期
    int editTerm(Map<String,Object> param);
    //删除学期
    int delTerm(Map<String,Object> param);


}
