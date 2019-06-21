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
import java.util.List;
import java.util.Map;

/**
 * 首页
 */
@Controller
//@CrossOrigin
public class HomeController {

    @Resource
    private HomeService homeService;


    /**
     * var dataMap = [{xm:xm,sfzh:sfzh},{ 1}]
     * 传值 data：JSON.stringify(dataMap)
     *
     * kx  选择科系   必选
     * zy  选择专业
     * xs 选择学生
     * bj  选择所在班级
     * xq  选择学期   必选
     * id   默认是0   这个分开传，不放到JSON串里   criterion字典ID
     */
    @RequestMapping("/home/makeTb")
    @ResponseBody
    public Map<String,Object> makeTb(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        String data = request.getParameter("data");
        String parent_id = request.getParameter("id");
        try{
            List<Map<String,Object>> list = homeService.makeTb(data,parent_id);
            result.put("data",list);
            result.put("message","图表查询成功");
            result.put("code","200");
        }catch (Exception e){
            result.put("data",null);
            result.put("message","图表查询失败");
            result.put("code","500");
        }
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
