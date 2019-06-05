package com.evaluate.service;


import java.util.List;
import java.util.Map;

public interface SystemService {
    List usersList(Map<String,Object> param,int pageNum, int pageSize);
}
