package com.evaluate.service;


import java.util.List;
import java.util.Map;

public interface SystemService {
    List usersList(Map<String,Object> param,int pageNum, int pageSize);
    void addUsers(Map<String,Object> param);
    //是否占用用户名
    int existUser(Map<String,Object> param);
    //修改用户密码
    void editUsersPas(Map<String,Object> param);
    //修改用户信息
    void editUsersRole(Map<String,Object> param);
    //删除用户
    void delUsers(Map<String,Object> param);
}
