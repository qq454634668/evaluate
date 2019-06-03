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
@CrossOrigin
public class DicController {
    @Resource
    private DicService dicService;

    /**
     * 老师菜单
     */
    @ResponseBody
    @RequestMapping("/college/delTeam")
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

}
