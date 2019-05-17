package com.evaluate.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 指标管理
 */
@Controller
public class quotaController {
    /**
     * 增加指标
     * parent_id  一级指标 0    二三级指标为上级ID
     * standard  参考分值
     * name 指标（内容）
     * insert into yuyi_evaluate_criterion (parent_id,name,standard) VALUES (#{parent_id},#{name}，#{standard})
     */

    @RequestMapping("/daily/addQuota")
    public Map<String,Object> addQuota(){
        Map<String,Object> result = new HashMap<>();
        return result;
    }
}
