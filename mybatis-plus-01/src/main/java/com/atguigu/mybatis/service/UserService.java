package com.atguigu.mybatis.service;

import com.atguigu.mybatis.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author zo2
 */
public interface UserService extends IService<User> {
    /**
     * 根据name查询用户
     * @param name 用户名
     * @return 用户集合
     */
    List<User> selectAllByName(String name);

    /**
     * 根据age查询用户
     * @param age 用户年龄
     * @return 用户集合
     */
    List<User> selectAllByAge(Integer age);
}
