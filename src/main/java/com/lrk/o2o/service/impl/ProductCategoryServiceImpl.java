package com.lrk.o2o.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrk.o2o.entity.ProductCategory;
import com.lrk.o2o.mapper.ProductCategoryMapper;
import com.lrk.o2o.service.ProductCategoryService;
import com.lrk.o2o.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public DataGridView getDataGridView(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ProductCategory> products=productCategoryMapper.selectList(null);
        PageInfo<ProductCategory> pageInfo=new PageInfo<>(products);
        DataGridView<ProductCategory> dataGridView=new DataGridView<>();
        dataGridView.setCount(pageInfo.getTotal());
        dataGridView.setData(pageInfo.getList());

        return dataGridView;
    }


}
