package com.zjweu.sutuofen.service;

import com.zjweu.sutuofen.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author swithin
 * @since 2023-10-24
 */
public interface IUserService extends IService<User> {

    User login(User user);
}
