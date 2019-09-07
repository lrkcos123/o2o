package com.lrk.o2o.entity;

import lombok.Data;

import java.util.Date;
@Data
public class AwardMap {
    private Integer userAwardId;

    private Integer userId;

    private Integer awardId;

    private Integer shopId;

    private String userName;

    private String awardName;

    private Date expireTime;

    private Date createTime;

    private Integer usedStatus;

    private Integer point;

}