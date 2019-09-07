package com.lrk.o2o.service.impl;

import com.lrk.o2o.service.ProductCategoryService;
import com.lrk.o2o.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductService productService;
//    @Test
//    public void getDataGridView() {
//        System.out.println(productService.getDataGridView(1,2));
//    }

    @Test
    public void getDataGridView1() {
        System.out.println(productCategoryService.getDataGridView(1,2));
    }
}