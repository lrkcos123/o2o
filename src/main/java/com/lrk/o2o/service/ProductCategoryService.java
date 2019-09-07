package com.lrk.o2o.service;

import com.lrk.o2o.entity.ProductCategory;
import com.lrk.o2o.utils.DataGridView;

public interface ProductCategoryService {
    DataGridView getDataGridView(Integer pageNum, Integer pageSize);


}
