package com.lrk.o2o.service;

import com.lrk.o2o.entity.LocalAuth;
import com.lrk.o2o.entity.ShopAuthMap;


import java.util.List;

public interface ShopAuthMapService {



    List<ShopAuthMap> getShopsByAuthId(LocalAuth auth);
}
