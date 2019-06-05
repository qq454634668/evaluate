package com.evaluate.service.impl;


import com.evaluate.mapper.UserMapper;
import com.evaluate.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int existUser(Map<String, Object> param) {
        return userMapper.existUser(param);
    }

    @Override
    public List<Map<String, Object>> user(Map<String, Object> param) {
        return userMapper.user(param);
    }


    @Override
    public List<Map<String, Object>> menuInfo(Map<String, Object> param) {
        List<Map<String, Object>> mainMenu = userMapper.MainMenu(param);
        List<Map<String,Object>> result = new ArrayList<>();
        mainMenu.forEach(mainMenuMap->{
            Map<String,Object> map = new HashMap<>();
            Object id = mainMenuMap.get("id");
            map.put("id",id);
            param.put("id",id);
            map.put("mainMenu",mainMenuMap);
            map.put("UnderMenu",userMapper.UnderMenu(param));
            result.add(map);
        });
        return result;
    }

    @Override
    public List<Map<String, Object>> userInfoId(Map<String, Object> param) {
        return userMapper.UserInfoId(param);
    }

    @Override
    public List<Map<String, Object>> getUserInfoId(Map<String, Object> param) {
        return userMapper.getUserInfoId(param);
    }

    @Override
    public void insertToken(Map<String, Object> param) {
         userMapper.insertToken(param);
    }

    @Override
    public void updateLastTime(Map<String, Object> param) {
        userMapper.updateLastTime(param);
    }


}
