package com.lrk.o2o.service;

import com.github.pagehelper.PageInfo;
import com.lrk.o2o.entity.Product;
import com.lrk.o2o.utils.DataGridView;
import com.lrk.o2o.vo.ProductVo;

public interface ProductService {
//    DataGridView getDataGridView(Integer pageNum, Integer pageSize);

    PageInfo<Product> getPage(Integer pageNum, Integer pageSize, ProductVo productVo);

    void deleteProductById(Product product);

    /**
     * 下架商品
     * @param product
     */
    void down(Product product);

    /**
     * 上架商品
     * @param product
     */
    void up(Product product);

    /**
     * 批量删除
     * @param ids
     */
    void deleteProductByIds(String[] ids);

    /**
     * 新增商品
     * @param product
     */
    void addProduct(Product product);

    /**
     * 修改商品
     * @param product
     */
    void updateProduct(Product product);
}
