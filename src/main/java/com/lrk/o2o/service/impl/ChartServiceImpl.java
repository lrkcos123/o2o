package com.lrk.o2o.service.impl;

import com.lrk.o2o.mapper.ChartMapper;
import com.lrk.o2o.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class ChartServiceImpl implements ChartService {

    @Autowired
    private ChartMapper chartMapper;

    @Override
    public List<Map<String, Object>> getTop5Product(Map<String, Object> map) {
        return chartMapper.getTop5Product(map);
    }

    @Override
    public Map<String, Object> getOrderStatus(Map<String, Object> map) {
        return chartMapper.getOrderStatus(map);
    }

    @Override
    public List<Map<String, Object>> getMoney(Map<String, Object> map) {
        return chartMapper.getMoney(map);
    }

    @Override
    public List<Map<String,Object>> getMoneyByType(Map<String, Object> map) {
        return chartMapper.getMoneyByType(map);
    }
}
