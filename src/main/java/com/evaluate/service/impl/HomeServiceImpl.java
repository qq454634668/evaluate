package com.evaluate.service.impl;


import com.alibaba.fastjson.JSON;
import com.evaluate.mapper.HomeMapper;
import com.evaluate.pojo.Demo;
import com.evaluate.service.HomeService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {

    @Resource
    private HomeMapper homeMapper;

    @Override
    public List<Map<String, Object>> makeTb(String data, String parent_id) {
        Map<String,Object> param = new HashMap<>();
        param.put("parent_id",parent_id);
        List resultList = new ArrayList();
        List<Demo> demoList = JSON.parseArray(data,Demo.class);
        for(int i=0;i<demoList.size();i++){
//            JSONObject obj = JSONObject.fromObject(data);
            Demo obj = demoList.get(i);
            param.put("kx",obj.getKx());
            param.put("xq",obj.getXq());
            String zy = obj.getZy();
            if(zy.equals(null) || zy.equals("")){
                //进行科系比较
                param.put("zy","");
            }else{
                param.put("zy",zy);
            }
            String bj = obj.getBj();
            if(bj.equals(null) || bj.equals("")){
                //进行专业比较
                param.put("bj","");
            }else{
                param.put("bj",bj);
            }
            String stu = obj.getStu();
            if(stu.equals(null) || stu.equals("")){
                //进行班级比较
                param.put("stu","");
            }else{
                param.put("stu",stu);
            }
            List<Map<String,Object>> list = homeMapper.sorceList(param);
            resultList.add(list);
        }

        return resultList;
    }

}
