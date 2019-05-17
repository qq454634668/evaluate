package com.evaluate.service;

import java.util.List;
import java.util.Map;

public interface DailyService {
    /**
     *床位按楼的一个根据fjbh分组的list
     */
    List<Map<String, Object>> BedListMap(Map<String, Object> param);
    /**
     *学生list
     */
    List<Map<String, Object>> StuList(Map<String, Object> param);
    /**
     * 入住/换宿
     */
    void MoveInto(Map<String, Object> param);
    /**
     * 退宿
     */
    void QuitSs(Map<String, Object> param);
    /**
     * 同意/不同意申请，同意自动更换或者入住
     */
    void verifyAsk(String sqrxh, String ycwbh, String sqcwbh, String sqlx, String zxzt, String zxjgyy, String id);
    /**
     * 入住/换宿/退宿申请
     */
    void applyForAsk(Map<String, Object> param);
    /**
     * 申请列表
     */
    List<Map<String, Object>> applyForList(Map<String, Object> param, int pageNum, int pageSize);
}
