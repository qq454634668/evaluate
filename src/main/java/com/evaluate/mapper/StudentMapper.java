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
    //获得parent_id
    List<Map<String,Object>> getParentId(Map<String,Object> param);

    List<Map<String,Object>> quotaList(Map<String,Object> param);
    //带分数的列表
    List<Map<String,Object>> quotaList2(Map<String,Object> param);
    //判断该Criterion_id和该学生是否有数据
    List<Map<String,Object>> existCriterion(Map<String,Object> param);
}
