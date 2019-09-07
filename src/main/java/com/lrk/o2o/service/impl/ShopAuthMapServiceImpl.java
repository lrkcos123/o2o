package com.lrk.o2o.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lrk.o2o.entity.LocalAuth;
import com.lrk.o2o.entity.ShopAuthMap;
import com.lrk.o2o.mapper.ShopAuthMapMapper;
import com.lrk.o2o.service.ShopAuthMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopAuthMapServiceImpl implements ShopAuthMapService {

    @Autowired
    private ShopAuthMapMapper shopAuthMapMapper;

    @Override
    public List<ShopAuthMap> getShopsByAuthId(LocalAuth auth) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_id",auth.getUserId());
        return shopAuthMapMapper.selectList(queryWrapper);
    }

}
