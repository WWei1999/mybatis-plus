package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author zo2
 */
public interface UserMapper extends BaseMapper<User> {

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
