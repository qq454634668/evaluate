package com.evaluate.service.impl;


import com.evaluate.mapper.HomeMapper;
import com.evaluate.service.HomeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {

    @Resource
    private HomeMapper homeMapper;

    @Override
    public Map<String, Object> makeTb(String data) {
        return null;
    }
}
