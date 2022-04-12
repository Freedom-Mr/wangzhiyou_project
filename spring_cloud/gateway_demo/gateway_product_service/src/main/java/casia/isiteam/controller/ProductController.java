package casia.isiteam.controller;

import casia.isiteam.pojo.Product;
import casia.isiteam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return productService.selectProductList();
    }

    @GetMapping("/listByIds")
    public List<Product> selectProductListByIds(@RequestParam("id") List<Integer> ids){
        return productService.selectProductListByIds(ids);
    }

    @GetMapping("/{id}")
    public Product selectProductById(@PathVariable("id") Integer id){
        return productService.selectProductById(id);
    }

    @GetMapping("/{id}/{flag}")
    public Product selectProductByIdAnd(@PathVariable("id") Integer id,@PathVariable("flag") String flag){
        System.out.println(flag);
        return productService.selectProductById(id);
    }
}
