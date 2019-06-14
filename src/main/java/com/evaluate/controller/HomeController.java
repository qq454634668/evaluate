package com.evaluate.controller;


import com.evaluate.service.HomeService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 首页
 */
@Controller
@CrossOrigin
public class HomeController {

    @Resource
    private HomeService homeService;


    /**
     * var dataMap = [{xm:xm,sfzh:sfzh},{ 1}]
     * 传值 data：JSON.stringify(dataMap)
     *
     * kx  选择科系   必选
     * zy  选择专业
     * bj  选择所在班级
     * stu 选择学生
     * xq  选择学期   必选
     * parent_id   默认是0
     */
    @RequestMapping("/home/makeTb")
    @ResponseBody
    public Map<String,Object> makeTb(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        String data = request.getParameter("data");
        String parent_id = request.getParameter("parent_id");
        result = homeService.makeTb(data,parent_id);
        return result;
    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping("/test")
    @ResponseBody
    public Map<String,Object> test(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        String data = request.getParameter("data");
        JSONObject obj = JSONObject.fromObject(data);
        System.out.println("sss");
        return result;
    }
}
