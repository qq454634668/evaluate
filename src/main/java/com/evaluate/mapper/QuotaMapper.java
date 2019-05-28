package com.evaluate.mapper;

import java.util.List;
import java.util.Map;

public interface QuotaMapper {
    int addQuota(Map<String,Object> param);
    int editQuota(Map<String,Object> param);
}
