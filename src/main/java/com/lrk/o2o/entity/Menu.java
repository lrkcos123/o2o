package com.lrk.o2o.entity;

import lombok.Data;

@Data
public class Menu {
    private Integer id;

    private Integer pid;

    private String title;

    private String href;

    private Integer spread;

    private String target;

    private String icon;

    private Integer available;

}