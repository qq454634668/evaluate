package com.evaluate.service.impl;


import com.evaluate.mapper.QuotaMapper;
import com.evaluate.service.QuotaService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QuotaServiceImpl implements QuotaService {

    @Resource
    private QuotaMapper quotaMapper;



    @Override
    public void addQuota(Map<String, Object> param) {
        int flag = quotaMapper.addQuota(param);
        if(flag <= 0){
            throw new RuntimeException("添加失败");
        }
    }

    @Override
    public void editQuota(Map<String, Object> param) {
        int flag = quotaMapper.editQuota(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public void delQuota(Map<String, Object> param) {
        int flag = quotaMapper.delQuota(param);
        if(flag <= 0){
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    public List quotaList(Map<String, Object> param) {
//        List result = new ArrayList<>();
        //parent_id为0,根菜单
        param.put("parent_id","0");
        List<Map<String,Object>> list1 = quotaMapper.quotaList(param);
        List oneMenu = new ArrayList<>();
        for(int a=0;a<list1.size();a++){
            Map<String,Object> mapR1 = new HashMap<>();
            Map<String,Object> map1 = list1.get(a);
            param.put("parent_id",map1.get("id"));
            List<Map<String,Object>> list2 = quotaMapper.quotaList(param);
            List twoMenu = new ArrayList<>();
            for(int b=0;b<list2.size();b++){
                Map<String,Object> mapR2 = new HashMap<>();
                Map<String,Object> map2 = list2.get(b);
                param.put("parent_id",map2.get("id"));
                List<Map<String,Object>> list3 = quotaMapper.quotaList(param);
                List threeMenu = new ArrayList<>();
                for(int c=0;c<list3.size();c++){
//                    System.out.println("a=="+a+",b==="+b+",c==="+c);
                    Map<String,Object> mapR3 = new HashMap<>();
                    Map<String,Object> map3 = list3.get(c);
                    param.put("parent_id",map3.get("id"));
                    List<Map<String,Object>> list4 = quotaMapper.quotaList(param);
                    mapR3.put("fjMenu",map3);
                    mapR3.put("zjMenu",list4);
                    threeMenu.add(c,mapR3);
                }
                mapR2.put("fjMenu",map2);
                mapR2.put("zjMenu",threeMenu);
                twoMenu.add(b,mapR2);
            }
            mapR1.put("fjMenu",map1);
            mapR1.put("zjMenu",twoMenu);
            oneMenu.add(a,mapR1);
        }

        return oneMenu;
    }


//    @Override
//    public List quotaList(Map<String, Object> param) {
//        List<Map<String,Object>> list = quotaMapper.quotaList(param);
//        return list;
//    }

    @Override
    public void editWeight(String id, String weight) {
        String[] idList = id.split(",");
        String[] weightList = weight.split(",");
        int length = idList.length;
        for(int i=0;i<length;i++){
            Map<String,Object> param = new HashMap<>();
            param.put("weight",weightList[i]);
            param.put("id",idList[i]);
            quotaMapper.editWeight(param);
        }
    }


}
