package com.evaluate.service;

import java.util.List;
import java.util.Map;

public interface QuotaService {
    /**
     *增加指标
     */
    void addQuota(Map<String, Object> param);
    //修改指标
    void editQuota(Map<String, Object> param);
    //删除指标
    void delQuota(Map<String, Object> param);
    //指标列表
    List quotaList(Map<String, Object> param);
    //修改权重
    void editWeight(String id,String weight);
}
