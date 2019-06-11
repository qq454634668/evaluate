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
    //此学生此评分项有没有评分
    List existScore(Map<String,Object> param);
    //添加分数
    int addScore(Map<String,Object> param);
    //更新分数
    int editScore(Map<String,Object> param);
    //添加单项分数
    int addScoreSingle(Map<String,Object> param);
}
