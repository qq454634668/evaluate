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


}
