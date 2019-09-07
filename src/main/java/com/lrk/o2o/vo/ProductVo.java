package com.lrk.o2o.vo;

import com.lrk.o2o.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductVo extends Product {

    private String productName;
    private String minPrice;
    private String maxPrice;
    private String startTime;
    private String endTime;

    private List<Integer> shopIds;
}
