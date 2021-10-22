package com.atguigu.mybatis;

import com.atguigu.mybatis.entity.Product;
import com.atguigu.mybatis.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO：
 *
 * @author ：zo2
 * @version ：1.0
 * @date ：2021/10/22 20:32
 */
@SpringBootTest
public class ProductMapperTests {

    @Resource
    ProductMapper productMapper;

    @Test
    void testInsert() {
        Product Product = new Product(2l, "钢笔", 50, 0, 0);
        int i = productMapper.insert(Product);
        System.out.println("成功插入：" + i + "条数据。");
    }

    @Test
    void testQueryById() {
        Product Product = productMapper.selectById(1);
        System.out.println(Product);
    }

    @Test
    void testOptimisticLock() {
        //0.获取产品对象:Product(id=1, name=笔记本, price=100, version=0, deleted=0)
        Product product_wang = productMapper.selectById(1l);
        Product product_li = productMapper.selectById(1l);
        //1.小王增加50元
        product_wang.setPrice(product_wang.getPrice()+50);
        productMapper.updateById(product_wang);
        //2.小李减少30元
        product_li.setPrice(product_li.getPrice()-30);
        productMapper.updateById(product_li);
        //3.最终结果：成本是80元,我们期望是100+50-30=120元,每本利润40元
        Product product_1 = productMapper.selectById(1l);
        System.out.println("最终结果："+product_1.getPrice());
    }

}
