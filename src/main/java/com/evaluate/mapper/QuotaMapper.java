package com.evaluate.mapper;

import java.util.List;
import java.util.Map;

public interface QuotaMapper {
    int addQuota(Map<String,Object> param);
    int editQuota(Map<String,Object> param);
    int delQuota(Map<String,Object> param);
    List<Map<String,Object>> quotaList(Map<String,Object> param);
    void editWeight(Map<String,Object> param);
}
