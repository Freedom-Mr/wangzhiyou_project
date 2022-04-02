package casia.isiteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import casia.isiteam.pojo.Product;
import casia.isiteam.service.ProductService;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ProductController
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/30
 * Email: zhiyou_wang@foxmail.com
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> selectProductList(){
        return productService.selectProductList();
    }

    @GetMapping("/{id}")
    public List<Product> selectProductList(@PathVariable("id") Integer id){
        return productService.selectProductList(id);
    }

    @PostMapping("/save")
    public Map<Object,Object> createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/pojo")
    public Product selectProductByPojo(@RequestBody Product product){
        return productService.selectProductByPojo(product);
    }
}
