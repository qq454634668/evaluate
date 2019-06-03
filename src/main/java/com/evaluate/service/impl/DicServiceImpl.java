package com.evaluate.service.impl;


import com.evaluate.mapper.DicMapper;
import com.evaluate.service.CollegeService;
import com.evaluate.service.DicService;
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
public class DicServiceImpl implements DicService {

    @Resource
    private DicMapper dicMapper;



}
