package com.atguigu.mybatis;

import com.atguigu.mybatis.entity.Product;
import com.atguigu.mybatis.entity.User;
import com.atguigu.mybatis.mapper.ProductMapper;
import com.atguigu.mybatis.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * TODO：
 *
 * @author ：zo2
 * @version ：1.0
 * @date ：2021/10/23 10:41
 */
@SpringBootTest
public class WrapperTest {

    @Resource
    UserMapper userMapper;

    @Resource
    ProductMapper productMapper;

    @Test
    void testQueryWrapper(){
        QueryWrapper<User> query = new QueryWrapper<>();
        query
                .like("name","t")
                .between("age",15,25)
                .orderByAsc("age")
                .groupBy("sex");
        List<User> list = userMapper.selectList(query);
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    void testQueryWrapper02(){
        QueryWrapper<User> query = new QueryWrapper<>();
        query.isNull("email");
        int i = userMapper.delete(query);
        System.out.println(i == 0 ? "删除失败" : "删除成功");
    }

    @Test
    void testQueryWrapper03(){
        QueryWrapper<User> query = new QueryWrapper<>();
        query.select("name","age");
        List<Map<String,Object>> list =userMapper.selectMaps(query);
        for (Map<String, Object> objectMap : list) {
            System.out.println(objectMap);
        }
    }

    @Test
    void testQueryWrapper04(){
        QueryWrapper<User> query = new QueryWrapper<>();
        query
                .like("name","n")
                .and(i->i.lt("age",25));
        List<User> list = userMapper.selectList(query);
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    void testQueryWrapper05(){
        QueryWrapper<User> query = new QueryWrapper<>();

        query.le("id",100);
        List<User> list = userMapper.selectList(query);
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    void testUpdateWrapper(){
        UpdateWrapper<User> update = new UpdateWrapper<>();
        update
                .set("age",22)
                .set("email","atguigu@qq.com")
                .like("name","大聪明");

        userMapper.update(new User(),update);
        List<User> list = userMapper.selectList(update);
        for (User user : list) {
            System.out.println(user);
        }
    }

}
