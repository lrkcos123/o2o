package com.lrk.o2o.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrk.o2o.entity.Product;
import com.lrk.o2o.mapper.ProductMapper;
import com.lrk.o2o.service.ProductService;
import com.lrk.o2o.utils.DataGridView;
import com.lrk.o2o.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

//    @Override
//    public DataGridView getDataGridView(Integer pageNum, Integer pageSize) {
//        PageHelper.startPage(pageNum,pageSize);
//        List<Product> products=productMapper.selectList(null);
//        PageInfo<Product> pageInfo=new PageInfo<>(products);
//        DataGridView<Product> dataGridView=new DataGridView<>();
//        dataGridView.setCount(pageInfo.getTotal());
//        dataGridView.setData(pageInfo.getList());
//        return dataGridView;
//    }

    @Override
    public PageInfo<Product> getPage(Integer pageNum, Integer pageSize, ProductVo productVo) {

        PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>(); //封装查询条件
        if (!StringUtils.isEmpty(productVo.getProductName())) {
            queryWrapper.like("product_name", productVo.getProductName());
        }
        if (!StringUtils.isEmpty(productVo.getStartTime()) && !StringUtils.isEmpty(productVo.getEndTime())) {
            queryWrapper.between("create_time", productVo.getStartTime(), productVo.getEndTime());
        }
        // 时间和价格的判断：2个都填写 between...and 若只写一个 gt 或者 lt
        if (!StringUtils.isEmpty(productVo.getMinPrice()) && !StringUtils.isEmpty(productVo.getMaxPrice())) {
            queryWrapper.between("promotion_price", productVo.getMinPrice(), productVo.getMaxPrice());
        }
        //查询全部，不包括删除的
        if (!StringUtils.isEmpty(productVo.getEnableStatus()) && productVo.getEnableStatus() == 3) {
            queryWrapper.in("enable_status", 0, 1);
        }
        // 查询在架或下架的
        if (!StringUtils.isEmpty(productVo.getEnableStatus()) && productVo.getEnableStatus() != 3) {
            queryWrapper.eq("enable_status", productVo.getEnableStatus());
        }
        queryWrapper.in("enable_status", 0, 1);
        // 当前登录人的所有shop下的商品
        queryWrapper.in("shop_id", productVo.getShopIds());
        List<Product> products = productMapper.selectList(queryWrapper);
        return new PageInfo<>(products);

    }

    @Override
    public void deleteProductById(Product product) {
        product.setEnableStatus(2);
        UpdateWrapper<Product> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("product_id",product.getProductId());
        productMapper.update(product,updateWrapper);
    }

    @Override
    public void down(Product product) {
        product.setEnableStatus(1);
        UpdateWrapper<Product> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("product_id",product.getProductId());
        productMapper.update(product,updateWrapper);
    }

    @Override
    public void up(Product product) {
        product.setEnableStatus(0);
        UpdateWrapper<Product> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("product_id",product.getProductId());
        productMapper.update(product,updateWrapper);
    }


    @Override
    public void deleteProductByIds(String[] ids) {
        Product product = new Product();
        product.setEnableStatus(2);
        UpdateWrapper<Product> updateWrapper = new UpdateWrapper<>();
        updateWrapper.in("product_id",ids);
        productMapper.update(product,updateWrapper);
    }

    @Override
    public void addProduct(Product product) {
        productMapper.insert(product);
    }

    /**
     * 修改商品
     * @param product
     */
    @Override
    public void updateProduct(Product product) {
        productMapper.updateById(product);
    }
}
