package com.evaluate.service.impl;



import com.evaluate.mapper.StudentMapper;
import com.evaluate.service.StudentService;
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
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;


    @Override
    public List stuList(Map<String, Object> param, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return studentMapper.stuList(param);
    }

    @Override
    public void addStu(Map<String, Object> param) {
        int flag = studentMapper.addStu(param);
        if(flag <= 0){
            throw new RuntimeException("添加失败");
        }
    }

    @Override
    public List stuOne(Map<String, Object> param) {
        return studentMapper.stuOne(param);
    }

    @Override
    public void editStu(Map<String, Object> param) {
        int flag = studentMapper.editStu(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public void delStu(Map<String, Object> param) {
        int flag = studentMapper.delStu(param);
        if(flag <= 0){
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    public void addScore(Map<String, Object> param) {
        List flag=studentMapper.existScore(param);
        if(flag.size()==0){
            //插入
            studentMapper.addScore(param);   //第一次插入直接把score当得分插入，更新的时候就是加减法了
            Object score_id = param.get("id");
            param.put("score_id",score_id);
        }else{
            //更新操作
            Map map = (Map) flag.get(0);
            Object score_id = map.get("id");
            param.put("score_id",score_id);
            studentMapper.editScore(param);
        }
        studentMapper.addScoreSingle(param);  //统一记录单一数据
    }


    @Override
    public List quotaList(Map<String, Object> param) {
        //parent_id为0,根菜单
        param.put("parent_id","0");
        List<Map<String,Object>> list1 = studentMapper.quotaList(param);
        List oneMenu = new ArrayList<>();
        double oneSorce = 0;
        double twoSorce = 0;
        double threeSorce = 0;
        for(int a=0;a<list1.size();a++){
            Map<String,Object> mapR1 = new HashMap<>();
            Map<String,Object> map1 = list1.get(a);
            param.put("parent_id",map1.get("id"));
            List<Map<String,Object>> list2 = studentMapper.quotaList(param);
            List twoMenu = new ArrayList<>();
            for(int b=0;b<list2.size();b++){
                Map<String,Object> mapR2 = new HashMap<>();
                Map<String,Object> map2 = list2.get(b);
                param.put("parent_id",map2.get("id"));
                List<Map<String,Object>> list3 = studentMapper.quotaList(param);
                List threeMenu = new ArrayList<>();
                for(int c=0;c<list3.size();c++){
//                    System.out.println("a=="+a+",b==="+b+",c==="+c);
                    Map<String,Object> mapR3 = new HashMap<>();
                    Map<String,Object> map3 = list3.get(c);
                    param.put("parent_id",map3.get("id"));
                    List<Map<String,Object>> list4 = studentMapper.quotaList2(param);
                    threeSorce = getSorce(list4);
                    mapR3.put("fjMenu",map3);
                    mapR3.put("zjMenu",list4);
                    mapR3.put("scrce",threeSorce);
                    threeMenu.add(c,mapR3);
                    twoSorce += threeSorce;
                    threeSorce = 0;
                }
                String weightString = map2.get("weight").toString();
                double weight = Double.parseDouble(weightString);
                double finalScore = twoSorce*weight/100;
                oneSorce += finalScore;
                mapR2.put("fjMenu",map2);
                mapR2.put("zjMenu",threeMenu);
                mapR2.put("scrce",twoSorce);
                twoMenu.add(b,mapR2);
                twoSorce = 0;
            }
            String weightString = map1.get("weight").toString();
            double weight = Double.parseDouble(weightString);
            double finalScore = oneSorce*weight/100;
//            oneSorce += finalScore;
            mapR1.put("fjMenu",map1);
            mapR1.put("zjMenu",twoMenu);
            mapR1.put("scrce",finalScore);
            oneMenu.add(a,mapR1);
            oneSorce = 0;
        }

        return oneMenu;
    }
    private double getSorce(List<Map<String,Object>> list){
        double sum =0;
        for(int i=0;i<list.size();i++){
            //取每一个map的得分，有就是有没有就是0，之后加起来作为上一级的得分
            Map<String,Object> map = list.get(i);
            String scoreString = map.get("score").toString();
            double score = Double.parseDouble(scoreString);
            String weightString = map.get("weight").toString();
            double weight = Double.parseDouble(weightString);
            double finalScore = score*weight/100;
            sum += finalScore;
        }
        return sum;
    }
}
