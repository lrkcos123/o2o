package com.lrk.o2o.controller;

import com.github.pagehelper.PageInfo;
import com.lrk.o2o.entity.LocalAuth;
import com.lrk.o2o.entity.Product;
import com.lrk.o2o.entity.ShopAuthMap;
import com.lrk.o2o.exception.O2OException;
import com.lrk.o2o.service.ProductService;
import com.lrk.o2o.service.ShopAuthMapService;
import com.lrk.o2o.utils.*;
import com.lrk.o2o.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("shop/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ShopAuthMapService shopAuthMapService;

    @GetMapping("list.html")
    public String toList() {
        return "product/list";
    }

    @GetMapping("list")
    @ResponseBody
    public DataGridView list(ProductVo productVo, HttpSession session,
                             @RequestParam(value = "page",required = false,defaultValue = "1")Integer page,
                             @RequestParam(value = "limit",required = false,defaultValue = "5")Integer limit){
        LocalAuth user = (LocalAuth) session.getAttribute(SysConstants.SESSION_USER);
        List<ShopAuthMap> usershops = shopAuthMapService.getShopsByAuthId(user);

        ArrayList<Integer> shopids=new ArrayList<>();
        for (ShopAuthMap usershop:usershops) {
            shopids.add(usershop.getShopId());
        }
        productVo.setShopIds(shopids);
        PageInfo<Product> pageInfo=productService.getPage(page,limit,productVo);
        DataGridView<Product> dataGridView=new DataGridView<>();
        dataGridView.setCount(pageInfo.getTotal());
        dataGridView.setData(pageInfo.getList());
        return dataGridView;
    }

    @GetMapping("deleteProduct")
    @ResponseBody
    public Object deleteProduct(Product product) {
        try {
            this.productService.deleteProductById(product);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("deleteBatchProduct")
    @ResponseBody
    public ResultObj deleteBatchProduct(String[] ids) {
        try {
            this.productService.deleteProductByIds(ids);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 下架商品
     * @param product
     * @return
     */
    @GetMapping("down")
    @ResponseBody
    public ResultObj down(Product product) {
        try {
            this.productService.down(product);
            return ResultObj.DOWN_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DOWN_ERROR;
        }
    }

    /**
     * 上架商品
     * @param product
     * @return
     */
    @GetMapping("up")
    @ResponseBody
    public ResultObj up(Product product) {
        try {
            this.productService.up(product);
            return ResultObj.UP_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UP_ERROR;
        }
    }

    /**
     * 添加商品
     * @param product
     * @return
     */
    @PostMapping("addProduct")
    @ResponseBody
    public ResultObj addProduct(Product product) {
        //设置时间
        product.setCreateTime(new Date());
        product.setLastEditTime(new Date());

        try {
            //如果不是默认图片就去掉图片的_temp的后缀
            if(!product.getImgAddr().equals(SysContants.DEFAULT_PRODUCT_IMG)) {
                String filePath= AppFileUtils.updateFileName(product.getImgAddr(),SysContants.FILE_UPLOAD_TEMP);
                product.setImgAddr(filePath);
            }
            productService.addProduct(product);
            return ResultObj.ADD_SUCCESS;
        } catch (O2OException e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改商品
     * @param product
     * @return
     */
    @PostMapping("updateProduct")
    @ResponseBody
    public ResultObj updateProduct(Product product) {
        //设置修改时间
        product.setLastEditTime(new Date());

        try {
            //如果不是默认图片就去掉图片的_temp的后缀
            if(!product.getImgAddr().equals(SysContants.DEFAULT_PRODUCT_IMG)) {
                String filePath=AppFileUtils.updateFileName(product.getImgAddr(),SysContants.FILE_UPLOAD_TEMP);
                product.setImgAddr(filePath);
            }
            productService.updateProduct(product);
            return ResultObj.UPDATE_SUCCESS;
        } catch (O2OException e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
}
