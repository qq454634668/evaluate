package com.evaluate.service;


import java.util.List;
import java.util.Map;

public interface CollegeService {
    //学校列表
    List collegeList(Map<String,Object> param,int pageNum, int pageSize);
    //增加学院
    void addCollege(Map<String,Object> param);
    //修改学院
    void editCollege(Map<String,Object> param);
    //删除学院
    void delCollege(Map<String,Object> param);
}
