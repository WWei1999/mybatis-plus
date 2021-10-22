package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

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

    /**
     * 查询全部用户
     * @return 用户集合
     */
    List<User> selectAll();

    /**
     * 分页查询
     * @param page 分页对象
     * @param age 年龄
     * @return 结果封装
     */
    IPage<User> selectPageByMinAge(Page<?> page, Integer age);

}
