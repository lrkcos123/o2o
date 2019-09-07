package com.lrk.o2o.service;

import java.util.List;
import java.util.Map;

public interface ChartService {
    List<Map<String,Object>> getTop5Product(Map<String,Object> map);

    Map<String,Object> getOrderStatus(Map<String,Object> map);

    List<Map<String,Object>> getMoney(Map<String,Object> map);

    List<Map<String,Object>> getMoneyByType(Map<String,Object> map);
}
