package casia.isiteam.fallback;

import casia.isiteam.pojo.Product;
import casia.isiteam.service.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: ProductServiceFallback
 * @Description: 服务熔断降级处理
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/4/7
 * Email: zhiyou_wang@foxmail.com
 */
//@Component
public class ProductServiceFallback implements ProductService {

    @Override
    public List<Product> selectProductList() {
        return Arrays.asList(
                new Product(1,"托底数据-华为手机-7070",2,5888D),
                new Product(2,"托底数据-小米手机",1,4888D),
                new Product(3,"托底数据-苹果手机",4,6888D)
        );
    }

    @Override
    public List<Product> selectProductListByIds(List<Integer> ids) {
        List<Product> products = new ArrayList<>();
        ids.forEach(id-> products.add(new Product(id,"托底数据-电视剧"+id,1,2002D)));
        return products;
    }

    @Override
    public Product selectProductById(Integer id) {
        return new Product(id,"托底数据-冰箱",2,5888D);
    }
}
