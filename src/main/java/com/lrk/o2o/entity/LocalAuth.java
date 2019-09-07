package com.lrk.o2o.entity;

import lombok.Data;

import java.util.Date;
@Data
public class LocalAuth {
    private Integer localAuthId;

    private Integer userId;

    private String userName;

    private String password;

    private Date createTime;

    private Date lastEditTime;


}