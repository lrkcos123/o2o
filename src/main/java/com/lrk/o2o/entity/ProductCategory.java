package com.lrk.o2o.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class ProductCategory {
    private Integer productCategoryId;

    private String productCategoryName;

    private String productCategoryDesc;

    private Integer priority;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date lastEditTime;

    private Integer shopId;

}