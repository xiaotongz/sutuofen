package com.zjweu.sutuofen.mapper;

import com.zjweu.sutuofen.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScans;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author swithin
 * @since 2023-10-24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
