package com.lrk.o2o.entity;

import lombok.Data;

import java.util.Date;
@Data
public class UserShopMap {
    private Integer userShopId;

    private Integer userId;

    private Integer shopId;

    private String userName;

    private String shopName;

    private Date createTime;

    private Integer point;

}