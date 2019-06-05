package com.evaluate.mapper;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int existUser(Map<String, Object> param);

    /**
     * 用户信息
     */
    List<Map<String,Object>> user(Map<String, Object> param);
    List<Map<String,Object>> UserInfoId(Map<String, Object> param);
    void insertToken(Map<String, Object> param);
    /**
     * 主菜单
     */
    List<Map<String,Object>> MainMenu(Map<String, Object> param);
    /**
     * 下级菜单
     */
    List<Map<String,Object>> UnderMenu(Map<String, Object> param);
    List<Map<String,Object>> getUserInfoId(Map<String, Object> param);
    //更新最后登录时间
    void updateLastTime(Map<String, Object> param);
}
