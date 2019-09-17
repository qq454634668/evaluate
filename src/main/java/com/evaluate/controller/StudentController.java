package com.evaluate.controller;

import com.evaluate.service.StudentService;
import com.evaluate.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.krb5.internal.PAData;

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
    @Resource
    private UserService userService;


    /**
     * 和评分学生是一个列表，不显示原图的数据项
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
        try{
            Map<String,Object> param = new HashMap<>();
            param.put("identity",request.getParameter("identity"));
            param.put("id",request.getParameter("id"));
            param.put("name",request.getParameter("name"));
            param.put("sex",request.getParameter("sex"));
            param.put("birthday",request.getParameter("birthday"));
            param.put("nation",request.getParameter("nation"));
            param.put("card",request.getParameter("card"));
            param.put("origin",request.getParameter("origin"));
            param.put("mobile",request.getParameter("mobile"));
            param.put("department_id",request.getParameter("department_id"));
            param.put("specialty_id",request.getParameter("specialty_id"));
            param.put("grade_id",request.getParameter("grade_id"));
            param.put("team_id",request.getParameter("team_id"));
            param.put("parent",request.getParameter("parent"));
            param.put("parentmobile",request.getParameter("parentmobile"));
            param.put("address",request.getParameter("address"));
            param.put("password",request.getParameter("password"));
            System.out.println();
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


    /**
     * 删除学生
     * id
     */
    @ResponseBody
    @RequestMapping("/stu/delStu")
    public Map<String,Object> delStu(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("id",request.getParameter("id"));
            studentService.delStu(param);
            result.put("data",null);
            result.put("message","删除学生成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("data", null);
            result.put("message","删除学生失败");
            result.put("code","500");
        }
        return result;
    }

    /**
     * 添加评分
     * student_id   学生ID
     * term_id      季度
     *criterion_id  评分项ID
     * score        分数
     * type         评分类型（0是加分  1是减分）
     * bz           备注
     */
    @ResponseBody
    @RequestMapping("/stu/addScore")
    public Map<String,Object> addScore(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String token = request.getHeader("token");
            param.put("token",request.getParameter("token"));
            param.put("student_id",request.getParameter("student_id"));
            param.put("term_id",request.getParameter("term_id"));
            param.put("criterion_id",request.getParameter("criterion_id"));
            param.put("score",request.getParameter("score"));
            param.put("type",request.getParameter("type"));
            Object bz = request.getParameter("bz");
            if(bz==null){
                param.put("bz","");
            }else{
                param.put("bz",bz);
            }
            List<Map<String,Object>> userList= userService.getUserInfoId(param);
            if(userList.size()!=0){
                Map<String,Object> lsMap = userList.get(0);
                String role_id = (String) lsMap.get("role_id");
                if(role_id.equals("6")){
                    //role_id权限等于6是班主任
                    List stuList= studentService.pdStuTer(param);
                    if(stuList.size()>0){
                        //是该学生班主任可以评分
                        studentService.addScore(param);
                        result.put("data",null);
                        result.put("message","评分成功");
                        result.put("code","200");
                    }else{
                        //不是该学生班主任可以评分
                        result.put("data",null);
                        result.put("message","不是该学生班主任,不可以进行评分");
                        result.put("code","202");
                    }
                }else{
                    //不是班主任，暂时默认就是管理员什么操作也不用做，直接加分
                    studentService.addScore(param);
                    result.put("data",null);
                    result.put("message","评分成功");
                    result.put("code","200");
                }
            }else{
                result.put("data",null);
                result.put("message","用户登录信息不存在,请重新登录");
                result.put("code","201");
            }

        }catch (Exception e){
            result.put("data", e.getMessage());
            result.put("message","评分失败");
            result.put("code","500");
        }
        return result;
    }

    /**
     * 评分结果列表
     * student_id  学生ID
     * term_id     学期ID
     */
    @ResponseBody
    @RequestMapping("/stu/scoreList")
    public Map<String,Object> scoreList(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("student_id",request.getParameter("student_id"));
            param.put("term_id",request.getParameter("term_id"));
            List list = studentService.quotaList2(param);
            result.put("data",list);
            result.put("message","评分结果成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("data", null);
            result.put("message","评分结果失败");
            result.put("code","500");
        }
        return result;
    }
    /**
     * 评分详情列表（最后一级别评分项，点击列出所有投票详情）
     * id  评分项ID
     */
    @ResponseBody
    @RequestMapping("/stu/scoreXqList")
    public Map<String,Object> scoreXqList(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("id",request.getParameter("id"));
            List list = studentService.scoreXqList(param);
            result.put("data",list);
            result.put("message","评分详情列表成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("data", null);
            result.put("message","评分详情列表失败");
            result.put("code","500");
        }
        return result;
    }
}
