package com.zjweu.sutuofen.controller;


import cn.hutool.core.util.StrUtil;
import com.zjweu.sutuofen.common.R;
import com.zjweu.sutuofen.dto.UserDTO;
import com.zjweu.sutuofen.entity.User;
import com.zjweu.sutuofen.service.impl.UserServiceImpl;
import com.zjweu.sutuofen.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author swithin
 * @since 2023-10-24
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/get/{id}")
    User getById(@PathVariable String id){
        return userService.getById(id);
    }

    @PostMapping("/login")
    public R login(@RequestBody User user){
        //先判断前端传的参数是否有空的
        if(StrUtil.isBlank(user.getId()) || StrUtil.isBlank(user.getPassword())){
            return R.error("账号密码其中有空");
        }
        //在调用业务层，业务层如果返回true，则说明登录成功，并且返回userDto,其中包含token
        User res = userService.login(user);
        if(res != null){
            String token = JWTUtils.genToken(user.getId());
            UserDTO userDto = new UserDTO(res);
            userDto.setToken(token);
            return R.success("登录成功").add("userDto",userDto);
        }
        else{
            return R.error("账号或密码错误");
        }
    }

}
