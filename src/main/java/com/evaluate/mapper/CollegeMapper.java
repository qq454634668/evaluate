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

}
