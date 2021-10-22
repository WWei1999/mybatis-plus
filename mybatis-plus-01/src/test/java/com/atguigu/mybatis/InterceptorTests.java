package com.atguigu.mybatis;

import com.atguigu.mybatis.entity.User;
import com.atguigu.mybatis.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * TODO：
 *
 * @author ：zo2
 * @version ：1.0
 * @date ：2021/10/22 19:53
 */
@SpringBootTest
public class InterceptorTests {

    @Resource
    MybatisPlusInterceptor interceptor;

    @Resource
    UserMapper userMapper;

    @Test
    void testInterectptor(){
        System.out.println(interceptor);
    }

    @Test
    void testFindByPage(){
        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page, null);
        for (User record : page.getRecords()) {
            System.out.println(record);
        }
    }

    @Test
    void testFindPageByAge(){
        Page<User> page = new Page<>(1,5);
        userMapper.selectPageByMinAge(page,25);
        for (User record : page.getRecords()) {
            System.out.println(record);
        }
    }

}
