package com.evaluate.mapper;

import java.util.List;
import java.util.Map;

public interface CollegeMapper {
    //学校列表
    List collegeList(Map<String,Object> param);
    //增加学院
    int addCollege(Map<String,Object> param);
    //修改学院
    int editCollege(Map<String,Object> param);
    //删除学院
    int delCollege(Map<String,Object> param);

}
