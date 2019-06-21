package com.evaluate.controller;

import com.evaluate.service.DicService;
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
//@CrossOrigin
public class DicController {

    @Resource
    private DicService dicService;

    /**
     * 老师菜单
     */
    @ResponseBody
    @RequestMapping("/dic/usersList")
    public Map<String,Object> usersList(HttpServletRequest request){
            Map<String,Object> result = new HashMap<>();
            Map<String,Object> param = new HashMap<>();
            try{
                result.put("data",dicService.usersList(param));
                result.put("message","老师菜单查询成功");
                result.put("code","200");
            }catch (Exception e){
                result.put("message","师菜单查询失败");
                result.put("code","500");
                result.put("data",e.getMessage());
            }
            return result;

    }
    /**
     *选择学级
     */
    @ResponseBody
    @RequestMapping("/dic/dicGrade")
    public Map<String,Object> dicGrade(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            result.put("data",dicService.dicGrade(param));
            result.put("message","选择学级查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","选择学级查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     *选择科系
     */
    @ResponseBody
    @RequestMapping("/dic/dicDepartment")
    public Map<String,Object> dicDepartment(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            result.put("data",dicService.dicDepartment(param));
            result.put("message","选择科系查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","选择科系查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     *选择专业
     * id 科系ID
     */
    @ResponseBody
    @RequestMapping("/dic/dicSpecialty")
    public Map<String,Object> dicSpecialty(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("parent_id",request.getParameter("id"));
            result.put("data",dicService.dicSpecialty(param));
            result.put("message","选择专业查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","选择专业查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     *根据年级和专业 选择班级
     * grade_id     年级ID
     * specialty_id 专业ID
     */
    @ResponseBody
    @RequestMapping("/dic/dicTeam")
    public Map<String,Object> dicTeam(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("grade_id",request.getParameter("grade_id"));
            param.put("specialty_id",request.getParameter("specialty_id"));
            result.put("data",dicService.dicTeam(param));
            result.put("message","选择班级查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","选择班级查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     *选择角色
     */
    @ResponseBody
    @RequestMapping("/dic/dicRole")
    public Map<String,Object> dicRole(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            result.put("data",dicService.dicRole(param));
            result.put("message","选择角色查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","选择角色查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     *根据专业选择班级
     * specialty_id 专业ID
     */
    @ResponseBody
    @RequestMapping("/dic/dicTeamZy")
    public Map<String,Object> dicTeamZy(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("grade_id","");
            param.put("specialty_id",request.getParameter("specialty_id"));
            result.put("data",dicService.dicTeam(param));
            result.put("message","选择班级查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","选择班级查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     *根据班级选择学生
     * team_id 班级ID
     */
    @ResponseBody
    @RequestMapping("/dic/dicStu")
    public Map<String,Object> dicStu(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("team_id",request.getParameter("team_id"));
            result.put("data",dicService.dicStu(param));
            result.put("message","根据班级选择学生查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","根据班级选择学生查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
}
