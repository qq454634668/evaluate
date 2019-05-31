package com.evaluate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 学院管理
 */
@Controller
@CrossOrigin
public class CollegeController {
    /*------------------------------学级管理 --------------------------------*/
    /**
     * 添加学级
     */
    public Map<String,Object> addGrades(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();

        return result;
    }
}
