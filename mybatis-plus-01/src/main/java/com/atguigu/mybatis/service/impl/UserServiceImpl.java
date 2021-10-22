package com.atguigu.mybatis.service.impl;

import com.atguigu.mybatis.entity.User;
import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO：
 *
 * @author ：zo2
 * @version ：1.0
 * @date ：2021/10/22 10:38
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public List<User> selectAllByName(String name) {
        return userMapper.selectAllByName(name);
    }

    @Override
    public List<User> selectAllByAge(Integer age) {
        return userMapper.selectAllByAge(age);
    }

}
