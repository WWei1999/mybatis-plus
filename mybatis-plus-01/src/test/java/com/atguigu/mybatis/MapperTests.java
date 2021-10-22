package com.atguigu.mybatis;

import com.atguigu.mybatis.entity.User;
import com.atguigu.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.*;

/**
 * TODO：
 *
 * @author ：zo2
 * @version ：1.0
 * @date ：2021/10/22 9:23
 */
@SpringBootTest
public class MapperTests {

    @Resource
    UserMapper userMapper;

    @Test
    void testInsert() {
        User user = new User(8L, "tom", 22, "qian@runyu.com");
        int i = userMapper.insert(user);
        System.out.println("成功插入：" + i + "条数据。");
    }

    @Test
    void testDeleteById() {
        int i = userMapper.deleteById(8L);
        System.out.println("成功删除：" + i + "条数据。");
    }

    @Test
    void testUpdate() {
        User user = new User(8L, "周润发", 22, "zhou@runfa.com");
        int i = userMapper.updateById(user);
        System.out.println("成功修改：" + i + "条数据。");
    }

    @Test
    void testQueryById() {
        User user = userMapper.selectById(5);
        System.out.println(user);
    }

    @Test
    void testQueryBatch() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList("1", "2", "3", "4"));
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void testQueryMap() {
        Map<String,Object> condition = new HashMap<String,Object>();
        //查询name为Tom并且age为28的用户
        condition.put("name","Tom");
        condition.put("age",28);
        List<User> users = userMapper.selectByMap(condition);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void testSelectAllByName(){
        List<User> list = userMapper.selectAllByName("Tom");
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    void testSelectAllByAge(){
        List<User> list = userMapper.selectAllByAge(27);
        for (User user : list) {
            System.out.println(user);
        }
    }
}
