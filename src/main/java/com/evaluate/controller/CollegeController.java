package com.evaluate.controller;

import com.evaluate.service.CollegeService;
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
 * 学院管理
 */
@Controller
@CrossOrigin
public class CollegeController {
    /*------------------------------学级管理 start--------------------------------*/

    @Resource
    private CollegeService collegeService;
    /**
     * 学级列表
      */
    @ResponseBody
    @RequestMapping("/college/gradeList")
    public Map<String,Object> gradeList(HttpServletRequest request,int pageNum,int pageSize){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        List<Map<String,Object>> list=new ArrayList<>();
        try{
            list = collegeService.gradeList(param,pageNum,pageSize);
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
    @ResponseBody
    @RequestMapping("/college/addGrade")
    public Map<String,Object> addGrade(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String grade = request.getParameter("grade");
            param.put("grade",grade);
            collegeService.addGrade(param);
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
    @ResponseBody
    @RequestMapping("/college/editGrade")
    public Map<String,Object> editGrade(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String grade = request.getParameter("grade");
            String id = request.getParameter("id");
            param.put("grade",grade);
            param.put("id",id);
            collegeService.editGrade(param);
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
    @ResponseBody
    @RequestMapping("/college/delGrade")
    public Map<String,Object> delGrade(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String id = request.getParameter("id");
            param.put("id",id);
            collegeService.delGrade(param);
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
    /**
     * 专业列表
     */
    @ResponseBody
    @RequestMapping("/college/specialtyList")
    public Map<String,Object> specialtyList(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            result.put("data",collegeService.specialtyList(param));
            result.put("message","专业列表查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","专业列表查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }

    /**
     * 增加专业
     * specialty  专业名
     * parent_id  父级ID
     */
    @ResponseBody
    @RequestMapping("/college/addSpecialty")
    public Map<String,Object> addSpecialty(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            String specialty = request.getParameter("specialty");
            param.put("specialty",specialty);
            String parent_id = request.getParameter("parent_id");
            param.put("parent_id",parent_id);
            collegeService.addSpecialty(param);
            result.put("data",null);
            result.put("message","添加专业成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","添加专业失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 修改专业
     * specialty  专业名
     * id          ID
     */
    @ResponseBody
    @RequestMapping("/college/editSpecialty")
    public Map<String,Object> editSpecialty(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("specialty",request.getParameter("specialty"));
            param.put("id",request.getParameter("id"));
            collegeService.editSpecialty(param);
            result.put("data",null);
            result.put("message","修改专业成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","修改专业失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 删除专业
     * id
     */
    @ResponseBody
    @RequestMapping("/college/delSpecialty")
    public Map<String,Object> delSpecialty(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("id",request.getParameter("id"));
            collegeService.delSpecialty(param);
            result.put("data",null);
            result.put("message","删除专业成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","删除专业失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 科系列表
     */
    @ResponseBody
    @RequestMapping("/college/departmentList")
    public Map<String,Object> departmentList(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            result.put("data",collegeService.departmentList(param));
            result.put("message","科系列表查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","科系列表查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /*------------------------------科系与专业管理  end--------------------------------*/

    /*------------------------------    班级管理  start--------------------------------*/
    /**
     * 班级列表
     * specialty_parent_id  科目ID yuyi_evaluate_department表ID
     * grade_id 年级ID
     * http://localhost:8080/college/teamList?specialty_parent_id=20&grade_id=5
     */
    @ResponseBody
    @RequestMapping("/college/teamList")
    public Map<String,Object> teamList(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("specialty_parent_id",request.getParameter("specialty_parent_id"));
            param.put("grade_id",request.getParameter("grade_id"));
            result.put("data",collegeService.teamList(param));
            result.put("message","班级列表查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","班级列表查询失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /**
     * 添加班级
     * department_id 专业类别ID
     * specialty_id  专业ID
     * grade_id      年级ID
     * name           班级名
     * teacher_id    班主任ID
     */
    @ResponseBody
    @RequestMapping("/college/addTeam")
    public Map<String,Object> addTeam(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("department_id",request.getParameter("department_id"));
            param.put("specialty_id",request.getParameter("specialty_id"));
            param.put("grade_id",request.getParameter("grade_id"));
            param.put("name",request.getParameter("name"));
            param.put("teacher_id",request.getParameter("teacher_id"));
            collegeService.addTeam(param);
            result.put("data",null);
            result.put("message","添加班级成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("message","添加班级失败");
            result.put("code","500");
            result.put("data",e.getMessage());
        }
        return result;
    }
    /*------------------------------    班级管理  end--------------------------------*/

}
