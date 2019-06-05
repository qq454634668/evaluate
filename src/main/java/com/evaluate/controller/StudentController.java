package com.evaluate.controller;

import com.evaluate.service.StudentService;
import com.github.pagehelper.PageHelper;
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
 * 学生管理
 */
@Controller
@CrossOrigin
public class StudentController {

    @Resource
    private StudentService studentService;


    /**
     * 学生列表
     * grade_id        年级ID
     * department_id   科系ID
     * specialty_id    专业ID
     * team_id         班级ID
     * key             搜索条件
     */
    @ResponseBody
    @RequestMapping("/stu/stuList")
    public Map<String,Object> stuList(HttpServletRequest request,int pageNum,int pageSize){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        param.put("grade_id",request.getParameter("grade_id"));
        param.put("department_id",request.getParameter("department_id"));
        param.put("specialty_id",request.getParameter("specialty_id"));
        param.put("team_id",request.getParameter("team_id"));
        String key = request.getParameter("key");
        if(key!=null && key !=""){
            key = "%"+key+"%";
        }
        param.put("key",key);
        try{
//            PageInfo<Map<String,Object>> pageList = new PageInfo<>(list);
            List list = studentService.stuList(param,pageNum,pageSize);
            PageInfo pageInfo = new PageInfo(list);
            result.put("data", pageInfo);
            result.put("message","学生列表查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("data", null);
            result.put("message","学生列表查询失败");
            result.put("code","500");
        }
        return result;
    }
    /**
     * 添加学生
     * identity 学号   name  姓名  sex 性别（字典）  birthday 生日  nation 民族（字典）
     *card 身份证号  origin 籍贯  mobile 电话  grade_id 年级ID department_id 科系ID
     * specialty_id 专业ID  team_id 班级ID parent 家长姓名   parentmobile 家长电话
     * address 地址  password 密码
     */
    @ResponseBody
    @RequestMapping("/stu/addStu")
    public Map<String,Object> addStu(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("identity",request.getParameter("identity"));
            param.put("name",request.getParameter("name"));
            param.put("sex",request.getParameter("sex"));
            param.put("birthday",request.getParameter("birthday"));
            param.put("nation",request.getParameter("nation"));
            param.put("card",request.getParameter("card"));
            param.put("origin",request.getParameter("origin"));
            param.put("mobile",request.getParameter("mobile"));
            param.put("grade_id",request.getParameter("grade_id"));
            param.put("department_id",request.getParameter("department_id"));
            param.put("specialty_id",request.getParameter("specialty_id"));
            param.put("team_id",request.getParameter("team_id"));
            param.put("parent",request.getParameter("parent"));
            param.put("parentmobile",request.getParameter("parentmobile"));
            param.put("address",request.getParameter("address"));
            param.put("password",request.getParameter("password"));
            studentService.addStu(param);
            result.put("data", null);
            result.put("message","添加学生成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("data", null);
            result.put("message","添加学生失败");
            result.put("code","500");
        }
        return result;
    }

    /**
     * 学生个人基本信息
     * id
     */
    @ResponseBody
    @RequestMapping("/stu/stuOne")
    public Map<String,Object> stuOne(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("id",request.getParameter("id"));
            result.put("data",studentService.stuOne(param).get(0));
            result.put("message","学生个人基本信息查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("data", null);
            result.put("message","学生个人基本信息查询失败");
            result.put("code","500");
        }
        return result;
    }
    /**
     * 修改学生
     * id
     * identity 学号   name  姓名  sex 性别（字典）  birthday 生日  nation 民族（字典）
     *card 身份证号  origin 籍贯  mobile 电话  grade_id 年级ID department_id 科系ID
     * specialty_id 专业ID  team_id 班级ID parent 家长姓名   parentmobile 家长电话
     * address 地址  password 密码
     */
    @ResponseBody
    @RequestMapping("/stu/editStu")
    public Map<String,Object> editStu(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("id",request.getParameter("id"));
            param.put("identity",request.getParameter("identity"));
            param.put("name",request.getParameter("name"));
            param.put("sex",request.getParameter("sex"));
            param.put("birthday",request.getParameter("birthday"));
            param.put("nation",request.getParameter("nation"));
            param.put("card",request.getParameter("card"));
            param.put("origin",request.getParameter("origin"));
            param.put("mobile",request.getParameter("mobile"));
            param.put("grade_id",request.getParameter("grade_id"));
            param.put("department_id",request.getParameter("department_id"));
            param.put("specialty_id",request.getParameter("specialty_id"));
            param.put("team_id",request.getParameter("team_id"));
            param.put("parent",request.getParameter("parent"));
            param.put("parentmobile",request.getParameter("parentmobile"));
            param.put("address",request.getParameter("address"));
            param.put("password",request.getParameter("password"));
            studentService.editStu(param);
            result.put("data", null);
            result.put("message","修改学生成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("data", null);
            result.put("message","修改学生失败");
            result.put("code","500");
        }
        return result;
    }

}
