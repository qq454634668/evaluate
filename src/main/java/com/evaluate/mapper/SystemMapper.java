package com.evaluate.mapper;

import java.util.List;
import java.util.Map;

public interface SystemMapper {
    List usersList(Map<String,Object> param);
    int addUsers(Map<String,Object> param);
    //是否占用用户名
    int existUser(Map<String,Object> param);
    //修改密码
    int editUsersPas(Map<String,Object> param);
    //修改用户信息
    int editUsersRole(Map<String,Object> param);
    //删除用户
    int delUsers(Map<String,Object> param);
    //角色列表
    List roleList(Map<String,Object> param);
}
