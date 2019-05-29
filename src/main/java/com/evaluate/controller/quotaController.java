package com.evaluate.controller;


import com.evaluate.service.QuotaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 指标管理
 */
@Controller
@CrossOrigin
public class QuotaController {

    @Resource
    QuotaService quotaService;
    /**
     * 增加指标
     * parent_id  一级指标 0    二三级指标为上级ID
     * standard  参考分值
     * name      指标（内容）
     * initial   初始值
     * type      评分方式 默认 0,1是加分
     */

    @RequestMapping("/quota/addQuota")
    @ResponseBody
    public Map<String,Object> addQuota(String parent_id,String standard,
                                       String name,String initial,String type){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("parent_id",parent_id);
            param.put("standard",standard);
            param.put("name",name);
            param.put("initial",initial);
            param.put("type",type);
            quotaService.addQuota(param);
            result.put("data",null);
            result.put("message","插入成功");
            result.put("code",200);

        }catch (Exception e){
            result.put("data",e.getMessage());
            result.put("message","插入失败");
            result.put("code",500);
        }
        return result;
    }
    /**
     * 修改指标
     * standard  参考分值
     * name 指标（内容）
     * id
     * initial   初始值
     * type      评分方式 默认 0,1是加分
      */
    @RequestMapping("/quota/editQuota")
    @ResponseBody
    public Map<String,Object> editQuota(String id,String standard,String name){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("id",id);
            param.put("standard",standard);
            param.put("name",name);
            quotaService.editQuota(param);
            result.put("data",null);
            result.put("message","更新成功");
            result.put("code",200);

        }catch (Exception e){
            result.put("data",e.getMessage());
            result.put("message","更新失败");
            result.put("code",500);
        }
        return result;
    }
    /**
     * 删除指标
     * id
     */
    @RequestMapping("/quota/delQuota")
    @ResponseBody
    public Map<String,Object> delQuota(String id){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        try{
            param.put("id",id);
            quotaService.delQuota(param);
            result.put("data",null);
            result.put("message","删除成功");
            result.put("code",200);

        }catch (Exception e){
            result.put("data",e.getMessage());
            result.put("message","删除失败");
            result.put("code",500);
        }
        return result;
    }

    /**
     * 指标列表
     */
    /**
     * 修改权重
     */
}
