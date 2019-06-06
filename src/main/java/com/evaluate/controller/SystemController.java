package com.evaluate.controller;

import com.evaluate.service.SystemService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典
 */
@Controller
@CrossOrigin
public class SystemController {

    @Resource
    private SystemService systemService;

    /**
     * 用户管理列表
     * role_id  角色
     * kssj    开始时间  20190605141725
     * jssj    结束时间  20190605155625
     *
     */
    @ResponseBody
    @RequestMapping("/system/usersList")
    public Map<String,Object> usersList(HttpServletRequest request, int pageNum, int pageSize){
            Map<String,Object> result = new HashMap<>();
            Map<String,Object> param = new HashMap<>();
            List<Map<String,Object>> list=new ArrayList<>();
            try{
                list = systemService.usersList(param,pageNum,pageSize);
                PageInfo<Map<String,Object>> pageList = new PageInfo<>(list);
                result.put("data",pageList);
                result.put("message","用户管理查询成功");
                result.put("code","200");
            }catch (Exception e){
                result.put("message","用户管理查询失败");
                result.put("code","500");
                result.put("data",e.getMessage());
            }
            return result;
    }
    /**
     * 新增用户
     * first_name 姓名
     * login      用户名
     * password   密码
     * role_id    权限ID
     */
    public Map<String,Object> addUsers(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            systemService.addUsers(param);
            result.put("data",null);
            result.put("message","用户管理查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","用户管理查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 修改用户密码
     */
    public Map<String,Object> editUsersPas(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        return result;
    }
    /**
     * 修改用户角色
     */
    public Map<String,Object> editUsersRole(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        return result;
    }
    /**
     * 删除用户
     */
    public Map<String,Object> delUsers(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        return result;
    }
}
