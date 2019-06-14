package com.evaluate.service.impl;


import com.evaluate.mapper.HomeMapper;
import com.evaluate.service.HomeService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {

    @Resource
    private HomeMapper homeMapper;

    @Override
    public Map<String, Object> makeTb(String data, String parent_id) {
        Map<String,Object> param = new HashMap<>();
        JSONObject obj = JSONObject.fromObject(data);
        param.put("kx",obj.get("kx"));
        String xq = obj.getString("xq");
        param.put("xq",obj.get("xq"));
        String zy = obj.getString("zy");
        if(zy==null || zy ==""){
            //进行科系比较

        }else{
            param.put("zy",zy);
        }
        String bj = obj.getString("bj");
        if(bj==null || bj ==""){
            //进行专业比较
        }else{
            param.put("bj",bj);
        }
        String stu = obj.getString("stu");
        if(stu==null || stu ==""){
            //进行班级比较
        }else{
            param.put("stu",stu);
        }
        return null;
    }

}
