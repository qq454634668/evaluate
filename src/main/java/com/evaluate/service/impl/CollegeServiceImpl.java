package com.evaluate.service.impl;


import com.evaluate.mapper.CollegeMapper;
import com.evaluate.service.CollegeService;
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
public class CollegeServiceImpl implements CollegeService {

    @Resource
    private CollegeMapper collegeMapper;


    @Override
    public List gradeList(Map<String, Object> param) {
//        PageHelper.startPage(pageNum,pageSize);
        return collegeMapper.gradeList(param);
    }

    @Override
    public void addGrade(Map<String, Object> param) {
        int flag = collegeMapper.addGrade(param);
        if(flag <= 0){
            throw new RuntimeException("添加失败");
        }
    }

    @Override
    public void editGrade(Map<String, Object> param) {
        int flag = collegeMapper.editGrade(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public void delGrade(Map<String, Object> param) {
        int flag = collegeMapper.delGrade(param);
        if(flag <= 0){
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    public List specialtyList(Map<String, Object> param) {
        List list = collegeMapper.departmentList(param);
        List resultList = new ArrayList();
        for(int i=0;i<list.size();i++){
            Map map = (Map) list.get(i);
            Map resultMap = new HashMap();
            resultMap.put("mainMenu",map);
            param.put("id",map.get("id"));
            List specialtyList = collegeMapper.specialtyList(param);
            resultMap.put("sonMenu",specialtyList);
            resultList.add(i,resultMap);
        }
        return resultList;
    }

    @Override
    public void addSpecialty(Map<String, Object> param) {
        int flag = collegeMapper.addSpecialty(param);
        if(flag <= 0){
            throw new RuntimeException("添加失败");
        }
    }

    @Override
    public void editSpecialty(Map<String, Object> param) {
        int flag = collegeMapper.editSpecialty(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public void delSpecialty(Map<String, Object> param) {
        int flag = collegeMapper.delSpecialty(param);
        if(flag <= 0){
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    public List departmentList(Map<String, Object> param) {
        return collegeMapper.departmentList(param);
    }

    @Override
    public List teamList(Map<String, Object> param) {
        Object parent_id_init = param.get("grade_id");
        Object specialty_parent_id =  param.get("specialty_parent_id");
        Object department =  param.get("department");
        List list1 = new ArrayList();
        if(!specialty_parent_id.equals("")&&!specialty_parent_id.equals(null)){
            Map lsMap = new HashMap();
            lsMap.put("id",specialty_parent_id);
            lsMap.put("department",department);
            list1.add(0,lsMap);
        }else{
            list1 =collegeMapper.departmentList(param);
        }
        List oneMenu = new ArrayList<>();
        for(int i=0;i<list1.size();i++){
            Map map1= (Map) list1.get(i);
            Map resultMap1 = new HashMap();
            param.put("id",map1.get("id").toString());
            List list2 = new ArrayList();
            list2 = collegeMapper.specialtyList(param);
            List twoMenu = new ArrayList<>();
            for(int a=0;a<list2.size();a++){
                Map map2= (Map) list2.get(a);
                Map resultMap2 = new HashMap();
                param.put("specialty_id",map2.get("id"));
                Object grade_id =  param.get("grade_id");
                Object grade_name =  param.get("grade_name");
                List list3 = new ArrayList();
                if(!grade_id.equals(null)&&!grade_id.equals("")){
                    Map lsMap2 = new HashMap();
                    lsMap2.put("grade_id",grade_id);
                    lsMap2.put("grade_name",grade_name);
                    list3.add(0,lsMap2);
                }else{
//                    list3 = collegeMapper.gradeList2(param);
                    list3 = collegeMapper.gradeList(param);
                }
                List threeMenu = new ArrayList<>();
                for(int b=0;b<list3.size();b++){
                    Map map3 = (Map) list3.get(b);
                    Map resultMap3 = new HashMap();
                    param.put("grade_id",map3.get("id"));
                    List list4 = collegeMapper.teamList(param);
                    param.put("grade_id",parent_id_init);  //每次查询完  恢复成查询条件
                    resultMap3.put("mainMenu",map3);
                    resultMap3.put("sonMenu",list4);
                    threeMenu.add(b,resultMap3);
                }
                resultMap2.put("mainMenu",map2);
                resultMap2.put("sonMenu",threeMenu);
                twoMenu.add(a,resultMap2);
            }
            resultMap1.put("mainMenu",map1);
            resultMap1.put("sonMenu",twoMenu);
            oneMenu.add(i,resultMap1);
        }
        return oneMenu;
    }

    @Override
    public void addTeam(Map<String, Object> param) {
        int flag = collegeMapper.addTeam(param);
        if(flag <= 0){
            throw new RuntimeException("添加失败");
        }
    }

    @Override
    public void editTeam(Map<String, Object> param) {
        int flag = collegeMapper.editTeam(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public void delTeam(Map<String, Object> param) {
        int flag = collegeMapper.delTeam(param);
        if(flag <= 0){
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    public List termList(Map<String, Object> param) {
        return collegeMapper.termList(param);
    }

    @Override
    public void addTerm(Map<String, Object> param) {
        int flag = collegeMapper.addTerm(param);
        if(flag <= 0){
            throw new RuntimeException("增加失败");
        }
    }

    @Override
    public void editTerm(Map<String, Object> param) {
        int flag = collegeMapper.editTerm(param);
        if(flag <= 0){
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public void delTerm(Map<String, Object> param) {
        int flag = collegeMapper.delTerm(param);
        if(flag <= 0){
            throw new RuntimeException("删除失败");
        }
    }
}
