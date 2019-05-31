package com.evaluate.controller;

import com.evaluate.service.CollegeService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学院管理
 */
@Controller
@CrossOrigin
public class CollegeController {
    /*------------------------------学级管理 start--------------------------------*/

    @Resource
    private CollegeService collegeService;
    /**
     * 学校列表
      */
    public Map<String,Object> collegeList(HttpServletRequest request,int pageNum,int pageSize){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        try{
            list = collegeService.collegeList(param,pageNum,pageSize);
            PageInfo<Map<String,Object>> pageList = new PageInfo<>(list);
            result.put("data",pageList);
            result.put("message","学校列表查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","学校列表查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 添加学级
     * grade  学级
     */
    public Map<String,Object> addGrades(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String grade = request.getParameter("grade");
            param.put("grade",grade);
            collegeService.addCollege(param);
            result.put("data",null);
            result.put("message","添加学级查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","添加学级查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 修改学级
     * grade 年级
     * id
     */
    public Map<String,Object> editCollege(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String grade = request.getParameter("grade");
            String id = request.getParameter("id");
            param.put("grade",grade);
            param.put("id",id);
            collegeService.editCollege(param);
            result.put("data",null);
            result.put("message","修改学级查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","修改学级查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 删除学级
     * id
     */
    public Map<String,Object> delCollege(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String id = request.getParameter("id");
            param.put("id",id);
            collegeService.delCollege(param);
            result.put("data",null);
            result.put("message","删除学级查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","删除学级查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /*------------------------------学级管理  end--------------------------------*/


    /*------------------------------科系与专业管理  start--------------------------------*/

    /*------------------------------科系与专业管理  end--------------------------------*/
}
