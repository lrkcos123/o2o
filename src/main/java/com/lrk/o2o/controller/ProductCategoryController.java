package com.lrk.o2o.controller;

import com.lrk.o2o.service.ProductCategoryService;
import com.lrk.o2o.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("shop/category")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("list.html")
    public String toList() {
        return "category/list";
    }

    @GetMapping("list")
    @ResponseBody
    public DataGridView list(@RequestParam(value = "page",required = false,defaultValue = "1")Integer page,
                             @RequestParam(value = "limit",required = false,defaultValue = "5")Integer limit){
        return productCategoryService.getDataGridView(page,limit);
    }
}
