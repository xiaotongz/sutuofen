package com.zjweu.sutuofen.service.impl;

import com.zjweu.sutuofen.entity.User;
import com.zjweu.sutuofen.mapper.UserMapper;
import com.zjweu.sutuofen.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author swithin
 * @since 2023-10-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        //若数据库没有该用户则返回false，若密码不正确也返回false，密码正确返回true
        User res = userMapper.selectById(user.getId());
        if(res == null) return null;
        if(!res.getPassword().equals(user.getPassword())) return null;
        return res;
    }
}
