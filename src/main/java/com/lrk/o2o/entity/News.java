package com.lrk.o2o.entity;

import lombok.Data;

import java.util.Date;
@Data
public class News {
    private Integer id;

    private String title;

    private String content;

    private Date createtime;

    private String opername;

}