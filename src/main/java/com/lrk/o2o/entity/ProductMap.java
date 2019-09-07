package com.lrk.o2o.entity;

import lombok.Data;

import java.util.Date;
@Data
public class ProductMap {
    private Integer userProductId;

    private Integer userId;

    private Integer productId;

    private Integer shopId;

    private String userName;

    private String productName;

    private Date createTime;

    private Integer point;

}