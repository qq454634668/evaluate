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
     */
    public Map<String,Object> makeTb(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        String data = request.getParameter("data");
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
