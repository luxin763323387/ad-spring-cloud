package com.cn.lx.controller;

import com.alibaba.fastjson.JSON;
import com.cn.lx.exception.AdException;
import com.cn.lx.service.IUserService;
import com.cn.lx.vo.CreateUserRequest;
import com.cn.lx.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author StevenLu
 * @date 2019-08-26 01:11
 */
@RestController
@Slf4j
public class UserOPController {

    @Resource
    private IUserService userService;

    @PostMapping("/create/user")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest createUserRequest) throws AdException{
        log.info("创建用户入参:{}", JSON.toJSON(createUserRequest));
        CreateUserResponse user = userService.createUser(createUserRequest);
        log.info("创建用户响应:{}",JSON.toJSON(user));
        return user;
    }
}
