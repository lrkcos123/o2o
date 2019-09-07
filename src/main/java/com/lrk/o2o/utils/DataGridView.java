package com.lrk.o2o.utils;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataGridView<T> {
    private Integer code = 0;
    private String msg = "";
    private Long count=0L;
    private List<T> data=new ArrayList<>();
}