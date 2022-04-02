package casia.isiteam.service.impl;


import casia.isiteam.pojo.Product;
import casia.isiteam.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ProductServiceImpl
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/30
 * Email: zhiyou_wang@foxmail.com
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> selectProductList(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList(
            new Product(1,"华为手机-7080",2,5888D),
            new Product(2,"小米手机",1,4888D),
            new Product(3,"苹果手机",4,6888D)
        );
    }

    @Override
    public List<Product> selectProductList(Integer id){
        return Arrays.asList(
                new Product(1,"冰箱-7080",2,5888D)
        );
    }

    @Override
    public Map<Object, Object> createProduct(Product product) {
        System.out.println(product);
        return new HashMap<Object, Object>(){
            {
                put("code",200);
                put("message","新增成功！");
            }
        };
    }

    @Override
    public Product selectProductByPojo(Product product){
        System.out.println(product);
        return product;
    }
}
