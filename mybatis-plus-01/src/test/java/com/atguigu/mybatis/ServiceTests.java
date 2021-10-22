package com.atguigu.mybatis;

import com.atguigu.mybatis.entity.User;
import com.atguigu.mybatis.service.UserService;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO：
 *
 * @author ：zo2
 * @version ：1.0
 * @date ：2021/10/22 10:40
 */
@SpringBootTest
public class ServiceTests {
    @Resource
    private UserService userService;

    @Test
    void testService(){
        User user = userService.getById(1L);
        System.out.println("ID为1的用户："+user);
        int count = userService.count();
        System.out.println("总记录数："+count);
    }

    @Test
    void testSaveBatch(){
        List<User> list = new ArrayList<User>();

        for (int i = 0; i < 10; i++) {
            list.add(new User(100L+i,"User"+i,22+i,"user"+i+"@qq.com"));
        }
        boolean b = userService.saveBatch(list);
        System.out.println("是否批量添加成功："+b);
    }

    @Test
    void testSelectAllByName(){
        List<User> list = userService.selectAllByName("Tom");
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    void testSelectAllByAge(){
        List<User> list = userService.selectAllByAge(22);
        for (User user : list) {
            System.out.println(user);
        }
    }

}
