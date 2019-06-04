package com.evaluate.service;


import java.util.List;
import java.util.Map;

public interface StudentService {
    //学生列表
    List stuList(Map<String,Object> param,int pageNum,int pageSize);
}
