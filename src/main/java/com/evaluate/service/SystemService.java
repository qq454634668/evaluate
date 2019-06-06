package com.evaluate.service;


import java.util.List;
import java.util.Map;

public interface SystemService {
    List usersList(Map<String,Object> param,int pageNum, int pageSize);
    void addUsers(Map<String,Object> param);
    //是否占用用户名
    int existUser(Map<String,Object> param);
}
