package com.lrk.o2o.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrk.o2o.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface ProductMapper extends BaseMapper<Product> {
}
