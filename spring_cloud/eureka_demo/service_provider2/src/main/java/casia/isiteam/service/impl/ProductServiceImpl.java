package casia.isiteam.service.impl;

import casia.isiteam.pojo.Product;
import casia.isiteam.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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
        return Arrays.asList(
            new Product(1,"华为手机-7071",2,5888D),
            new Product(2,"小米手机",1,4888D),
            new Product(3,"苹果手机",4,6888D)
        );
    }
}
