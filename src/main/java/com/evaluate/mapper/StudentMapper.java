package com.evaluate.mapper;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    //学生列表
    List stuList(Map<String,Object> param);
    //手动添加学生
    int addStu(Map<String,Object> param);
    //学生个人基本信息
    List stuOne(Map<String,Object> param);
    //修改学生
    int editStu(Map<String,Object> param);
    //删除学生
    int delStu(Map<String,Object> param);
}
