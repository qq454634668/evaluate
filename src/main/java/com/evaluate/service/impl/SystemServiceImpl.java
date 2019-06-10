package com.evaluate.service.impl;


import com.evaluate.mapper.DicMapper;
import com.evaluate.mapper.SystemMapper;
import com.evaluate.service.DicService;
import com.evaluate.service.SystemService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SystemServiceImpl implements SystemService {

    @Resource
    private SystemMapper systemMapper;

    @Override
    public List usersList(Map<String, Object> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return systemMapper.usersList(param);
    }

    @Override
    public void addUsers(Map<String, Object> param) {
        int flag = systemMapper.addUsers(param);
        if(flag <= 0){
            throw new RuntimeException("添加失败");
        }
    }

    @Override
    public int existUser(Map<String, Object> param) {
        return systemMapper.existUser(param);
    }

    @Override
    public void editUsersPas(Map<String, Object> param) {
        int flag = systemMapper.editUsersPas(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public void editUsersRole(Map<String, Object> param) {
        int flag = systemMapper.editUsersRole(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public void delUsers(Map<String, Object> param) {
        int flag = systemMapper.delUsers(param);
        if(flag <= 0){
            throw new RuntimeException("删除失败");
        }
    }
}
