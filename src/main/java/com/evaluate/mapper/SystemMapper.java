package com.evaluate.mapper;

import java.util.List;
import java.util.Map;

public interface SystemMapper {
    List usersList(Map<String,Object> param);
    int addUsers(Map<String,Object> param);
}
